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
        bsi.setBizdao(bizdao);// ע��

        String queryProductName = request.getParameter("queryProductName");// ��Ʒ����
        String queryProviderId = request.getParameter("queryProviderId");// ��Ӧ��
        String queryIsPayment = request.getParameter("queryIsPayment");// �Ƿ񸶿�
        // ��̬sql ��Ʒ����:ģ����ѯ ����3����������װ��HashMap
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
