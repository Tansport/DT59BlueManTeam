package com.dt59.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	/**
	 * @param req:request  resp:response
	 * */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		request.setCharacterEncoding("utf-8");
		String str= request.getParameter("uname");
		//存值
		request.setAttribute("uname", str);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		System.out.println("我被毁了！");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		System.out.println("第1次调用servlet!");
	}
	
}
