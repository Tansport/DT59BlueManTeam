package com.dt59.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dt59.entity.Message;
import com.dt59.entity.Revert;
import com.dt59.impl.BizDaoImpl;
import com.dt59.service.impl.BizServiceImpl;

/**
 * Servlet implementation class RevertServlet
 */
public class RevertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevertServlet() {
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
//	    String id=request.getParameter("id");
	    BizDaoImpl bizdao=new BizDaoImpl();
        BizServiceImpl bsi=new BizServiceImpl();
        bsi.setBizbao(bizdao);
        int id = Integer.parseInt(request.getParameter("id"));
//        Message mess= bsi.getMessageById(Integer.parseInt(id));
//        List<Revert> listrev=bsi.getAllRevert();
        Message mess = bsi.getMessageById(id);
        List<Revert> revertListById = bsi.getRevertById(id);
//        List<Message> listmess=bsi.getAllMessage();
//        HttpSession session= request.getSession(false);
        request.setAttribute("mess", mess);
        request.setAttribute("listrev", revertListById);
        
        
//        String id = request.getParameter("id");
//        Integer id1 = Integer.parseInt(id);
//        session.setAttribute("id", id1);
        request.getRequestDispatcher("Jsp_Proscenium/MessageBoard_replay.jsp").forward(request, response);
	}

}
