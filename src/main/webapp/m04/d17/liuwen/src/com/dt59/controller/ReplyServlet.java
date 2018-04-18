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
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see Servlet#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at:
        // ").append(request.getContextPath());
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // doGet(request, response);
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bizdao);
        int flag = bsi.getUpdateRepaly(Integer.parseInt(request.getParameter("2")), request.getParameter("content"),
                request.getParameter("loginName"));
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (flag > 0) {
            out.print("<script>");
            out.print("alert('回复成功！');");
            out.print("location.href='Jsp_Proscenium/MessageBoard_replay.jsp';");
            out.print("</script>");
            out.flush();
            out.close();
        } else {
            out.print("<script>");
            out.print("alert('回复失败！');");
            out.print("location.href='Jsp_Proscenium/MessageBoard_replay.jsp';");
            out.print("</script>");
        }
    }

}
