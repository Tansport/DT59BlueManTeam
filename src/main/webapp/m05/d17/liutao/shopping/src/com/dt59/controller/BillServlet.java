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

        SqlSession sqlsession = ssf.openSession();

        BizDao bizdao = sqlsession.getMapper(BizDao.class);

        BizServiceimpl bsi = new BizServiceimpl();
        bsi.setBizdao(bizdao);
        List<Bill> list = bsi.getAllBill();
        List<String> listpro = bsi.getProviderByTinc();
        List<String> listIpay = bsi.getSmbmsBillIspay();
        request.setAttribute("list", list);
        request.setAttribute("listpro", listpro);
        request.setAttribute("listIpay", listIpay);
        request.getRequestDispatcher("jsp/billlist.jsp").forward(request, response);
    }

}
