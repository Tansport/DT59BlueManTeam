<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>购物车Shopping</title>
</head>
<% // 不读取缓存
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragrma","no-cache"); 
	response.setDateHeader("Expires",0); 
%>
<body>
	<form action="login" method="post">
		<table align="left" border="1">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="uname" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="upwd" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登入" /></td>
			</tr>
		</table>
	</form>
	<table align="center" border="1">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${listsp }" var="lst">
			<tr>
				<td>${lst.spid }</td>
				<td>${lst.spname }</td>
				<td>${lst.spprice }</td>
				<td>${lst.spdesc }</td>
				<td><a href="shopping?spid=${lst.spid }&client_token=${server_token }">放入购物车</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>