package com.dt59.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AjaxServlet extends HttpServlet {

    public AjaxServlet() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String[] city = null;
        InputStream ist = request.getInputStream();
        InputStreamReader isrr = null;
        BufferedReader br = null;
        PrintWriter out = response.getWriter();
        try {
            isrr = new InputStreamReader(ist, "utf-8");
            br = new BufferedReader(isrr);
            String str = br.readLine();
            JSONObject jobj = JSONObject.fromObject(str);
            String obj = (String) jobj.get("pro");
            if (obj.equals("湖北")) {
                city = new String[] { "武汉", "浠水", "蕲春" };
            } else if (obj.equals("湖南")) {
                city = new String[] { "长沙", "岳阳", "绍山" };
            } else if (obj.equals("广东")) {
                city = new String[] { "广州", "惠州" };
            }
            JSONArray jarr = JSONArray.fromObject(city);
            out.write(jarr.toString());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            br.close();
            isrr.close();
        }
    }

    @Override
    public void init() throws ServletException {
        // Put your code here
    }

}
