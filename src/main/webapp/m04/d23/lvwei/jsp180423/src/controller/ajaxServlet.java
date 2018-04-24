package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ajaxServlet
 */
public class ajaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ajaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        InputStream ist = request.getInputStream();
        InputStreamReader isrr = null;
        BufferedReader br = null;

        List<String> list = new ArrayList<String>();
        PrintWriter out = response.getWriter();

        try {
            isrr = new InputStreamReader(ist);
            br = new BufferedReader(isrr);
            String str = br.readLine();

            // System.out.println("str:" + str);

            JSONObject jobj = JSONObject.fromObject(str);
            String obj = (String) jobj.get("pro");
            // String obj = request.getParameter("pro");
            // System.out.println("str:" + obj);
            if ("湖北".equals(obj)) {
                list.add("武汉");
                list.add("襄阳");
                list.add("随州");
                list.add("枣阳");
            } else if ("湖南".equals(obj)) {
                list.add("长沙");
                list.add("常德");
                list.add("长铺子");
            } else if ("广州".equals(obj)) {
                list.add("广州");
                list.add("东莞");
                list.add("福建");
            }
            // System.out.println("str:" + list.size());
            JSONArray jarr = JSONArray.fromObject(list);
            out.write(jarr.toString());
        } catch (Exception e) {
            // TODO: handle exception
        }

        // String province = request.getParameter("province");

    }
}
