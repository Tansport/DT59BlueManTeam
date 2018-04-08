<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.impl.BizDaoImpl" %>
<%@ page import="service.BizServicerImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>  
	 <%
	 	request.setCharacterEncoding("utf-8");
 		String id= request.getParameter("id");
 		
    	BizDaoImpl bdi=new BizDaoImpl();
	 	BizServicerImpl bsi=new BizServicerImpl();
    	bsi.setBizdao(bdi);//注入
    	
    	int flag=bsi.delNewsInfoById(Integer.valueOf(id));
    	if(flag>0){
    		response.sendRedirect("delone.jsp");
    	}else{
    		response.sendRedirect("deltwo.jsp");
    	}
     %>
</body>
</html>