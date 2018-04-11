<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>标题是：<%=request.getAttribute("ntitle")%></h1><br />
	<h1>作者是：<%=request.getAttribute("nauthor")%></h1><br />
	<h1>摘要是：<%=request.getAttribute("nsummary")%></h1><br />
	<h1>内容是：<%=request.getAttribute("ncontent")%></h1><br />
	<h1>文件名：<%=request.getAttribute("filename")%></h1>
	<br />
	<h1>
		文件路径：<%=request.getAttribute("path1")%></h1>
	<br />
	<img src="pic/<%=request.getAttribute("filename")%>">

</body>
</html>