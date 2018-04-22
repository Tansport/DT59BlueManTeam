package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;
import entity.shangping;

/**
 * Servlet implementation class numServlet
 */
public class numServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public numServlet() {
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
        String spid = request.getParameter("spid");
        String num = request.getParameter("cnum");
        int spid1 = Integer.valueOf(spid);
        int num1 = Integer.valueOf(num);

        BizDaoImpl bdi = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bdi);

        shangping sp = bsi.getshagshangpin(spid1);
        if (num1 <= 1) {
            sp.setNum(1);
        } else {
            sp.setNum(num1);
        }

        HttpSession session = request.getSession();

        HashMap<Integer, shangping> map1 = (HashMap<Integer, shangping>) session.getAttribute("map");

        map1.put(spid1, sp);
        session.setAttribute("map", map1);
        request.getRequestDispatcher("Show.jsp").forward(request, response);
    }

    public void init() throws ServletException {
        // map = new HashMap<Integer, shangping>();
    }
}
