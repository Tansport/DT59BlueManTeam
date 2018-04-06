<%@page import="com.xin.service.impl.BizServicerImpl"%>
<%@page import="com.xin.dao.impl.BizDaoImpl"%>
<%@page import="com.xin.entity.UserInfo"%>
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
	//获取用户名
	String uname=request.getParameter("uname");
	//获取密码
	String pwd=request.getParameter("upwd");
	//装箱 
	UserInfo user=new UserInfo();
	user.setName(uname);
	user.setPwd(pwd);
	
	BizDaoImpl bdi=new BizDaoImpl();
	bdi.denglu(user);
	BizServicerImpl bsi=new BizServicerImpl();
	bsi.setBizdao(bdi);
	
	boolean flag=bsi.denglu(user);
	if(flag){
	    session.setAttribute("uname", uname);
	  //  session.setMaxInactiveInterval(60*60);
	    //转发
	  request.getRequestDispatcher("admin/admin.jsp").forward(request, response);  
	}else{
	    response.sendRedirect("index.jsp");
	}
	
	%>
</body>
</html>