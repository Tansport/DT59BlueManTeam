package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;
import entity.shangping;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShoppingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Map<Integer, shangping> map = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
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
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("loginname");
        String sid = request.getParameter("sid");

        // HashMap<Integer, shangping> map1 = (HashMap<Integer, shangping>)
        // session.getAttribute("map");

        BizDaoImpl bdi = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bdi);

        PrintWriter out = response.getWriter();

        Integer id = Integer.valueOf(sid);

        if (obj != null) {

            shangping sp = bsi.getshagshangpin(Integer.valueOf(sid));
            if (map.containsKey(id)) { // 判断是否相同id
                sp.setNum(map.get(id).getNum() + 1);
                map.put(id, sp);
            } else {
                map.put(id, sp);
            }

            // request.setAttribute("sp", sp);
            // session.setAttribute("map", map1);
            session.setAttribute("map", map);
            // request.setAttribute("xiaoji", map.get(id).getSpprice() *
            // map.get(id).getNum());
            request.getRequestDispatcher("Show.jsp").forward(request, response);
        } else {
            out.print("<script>");
            out.print("alert('您尚未登陆，请先登录');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();
        }
    }

    public void init() throws ServletException {
        map = new HashMap<Integer, shangping>();
    }
}
