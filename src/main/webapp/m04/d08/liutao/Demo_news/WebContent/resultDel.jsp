<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>resultDel</title>
</head>
<body>
<%	BizDaoImpl bdi=new BizDaoImpl();
	BizServiceImpl bsi=new BizServiceImpl();
	bsi.setBizDao(bdi);//注入
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	int result=bsi.delNewsInfoById(Integer.valueOf(id));
	if(result>0){
	    response.sendRedirect("admin/admin.jsp");
	}else{
	    response.sendRedirect("index.jsp");
	}
	
%>
</body>
</html>