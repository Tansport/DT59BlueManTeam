<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		//装箱
		UserInfo user = new UserInfo();
		user.setUsername(uname);
		user.setPassword(pwd);
		
		BizDaoImpl bdi = new BizDaoImpl();
		BizServiceImpl bsi = new BizServiceImpl();
		bsi.setBizDao(bdi);
		boolean flag = bsi.validateUser(user);
		if(flag){
		    //转发
		    session.setAttribute("uname", uname);
		    session.setMaxInactiveInterval(10);
		    request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}else{
		    response.sendRedirect("index.jsp");
		} 
		
	%>
<%-- 	<h1><%=uname %></h1>
	<h1><%=pwd %></h1> --%>
</body>
</html>