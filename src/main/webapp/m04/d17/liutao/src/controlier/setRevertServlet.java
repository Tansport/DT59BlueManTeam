package controlier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BizServicerImpl;
import dao.impl.BizDaoImpl;

/**
 * Servlet implementation class setRevertServlet
 */
public class setRevertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public setRevertServlet() {
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

        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String mid = request.getParameter("messageid");
        int midd = Integer.valueOf(mid);

        int fage = bsi.setrevert(midd, content, name);

        // if (fage > 0) {
        // request.getRequestDispatcher("Jsp_Proscenium/R_MessageBoard.jsp").forward(request,
        // response);
        // }
        PrintWriter out = response.getWriter();

        if (fage > 0) {
            int r = bsi.rcount(midd);
            int update = bsi.updatemess(r, midd);
            if (update > 0) {
                out.print("<script>");
                out.print("alert('回复成功');");
                out.print("location.href='Jsp_Proscenium/S_MessageBoard.jsp'");
                out.print("</script>");
                out.flush();// 刷新
                out.close();
            }
        } else {
            out.print("<script>");
            out.print("alert('回复失败');");
            out.print("location.href='Jsp_Proscenium/S_MessageBoard.jsp'");
            out.print("</script>");
            out.flush();// 刷新
            out.close();
        }

    }
}
