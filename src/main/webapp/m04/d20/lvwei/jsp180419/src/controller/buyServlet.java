package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;
import entity.shangping;
import entity.shangpingche;

/**
 * Servlet implementation class buyServlet
 */
public class buyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyServlet() {
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
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        BizDaoImpl bdi = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bdi);

        String str = request.getParameter("spid");
        int id = Integer.valueOf(str);

        String num = request.getParameter("spnum");
        int num1 = Integer.valueOf(num);

        String str1 = request.getParameter("spxj");
        Float count = Float.valueOf(str1);

        HttpSession session = request.getSession();
        HashMap<Integer, shangping> map = (HashMap<Integer, shangping>) session.getAttribute("map");

        shangpingche buy = new shangpingche();
        buy.setSpid(id);
        buy.setSpname(map.get(id).getSpname());
        buy.setSpprice(map.get(id).getSpprice());
        buy.setSpdesc(map.get(id).getSpdesc());
        buy.setNum(num1);
        buy.setCount(count);

        int flag = bsi.setche(buy);

        PrintWriter out = response.getWriter();

        if (flag > 0) {
            out.print("<script>");
            out.print("alert('添加成功');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();
        } else {
            out.print("<script>");
            out.print("alert('添加失败');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();
        }

    }
}
