package com.gs.fefec.ws.client.invoke;



import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Cookie;

public class ClientFilter implements ClientRequestFilter {

	private Cookie cookie;
	private long clientId;
	private String x_auth_token;
	
	@Override
	public void filter(ClientRequestContext request) throws IOException {
		ArrayList<Object> cookies = new ArrayList<Object>();
		cookies.add(getCookie());
		request.getHeaders().add("Cookie", cookies);
		request.getHeaders().add("applicantname", clientId);
		request.getHeaders().add("X-Auth-Token", x_auth_token);
	}
	
	public Cookie getCookie() {
		return cookie;
	}
	
	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getX_auth_token() {
		return x_auth_token;
	}

	public void setX_auth_token(String x_auth_token) {
		this.x_auth_token = x_auth_token;
	}
}