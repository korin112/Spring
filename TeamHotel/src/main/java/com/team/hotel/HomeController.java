package com.team.hotel;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/typecontrol")
	public String typecontrol() {
		return "typecontrol";
	}
	 
	@RequestMapping("/addType")
	public String addType(HttpServletRequest hsr) {
		int type_code = Integer.parseInt(hsr.getParameter("type_code"));
		String name = hsr.getParameter("name");
		
		iHotel addtype=sqlSession.getMapper(iHotel.class);
		addtype.addType(type_code,name);
		return "typecontrol";
	}
		
	@RequestMapping("/selType")
	public String selType(Model m) {
		iHotel selType = sqlSession.getMapper(iHotel.class);
		
		return "";
	}
	
	
	
	
	@RequestMapping("/roomcontrol")
	public String roomcontrol() {
		return "roomcontrol";
	}
	
	@RequestMapping("/addRoom")
	public String addRoom(HttpServletRequest hsr) {
		String name = hsr.getParameter("name");
		int type = Integer.parseInt(hsr.getParameter("type"));
		int howmany = Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch = Integer.parseInt(hsr.getParameter("howmuch"));
		
		iHotel addroom=sqlSession.getMapper(iHotel.class);
		addroom.addRoom(name,type,howmany,howmuch);
		return "roomcontrol";
	}
	
	
	
	
	
	
}
