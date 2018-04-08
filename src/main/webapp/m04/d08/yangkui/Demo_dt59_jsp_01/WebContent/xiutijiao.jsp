<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.NewsInfo"%>
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
	BizDaoImpl bdi=new BizDaoImpl();
	BizServiceImpl bsi=new BizServiceImpl();
	bsi.setBizDao(bdi);//注入
		
		request.setCharacterEncoding("utf-8");
		
		String nti=request.getParameter("ntitle");
		String nau=request.getParameter("nauthor");
		
		Integer sid=(Integer)application.getAttribute("sid");
		
		NewsInfo nf=new NewsInfo();
		nf.setNewsauthor(nau);
		nf.setNewstitle(nti);
		nf.setNewsid(sid);
		
		int flag=bsi.add(nf);
		 if(flag>0){
		    request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}else{
		    response.sendRedirect("deltwo.jsp");
		} 
		
	%>
	
</body>
</html>