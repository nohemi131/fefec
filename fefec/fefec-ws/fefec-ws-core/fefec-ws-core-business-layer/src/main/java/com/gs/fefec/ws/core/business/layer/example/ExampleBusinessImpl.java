package com.gs.fefec.ws.core.business.layer.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gs.fefec.ws.core.business.interfaces.example.IExampleBusiness;
import com.gs.fefec.ws.core.data.interfaces.example.ISpExampleDAO;
import com.gs.fefec.ws.core.entities.data.example.Example;
import com.gs.fefec.ws.core.entities.services.example.RequestExampleTO;
import com.gs.fefec.ws.core.entities.services.example.ResponseExampleTO;

@Component
public class ExampleBusinessImpl implements IExampleBusiness{

	private static Logger log= Logger.getLogger(ExampleBusinessImpl.class.getName());
	
	@Autowired
	private ISpExampleDAO spExampleDAOImpl;
	
	private List<String> message;
	
	public ResponseExampleTO exampleBusinessMethod(RequestExampleTO requestExampleTO) throws Exception {
		log.info("ExampleBusinessImpl.exampleBusinessMethod()");
		message= new ArrayList<String>();
		ResponseExampleTO response = new ResponseExampleTO();
		
		Example example=spExampleDAOImpl.invokeSpExample(requestExampleTO.getValor1());
		response.setCode(example.getCode());
		
		if(example.getCode()==0) {
			response.setReturn1(example.getReturn1());
		}else {
			message.add("Error invoke Layer Data");
		}
		
		message.add(example.getMessage());
		response.setMessage(message);
		return response;
	}
}
