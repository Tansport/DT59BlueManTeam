<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<form action="http://localhost:8088/TestDemo_zhengJsp/servlet/Login"
		method="get">
		用户名:<input type="text" name="username"> 密&nbsp;码<input
			type="password" name="password"> <input type="submit"
			value="登录"> <input type="reset" value="重复">
	</form>
</body>
</html>