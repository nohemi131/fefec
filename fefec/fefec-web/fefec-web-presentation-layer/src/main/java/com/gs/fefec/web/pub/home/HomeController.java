package com.gs.fefec.web.pub.home;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	@RequestMapping( value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView home(HttpServletRequest request,HttpSession session) {	
		session.invalidate();
		session.getId();
		return new ModelAndView("HomeController.index");
	}


	@RequestMapping( value="/notAllowed", method= {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView  notAllowed(HttpServletRequest request) {
		  return new ModelAndView("HomeController.notAllowed");
	}


	@RequestMapping( value="/header", method= {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView  header(HttpServletRequest request) {
		  return new ModelAndView("HomeController.header");
	}

}
