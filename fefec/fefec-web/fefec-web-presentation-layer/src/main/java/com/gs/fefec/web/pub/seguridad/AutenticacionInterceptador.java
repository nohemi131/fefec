package com.gs.fefec.web.pub.seguridad;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutenticacionInterceptador extends HandlerInterceptorAdapter {

	private static Logger log = Logger.getLogger(AutenticacionInterceptador.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	log.info("AutenticacionInterceptador.preHandle()");
    	//Todo
    	/**
    	 * if(valida seguridad de url){
    	 * response.sendRedirect("denegado");
    			return false;
   			}
    	 */
   				
    		
        return super.preHandle(request, response, handler);
    }
}