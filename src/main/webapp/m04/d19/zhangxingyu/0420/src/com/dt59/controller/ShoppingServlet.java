package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Shangping;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShoppingServlet extends HttpServlet {
    Map<Integer, Shangping> map = null;

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("loginName");
        String sid = request.getParameter("sid");
        if (obj != null) {
            Shangping sp = bsi.getShangpingById(Integer.valueOf(sid));
            request.setAttribute("sp", sp);
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else {
            out.print("<script>");
            out.print("alert('ÄúÉÐÎ´µÇÂ¼£¬ÇëÏÈµÇÂ¼£¡')");
            out.print("window.location.href='init';");
            out.print("</script>");
            out.flush();
            out.close();
        }
    }

    @Override
    public void init() throws ServletException {
        map = new HashMap<Integer, Shangping>();
    }
}
