package controlier;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;
import entity.Message;
import entity.revert;

/**
 * Servlet implementation class revertServlet
 */
public class revertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public revertServlet() {
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

        List<Message> mess = bsi.getmessage();
        List<revert> rev = bsi.getrevert();
        HttpSession session = request.getSession();
        session.setAttribute("Mess1", mess);
        session.setAttribute("listrev", rev);

        String id = request.getParameter("id");
        Integer id1 = Integer.parseInt(id);
        session.setAttribute("id", id1);

        request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request, response);
    }

}
