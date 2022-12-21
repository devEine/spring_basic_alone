package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		//1. 로그인 체크 
		if(!loginCheck(request)) { //세션에 저장된 id가 null이면(로그인이 되어있지 않으면)
			return "redirect:/login/login?toURL="+request.getRequestURL(); //로그인 페이지로 이동 
			//return "redirect:/login/login"; //로그인 페이지로 이동 
		}
		return "boardList";//로그인 했으면 게시판 view로 이동 
	}

	private boolean loginCheck(HttpServletRequest request) {
		//1. 세션을 얻어서
		HttpSession session = request.getSession();
		//2. 세션의 id가 있는지 확인, id가 있으면 true반환
		/*
		 * if(session.getAttribute("id")==null) 
		 * 	return true; 
		 * else 
		 * 	return false;
		 */
		
		return session.getAttribute("id")!=null;
	}
}
