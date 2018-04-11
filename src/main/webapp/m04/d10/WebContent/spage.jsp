
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.Page"%>
<%@ page import="dao.impl.BizDaoImpl"%>
<%@ page import="service.BizServicerImpl"%>
<%@ page import="java.util.List"%>
<%@ page import="entity.NewsInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	    BizDaoImpl bdi = new BizDaoImpl();
	    BizServicerImpl bsi = new BizServicerImpl();
	    bsi.setBizdao(bdi);//注入

	    request.setCharacterEncoding("utf-8");
	    String currentpage = request.getParameter("currentpage");
	    Page page2 = new Page();
	    
	    List<Page> sum=bsi.sum();
	    int fenye=sum.get(0).getSumsize()/3;
	    if(sum.get(0).getSumsize()%3==0){
	        page2.setLastpage(fenye);
	    }else{
	        page2.setLastpage(fenye+1);
	        
	    }

	    Integer it = Integer.parseInt(currentpage);
	  

	    page2.setCurrentpage(it);

	    List<NewsInfo> list = bsi.newslist(page2);
	    request.setAttribute("page2", page2);
	    request.setAttribute("listpage", list);
	    request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	%>
</body>
</html>