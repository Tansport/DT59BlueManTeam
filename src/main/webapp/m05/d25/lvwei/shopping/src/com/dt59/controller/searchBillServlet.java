package com.dt59.controller;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class searchBillServlet
 */
public class searchBillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchBillServlet() {
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
        bsi.setBizdao(bizdao);// 注入

        String queryProductName = request.getParameter("queryProductName");// 商品名称
        String queryProviderId = request.getParameter("queryProviderId");// 供应商
        String queryIsPayment = request.getParameter("queryIsPayment");// 是否付款
        // 动态sql 商品名称:模糊查询 上述3个参数，封装到HashMap
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (queryProductName.trim().length() != 0) {
            map.put("qname", "%" + queryProductName + "%");
        }
        if (!queryProviderId.trim().equals("0")) {
            map.put("qid", queryProviderId);
        }
        if (!queryIsPayment.trim().equals("0")) {
            map.put("qispay", queryIsPayment);
        }
        List<Bill> listsb = bsi.getAllBillByTj(map);
        List<String> listpro = bsi.getProviderByTinc();
        List<String> listispay = bsi.getSmbmsBillIspay();
        request.setAttribute("list", listsb);
        request.setAttribute("listpro", listpro);
        request.setAttribute("listIpay", listispay);
        request.getRequestDispatcher("jsp/billlist.jsp").forward(request, response);

    }

}
