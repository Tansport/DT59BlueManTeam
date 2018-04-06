<%@ page import="news.*" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
 //request.setCharacterEncoding("utf-8");
 String name=request.getParameter("uname");
 String psw=request.getParameter("upwd");
 UserInfo ui=new UserInfo();
 ui.setName(name);
 ui.setPsw(psw);
 BizDaoImpl bdi=new BizDaoImpl();
 boolean flag=bdi.yanzheng(ui);
    if(flag){
    session.setAttribute("name",name);
    request.getRequestDispatcher("news_add.html").forward(request,response);    
 }else{
     response.sendRedirect("index.jsp");
 }
%>

</body>
</html>