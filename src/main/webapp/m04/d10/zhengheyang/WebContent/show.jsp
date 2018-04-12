<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 4/11/18
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
</head>
<body>
	<h2>
		文件名:<%=request.getAttribute("filename")%>
		<br /> 文件路径:<%=request.getAttribute("path2")%>
	</h2>
	<img src="upload/<%=request.getAttribute("filename")%>" />
</body>
</html>
