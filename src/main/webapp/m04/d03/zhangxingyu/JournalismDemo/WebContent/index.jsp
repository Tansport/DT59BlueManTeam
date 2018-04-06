<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重定义</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name").trim();
		String pwd=request.getParameter("password").trim();
		boolean valid=false;
		if("admin".equals(name)&&"admin".equals(pwd)){
		    valid=true;
		    session.setAttribute("login", name);
		    session.setMaxInactiveInterval(10*60);
		}
		if(valid){
		    request.getRequestDispatcher("admin.jsp").forward(request, response);
		}else{
		    response.sendRedirect("index.jsp"); 
		}
	%>
</body>
</html>