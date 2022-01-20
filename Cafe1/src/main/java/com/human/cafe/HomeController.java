package com.human.cafe;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.cafe.iCafe;	//interface import해줘야됨

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
//		cafe.getMenuList(); // return값 = arraylist로 옴
//		ArrayList<Menu> ml=cafe.getMenuList();
		model.addAttribute("ml",cafe.getMenuList());
		return "home";
	}
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST,
					produces="application/json;charset=utf-8")//이거 넣으면 한글 안깨짐
	public String list() {
		iCafe cafe=sqlSession.getMapper(iCafe.class);
		ArrayList<Menu> ml=cafe.getMenuList();
		//JSONObject를 JSONArray에 넣고 이걸 toString -> writer().print()로 써야됨
		//[{name:'americano',price:2000},{name:'mocca',price:3500},.....] 이게 한 덩이
		JSONArray ja=new JSONArray();
		for(int i=0; i<ml.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("code",ml.get(i).getCode());
			jo.put("name",ml.get(i).getName());
			jo.put("price",ml.get(i).getPrice());
			ja.add(jo);
		}
		return ja.toString();
		
	}
}
