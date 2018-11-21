package com.gs.fefec.web.pub.session;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

	@RequestMapping( value="/sessionExpire", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView  sessionExpire( HttpServletRequest request) {
		return new ModelAndView("SessionController.sessionExpire");
	}
}