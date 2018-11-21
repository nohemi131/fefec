package com.gs.fefec.ws.core.entities.data.example;

import com.gs.fefec.ws.core.entities.data.SpCore;

public class Example extends SpCore{

	private String return1;

	public String getReturn1() {
		return return1;
	}

	public void setReturn1(String return1) {
		this.return1 = return1;
	}

	@Override
	public String toString() {
		return "Example [return1=" + return1 + ", toString()=" + super.toString() + "]";
	}


	
}
