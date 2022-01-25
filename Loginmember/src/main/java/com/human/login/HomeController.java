package com.human.login;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.login.iMember;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/signon", method = RequestMethod.GET)
	public String signon(HttpServletRequest hsr) {
		return "signon";
	}
	
	@RequestMapping(value = "/insertLogin", method = RequestMethod.POST,
			produces="application/json;charset=utf-8")
	public String insertLogin(HttpServletRequest hsr) {
		try {
		String name=hsr.getParameter("name");
		String gender=hsr.getParameter("gender");
		String userid=hsr.getParameter("userid");
		String passcode=hsr.getParameter("passcode");
		String[] interest1=hsr.getParameterValues("interest");
		String interest="";
		
		for(int i=0;i<interest1.length;i++) {
			interest+=interest1[i];
		}
		
		iMember member=sqlSession.getMapper(iMember.class);
		member.insertLogin(name,gender,userid,passcode,interest);
		}catch (Exception e) {

		}
		return "signon";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signchk", method = RequestMethod.POST,
					produces="application/json;charset=utf-8")
	public String signonchk() {
		iMember member=sqlSession.getMapper(iMember.class);
		ArrayList<Login1> sgchk=member.getsignchk();
		JSONArray ja=new JSONArray();	
		for(int i=0; i<sgchk.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("userid",sgchk.get(i).getUserid());
			jo.put("passcode",sgchk.get(i).getPasscode());
			ja.add(jo);
	}
	return ja.toString();
	
	}
	
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
	 * login() {
	 * 
	 * return "login"; }
	 */
}
