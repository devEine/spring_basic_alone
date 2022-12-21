package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	//로그인 페이지 보여주기 (GET)
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1.세션을 종료
		session.invalidate();
		//2.홈으로 이동 
		return "redirect:/";
		
	}
	
	//로그인 과정 처리하기(POST)
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, String toURL,
			HttpServletResponse response, HttpServletRequest request) throws Exception{
 
		//1. id와 pw확인
		if(!loginCheck(id,pwd)) {
			//2-1. 일치하지 않으면 loginForm으로 이동 
			String msg = URLEncoder.encode("id 또는 pw가 일치하지 않습니다.","utf-8");
			
			return "redirect:/login/login?msg="+msg; 
		}
		//2-2. id와 pw일치하면, (아이디 쿠키 저장)
		//세션 객체 얻어오기 -> request에서 세션 얻어옴
		HttpSession session = request.getSession();
		//세션 객체에 id를 저장
		session.setAttribute("id",id);
		
		if(rememberId) { //아이디 저장버튼이 눌러져있을때 (참일때) => 쿠키 생성
			//1.쿠키를 생성
			Cookie cookie = new Cookie("id",id); //id라는 이름으로 들어오는 id값 저장 
			//2.응답에 저장
			response.addCookie(cookie); //쿠키 추가
		}else {
			//아이디 저장버튼이 눌러져있지 않을 때(거짓일 때) => 쿠키 삭제
			//1.쿠키를 삭제 
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			//2.응답에 저장
			response.addCookie(cookie);
			
		}
			//3.홈으로 이동
		//toURL이 제대로 넘어오지 않으면 홈화면으로 이동 
		toURL = toURL==null || toURL.equals("")? "/":toURL;
		
		return "redirect:"+toURL;
	}
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}

}
