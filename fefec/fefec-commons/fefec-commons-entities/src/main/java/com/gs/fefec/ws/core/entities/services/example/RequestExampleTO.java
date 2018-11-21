package com.gs.fefec.ws.core.entities.services.example;

import javax.xml.bind.annotation.XmlRootElement;

import com.gs.fefec.ws.core.entities.services.RequestTO;

@XmlRootElement
public class RequestExampleTO extends RequestTO {

	private String valor1;

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	@Override
	public String toString() {
		return "ExampleRequestTO [valor1=" + valor1 + ", toString()=" + super.toString() + "]";
	}
	
}
