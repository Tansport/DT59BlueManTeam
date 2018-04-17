/**
 * Project Name:Demo_dt59_pinHong_01
 * File Name:revertServlet.java
 * Package Name:com.dt59.controller
 * Date:2018年4月17日上午12:48:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Message;
import com.dt59.entity.revert;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Description: <br/>
 * Date: 2018年4月17日 上午12:48:55 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class revertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public revertServlet() {
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
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bizdao);

        List<Message> mess = bsi.getmessage();
        List<revert> rev = bsi.getrevert();
        HttpSession session = request.getSession();
        session.setAttribute("Mess1", mess);
        session.setAttribute("listrev", rev);

        String id = request.getParameter("id");
        Integer id1 = Integer.parseInt(id);
        session.setAttribute("id", id1);

        request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request, response);
    }

}
