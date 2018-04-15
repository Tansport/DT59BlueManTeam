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
 * Servlet implementation class SpageServlet
 */
public class SpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpageServlet() {
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
	    request.setCharacterEncoding("utf-8");
        String currentpage = request.getParameter("currentpage");
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizbao(bdi);// 注入
        Page page = new Page();
        HttpSession session = request.getSession();
        int count = bsi.getSumCount(page);// 总页数
        page.setLastpage(count);// 计算出尾页数
        page.setCurrentpage(Integer.parseInt(currentpage));
        List<Product> listpro = bsi.getLimitPage(page);
        session.setAttribute("listpro", listpro);
        session.setAttribute("page", page);
        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);
	}
	
}
