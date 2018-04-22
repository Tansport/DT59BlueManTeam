package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Shangping;
import com.dt59.service.impl.BizServiceImpl;

public class InitServlet extends HttpServlet {

	
	public InitServlet() {
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
		BizDaoImpl bdi=new BizDaoImpl();
		BizServiceImpl bsi=new BizServiceImpl();
		bsi.setBizDao(bdi);
		List<Shangping> listsp= bsi.getAllShangping();
		request.setAttribute("listsp", listsp);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
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
