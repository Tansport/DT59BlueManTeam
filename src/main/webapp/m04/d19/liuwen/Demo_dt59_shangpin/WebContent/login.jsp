<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
</body>
</html>