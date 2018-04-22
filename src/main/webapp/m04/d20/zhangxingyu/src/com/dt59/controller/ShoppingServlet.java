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

public class ShoppingServlet extends HttpServlet {

    Map<Integer, Shangping> map = null;

    public ShoppingServlet() {
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);
        PrintWriter out = response.getWriter();
        // �жϵ�ǰ�û��Ƿ��¼
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("loginName");// 1
        String sid = request.getParameter("sid");
        Integer id = Integer.valueOf(sid);

        Object server_token = session.getAttribute("server_token");// 2

        if (server_token != null) {
            String s_token = (String) server_token;
            String client_token = request.getParameter("client_token");

            if (client_token.equals(s_token)) {
                if (obj != null) {
                    // �ȿ��ǵ�½�����⣬�ٿ�������
                    Shangping sp = bsi.getShangpingById(Integer.valueOf(sid));
                    if (map.containsKey(id)) { // �ж��Ƿ���ͬid
                        sp.setNum(map.get(id).getNum() + 1);
                        map.put(id, sp);
                    } else {
                        map.put(id, sp);
                    }
                    session.setAttribute("map", map);
                    request.getRequestDispatcher("Show.jsp").forward(request, response);
                } else {
                    out.print("<script>");
                    out.print("alert('����δ��½�����ȵ�¼');");
                    out.print("window.location.href='init';");
                    out.print("</script>");
                    out.flush();
                    out.close();
                }
                // ����session�е�����
                session.removeAttribute("server_token");
            }
        } else {
            out.print("<script>");
            out.print("alert('�벻Ҫ�ظ�ˢ�£�');");
            out.print("window.location.href='init';");
            out.print("</script>");
            out.flush();
            out.close();
        }
    }

    @Override
    public void init() throws ServletException {
        // Put your code here
        map = new HashMap<Integer, Shangping>();
    }

}
