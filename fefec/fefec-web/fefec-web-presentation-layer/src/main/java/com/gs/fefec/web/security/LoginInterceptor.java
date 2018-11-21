package com.gs.fefec.web.security;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	if( request.getRequestURL().indexOf("rest")<0 && request.getRequestURL().indexOf("private")<0){    	
    		log.info("denied");
   			response.sendRedirect("denied");
    		return false;   			
    	}
        return super.preHandle(request, response, handler);
    }
}