package com.gs.fefec.ws.core.entities.services;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseTO {

	public int code;
	public List<String> message;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ResponseTO [code=" + code + ", message=" + message + "]";
	}
}
