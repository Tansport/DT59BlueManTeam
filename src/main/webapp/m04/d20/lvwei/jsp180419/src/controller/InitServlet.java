package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import util.TokenUtil;
import dao.impl.BizDaoImpl;
import entity.shangping;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
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
        BizDaoImpl bdi = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bdi);

        // 令牌
        TokenUtil tu = TokenUtil.getInstance();
        String server_token = tu.get_token();
        HttpSession session = request.getSession();
        session.setAttribute("server_token", server_token);

        List<shangping> listsp = bsi.getallshangpingList();
        request.setAttribute("listsp", listsp);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
