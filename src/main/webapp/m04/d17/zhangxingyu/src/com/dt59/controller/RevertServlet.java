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
import com.dt59.entity.Revert;
import com.dt59.service.impl.BizServiceImpl;

public class RevertServlet extends HttpServlet {

    public RevertServlet() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        // 通过id获取message数据中信息
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bizdao);// 为什么要注入
        Message mess = bsi.getMessageById(Integer.parseInt(id));
        List<Revert> listrev = bsi.getAllRevert();
        HttpSession session = request.getSession(false);// a标记方式提交，那么就不需要创建新的session
        session.setAttribute("mess", mess);
        session.setAttribute("listrev", listrev);
        String id1 = request.getParameter("id");
        Integer id2 = Integer.parseInt(id);
        session.setAttribute("id1", id2);
        String name = request.getParameter("user");
        session.setAttribute("name", name);
        request.getRequestDispatcher("Jsp_Proscenium/R_MessageBoard.jsp").forward(request, response);
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    @Override
    public void init() throws ServletException {
        // Put your code here
    }

}
