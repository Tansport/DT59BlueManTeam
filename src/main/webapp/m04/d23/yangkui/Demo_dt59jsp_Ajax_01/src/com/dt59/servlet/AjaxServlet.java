package com.dt59.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
//        String province= request.getParameter("province");
        String[] city=null;
        InputStream ist=request.getInputStream();
        InputStreamReader isrr=null;
        BufferedReader br=null;
        PrintWriter out=response.getWriter();
       try {
           isrr=new InputStreamReader(ist,"utf-8");
           br=new BufferedReader(isrr);
           String str= br.readLine();
//           System.out.println("str:"+str);
           JSONObject jobj= JSONObject.fromObject(str);
           String obj= (String)jobj.get("pro");
           if(obj.equals("湖北")){
               city=new String[]{"武汉","浠水","蕲春"};
           }else if(obj.equals("湖南")){
               city=new String[]{"长沙","岳阳","绍山"};
           }else if(obj.equals("广东")){
               city=new String[]{"广州","惠州"};
           }
           JSONArray jarr= JSONArray.fromObject(city);
           out.write(jarr.toString());
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally{
        out.flush();
        out.close();
        br.close();
        isrr.close();
    }
	}

}
