package com.human.cafe;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.cafe.iCafe;	//interface import해줘야됨
import com.human.cafe.Cafesales;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//XML	-> SQL id를 interface(iCafe.java)에서 ArrayList로 Menu 받아야됨 
//DTO	-> Menu.java 패키지 안에 들은거임
//Interface

@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		iCafe cafe=sqlSession.getMapper(iCafe.class);	//interface에서 찾아오는거임
		model.addAttribute("ml",cafe.getMenuList());
		model.addAttribute("sl",cafe.getSales());
		return "home";
		
//		cafe.getMenuList(); // return값 = arraylist로 옴
//		ArrayList<Menu> ml=cafe.getMenuList();
	}
	@ResponseBody	// return "data" 원래는 return jsp파일이지만 responsebody가 붙으면 data를 return한다는 말.
	@RequestMapping(value="/list",method=RequestMethod.POST,
					produces="application/json;charset=utf-8")//이거 넣어야 한글 안깨짐
	public String list() {
		iCafe cafe=sqlSession.getMapper(iCafe.class);
		ArrayList<Menu> ml=cafe.getMenuList();
		//JSONObject를 JSONArray에 넣고 이걸 toString -> writer().print()로 써야됨
		//[{name:'americano',price:2000},{name:'mocca',price:3500},.....] 이게 한 덩이
		JSONArray ja=new JSONArray();	// jsonarray,jsonobject로 받아서 처리해야됨 json lib쓰려면 pom.xml에서 dependency import.
		for(int i=0; i<ml.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("code",ml.get(i).getCode());
			jo.put("name",ml.get(i).getName());
			jo.put("price",ml.get(i).getPrice());
			ja.add(jo);
			
		}
		return ja.toString(); // function txt로 들어감
		
	}
	@ResponseBody
	@RequestMapping(value="/insertMenu",method=RequestMethod.POST)
	public String insertMenu(HttpServletRequest hsr) {
		String retval="";	//return값 빈칸으로 먼저 만들고
		try {
			String name=hsr.getParameter("name");
			int price=Integer.parseInt(hsr.getParameter("price"));
		
			iCafe cafe=sqlSession.getMapper(iCafe.class);
			cafe.insertMenu(name,price);
			retval="ok";
		} catch(Exception e) {
			retval="fail";
		}
		return retval;	//전달 될 데이터임
	}
	
	@ResponseBody
	@RequestMapping(value="/updateMenu",method=RequestMethod.POST)
	public String updateMenu(HttpServletRequest hsr) {
		String retval="";
		try {
			int code=Integer.parseInt(hsr.getParameter("code"));
			String name=hsr.getParameter("name");
			int price=Integer.parseInt(hsr.getParameter("price"));
		
			iCafe cafe=sqlSession.getMapper(iCafe.class);
			cafe.updateMenu(code,name,price);
			retval="ok";
		} catch (Exception e) {
			retval="fail";
		}
		return retval;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMenu",method=RequestMethod.POST)
	public String deleteMenu(HttpServletRequest hsr) {
		String retval="";
		try {
		int code=Integer.parseInt(hsr.getParameter("code"));
		
		iCafe cafe=sqlSession.getMapper(iCafe.class);
		cafe.deleteMenu(code);
		retval="ok";
		} catch (Exception e) {
			retval="fail";
		}
		return retval;
	}
	
	@ResponseBody
	@RequestMapping(value="/insertSales",method=RequestMethod.POST,
					produces="application/json;charset=utf-8")
	public String insertSales(HttpServletRequest hsr) {
		String retval="";
		try {
			
		int menu_code=Integer.parseInt(hsr.getParameter("menu_code"));
		int qty=Integer.parseInt(hsr.getParameter("qty"));
		int price=Integer.parseInt(hsr.getParameter("price"));
		String mobile=hsr.getParameter("mobile");
		
		iCafe cafe=sqlSession.getMapper(iCafe.class);
		cafe.insertSales(menu_code, qty, price, mobile);
		retval="ok";
		} catch(Exception e){
			retval="fail";
		}
		return retval;
	}
	
	@ResponseBody
	@RequestMapping(value="/salesMenu",method=RequestMethod.POST,
					produces="application/json;charset=utf-8")
	public String salesMenu() {
			iCafe cafe=sqlSession.getMapper(iCafe.class);
			ArrayList<Sales> ml=cafe.salesMenu();
			JSONArray ja=new JSONArray();	
			for(int i=0; i<ml.size(); i++) {
				JSONObject jo=new JSONObject();
				jo.put("name",ml.get(i).getName());
				jo.put("total",ml.get(i).getTotal());
				ja.add(jo);
		}
		return ja.toString();		//json array를 문자열로 만들어라, json format data
		
	}
	
	@ResponseBody
	@RequestMapping(value="/salesMobile",method=RequestMethod.POST,
					produces="application/json;charset=utf-8")
	public String salesMobile() {
			iCafe cafe=sqlSession.getMapper(iCafe.class);
			ArrayList<Sales> ml=cafe.salesMobile();
			JSONArray ja=new JSONArray();	
			for(int i=0; i<ml.size(); i++) {
				JSONObject jo=new JSONObject();
				jo.put("mobile",ml.get(i).getName());
				jo.put("total",ml.get(i).getTotal());
				ja.add(jo);
		}
		return ja.toString();		//json array를 문자열로 만들어라, json format data
		
	}

	
	
	
}
