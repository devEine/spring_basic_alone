package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	
	//예외가 발생하는 상황에 공통적으로 사용하는 메서드
	//try-catch일일히 안적어도 됨 
	@ExceptionHandler(Exception.class)
	public String cacther(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	//예외 종류에 따라 다르게 받을 수 있음 (NullPointerException인 경우)
	//애너테이션에 처리할 예외 경우 여러개 추가 가능 
	//만약 Exception의 자식 예외가 발생했는데 처리할 메서드 없는 경우 
	//조상인 Exception처리 메서드가 예외 처리함 
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//에러 코드를 변경하고 싶을 때 사용가능 
	public String cacther2(Exception ex, Model m) {
		System.out.println("ExceptionController: NullPointerException 처리");
		//=> ControllerAdvice 애너테이션보다 가까운 컨트롤러가 예외처리를 우선함을 확인
		//m.addAttribute("ex", ex);
		return "error";
	}
	/*
	 * @ExceptionHandler(FileNotFoundException.class) public String
	 * cacther3(Exception ex, Model m) { m.addAttribute("ex", ex); return "error"; }
	 */
	
	
	
	@RequestMapping("/ex")
	public String main() throws Exception{
			throw new Exception("예외가 발생하였습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
			throw new NullPointerException("예외가 발생하였습니다.");
	}
	
	/*
	 * @RequestMapping("/ex3") public String main3() throws Exception{ throw new
	 * FileNotFoundException("예외가 발생하였습니다."); }
	 */
	
	
}