package com.gs.fefec.web.pub.session;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/public/restSpring/session")
public class SessionRestController {

	@RequestMapping(value="/refresh", method=RequestMethod.POST)
	public @ResponseBody String refreshSession(HttpServletRequest request,HttpSession session) {
		return "";
	}
}
