<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 	request.setCharacterEncoding("utf-8");//设置编码集
	//获取用户名
	String uname=request.getParameter("uname");
    //获取密码
	String upwd=request.getParameter("upwd");
    //装箱
    UserInfo ui=new UserInfo();
    ui.setName(uname);
    ui.setPsw(upwd);
    BizDaoImpl bdi=new BizDaoImpl();
    BizServiceImpl bsi=new BizServiceImpl();
    bsi.setBizDao(bdi);//注入
    boolean flag= bdi.validateUser(ui);
    if(flag){
        session.setAttribute("uname", uname);//设定键值，并保存再会话中
        session.removeAttribute("error");//清除错误
        List<NewsInfo> listNews=bsi.addTitle();//调取服务层方法
        request.setAttribute("listNews", listNews);//设定属性和值请求发送
        request.getRequestDispatcher("admin/admin.jsp").forward(request, response);//转发
        
    }else{
        //重定向
        response.sendRedirect("index.jsp");
        session.setAttribute("error", "用户名或密码错误!");//定向失败提示错误
    }
    
    
    
    
    
	
	
	
	%>

</body>
</html>