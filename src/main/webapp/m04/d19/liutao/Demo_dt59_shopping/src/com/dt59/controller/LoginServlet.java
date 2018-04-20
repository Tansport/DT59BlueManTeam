package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.User;
import com.dt59.service.impl.BizDaoServiceImpl;

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
        super.destroy();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");//
        BizDaoImpl bdi = new BizDaoImpl();
        BizDaoServiceImpl bsi = new BizDaoServiceImpl();
        bsi.setBizdao(bdi);// 注入

        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        User user = new User(uname, upwd);
        boolean flag = bsi.getAllUser(user);

        PrintWriter out = response.getWriter();

        if (flag) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60 * 60);// 登陆有效时间
            session.setAttribute("LoginName", uname);// 设定登陆名
            // request.getRequestDispatcher("Init").forward(request,
            // response);//转发在客户端之前交换数据
            response.sendRedirect("Init");// 重定向在服务器端请求响应，有数据交换产生

        } else {
            out.print("<script>");
            out.print("alert('账号或密码错误,请重新登陆!');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();

        }

    }
}
