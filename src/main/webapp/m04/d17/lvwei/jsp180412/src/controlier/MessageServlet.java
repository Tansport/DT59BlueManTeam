package controlier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;
import entity.Message;
import entity.User;

/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
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
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bizdao);

        List<Message> mess = bsi.getmessage(); // 遍历留言主题
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
