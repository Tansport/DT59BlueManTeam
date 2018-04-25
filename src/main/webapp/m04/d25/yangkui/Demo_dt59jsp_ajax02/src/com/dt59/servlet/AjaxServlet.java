package com.dt59.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
        response.setContentType("text/html");
        InputStream ist= request.getInputStream();
        InputStreamReader isrr=null;
        BufferedReader br=null;
        PrintWriter out=response.getWriter();
        try {
            isrr=new InputStreamReader(ist,"utf-8");
            br=new BufferedReader(isrr);
            String str= br.readLine();
            Person person= (Person)JsonUtil.getObject4JsonString(str, Person.class);
//            Person person1=new Person("汪洋",21,'男',"学生","北京市海淀区上地西里x号楼x单元x号","13600000000");
//            System.out.println("name:"+person.getName());
//            System.out.println(str.length());
            List<Person> list=new ArrayList<Person>();
            list.add(person);
            JSONArray jarr=JSONArray.fromObject(person);
            out.write(jarr.toString());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            out.flush();
            out.close();
            br.close();
            isrr.close();
        }
    }

}
