package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//�������� �ʱ�ȭ �� �� �ڵ� ȣ��Ǵ� �޼��� 
		//1. �������� �ʱ�ȭ �۾� ��� 
		System.out.println("HelloServlet init() is called");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.�Է�
		//2.ó��
		//3.��� 
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		//3.������ - �������� �޸𸮿��� ����
		System.out.println("HelloServlet destroy() is called");
	}

	
}