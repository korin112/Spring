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
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/signon", method = RequestMethod.GET)
	public String signon() {
		return "signon";
	}

	@RequestMapping(value = "/insertLogin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String insertLogin(HttpServletRequest hsr) {
		try {
			String name = hsr.getParameter("name");
			String gender = hsr.getParameter("gender");
			String userid = hsr.getParameter("userid");
			String passcode = hsr.getParameter("passcode");
			String[] interest1 = hsr.getParameterValues("interest");
			String interest = "";

			for (int i = 0; i < interest1.length; i++) {
				interest += interest1[i];
			}

			iMember member = sqlSession.getMapper(iMember.class);
			member.insertLogin(name, gender, userid, passcode, interest);
		} catch (Exception e) {

		}
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "/sign_check", method = RequestMethod.POST,
					produces = "application/json;charset=utf-8")
	public String signoncheck() {
		iMember member = sqlSession.getMapper(iMember.class);
		ArrayList<Login1> getsigncheck = member.getsigncheck();
		JSONArray ja = new JSONArray();
		for (int i = 0; i < getsigncheck.size(); i++) {
			JSONObject jo = new JSONObject();
			jo.put("userid", getsigncheck.get(i).getUserid());
			ja.add(jo);
		}
		return ja.toString();
	}
	
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String login() {
	  
	  return "login";
	  }
	 
	  @RequestMapping(value = "/login_check", method = RequestMethod.POST)
	  public String login_check(HttpServletRequest hsr,Model model) {
		  	String userid=hsr.getParameter("userid");
		  	String passcode=hsr.getParameter("passcode");
		  	iMember member = sqlSession.getMapper(iMember.class);
		  	ArrayList<Login1> m=member.member();
			String flag="";
			for(int i=0; i<m.size(); i++){
				if(m.get(i).userid.equals(userid) && m.get(i).passcode.equals(passcode)) { 
				flag="ok";
				break;
				}else {
					flag="fail";
				}
			}
		if(flag.equals("fail")){
			model.addAttribute("userid","아이디와 비밀번호가 일치하지 않습니다.");
			return "login";
		}else {
		member.updateLogin(userid);
		model.addAttribute("userid",userid);
		return "home";
		}
	  }

	  @RequestMapping(value = "/logout", method = RequestMethod.POST)
	  public String logout(HttpServletRequest hsr) {
		  String userid=hsr.getParameter("logout");
		  System.out.println(userid);
		  iMember member = sqlSession.getMapper(iMember.class);
		  member.updateLogout(userid);
	  return "home";
	  }
}
