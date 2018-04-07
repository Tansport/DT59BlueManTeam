<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>你输入的注册信息</title>
</head>
<body>
<% 
 request.setCharacterEncoding("utf-8");//设置post得到的信息格式
 //URIEcodin="utf-8", tomcat中conf文件设置字符格式,当用get时；
 // String name=request.getParameter("username");当用get时；
 //name=new String(name.getBytes("ISO-8859-1"),"utf-8");当用get时；
 String name=request.getParameter("username");
 String password=request.getParameter("password");
 String[] channels=request.getParameterValues("channel");
%>
<div align="center">你输入的注册信息
<table>
<tr><td>用户名:</td>
<td>
<%=name%>
</td></tr>
<tr><td>密码:</td>
<td>
<%=password%>
</td></tr>
<tr><td>信息来源:</td>
<td>
<% 
if(channels!=null){
for(String channel:channels){
    out.println(channel);
}
}
%>
</td></tr>
</table>
</div>
</body>
</html>