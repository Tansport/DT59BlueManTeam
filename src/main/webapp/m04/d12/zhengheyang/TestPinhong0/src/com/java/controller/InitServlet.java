package com.java.controller;

import com.java.dao.com.java.Bazimp.BizDaoImpl;
import com.java.entity.News;
import com.java.serves.com.java.BizServiceImpl.BizServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class InitServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizdao(bizdao);
        List<News> listnews = bsi.getAllNews();

        HttpSession session = request.getSession();
        session.setAttribute("listnews",listnews);
        request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
