<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.impl.BizDaoImpl"%>
<%@ page import="service.BizServicerImpl"%>
<%@ page import="entity.NewsInfo"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    request.setCharacterEncoding("utf-8");
	    String xiu = request.getParameter("xiu");
	    String xiu2 = request.getParameter("xiu2");
	    String id= request.getParameter("xiuid");
	    
	    int id1=(Integer.valueOf(id));
  
	    
	    application.setAttribute("xiuid",id1);
		session.setAttribute("xiu2", xiu2);
	    session.setAttribute("xiu1", xiu);
	    request.getRequestDispatcher("admin/news_modify.jsp").forward(request, response);
	%>

</body>
</html>