<%@page import="java.util.List"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.*"%>
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
	    String currentpage = request.getParameter("currentpage");
	    Page page2 = new Page();
	    page2.setCurrentpage(Integer.parseInt(currentpage));
	    BizDaoImpl bdi = new BizDaoImpl();
	    BizServiceImpl bsi = new BizServiceImpl();
	    bsi.setBizDao(bdi);//注入
	    
	  /*   List<Page> listsum = bsi.sum();
	    int lastpage = listsum.get(0).getSumsize()/3;
	    if(listsum.get(0).getSumsize()%3==0){
	        page2.setLastpage(lastpage);
	    }else{
	        page2.setLastpage(lastpage+1);
	    } */
	    
	    List<NewsInfo> list = bsi.getNewsInfoByPage(page2);
	    request.setAttribute("page2", page2);
	    request.setAttribute("listpage", list); 
	    request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	%>
	<h1><%=page2.getLastpage() %></h1>
</body>
</html>