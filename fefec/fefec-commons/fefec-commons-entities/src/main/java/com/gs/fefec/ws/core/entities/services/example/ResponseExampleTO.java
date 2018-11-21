package com.gs.fefec.ws.core.entities.services.example;

import com.gs.fefec.ws.core.entities.services.ResponseTO;

public class ResponseExampleTO extends ResponseTO {

	public String return1;

	public String getReturn1() {
		return return1;
	}

	public void setReturn1(String return1) {
		this.return1 = return1;
	}

	@Override
	public String toString() {
		return "ExampleResponseTO [return1=" + return1 + ", toString()=" + super.toString() + "]";
	}
	
	
}
