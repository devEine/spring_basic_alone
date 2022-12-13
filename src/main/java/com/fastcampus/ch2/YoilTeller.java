package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//YoiTeller: 연월일 입력하면 요일을 알려주는 프로그램
		
		///1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2.작업
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);
		
		int dayOffWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOffWeek);
		
		//3.출력
		response.setContentType("text/html"); //출력할 데이터 타입 명시
		response.setCharacterEncoding("utf-8"); //인코딩 한글처리
		PrintWriter out = response.getWriter(); 
		//response객체에서 브라우저의 출력 스트림을 얻음
		out.println(year+"년 "+month+"월 "+day+"일은 ");
		out.println(yoil+"요일 입니다. ");
	}

}
