package com.dt59.servlet;

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
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see Servlet#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        InputStream ist = request.getInputStream();
        InputStreamReader isr = null;
        BufferedReader br = null;
        String[] city = null;
        PrintWriter out = response.getWriter();
        try {
            isr = new InputStreamReader(ist);
            br = new BufferedReader(isr);
            String str = br.readLine();
            System.out.println(str);// 可以把省份取出来，取出来的为Json格式
            // 需要对json格式进行解析
            JSONObject jobj = JSONObject.fromObject(str);
            String pro = (String) jobj.get("pro");
            // System.out.println(pro);
            // 通过省份获取city的值
            if (pro.equals("湖北")) {
                city = new String[] { "仙桃", "天门", "潜江" };
            } else if (pro.equals("江西")) {
                city = new String[] { "九江", "南昌", "宜春" };
            } else if (pro.equals("广东")) {
                city = new String[] { "广州", "东莞", "深圳" };
            }
            // 获取出来的值，转换成jsonarray格式，传回前端
            JSONArray jarray = JSONArray.fromObject(city);
            out.write(jarray.toString());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            br.close();
            isr.close();
        }
    }

}
