package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.User;
import com.dt59.service.impl.BizServiceimpl;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();
        SqlSessionFactory ssf = gsu.getsqlsessionfactory_();
        SqlSession sqlsession = ssf.openSession();
        BizServiceimpl bsi = new BizServiceimpl();
        BizDao bizdao = sqlsession.getMapper(BizDao.class);
        bsi.setBizdao(bizdao);// ×¢Èë

        String userCode = request.getParameter("userCode");
        String userPassword = request.getParameter("userPassword");

        User us = new User();
        us.setUserCode(userCode);
        us.setUserPassword(userPassword);
        List<User> list = bsi.validateUser(us);
        System.out.println("list:" + list.size());

        if (list.size() > 0) {
            // ×ª·¢

            request.getRequestDispatcher("jsp/frame.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

}
