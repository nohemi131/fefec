package com.gs.fefec.ws.client.invoke;



import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import org.apache.log4j.Logger;


import javax.ws.rs.core.Cookie;

public class ClientResponseHeaderFilter implements ClientResponseFilter {
	
	private Logger log= Logger.getLogger(ClientResponseHeaderFilter.class);

	private static String nameFile;
	private static String x_auth_token;
	private static Cookie cookieName;

	@Override
	public void filter(final ClientRequestContext reqCtx,final ClientResponseContext resCtx) throws IOException {
		//TODO ...
		log.info("ClientResponseHeaderFilter.filter()");
	}
	
	public static Cookie getCookieName() {
		return cookieName;
	}

	public static void setCookieName(Cookie cookieName) {
		ClientResponseHeaderFilter.cookieName = cookieName;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		ClientResponseHeaderFilter.nameFile = nameFile;
	}

	public static String getX_auth_token() {
		return x_auth_token;
	}

	public static void setX_auth_token(String x_auth_token) {
		ClientResponseHeaderFilter.x_auth_token = x_auth_token;
	}
}