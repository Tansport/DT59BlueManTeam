package com.dt59.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.dt59.entity.Person;
import com.dt59.util.JsonUtil;

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
        super.destroy();
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
        response.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        PrintWriter out = response.getWriter();
        InputStream ist = request.getInputStream();
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            isr = new InputStreamReader(ist, "utf-8");
            br = new BufferedReader(isr);
            String str = br.readLine();
            System.out.println("str:" + str);
            Person person = (Person) JsonUtil.getObject4JsonString(str, Person.class);
            List<Person> list = new ArrayList<Person>();
            list.add(person);
            JSONArray joa = JSONArray.fromObject(list);
            out.write(joa.toString());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            br.close();
            isr.close();

        }

    }
}
