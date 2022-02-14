package com.team.hotel;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)	//show home
	public String home() {
		return "home";
	}

	
	//typecontrol CRUD	
	@RequestMapping(value = "/controltype")		//show typecontrol
	public String typecontrol() {
		return "typecontrol";
	}
	@RequestMapping(value = "/NewFile")		//show typecontrol
	public String NewFile() {
		return "NewFile";
	}
	@RequestMapping("/addType")		//insert typecontrol
	public String addType(HttpServletRequest hsr) {
		String type_name = hsr.getParameter("name");
		iHotel addtype=sqlSession.getMapper(iHotel.class); 
		addtype.addType(type_name);
		return "typecontrol";
	}
		
	@RequestMapping("/updType")		//update typecontrol
	public String updType(HttpServletRequest hsr) {
		String type_name = hsr.getParameter("name");
		int type_code = Integer.parseInt(hsr.getParameter("type_code"));
		iHotel updtype=sqlSession.getMapper(iHotel.class);
		updtype.updType(type_code, type_name);
		return "redirect:/typecontrol";
	}
	
	@ResponseBody			// typecontrol ajaxcall
	@RequestMapping(value="/typeadd1",produces="application/json;charset=utf-8")
	public String typeadd1() {
		iHotel selType = sqlSession.getMapper(iHotel.class);
		ArrayList<roomtypeDTO> seltype=selType.selType();
		JSONArray ja= new JSONArray();
		for(int i=0; i<seltype.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("type_code",seltype.get(i).getType_code());
			jo.put("type_name",seltype.get(i).getType_name());
			ja.add(jo);
		}
		return ja.toString();
	}
		
	@RequestMapping("/delType")		//delete typecontrol
	public String doDelType(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("type_code"));
		iHotel delType=sqlSession.getMapper(iHotel.class);
		delType.delType(code);
		return "redirect:/controltype";
	}
	
	@RequestMapping("/typecontrol")		//select typecontrol
	public String selType(Model m) {
		iHotel selType = sqlSession.getMapper(iHotel.class);
		ArrayList<roomtypeDTO> seltype=selType.selType();
		m.addAttribute("seltype",seltype);
		return "typecontrol";
	}
		
	//roomcontrol CRUD
	
	@RequestMapping("/controlroom")		//show roomcontrol
	public String roomcontrol() {
		return "redirect:/roomcontrol";
	}
	
	@RequestMapping("/roomcontrol")		//select roomcontrol
	public String selRoom(Model m) {
		iHotel selRoom = sqlSession.getMapper(iHotel.class);
		ArrayList<roomDTO> selroom=selRoom.selRoom();
		m.addAttribute("selroom",selroom);
		return "roomcontrol";
	}
	
	@RequestMapping("/delRoom")		//delete roomcontrol
	public String doDeleteRoom(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("room_code"));
		iHotel delRoom=sqlSession.getMapper(iHotel.class);
		delRoom.delRoom(code);
		return "redirect:/roomcontrol";
	}
	
	@RequestMapping("/addRoom")		//insert roomcontrol
	public String addRoom(HttpServletRequest hsr) {
		String strCode = hsr.getParameter("room_code");
		String name = hsr.getParameter("name");
		int howmany = Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch = Integer.parseInt(hsr.getParameter("howmuch"));
		
		if(strCode.equals("")) {
		iHotel addroom=sqlSession.getMapper(iHotel.class);
		int type = Integer.parseInt(hsr.getParameter("seltype"));
		addroom.addRoom(name,type,howmany,howmuch);
		} else {					//update roomcontrol
			int code=Integer.parseInt(strCode);
			int type = Integer.parseInt(hsr.getParameter("seltype"));
			iHotel updroom=sqlSession.getMapper(iHotel.class);
			updroom.updRoom(code, name,type, howmany, howmuch);
		}
		return "roomcontrol";
	}
	
	@ResponseBody				// roomcontrol ajaxcall
	@RequestMapping(value="/roomadd1",produces="application/json;charset=utf-8")
	public String roomadd1() {
		iHotel selRoom = sqlSession.getMapper(iHotel.class);
		ArrayList<roomDTO> selroom=selRoom.selRoom();
		JSONArray ja= new JSONArray();
		for(int i=0; i<selroom.size(); i++) {
			JSONObject jo=new JSONObject();
			jo.put("room_code",selroom.get(i).getRoom_code());
			jo.put("name",selroom.get(i).getName());
			jo.put("type",selroom.get(i).getType_name());
			jo.put("howmany",selroom.get(i).getHowmany());
			jo.put("howmuch",selroom.get(i).getHowmuch());
			ja.add(jo);
		}
		return ja.toString();
	}
	// roominfo start
	
	@RequestMapping("/roominfo")
	public String showroominfo() {
		return "roominfo";
	}
	
	@RequestMapping("/header")
	public String showheader() {
		return "header";
	}
	
	
	
	
	
	@RequestMapping("/superior")		//show superior  type들
	public String Showsuperior() {
		return "superior";
	}
	@RequestMapping("/superior/SDB")
	public String ShowSDB() {
		return "SDB";
	}
	@RequestMapping("/superior/STW")
	public String ShowSTW() {
		return "STW";
	}
	@RequestMapping("/superior/SFD")
	public String ShowSFD() {
		return "SFD";
	}
	@RequestMapping("/superior/SFT")
	public String ShowSFT() {
		return "SFT";
	}
		
	
	@RequestMapping("/gorgeous")
	public String Showgorgeous() {
		return "gorgeous";
	}
	
	@RequestMapping("/suite")
	public String Showsuite() {
		return "suite";
	}
	
	
	
}
