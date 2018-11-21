package com.gs.fefec.web.security;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {
	private static Logger log = Logger.getLogger(CustomAuthenticationFilter.class);
	
	private String POST = "POST";

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		log.info("successfulAuthentication");
        String exito = (String) request.getSession(false).getAttribute("loginExitoso");
        request.getSession(false).removeAttribute("loginExitoso");
        if(exito == null || !exito.equals("True")){
        	String page = "/error/ErrorLogin.htm?tipo='datosIncorrectos'";
        	response.sendRedirect(page);

        }else{
        	Boolean sa = false;
        	if( null != request.getAttribute("sessionActual") ){
        		sa = (Boolean) request.getAttribute("sessionActual");
        	}
        	if( !sa ){
        		super.successfulAuthentication(request, response, chain, authResult);
        	}else{
        		String page = "/error/OtraSession.htm";
            	response.sendRedirect(page);
        	}
        }
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		super.unsuccessfulAuthentication(request, response, failed);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		if(request.getMethod().equals(POST)) {
			super.doFilter(request, response, chain);
		} else {
			request.getSession();
			chain.doFilter(request, response);
		}
	}
}
