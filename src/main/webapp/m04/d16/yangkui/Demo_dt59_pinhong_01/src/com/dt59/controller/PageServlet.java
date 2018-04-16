package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.impl.BizDaoImpl;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
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
//	    request.setCharacterEncoding("utf-8");
        String currentpage= request.getParameter("currentpage");
        BizDaoImpl bizdao=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizbao(bizdao);//为什么要注入
        int count=bsi.getProductNumber();
        Page pg=new Page();
        pg.setSumsize(count);
        pg.setLastpage(pg.getSumsize()%pg.getPagesize()==0?pg.getSumsize()/pg.getPagesize():pg.getSumsize()/pg.getPagesize()+1);
        pg.setCurrentpage(Integer.valueOf(currentpage));
        List<Product> listproduct= bsi.getAllProductByPage(pg);
        HttpSession session= request.getSession(false);
        session.setAttribute("listproduct", listproduct);
        session.setAttribute("pg", pg);
        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);
    
	}

}
