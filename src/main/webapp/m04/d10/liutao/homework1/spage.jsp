<%@page import="com.dt59.entity.NewsInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.dt59.service.impl.BizServiceImpl"%>
<%@page import="com.dt59.dao.impl.BizDaoImpl"%>
<%@page import="com.dt59.entity.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  request.setCharacterEncoding("utf-8");
	String currentpage=request.getParameter("currentpage");//获取页面字符
	Page pag=new Page();//使用javabean
	pag.setCurrentpage(Integer.parseInt(currentpage));//设定属性，解析成整型
	BizDaoImpl bdi=new BizDaoImpl();
	BizServiceImpl bsi =new BizServiceImpl();
	bsi.setBizDao(bdi);//注入
	int result=bsi.getSumCount(pag);
	pag.setSumpage(result);
	List<NewsInfo> list =bsi.getShowPageByCount(pag);//传递
	request.setAttribute("pag", pag);//传递page
	request.setAttribute("listpage", list);//传递list
	request.getRequestDispatcher("admin/admin.jsp").forward(request, response);//重定向
%>

</body>
</html>