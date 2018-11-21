package com.gs.fefec.ws.core.entities.web.session;

import com.gs.fefec.ws.core.entities.web.user.UserData;

public class PrincipalSession {

	private UserData userData = new UserData();

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	

}
