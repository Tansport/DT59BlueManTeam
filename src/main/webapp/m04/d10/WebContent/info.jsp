<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.impl.BizDaoImpl"%>
<%@ page import="entity.UserInfo"%>
<%@ page import="service.BizServicerImpl"%>
<%@ page import="entity.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.NewsInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<title>添加主题--管理后台</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
	    request.setCharacterEncoding("utf-8");
	    String ursename = request.getParameter("name");
	    String pwd = request.getParameter("pwd");

	    UserInfo user = new UserInfo();
	    user.setName(ursename);
	    user.setPwd(pwd);

	    BizDaoImpl bdi = new BizDaoImpl();
	    bdi.denglu(user);
	    BizServicerImpl bsi = new BizServicerImpl();
	    bsi.setBizdao(bdi);

	    boolean flag = bsi.denglu(user);
	    if (flag) {
	        session.setAttribute("login", ursename);
	        //  session.setMaxInactiveInterval(60*60);
	        //转发
	        Page page2=new Page();
	        page2.setCurrentpage(1);
	        List<NewsInfo> listnews = bsi.newslist(page2);
	        request.setAttribute("page2", page2);
	        request.setAttribute("listpage", listnews);
	        request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	        session.removeAttribute("login1");
	    } else {
	        response.sendRedirect("indexput.jsp");
	        session.setAttribute("login1", "用户名或密码不正确");

	    }
	%>

</body>
</html>