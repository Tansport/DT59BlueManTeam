package com.dt59.controller;

import java.io.IOException;

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
 * Servlet implementation class updatebillServlet
 */
public class updatebillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatebillServlet() {
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
        String id = request.getParameter("id");
        String billCode = request.getParameter("billCode");
        String productName = request.getParameter("productName");
        String productUnit = request.getParameter("productUnit");
        String productCount = request.getParameter("productCount");
        String totalPrice = request.getParameter("totalPrice");

        Bill sb = new Bill();
        sb.setId(Integer.valueOf(id));
        sb.setBillCode(billCode);
        sb.setProductName(productName);
        sb.setProductUnit(productUnit);
        sb.setProductCount(Double.valueOf(productCount));
        sb.setTotalPrice(Double.parseDouble(totalPrice));
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        try {
            int flag = bsi.updateBillById(sb);
            if (flag > 0) {
                response.getWriter().print("<h1>修改成功！</h1>");
                sqlsession.commit();
                request.getRequestDispatcher("jsp/billlist.jsp").forward(request, response);
            } else {
                response.getWriter().print("<h1>修改失败！</h1>");
            }

        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();
            e.printStackTrace();
        }
    }

}
