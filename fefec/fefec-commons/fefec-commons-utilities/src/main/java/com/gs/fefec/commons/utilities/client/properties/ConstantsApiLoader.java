package com.gs.fefec.commons.utilities.client.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConstantsApiLoader {
	public static Properties properties=new Properties();
	public static Properties propertiesClient=new Properties();
	private static String PATH_COMMONS= System.getProperty("path_commons");
	private Logger log= Logger.getLogger(ConstantsApiLoader.class);

	public ConstantsApiLoader(){
		try {
			FileInputStream pathProperties = new FileInputStream (PATH_COMMONS+"path.properties");
			FileInputStream urlServicesProperties = new FileInputStream (PATH_COMMONS+"urlServices.properties");
			if(pathProperties!=null){
				ConstantsApiLoader.properties.load(pathProperties	);
				ConstantsApiLoader.propertiesClient.load(urlServicesProperties);
				pathProperties.close();
				urlServicesProperties.close();
			}
			
		} catch (IOException e) {
			log.error("Message Error " +e.fillInStackTrace());
		}
	}
	
	public Properties getProperties() {			
		return ConstantsApiLoader.properties;
	}
	
	public Properties getPropertiesHost(){
		return ConstantsApiLoader.propertiesClient;
	}

}
