package com.gs.fefec.web.pub.login;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping( value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView  login(HttpServletRequest request,HttpSession session) {
		return new ModelAndView("LoginController.login");
	}


	@RequestMapping( value="/authentication", method= {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView  authentication(HttpServletRequest request) {
		  return new ModelAndView("LoginController.login");
	}

	@RequestMapping( value="/errorLogin", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView  errorLogin( HttpServletRequest request) {
		return new ModelAndView("LoginController.login");
	}
}
