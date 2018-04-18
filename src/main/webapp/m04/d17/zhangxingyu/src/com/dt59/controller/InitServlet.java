package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.impl.BizServiceImpl;

public class InitServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InitServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
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
		BizDaoImpl bizdao=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bizdao);//为什么要注入
		String cpath= request.getContextPath();
		System.out.println("路径:------------------------->"+cpath);
		String method= request.getMethod();//默认方式：GET
		System.out.println("方法---------------------->"+method);
		String initparam= getInitParameter("initParam");
		System.out.println("初始化参数------------------------->"+initparam);
		//f1 f2 f3 进入不同方法
		String cparam= this.getServletContext().getInitParameter("cparam");
		System.out.println("上下文的参数--------------------》"+cparam);
		List<News> listnews= bsi.getAllNews();
		//request.setAttribute("listnews", listnews);
		//null true false  null=true 创建一个session   false:多了一个检测 当前是否有session,如果有直接引用，如果没有才创建
		HttpSession session= request.getSession();
		session.setAttribute("listnews", listnews);
		List<Product> listpro=bsi.getAllProduct();
		session.setAttribute("listpro", listpro);
		//转发
		request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request, response);
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
