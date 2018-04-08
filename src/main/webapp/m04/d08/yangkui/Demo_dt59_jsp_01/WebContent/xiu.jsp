<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		request.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		String sid=request.getParameter("sid");
		String title=request.getParameter("title");
		
		int id=(Integer.valueOf(sid));
		application.setAttribute("sid", id);
		session.setAttribute("title", title);
		session.setAttribute("uname", uname);
		 
		request.getRequestDispatcher("admin/news_modify.jsp").forward(request, response);
		%>
</body>
</html>