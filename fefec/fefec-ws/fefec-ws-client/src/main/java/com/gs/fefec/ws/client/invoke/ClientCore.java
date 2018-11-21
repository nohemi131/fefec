package com.gs.fefec.ws.client.invoke;


import java.util.ArrayList;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import com.gs.fefec.commons.utilities.client.properties.ConstantsApiLoader;
import com.gs.fefec.commons.utilities.encript.CipherReflection;
import com.gs.fefec.commons.utilities.time.TimeUtil;
import com.gs.fefec.ws.core.entities.services.RequestTO;
import com.gs.fefec.ws.core.entities.services.ResponseTO;

public class ClientCore extends ConstantsApiLoader{

	public static Logger log = Logger.getLogger(ClientCore.class);

	private static ClientResponseHeaderFilter clientCookie= new ClientResponseHeaderFilter(); // response cookie
	private Properties propertie=getPropertiesHost();	
	private ClientConfig clientConfig = new ClientConfig();
	private Client client = ClientBuilder.newClient(clientConfig);
	private  WebTarget resourceWebTarget;
	private PoolingHttpClientConnectionManager  connectionManager = new PoolingHttpClientConnectionManager();
	
	public ClientCore(){		
		clientConfig = new ClientConfig();		 	
		connectionManager.setMaxTotal(10000);
	 	connectionManager.setDefaultMaxPerRoute(20);
		connectionManager.setMaxPerRoute(new HttpRoute(new HttpHost("localhost")), 40);		
		
		clientConfig.property( ApacheClientProperties.CONNECTION_MANAGER, connectionManager );
		//clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER_SHARED, true);
		
	 	ApacheConnectorProvider connector = new ApacheConnectorProvider();
		clientConfig.connectorProvider(connector);	
	
		JacksonJsonProvider jackson_json_provider = new JacksonJaxbJsonProvider().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		ObjectMapper object_mapper = jackson_json_provider.locateMapper(Object.class, MediaType.APPLICATION_JSON_TYPE);
		
        client = ClientBuilder.newClient(clientConfig);
        client.register(JacksonFeature.class);
        client.register(JacksonJsonProvider.class);
        client.register(object_mapper);
        resourceWebTarget = client.target(propertie.getProperty("UrlWS")).path(propertie.getProperty("contextWSService"));
	}
	
	public synchronized Object response(Object requestTO, String path,Class<?> classType,String applicantName) throws Exception {
		ClientFilter filterCookie= new ClientFilter();		
		if(((RequestTO)requestTO).getCookieName()!=null && !((RequestTO)requestTO).getCookieName().equals("") && !((RequestTO)requestTO).getCookieName().equals("null")){
			Cookie cookie= new Cookie("JSESSIONID",((RequestTO)requestTO).getCookieName());
			log.info("--------------------------------------COOKIE["+cookie+"]------------------------------");			
			filterCookie.setCookie(cookie);
		}			
		
	    WebTarget invokeWebTarget = resourceWebTarget.path(path);	  
	    invokeWebTarget.register(filterCookie);	
	    invokeWebTarget.register(clientCookie);
	    log.info("path: "+resourceWebTarget.getUri().getHost()+":"+resourceWebTarget.getUri().getPort()+ resourceWebTarget.getUri().getPath()+path);
	    Object responseTO = null;
		try{
			requestTO  = CipherReflection.encript(requestTO);
			responseTO = classType.newInstance();
			double startTime = System.nanoTime();			
			Response responseHttp=   invokeWebTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(requestTO),Response.class);
			responseTO =responseHttp.readEntity(responseTO.getClass());	
			double elapsedTime = TimeUtil.getElapsedTime(startTime);
			log.info("-- Time Client Finish ("+path+") ["+elapsedTime+"] ms --");
			
			requestTO  = CipherReflection.desencript(responseTO);
					
			responseHttp.close();
		}catch(Exception e){
			log.error("Message Error " +e);
			Object responseErrorTO=classType.newInstance();
			BeanUtils.copyProperties(responseTO,responseErrorTO );
			responseTO=responseErrorTO;
			((ResponseTO)responseTO).setCode(-1);
			((ResponseTO)responseTO).setMessage(new ArrayList<String>());
			((ResponseTO)responseTO).getMessage().add("Error");
		 }
		
		return responseTO;
	}	
}