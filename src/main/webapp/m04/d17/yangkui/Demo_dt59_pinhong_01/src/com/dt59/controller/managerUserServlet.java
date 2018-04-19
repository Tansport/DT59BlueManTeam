package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dt59.entity.User;
import com.dt59.impl.BizDaoImpl;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class managerUserServlet
 */
public class managerUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    BizDaoImpl bizdao=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizbao(bizdao);//为什么要注入
       List<User> listUser= bsi.getAllUser();
       request.setAttribute("listUser", listUser);
       request.getRequestDispatcher("admin/showUserList.jsp").forward(request, response);
        
	}

}
