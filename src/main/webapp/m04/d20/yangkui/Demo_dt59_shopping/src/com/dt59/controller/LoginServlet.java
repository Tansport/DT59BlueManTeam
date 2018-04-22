package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.entity.User;
import com.dt59.imp.BizDaoImpl;
import com.dt59.serevice.impl.BizServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    BizDaoImpl bizdao=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizdao(bizdao);
    
       String uname= request.getParameter("uname");
       String upwd= request.getParameter("upwd");
       User user=new User(uname,upwd);
      boolean flag= bsi.validateUser(user);
      PrintWriter  out= response.getWriter();
      if(flag){
         HttpSession session=request.getSession();
         session.setMaxInactiveInterval(60*60);
         session.setAttribute("LoginName", uname);
//         session.setAttribute("LoginName", upwd);
         response.sendRedirect("init");
      }else{
          out.print("<script>");
          out.print("alert('用户名和密码输入错误！');");
          out.print("window.location.href='init';");
          out.print("</script>");
          out.flush();
          out.close();
      //    response.sendRedirect("init");
      }
       
	}

}
