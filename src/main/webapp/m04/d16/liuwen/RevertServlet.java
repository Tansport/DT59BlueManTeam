package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Message;
import com.dt59.entity.Revert;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class RevertServlet
 */
public class RevertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevertServlet() {
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
        request.setCharacterEncoding("utf-8");
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bizdao);
        int id = Integer.parseInt(request.getParameter("mid"));
        List<Message> messListById = bsi.getMessageById(id);
        List<Revert> revertListById = bsi.getRevertById(id);
        // for (Revert revert : revertListById) {
        // System.out.println(revert.getRcontent());
        // }
        /*
         * for (Message message : messListById) {
         * System.out.println(message.getMtitle()); }
         */
        // HttpSession session = request.getSession();
        request.setAttribute("messListById", messListById);
        request.setAttribute("revertListById", revertListById);
        request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request, response);
    }
}
