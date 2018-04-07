<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");//设置字符集
	String name = request.getParameter("name");//根据页面表单组件名称获取页面提交数据
	String pwd = request.getParameter("pwd");//根据页面表单组件名称获取页面提交数据
	String[] channels = request.getParameterValues("channel");//获取一组以相同名称命名的表单组件提交的数据
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册信息</title>
</head>
<body>
	<div align="center">你输入的注册信息:
		<table border="0" align="center">
			<tr>
				<td width="80" height="20">用户名:</td>
				<td><%=name %></td>
			</tr>
			<tr>
				<td height="20">密码:</td>
				<td><%=pwd %></td>
			</tr>
			<tr>
				<td height="20">信息来源：</td>
				<td><%
						if (channels != null){
						    for(String channel : channels){
						        out.print(channel + "&nbsp;");
						    }
						}
					%>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>