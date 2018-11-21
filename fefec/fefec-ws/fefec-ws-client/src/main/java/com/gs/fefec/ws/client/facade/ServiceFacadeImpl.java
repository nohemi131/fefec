package com.gs.fefec.ws.client.facade;

import org.springframework.stereotype.Repository;

import com.gs.fefec.ws.client.facade.exampleServices.LoginServiceImpl;

@Repository
public class ServiceFacadeImpl {

	private LoginServiceImpl loginServiceImpl;
	

	public ServiceFacadeImpl(){
		loginServiceImpl= new LoginServiceImpl();
	
	}

	public LoginServiceImpl getLoginServiceImpl() {
		return loginServiceImpl;
	}

	
	
}
