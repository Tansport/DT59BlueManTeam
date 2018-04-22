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
        Object server_token = session.getAttribute("server_token");
        if (server_token != null) {

            String s_token = (String) server_token;
            String client_token = request.getParameter("client_token");
            String uname = (String) obj;

            if (client_token.equals(s_token)) {
                if (obj != null) {
                    // 思考：先把登录的问题考虑进去，再考虑令牌
                    // 正常跳转
                    Shopping sp = bsi.getAllbyId(sid);
                    // 思考:如何使用集合? 判断编号:1:重复的编号,数量累加 2:不包含编号的情况,新增一条
                    if (map.containsKey(sid)) {
                        // 1:重复的编号,数量累加
                        sp.setNum(map.get(sid).getNum() + 1);
                        map.put(sid, sp);
                    } else {
                        // 2:不包含编号的情况,新增一条
                        map.put(sid, sp);
                    }
                    request.setAttribute("map", map);
                    request.setAttribute("uname", uname);
                    request.getRequestDispatcher("show.jsp").forward(request, response);
                } else {
                    out.print("<script>");
                    out.print("alert('您尚未登录，请先登录！');");
                    out.print("window.location.href='init';");
                    out.print("</script>");
                    out.flush();
                    out.close();
                }
                // 消除session中的令牌
                session.removeAttribute("server_token");
            }
        } else {
            out.print("<script>");
            out.print("alert('请不要重复刷新!');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();

        }

    }
}
