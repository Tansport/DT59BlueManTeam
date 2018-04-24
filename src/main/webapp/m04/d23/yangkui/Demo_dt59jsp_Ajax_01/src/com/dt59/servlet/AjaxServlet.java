package com.dt59.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
        String province= request.getParameter("province");
        PrintWriter out= response.getWriter();
        //思考：根据code获取省份和城市
       ArrayList<String> arrli=new ArrayList<String>();
       arrli.add("武汉");
       arrli.add("襄阳");
       ArrayList<String> arrli2=new ArrayList<String>();
       arrli2.add("深圳");
       arrli2.add("惠州");
       ArrayList<String> arrli3=new ArrayList<String>();
       arrli3.add("郑州");
       arrli3.add("南阳");
        HashMap<String, ArrayList<String>> haar=new HashMap<String, ArrayList<String>>();
        haar.put("湖北",arrli );
        haar.put("广州",arrli2 );
        haar.put("河南",arrli3 );
        if(haar.containsKey("province")){
           out.print(haar.containsKey(province));
        }
       
        out.flush();
        out.close(); 
	}

}
