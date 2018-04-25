package controller;

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
import util.JsonUtil;
import entity.xinxi;

/**
 * Servlet implementation class ajaxServlet
 */
public class ajaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ajaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
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
            xinxi xin = (xinxi) JsonUtil.getObject4JsonString(str, xinxi.class);

            List<xinxi> list = new ArrayList<xinxi>();
            list.add(xin);
            JSONArray jarr = JSONArray.fromObject(list);
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

    // xinxi xi = new xinxi("汪洋", 21, '男', "学生", "北京市海淀区上地西里x号楼x单元x号",
    // "1360000000");
    // System.out.println(xi.getName());
    // List<xinxi> list = new ArrayList<xinxi>();
    // list.add(xi);
    //
    // JSONArray jarr = JSONArray.fromObject(list);
    // out.write(jarr.toString());

    // out.flush();
    // out.close();

}
