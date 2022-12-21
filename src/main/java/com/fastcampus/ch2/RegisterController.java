package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	// 신규회원 가입 화면 띄우기 -> GET방식
	
	//신규회원 가입 화면 => GET,POST방식 둘 다 가능 
	@RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})	
	public String register() {
		return "registerForm"; //String타입일땐 return타입과 동일한 view페이지 이동 
	}
	 

	// 가상주소, 메서드방식
	// @RequestMapping(value ="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // 4.3버전부터 적용가능
	public String save(User user, Model m) throws Exception {
		// 1.유효성 검사
		if (!isValid(user)) {
			// msg메세지를 브라우저에 전달하는 법 1)
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			// return "redirect:/register/add?msg="+msg;

			// msg메세지를 브라우저에 전달하는 법 2)
			m.addAttribute("msg", msg);
			return "forward:/register/add";
			// return "redirect:/register/add?msg="+msg; 위의 두 줄은 이 한 줄과 같은 의미
			// redirect - 재요청의 의미가 있음
		}

		// 2.DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
