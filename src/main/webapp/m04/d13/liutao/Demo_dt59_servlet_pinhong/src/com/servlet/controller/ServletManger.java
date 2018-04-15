package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.basedao.impl.BizDaoImpl;
import com.servlet.entity.User;
import com.servlet.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ServletManger
 */
public class ServletManger extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletManger() {
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
        String uname = request.getParameter("uname");// 获取输入的账号字符
        String upwd = request.getParameter("upwd");// 获取输入的密码字符
        User user = new User();
        user.setUname(uname);// 放入javabean中
        user.setUpwd(upwd);
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizdao(bdi);// 注入
        Boolean flag = bsi.getUserInfo(user);
        String ustatus = bsi.getUstaus(user);
        response.setCharacterEncoding("utf-8");// 服务端响应编码设置影响后台文字的编码格式
        PrintWriter out = response.getWriter();// 向客户端发送文本
        HttpSession session = request.getSession();// session接口
        if (flag) {
            session.setAttribute("Login", uname);
            session.setAttribute("ustatus", ustatus);
            request.getRequestDispatcher("admin/index.jsp").forward(request, response);
        } else {
            out.print("<script>");
            out.print("alert('用户名或密码错误！');");
            out.print("location.href='Jsp_Proscenium/Login.jsp';");
            // out.print("location.href='init';");
            out.print("</script>");
            out.flush();// 刷新
            out.close();
        }

    }
}
