package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Message;
import com.dt59.entity.User;
import com.dt59.service.impl.BizServiceImpl;

public class MessageServlet extends HttpServlet {

    public MessageServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bizdao);

        List<Message> mess = bsi.getAllMessage(); // 遍历留言主题
        HttpSession session = request.getSession();

        String userName = request.getParameter("userName"); // 用户名和密码匹配
        String password = request.getParameter("password");

        User user = new User();
        user.setUname(userName);
        user.setUpwd(password);

        boolean flag = bsi.validateUser(user);
        PrintWriter out = response.getWriter();

        if (flag) {

            session.setAttribute("Mess", mess);
            session.setAttribute("user", user);
            request.getRequestDispatcher("Jsp_Proscenium/S_MessageBoard.jsp").forward(request, response);
        } else {
            out.print("<script>");
            out.print("alert('用户名或密码错误');");
            out.print("location.href='Jsp_Proscenium/Loginliuyan.jsp'");
            out.print("</script>");
            out.flush();// 刷新
            out.close();
        }

    }

}
