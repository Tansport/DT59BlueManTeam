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
        Integer id = Integer.valueOf(sid);

        BizDaoImpl bdi = new BizDaoImpl();
        BizServicerImpl bsi = new BizServicerImpl();
        bsi.setBizdao(bdi);

        PrintWriter out = response.getWriter();

        Object server_token = session.getAttribute("server_token"); // 将InitServlet中的调过来

        if (server_token != null) {
            String s_token = (String) server_token;
            String client_token = request.getParameter("client_token");

            if (client_token.equals(s_token)) {
                if (obj != null) {
                    // 先考虑登陆的问题，再考虑令牌
                    shangping sp = bsi.getshagshangpin(Integer.valueOf(sid));
                    if (map.containsKey(id)) { // 判断是否相同id
                        sp.setNum(map.get(id).getNum() + 1);
                        map.put(id, sp);
                    } else {
                        map.put(id, sp);
                    }
                    session.setAttribute("map", map);
                    // response.sendRedirect("Show.jsp");
                    request.getRequestDispatcher("Show.jsp").forward(request, response);
                } else {
                    out.print("<script>");
                    out.print("alert('您尚未登陆，请先登录');");
                    out.print("window.location.href='Init';");
                    out.print("</script>");
                    out.flush();
                    out.close();
                }
                // 消除session中的令牌
                session.removeAttribute("server_token");
            }
        } else {
            out.print("<script>");
            out.print("alert('请不要重复刷新！');");
            out.print("window.location.href='Init';");
            out.print("</script>");
            out.flush();
            out.close();
        }

        // if (obj != null) {
        // // 先考虑登陆的问题，再考虑令牌
        // shangping sp = bsi.getshagshangpin(Integer.valueOf(sid));
        // if (map.containsKey(id)) { // 判断是否相同id
        // sp.setNum(map.get(id).getNum() + 1);
        // map.put(id, sp);
        // } else {
        // map.put(id, sp);
        // }
        //
        // session.setAttribute("map", map);
        // response.sendRedirect("Show.jsp");
        //
        // if (server_token != null) {
        // String s_token = (String) server_token;
        // String client_token = request.getParameter("client_token");
        // if (client_token.equals(s_token)) {
        // session.removeAttribute("server_token"); //
        // 清除掉系统令牌，使获得的令牌无法与系统令牌进行第二次比较
        // }
        // } else {
        // out.print("<script>");
        // out.print("alert('请不要重复刷新');");
        // out.print("window.location.href='Init';");
        // out.print("</script>");
        // out.flush();
        // out.close();
        // }
        //
        // } else {
        // out.print("<script>");
        // out.print("alert('您尚未登陆，请先登录');");
        // out.print("window.location.href='Init';");
        // out.print("</script>");
        // out.flush();
        // out.close();
        // }

    }

    public void init() throws ServletException {
        map = new HashMap<Integer, shangping>();
    }
}
