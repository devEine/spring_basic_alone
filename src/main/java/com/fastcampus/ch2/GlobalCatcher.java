package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch2")
//아무것도 안적으면 모든 패키지의 예외처리
//적으면 해당 패키지안의 예외만 처리 
public class GlobalCatcher {
	//@ControllerAdvice 애너테이션을 붙여주면
	//모든 컨트롤러에서 사용가능한 예외처리 메서드가 된다
	
	//만약 해당 컨트롤러와 글로벌 컨트롤러 둘 다에 발생한 에러를 처리하는 메서드가 있다면?
	//가까운 메서드가 처리함 => 개별 컨트롤러가 처리함 
	
	@ExceptionHandler(Exception.class)
	public String cacther(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String cacther2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
		
	}
	@ExceptionHandler(FileNotFoundException.class)
	public String cacther3(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}

}
