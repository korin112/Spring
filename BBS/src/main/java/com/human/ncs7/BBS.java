package com.human.ncs7;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BBS {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/list")
	public String list(Model model) {
		Ibbs bbs=sqlSession.getMapper(Ibbs.class);
		ArrayList<Post> alPost=bbs.getList();
		model.addAttribute("alPost",alPost);
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest hsr,Model model) {
		int id=Integer.parseInt(hsr.getParameter("id"));
		Ibbs bbs=sqlSession.getMapper(Ibbs.class);
		bbs.plusHit(id);	//조회수 증가
		Post post=bbs.getView(id);	//게시물 내용 가져오기
		model.addAttribute("post",post); // post를 실어서 출력하려함
		return "view";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest hsr) {
		int post_id=Integer.parseInt(hsr.getParameter("id"));
		Ibbs bbs=sqlSession.getMapper(Ibbs.class);
		bbs.deletePost(post_id);
		return "redirect:/list";	// 데이터를 실어서 (DB를 거치도록) 위해서 redirect 사용
	}
	
	@RequestMapping("/compose")
	public String compose() {
		return "write";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)	//get방식은 데이터 받는 양이 적으니 post로 받으려면 이렇게 받아야댐
	public String write(HttpServletRequest hsr) {
		String title=hsr.getParameter("title");
		String name=hsr.getParameter("name");
		String content=hsr.getParameter("content");
		
		Ibbs bbs=sqlSession.getMapper(Ibbs.class);
		bbs.writePost(title,name,content);
		return "redirect:/list";
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest hsr,Model model) {
		int id=Integer.parseInt(hsr.getParameter("id"));
		Ibbs bbs=sqlSession.getMapper(Ibbs.class);
		Post post=bbs.getView(id);
		model.addAttribute("post",post);
		return "update";
	}
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(HttpServletRequest hsr) {
		int id=Integer.parseInt(hsr.getParameter("post_id"));
		String title=hsr.getParameter("title");
		String name=hsr.getParameter("name");
		String content=hsr.getParameter("content");
		Ibbs bbs=sqlSession.getMapper(Ibbs.class);
		bbs.modifyPost(id,title,name,content);
		return "redirect:/list";
	}
}
