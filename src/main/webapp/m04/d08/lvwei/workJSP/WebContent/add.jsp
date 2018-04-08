<%@page import="entity.NewsInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.impl.BizDaoImpl"%>
<%@ page import="service.BizServicerImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    request.setCharacterEncoding("utf-8");
	    String ntitle = request.getParameter("ntitle");
	    String nauthor = request.getParameter("nauthor");

	    Integer sid=(Integer)application.getAttribute("xiuid");
	 //   int id1 = Integer.valueOf(id);

	    BizDaoImpl bdi = new BizDaoImpl();
	    BizServicerImpl bsi = new BizServicerImpl();
	    bsi.setBizdao(bdi);

	    NewsInfo nf = new NewsInfo();
	    nf.setNewsAuthor(nauthor);
	    nf.setNewsTitle(ntitle);
	    nf.setNewsId(sid);

	    int flag = bsi.gengxin(nf);
	    if(flag>0){
		    request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}else{
		    response.sendRedirect("deltwo.jsp");
		} 
	%>

</body>
</html>