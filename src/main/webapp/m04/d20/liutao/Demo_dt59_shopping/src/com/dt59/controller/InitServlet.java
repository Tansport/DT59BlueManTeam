package com.dt59.controller;

import java.io.IOException;
import java.util.List;

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
import com.dt59.until.Token;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
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
        BizDaoImpl bdi = new BizDaoImpl();
        BizDaoServiceImpl bsi = new BizDaoServiceImpl();
        bsi.setBizdao(bdi);
        List<Shopping> list = bsi.getAllShopping();

        HttpSession session = request.getSession();
        Token token = Token.getInstance();
        String server_token = token.get_token();
        session.setAttribute("server_token", server_token);

        request.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
