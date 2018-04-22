package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;

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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub\
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("gbk");
        response.setContentType("text/html");

        String name = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        BizDaoImpl bdi = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bdi);

        boolean flag = bsi.User(name, upwd);

        PrintWriter out = response.getWriter();
        if (flag) {// 判断用户名是否正确
            HttpSession session = request.getSession();

            // Object obj = session.getAttribute("server_token"); //
            // 将InitServlet中的调过来
            // if (obj != null) {
            // String click_token = request.getParameter("click_token");//
            // 获取隐藏域中的数据
            // String str = (String) obj;

            // if (click_token.equals(str)) {// 匹配隐藏域
            // 第一次
            session.setMaxInactiveInterval(60 * 60);
            session.setAttribute("loginname", name);
            response.sendRedirect("Init");

            // 清楚session中的令牌
            // session.removeAttribute("server_token"); //
            // 清除掉系统令牌，使获得的令牌无法与系统令牌进行第二次比较
            // } else {
            // out.print("<script>");
            // out.print("alert('不能重复提交');");
            // out.print("window.location.href='Init';");
            // out.print("</script>");

            // }

            // }

        } else {
            out.print("<script>");
            out.print("alert('用户名或密码错误');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();
        }

    }
}
