package com.human.exercise;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	@Autowired
	private SqlSession sqlSession;	//servlet-context bean에 있는 내용이 딸려들어감 db에 관해 설정된 데이터가 모아짐
	
	
	@RequestMapping("/deleteRoom")
	public String doDeleteRoom(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("roomcode"));
		iEmp delRoom=sqlSession.getMapper(iEmp.class);
		delRoom.deleteRoom(code);
		return "redirect:/roomadd";
	}
	
	@RequestMapping("/addType")
	public String addtype(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("type"));
		String name=hsr.getParameter("roomname");
		iEmp addtype=sqlSession.getMapper(iEmp.class);
		addtype.addType(code, name);
		return "addType";
	}
	
	@RequestMapping("/typeadd")
	public String typeadd() {
		return "addType";
	}
	
	@RequestMapping("/addRoom")		//insert
	public String doaddRoom(HttpServletRequest hsr) {
		String strCode=hsr.getParameter("roomcode");
		String name=hsr.getParameter("roomname");
		int type=Integer.parseInt(hsr.getParameter("roomtype"));
		int howmany=Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch=Integer.parseInt(hsr.getParameter("howmuch"));
		
		if(strCode.equals("")) {
		iEmp add=sqlSession.getMapper(iEmp.class);
		add.addRoom(name,type,howmany,howmuch);
		} else {
			int code=Integer.parseInt(strCode);
			iEmp emp=sqlSession.getMapper(iEmp.class);
			emp.updateRoom(code, name, type, howmany, howmuch);
		}
		return "redirect:/roomadd";
	}
	
	@RequestMapping("/roomadd")		//select
	public String doroomadd(Model m) {
		iEmp getRoom=sqlSession.getMapper(iEmp.class);
		ArrayList<room> RoomList=getRoom.getRoomList();
		m.addAttribute("roomlist",RoomList);
		ArrayList<RoomType> typeList=getRoom.getRoomType();
		m.addAttribute("types",typeList);
		
		
		return "addRoom";
	}
	
	@RequestMapping("/deleteMenu")
	public String doDeleteMenu(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("code"));
		iEmp delMenu=sqlSession.getMapper(iEmp.class);
		delMenu.deleteMenu(code);
		return "redirect:/menuadd";
	}

	@RequestMapping("/menuadd")	//addMenu.jsp 보여주기위함
	public String doMenuadd(Model m) {
		iEmp getMenu=sqlSession.getMapper(iEmp.class);
		ArrayList<Menu> MenuList=getMenu.getMenuList();
		m.addAttribute("MenuList",MenuList);
//		System.out.println(MenuList.size());
		return "addMenu";
	}
	
	@RequestMapping("/addMenu")	//submit버튼이 눌리면 작동
	public String doAddMenu(HttpServletRequest hsr) {
		String strCode=hsr.getParameter("code");
		String mname=hsr.getParameter("menu_name");
		int mprice=Integer.parseInt(hsr.getParameter("price"));
		
		if(strCode.equals("")) {	//insert
			iEmp emp=sqlSession.getMapper(iEmp.class);
			emp.addMenu(mname,mprice);
		} 		
		else {					//update
			int code=Integer.parseInt(strCode);
			iEmp emp=sqlSession.getMapper(iEmp.class);
			emp.updateMenu(code, mname, mprice);
		}
		return "redirect:/menuadd";
	}

	@RequestMapping("/country")
	public String CountryList(Model m) {
		iCountry cou=sqlSession.getMapper(iCountry.class);
		ArrayList<Country> alcountry=cou.getCountryList();
		m.addAttribute("alcountry",alcountry);
		return "country";
	}
	
	@RequestMapping("/emp")
	public String doEmpList(Model m) {
		iEmp emp=sqlSession.getMapper(iEmp.class);	//interface 이름 써줘야됨 데이터 싹 모여서
		ArrayList<Employee> alemp=emp.getEmpList(); //emp.xml에서 id가 getEmpList를 호출해라 실제로 데이터가 담기는건 alemp
		System.out.println(alemp.size());
		m.addAttribute("alemp",alemp);
		return "emp";
	}
	

	@RequestMapping(value = "/look", method = RequestMethod.GET)
	public String look(HttpServletRequest hsr, Model model) {
		model.addAttribute("mobile", "01035108965"); // model로 전달하는 데이터 "mobile"로 표현언어 하면 데이터 넘어감
		model.addAttribute("address", "충남 천안시 동남구 대흥동");
		return "look";
	}

//	@RequestMapping(value="/view", method=RequestMethod.GET)
	// get방식이면 아래처럼 씀
	@RequestMapping("/view")
	public String view(HttpServletRequest hsr) {
//	데이터 받을땐 HttpServletRequest 써줘야됨 pathvariable param도 쓸 수 있음
		String nick = hsr.getParameter("nickname");
//		데이터 받아오고 문자열이던 데이터 방식대로 변수 설정 해야됨 // client에서 보내진 데이터를 수집.
		System.out.println(nick);
		return "redirect:/look"; // redirect 안쓰면 look에 있는 데이터 안옴
		// redirect = look을 띄워라 라는 뜻
	}
	
	@RequestMapping("/calc")
	public String calc(HttpServletRequest hsr,Model model) {
//		int x1=Integer.parseInt(hsr.getParameter("x1"));
//		int x2=Integer.parseInt(hsr.getParameter("x2"));
//		int result;
//		String op=hsr.getParameter("op");
//
//		if(op.equals("+")) {
//			result=x1+x2;
//			model.addAttribute("result",result);
//			return "plus";
//		} else if(op.equals("-")) {
//			result=x1-x2;
//			model.addAttribute("result",result);
//			return "minus";
//		} else if(op.equals("x")) {
//			result=x1*x2;
//			model.addAttribute("result",result);
//			return "multi";
//		} else if(op.equals("/")) {
//			result=x1/x2;
//			model.addAttribute("result",result);
//			return "divide";
//		} else {
//			model.addAttribute("result","연산자불명");
//			return "error";
//		}
//		
		
//		int x1 = Integer.parseInt(hsr.getParameter("x1"));
//		int x2 = Integer.parseInt(hsr.getParameter("x2"));
//		int x1,x2;		
//		if(hsr.getParameter("x1") =="" || hsr.getParameter("x1")==null
//				|| hsr.getParameter("x2")=="" || hsr.getParameter("x2")==null) {
//			model.addAttribute("result","error");
//			return "input";
//		} else {
//			x1 = Integer.parseInt(hsr.getParameter("x1"));
//			x2 = Integer.parseInt(hsr.getParameter("x2"));
//			int result=x1*x2;
//			if(result<20)
//			model.addAttribute("result",result);
//			return "input";
//		  }
		
		try {
			int x1=Integer.parseInt(hsr.getParameter("x1"));
			int x2=Integer.parseInt(hsr.getParameter("x2"));
			int result=x1*x2;
			if(result<=20) {
				model.addAttribute("result",result);
				return "input";
			} else {
				model.addAttribute("result",result);
				return "calc";
			  }
		} catch(Exception e) {
			model.addAttribute("result","error");
			return "input";
		  }
	}
		
	
	@RequestMapping("/input")
	public String input() {
		return "input";
	}
	
	
}
