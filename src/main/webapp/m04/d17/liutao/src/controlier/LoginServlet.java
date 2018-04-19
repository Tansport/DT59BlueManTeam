package controlier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;
import entity.User;

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
     * @see Servlet#destroy()
     */
    public void destroy() {
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
        // request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = new User();
        user.setUname(userName);
        user.setUpwd(password);

        BizDaoImpl bizdao = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bizdao);

        // response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        boolean flag = bsi.validateUser(user);
        String ustatus = bsi.AllUser(user);
        HttpSession session = request.getSession();
        HttpSession session2 = request.getSession(false);
        if (flag) {
            // request.setAttribute("ustatus", ustatus);
            session2.setAttribute("loginName", userName);
            session.setAttribute("ustatus", ustatus);
            request.getRequestDispatcher("admin/index.jsp").forward(request, response);
        } else {
            out.print("<script>");
            out.print("alert('用户名或密码错误');");
            out.print("location.href='Jsp_Proscenium/Login.jsp'");
            out.print("</script>");
            out.flush();// 刷新
            out.close();
        }

    }
}
