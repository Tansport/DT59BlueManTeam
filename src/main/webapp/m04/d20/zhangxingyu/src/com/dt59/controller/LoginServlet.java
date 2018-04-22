package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.User;
import com.dt59.service.impl.BizServiceImpl;
import com.dt59.util.TokenUtil;

public class LoginServlet extends HttpServlet {


	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname= request.getParameter("uname");
		String upwd= request.getParameter("upwd");
		User user=new User(uname,upwd);
		BizDaoImpl bdi=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bdi);
		boolean flag=bsi.validateUser(user);
		PrintWriter out= response.getWriter();
		if(flag){
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(60*60);
			TokenUtil tu=TokenUtil.getInstance();
			String server_token= tu.get_token();
			session.setAttribute("server_token", server_token);
			session.setAttribute("loginName", uname);
			response.sendRedirect("init");
		}else{
			out.print("<script>");
			out.print("alert('用户名或密码错误！');");
			out.print("window.location.href='init';");
			out.print("</script>");
			out.flush();
			out.close();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
