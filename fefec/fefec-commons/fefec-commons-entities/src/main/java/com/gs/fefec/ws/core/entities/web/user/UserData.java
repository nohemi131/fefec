package com.gs.fefec.ws.core.entities.web.user;







public class UserData {
	
	private String userId;
	private String userDesc;
	private String firstName;
	private String lastName;
	private String secondLastName;
	private String email;	
	private String profileId;
	private String functionId; 	
	private String fingerId; //not sure if this will be used yet.
	private String ipKeyId;
	private boolean isDateIpDatePass;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	
	public String getFingerId() {
		return fingerId;
	}
	public void setFingerId(String fingerId) {
		this.fingerId = fingerId;
	}
	public String getIpKeyId() {
		return ipKeyId;
	}
	public void setIpKeyId(String ipKeyId) {
		this.ipKeyId = ipKeyId;
	}
	public boolean isDateIpDatePass() {
		return isDateIpDatePass;
	}
	public void setDateIpDatePass(boolean isDateIpDatePass) {
		this.isDateIpDatePass = isDateIpDatePass;
	}	
}
