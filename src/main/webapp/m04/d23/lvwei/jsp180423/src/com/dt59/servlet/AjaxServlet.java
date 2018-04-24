package com.dt59.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dt59.entity.Person;
import com.dt59.util.JsonUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AjaxServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AjaxServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			System.out.println("str:"+str);
			Person person= (Person)JsonUtil.getObject4JsonString(str, Person.class);
			Person person1=new Person(111,"Àî¿û",1500);
			Person person2=new Person(112,"ËÎ½­",1000);
			System.out.println("id:"+person.getId());
			System.out.println("name:"+person.getName());
			System.out.println("salary:"+person.getSalary());
			List<Person> list=new ArrayList<Person>();
			list.add(person);
			Map<Integer, Person> map=new HashMap<Integer, Person>();
			map.put(person.getId(), person);
			map.put(person1.getId(), person1);
			map.put(person2.getId(), person2);
			JSONArray jarr=JSONArray.fromObject(map);
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
