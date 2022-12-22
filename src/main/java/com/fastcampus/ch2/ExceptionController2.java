package com.fastcampus.ch2;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 -> 400 에러 코드 변경 
class MyException extends RuntimeException{
	public MyException(String msg) {
		super(msg);
	}
	public MyException() {
		this("");
	}
}

@Controller
public class ExceptionController2 {
	
	//예외처리 메서드는 동일한 컨트롤러 안에서만 사용가능함
	/*
	 * @ExceptionHandler(NullPointerException.class) public String
	 * cacther2(Exception ex, Model m) { m.addAttribute("ex", ex); return "error"; }
	 */
	
	/*
	 * @RequestMapping("/ex3") public String main() throws Exception{ throw new
	 * Exception("예외가 발생하였습니다."); }
	 */
	

	@RequestMapping("/ex3")
	public String main3() throws Exception{
		throw new Exception("예외가 발생하였습니다.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception{
		throw new NullPointerException("예외가 발생하였습니다.");
	}
	
	
}