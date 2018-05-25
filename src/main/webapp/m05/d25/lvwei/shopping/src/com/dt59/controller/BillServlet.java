package com.dt59.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Bill;
import com.dt59.pojo.Page;
import com.dt59.service.impl.BizServiceimpl;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Servlet implementation class BillServlet
 */
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
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
        GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();

        SqlSessionFactory ssf = gsu.getsqlsessionfactory_();

        SqlSession sqlsession = ssf.openSession(true);

        BizDao bizdao = sqlsession.getMapper(BizDao.class);

        BizServiceimpl bsi = new BizServiceimpl();
        bsi.setBizdao(bizdao);
        // List<Bill> list = bsi.getAllBill();

        int count = bsi.getAllBillCount();// 获取总条数
        Page pg = new Page();
        pg.setSizecount(count);
        pg.setLastpage(pg.getSizecount() % pg.getPagesize() == 0 ? pg.getSizecount() / pg.getPagesize() : pg
                .getSizecount() / pg.getPagesize() + 1);
        // 赋初始页:首页
        pg.setCurrentpage(1);

        List<Bill> list = bsi.getAllBillByPage(pg);
        List<String> listpro = bsi.getProviderByTinc();
        List<String> listIpay = bsi.getSmbmsBillIspay();

        HttpSession session = request.getSession();
        request.setAttribute("list", list);
        session.setAttribute("listpro", listpro);
        request.setAttribute("pg", pg);
        request.setAttribute("listIpay", listIpay);
        request.getRequestDispatcher("jsp/billlist.jsp").forward(request, response);
    }

}
