package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Shangpin;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShoppingServlet extends HttpServlet {
    Map<Integer, Shangpin> map = null;

    private static final long serialVersionUID = 1L;

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
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        map = new HashMap<Integer, Shangpin>();
    }

    /**
     * @see Servlet#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("LoginName");
        BizServiceImpl bsi = new BizServiceImpl();
        BizDaoImpl bdi = new BizDaoImpl();
        bsi.setBizDao(bdi);
        String str = request.getParameter("spid");
        int spid = Integer.parseInt(str);
        if (obj != null) {
            Shangpin sp = bsi.getSpInfoById(spid);
            // 1、重复的编号，数目在原基础上加1
            if (map.containsKey(spid)) {
                int i = map.get(spid).getNum();
                sp.setNum(i + 1);
                map.put(spid, sp);
                // 2、不包含的编号，新增一条
            } else {
                map.put(spid, sp);
            }
            // session.setAttribute("sp", sp);
            request.setAttribute("map", map);
            request.getRequestDispatcher("show.jsp").forward(request, response);
            // response.sendRedirect("show.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('您尚未登入')");
            // out.println("window.location.href='login.jsp';");
            out.println("window.location.href='init';");
            out.println("</script>");
            out.flush();
            out.close();
        }
    }
}
