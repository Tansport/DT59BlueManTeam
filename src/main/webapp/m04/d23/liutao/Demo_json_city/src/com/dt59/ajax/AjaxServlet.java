package com.dt59.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String province = request.getParameter("province");
        PrintWriter out = response.getWriter();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("武汉");
        list1.add("襄阳");
        list1.add("仙桃");
        list1.add("黄石");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("长沙");
        list2.add("岳阳");
        list2.add("湘潭");
        list2.add("衡阳");

        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("广州");
        list3.add("佛山");
        list3.add("惠州");
        list3.add("深圳");
        // ArrayList<String> list4 = null;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put("湖北", list1);
        map.put("湖南", list2);
        map.put("广东", list3);
        if (map.containsKey(province)) {
            out.print(map.get(province));
        }
        out.flush();
        out.close();
    }
}
