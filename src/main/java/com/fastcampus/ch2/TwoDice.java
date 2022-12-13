package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response)throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//매번 랜덤으로 각기 다른 주사위 이미지가 뜨게하기 위해서는?
		//Math.ramdom() : 0부터 1까지의 난수를 무작위로 생성
		//0부터 1 사이의 값이 소숫점이 붙어서 무작위로 출력
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		//HttpServletResponse 이용하여 브라우저에 이미지 띄우기
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src = 'resources/img/dice"+idx1+".jpg'>");
		out.println("<img src = 'resources/img/dice"+idx2+".jpg'>");		
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
