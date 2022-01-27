package com.human.exercise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

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
		int x1=Integer.parseInt(hsr.getParameter("x1"));
		int x2=Integer.parseInt(hsr.getParameter("x2"));
		int result;
		String op=hsr.getParameter("op");

		if(op.equals("+")) {
			result=x1+x2;
			model.addAttribute("result",result);
			return "plus";
		} else if(op.equals("-")) {
			result=x1-x2;
			model.addAttribute("result",result);
			return "minus";
		} else if(op.equals("x")) {
			result=x1*x2;
			model.addAttribute("result",result);
			return "multi";
		} else if(op.equals("/")) {
			result=x1/x2;
			model.addAttribute("result",result);
			return "divide";
		} else {
			model.addAttribute("result","연산자불명");
			return "error";
		}
		
		
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
//		try {
//			int x1=Integer.parseInt(hsr.getParameter("x1"));
//			int x2=Integer.parseInt(hsr.getParameter("x2"));
//			int result=x1*x2;
//			if(result<=20) {
//				model.addAttribute("result",result);
//				return "input";
//			} else {
//				model.addAttribute("result",result);
//				return "calc";
//			  }
//		} catch(Exception e) {
//			model.addAttribute("result","error");
//			return "input";
//		  }
	}
		
	
	@RequestMapping("/input")
	public String input() {
		return "input";
	}
	
	
}
