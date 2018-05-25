package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Bill;
import com.dt59.pojo.Page;
import com.dt59.service.impl.BizServiceimpl;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Servlet implementation class fpageServlet
 */
public class fpageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public fpageServlet() {
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
        GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();
        SqlSessionFactory ssf = gsu.getsqlsessionfactory_();
        SqlSession sqlsession = ssf.openSession();
        BizServiceimpl bsi = new BizServiceimpl();
        BizDao bizdao = sqlsession.getMapper(BizDao.class);
        bsi.setBizdao(bizdao);// ×¢Èë

        String currentpage = request.getParameter("currentpage");
        int count = bsi.getAllBillCount();
        Page pg = new Page();
        pg.setSizecount(count);
        pg.setLastpage(pg.getSizecount() % pg.getPagesize() == 0 ? pg.getSizecount() / pg.getPagesize() : pg
                .getSizecount() / pg.getPagesize() + 1);
        // ¸³³õÊ¼Ò³:Ê×Ò³
        pg.setCurrentpage(Integer.valueOf(currentpage));
        List<Bill> list = bsi.getAllBillByPage(pg);
        request.setAttribute("list", list);
        request.setAttribute("pg", pg);
        request.getRequestDispatcher("jsp/billlist.jsp").forward(request, response);

    }

}
