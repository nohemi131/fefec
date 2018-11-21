package com.gs.fefec.web.pub.login;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gs.fefec.commons.utilities.ws.constants.Constants;
import com.gs.fefec.ws.core.entities.web.session.PrincipalSession;
import com.gs.fefec.ws.core.entities.web.user.UserData;




@RestController
@RequestMapping("/private/restLogin")
public class LoginRestController extends Constants {

	private static Logger log= Logger.getLogger(LoginRestController.class);

	@RequestMapping(value="/getUser", method = {RequestMethod.POST})
	public @ResponseBody UserData getUserData(HttpServletRequest request,Model model,HttpSession session, Principal principal) {
		UserData userdata = new UserData();

		PrincipalSession principalSession =new PrincipalSession();

		String userName="";
		
		  try{
				
				log.info("username: "+principal.getName());
				userName = principal.getName();
				log.info("Decrypted userName:" + userName);


			}catch(Exception e){
				e.printStackTrace();
			}		  
		log.info("userName: "+userName);
		
			
		userdata.setUserDesc(userName);			
	
		userdata.setIpKeyId(request.getRemoteAddr());
		principalSession.setUserData(userdata);
		session.setAttribute(SESSION_VARIABLE, principalSession);
		return userdata;
	}
}