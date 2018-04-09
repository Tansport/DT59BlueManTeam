<%@page import="java.util.ArrayList"%>
<%@page import="com.dt59.entity.CommentInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	request.setCharacterEncoding("utf-8");
	String Author=request.getParameter("Author");
	String Title=request.getParameter("Title");
	String Id=request.getParameter("Id");
	application.setAttribute("Id", Integer.valueOf(Id));
	session.setAttribute("Author", Author);
	session.setAttribute("Title", Title);
	request.getRequestDispatcher("admin/news_modify.jsp").forward(request, response);	
%>

</body>
</html>