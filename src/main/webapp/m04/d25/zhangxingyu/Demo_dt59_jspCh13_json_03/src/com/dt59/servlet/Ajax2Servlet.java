package com.dt59.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.dt59.entity.Person;
import com.dt59.util.JsonUtil;

public class Ajax2Servlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public Ajax2Servlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    @Override
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        InputStream ist = request.getInputStream();
        InputStreamReader isrr = null;
        BufferedReader br = null;
        PrintWriter out = response.getWriter();
        try {
            isrr = new InputStreamReader(ist, "utf-8");
            br = new BufferedReader(isrr);
            String str = br.readLine();
            Person person = (Person) JsonUtil.getObject4JsonString(str, Person.class);
            List<Person> list = new ArrayList<Person>();
            list.add(person);
            JSONArray jarr = JSONArray.fromObject(person);
            out.write(jarr.toString());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            br.close();
            isrr.close();
        }
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    @Override
    public void init() throws ServletException {
        // Put your code here
    }

}
