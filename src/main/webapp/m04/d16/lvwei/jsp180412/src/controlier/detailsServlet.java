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
import entity.Page;
import entity.Product;

/**
 * Servlet implementation class detailsServlet
 */
public class detailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailsServlet() {
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

        Page page1 = new Page();

        page1.setCurrentpage(1); // 设置初始的第几页

        List<Product> list = bsi.newslist(page1);

        // List<Product> list = bsi.getALLProduct();

        HttpSession session = request.getSession();
        session.setAttribute("listnews", list);
        session.setAttribute("page", page1);

        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);

    }

}
