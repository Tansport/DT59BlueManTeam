package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Totle;
import com.dt59.service.impl.BizDaoServiceImpl;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
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
        response.setContentType("text/html");
        String spid = request.getParameter("spid");
        String spname = request.getParameter("spname");
        String spcount = request.getParameter("spcount");
        String sprice = request.getParameter("sprice");
        String spdesc = request.getParameter("spdesc");
        String sptotle = request.getParameter("sptotle");
        BizDaoImpl bdi = new BizDaoImpl();
        BizDaoServiceImpl bsi = new BizDaoServiceImpl();
        bsi.setBizdao(bdi);// 注入
        Totle totle = new Totle(Integer.valueOf(spid.trim()), spname.trim(), Integer.valueOf(spcount.trim()),
                Float.parseFloat(sprice.trim()), spdesc.trim(), Float.parseFloat(sptotle.trim()));
        int flag = bsi.getTotle(totle);
        PrintWriter out = response.getWriter();
        if (flag > 0) {
            out.write("添加成功！");

        } else {
            out.write("添加失败！");

        }

    }
}
