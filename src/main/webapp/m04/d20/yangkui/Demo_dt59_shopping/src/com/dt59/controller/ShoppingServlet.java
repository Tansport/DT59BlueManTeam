package com.dt59.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.entity.ShangPin;
import com.dt59.imp.BizDaoImpl;
import com.dt59.serevice.impl.BizServiceImpl;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<Integer, ShangPin> map=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	    map=new HashMap<Integer, ShangPin>();
	    
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
        
        BizDaoImpl bizdao=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizdao(bizdao);
        
        
        PrintWriter out= response.getWriter();
        
        //判断当前用户是否登录
        HttpSession session= request.getSession();
        Object obj=session.getAttribute("LoginName");//1
        
        String sid= request.getParameter("sid");
        Integer id=Integer.valueOf(sid);
        
        Object server_token= session.getAttribute("server_token");//2
        
        if(server_token!=null){
            String s_token=(String)server_token;
            String client_token=request.getParameter("client_token");
            if(client_token.equals(s_token)){
                if(obj!=null){
                    //思考：先把登录的问题考虑进去，再考虑令牌
                    //正常跳转
                    ShangPin sp= bsi.getShangpinById(Integer.valueOf(sid));
                    //思考:如何使用集合?  判断编号:1:重复的编号,数量累加  2:不包含编号的情况,新增一条
                    if(map.containsKey(id)){
                        //1:重复的编号,数量累加 
                        sp.setNum(map.get(id).getNum()+1);
                        map.put(id, sp);
                    }else{
                        //2:不包含编号的情况,新增一条
                        map.put(id, sp);
                    }
                    request.setAttribute("map", map);
//                    response.sendRedirect("show.jsp");
                    request.getRequestDispatcher("show.jsp").forward(request, response);
                }else{
                    out.print("<script>");
                    out.print("alert('您尚未登录，请先登录！');");
                    out.print("window.location.href='init';");
                    out.print("</script>");
                    out.flush();
                    out.close();
                }
                //消除session中的令牌
                session.removeAttribute("server_token");
            }
        }else{
            out.print("<script>");
            out.print("alert('请不要重复刷新！');");
             out.print("window.location.href='init';");
            out.print("</script>");
            out.flush();
            out.close();
        }
	}   
}
