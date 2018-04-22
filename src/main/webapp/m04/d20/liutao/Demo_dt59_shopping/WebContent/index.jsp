<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <% // 不读取缓存
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragrma","no-cache"); 
	response.setDateHeader("Expires",0); 
	%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<form action="Login" method="post">
<table align="right" border="1px">
<tr><td>用户名:</td><td><input type="text" name="uname"></td></tr>
<tr><td>密码:</td><td><input type="password" name="upwd"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="登陆"></td></tr>
</table>
</form>
<form action="shopping" method="post">
<table align="center" border="1px">
  <tr>
    <th>商品编号</th>
    <th>商品名称</th>
    <th>商品价格</th>
    <th>商品描述</th>
    <th>操作</th>
    
  </tr>
  <c:forEach  items="${list }" var="lis">
  <tr>
    <td>${lis.spid }</td>
    <td>${lis.spname }</td>
    <td>${lis.spprice }</td>
    <td>${lis.spdesc }</td> 
    <td><a href="Shopping?sid=${lis.spid}&client_token=${server_token}">加入购物车</a></td>
  </tr>
  </c:forEach>
</table>

</form>
</body>
</html>