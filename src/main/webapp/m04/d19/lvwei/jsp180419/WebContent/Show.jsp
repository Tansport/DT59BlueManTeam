<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎领导登陆购物车页面</h1>
	<table align="center" border="1">
		<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${map }" var="mp">
		<tr>
			<td>${mp.value.spid}</td>
			<td>${mp.value.spname }</td>
			<td>
				<a href="num?spid=${mp.value.spid }&cnum=${mp.value.num-1}">-</a>
				<input type="text" id="num" name="num" value="${mp.value.num }" size="5" />
				<a href="num?spid=${mp.value.spid }&cnum=${mp.value.num+1}">+</a>
			</td>
			<td>${mp.value.spprice }</td>
			<td>${mp.value.spdesc }</td>
			<td>
				<input type="text" id="price" name="price" value="${mp.value.num*mp.value.spprice }" size="7" />
			</td>
			<td>
				<a href="#">购买</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>