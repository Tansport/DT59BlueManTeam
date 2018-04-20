package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Shopping;
import com.dt59.service.impl.BizDaoServiceImpl;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShoppingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    HashMap<Integer, Shopping> map = null;// 声明

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        map = new HashMap<Integer, Shopping>();// 一次初始化多次调用
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
        response.setContentType("utf-8");

        BizDaoImpl bdi = new BizDaoImpl();
        BizDaoServiceImpl bsi = new BizDaoServiceImpl();
        bsi.setBizdao(bdi);// 注入

        PrintWriter out = response.getWriter();// 输出流
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("LoginName");
        String sd = request.getParameter("sid");
        int sid = Integer.valueOf(sd);
        if (obj != null) {
            String uname = (String) obj;
            request.setAttribute("uname", uname);
            Shopping sp = bsi.getAllbyId(sid);
            // 如何使用结合判断编号，重复的编号数量累加，不包含的编号新增一条
            if (map.containsKey(sid)) {
                // 重复的编号数量累加
                sp.setNum(map.get(sid).getNum() + 1);// 将值放入sp对象
                map.put(sid, sp);// 放入集合

            } else {
                // 不包含的编号新增一条
                map.put(sid, sp);//
            }

            // request.setAttribute("sp", sp);
            request.setAttribute("map", map);// 放入map集合
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else {
            out.print("<script>");
            out.print("alert('您未登陆!');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();

        }

    }
}
