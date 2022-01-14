package com.human.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";	// JSP file name
//	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";	// JSP file name
	}
	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest hsr,Model model) {
		String userid=hsr.getParameter("userid");
		if(userid.equals("")) {
			return "login";
		} else {
		model.addAttribute("id", userid);
		return "home";
		}
	}
	@RequestMapping("/")
	public String home() {
		return "home";	// JSP file name
	}
	@RequestMapping("/signon")
	public String sign() {
		return "signon";	// JSP file name
	}
	@RequestMapping("/signon_check")
	public String signcheck(HttpServletRequest hsr,Model model) {
		String name=hsr.getParameter("realname");
		if(name.equals("")) {	
		return "signon";
		} else {
			return "login";
		}
	}
//	@RequestMapping("/signon_check")
//	public String signcheck(HttpServletRequest hsr,Model model) {
//		String name=hsr.getParameter("realname");
//		String userid=hsr.getParameter("idname");
//		String passcode=hsr.getParameter("passcode");
//		String passcode1=hsr.getParameter("passcode1");
//		String gender=hsr.getParameter("gender");
//		String birthday=hsr.getParameter("birthday");
//		String[] interest=hsr.getParameterValues("interest");
//		if(name.equals("")) {	
//		return "signon";
//		} else {
//			return "login";
//		}
//	}
//	@RequestMapping("/signon_check")
//	public String signcheck(@RequestParam("name") String name,
//			@RequestParam("userid") String userid,
//			@RequestParam("passcode") String passcode,
//			@RequestParam("passcode1") String passcode1,
//			@RequestParam("gender") String gender,
//			@RequestParam("birthday") String birthday,
//			@RequestParam("interest") String[] interest,
//			Model model) {
//				return "login";
//	}
	
	
	@RequestMapping("/logout")
	public String logout() {
		return "home";	// JSP file name
	}
	
	
}
