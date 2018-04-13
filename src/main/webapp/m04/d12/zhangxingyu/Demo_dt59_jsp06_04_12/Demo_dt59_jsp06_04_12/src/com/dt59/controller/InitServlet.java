package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
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
        bsi.setBizdao(bizdao);
        List<News> listnews = bsi.getAllNews();
        HttpSession session = request.getSession();
        session.setAttribute("listnews", listnews);
        List<Product> listpro = bsi.getALLProduct();
        session.setAttribute("listpro", listpro);
        request.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(request, response);
        ;

    }

}
