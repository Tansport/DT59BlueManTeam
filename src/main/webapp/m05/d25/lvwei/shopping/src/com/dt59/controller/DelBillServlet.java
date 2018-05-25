package com.dt59.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.service.impl.BizServiceimpl;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Servlet implementation class DelBillServlet
 */
public class DelBillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelBillServlet() {
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
        request.setCharacterEncoding("utf-8");

        GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();
        SqlSessionFactory ssf = gsu.getsqlsessionfactory_();
        SqlSession sqlsession = ssf.openSession();
        BizServiceimpl bsi = new BizServiceimpl();
        BizDao bizdao = sqlsession.getMapper(BizDao.class);
        bsi.setBizdao(bizdao);// 注入

        System.out.println("异步进入servlet");
        InputStream ist = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(ist, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        System.out.println("str:" + str);
        JSONObject obj = JSONObject.fromObject(str);
        Object obj1 = obj.get("method");
        Object obj2 = obj.get("billid");
        System.out.println("obj1:" + obj1 + "\tobj2:" + obj2);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String tt = "";
        JSONObject jobj = null;
        String obj22 = obj2.toString();
        int flag = bsi.delBillCode(obj22);
        System.out.println("删除的结果:" + flag);
        if (flag > 0) {
            tt = "{delResult:'true'}";
            jobj = JSONObject.fromObject(tt);
            out.print(jobj);
            sqlsession.commit();

        } else {
            tt = "{delResult:'false'}";
            jobj = JSONObject.fromObject(tt);
            out.print(jobj);
        }
        out.flush();
        out.close();

    }
}
