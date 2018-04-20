package com.dt59.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Shangping;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class upServlet
 */
public class UpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpServlet() {
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
        String id = request.getParameter("id");
        String up = request.getParameter("up");
        int id1 = Integer.valueOf(id);
        int up1 = Integer.valueOf(up);

        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);

        Shangping sp = bsi.getShangpingById(id1);
        if (up1 <= 1) {
            sp.setUp(1);
        } else {
            sp.setUp(up1);
        }

        HttpSession session = request.getSession();

        HashMap<Integer, Shangping> map1 = (HashMap<Integer, Shangping>) session.getAttribute("map");

        map1.put(id1, sp);
        session.setAttribute("map", map1);
        request.getRequestDispatcher("Show.jsp").forward(request, response);
    }

}
