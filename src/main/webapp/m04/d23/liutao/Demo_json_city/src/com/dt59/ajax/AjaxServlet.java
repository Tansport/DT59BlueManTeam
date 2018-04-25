package com.dt59.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
        String[] city = null;
        PrintWriter out = response.getWriter();
        InputStream ist = request.getInputStream();// 将发送的数据以流的形式接收
        InputStreamReader isrr = null;
        BufferedReader br = null;
        try {
            isrr = new InputStreamReader(ist, "utf-8");
            br = new BufferedReader(isrr);
            String str = br.readLine();
            System.out.println("str:" + str);
            JSONObject jso = JSONObject.fromObject(str);
            String jsoo = (String) jso.get("pro");
            if (jsoo.equals("湖北")) {
                city = new String[] { "武汉", "黄石", "襄阳" };

            } else if (jsoo.equals("湖南")) {
                city = new String[] { "长沙", "岳阳", "湘潭" };

            } else if (jsoo.equals("广东")) {
                city = new String[] { "广州", "深圳", "佛山" };
            }
            System.out.println("数组的长度：" + city.length);
            JSONArray jarr = JSONArray.fromObject(city);// 将数组转换成jsonarry数组
            out.write(jarr.toString());

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            br.close();
            isrr.close();

        }

    }
}
