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
 * Servlet implementation class sumServlet
 */
public class sumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sumServlet() {
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

        // // TODO Auto-generated method stub
        BizDaoImpl bizdao = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bizdao);

        // request.setCharacterEncoding("utf-8");
        String currentpage = request.getParameter("currentpage");
        Integer it = Integer.parseInt(currentpage); // 获取当前页

        Page page2 = new Page();

        List<Page> sum = bsi.sum();

        page2.setSumsize(sum.get(0).getSumsize());// 设置总行数

        int fenye = page2.getSumsize() / page2.getPagesize();

        if (page2.getSumsize() % page2.getPagesize() == 0) {
            fenye = fenye;
        } else {
            fenye = fenye + 1;
        }

        page2.setCurrentpage(it);

        if (page2.getCurrentpage() <= 1) {
            page2.setCurrentpage(1);
        } else if (page2.getCurrentpage() <= fenye) {
            page2.setCurrentpage(it);
        } else {
            page2.setCurrentpage(fenye);
        }

        List<Product> list = bsi.newslist(page2);
        HttpSession session = request.getSession();
        session.setAttribute("page", page2);
        session.setAttribute("listnews", list);
        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);

    }
}
