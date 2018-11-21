package com.gs.fefec.ws.core.entities.services;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestTO {

	private String userName;
	private String macAddress;
	private String cookieName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getCookieName() {
		return cookieName;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	@Override
	public String toString() {
		return "RequestTO [userName=" + userName + ", macAddress=" + macAddress + ", cookieName=" + cookieName + "]";
	}

}
