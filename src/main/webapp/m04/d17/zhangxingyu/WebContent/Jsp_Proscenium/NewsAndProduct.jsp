<%@page import="com.dt59.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'NewsAndCommandProduct.jsp' starting page</title>
    
	
	<style type="text/css">
		a{
			font-size:13px;
			color:#000000;
			text-decoration:none;
		}
		a:hover{
			font-size:14px;
			color:#FF0000;
			text-decoration:underline;
		}
	</style>
	<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
	<script>
		$(function(){
			//$("#dd td a:even").css("background-color","yellow");
			$("li:odd").css("background-color","yellow");
		});
	</script>
  </head>
  
  <body>
	<table align="center" width="620" height="230" border="0" cellpadding="0" cellspacing="0">
	  <tr height="35">
		<td width="352"><img src="Img_Proscenium/d_r7_c1.jpg" width="101" height="35" /><img src="Img_Proscenium/d02.jpg" width="157" height="35" /><img src="Img_Proscenium/d_r7_c14.jpg" width="94" height="35" /></td>
		<td rowspan="16">
			<table width="268" height="236" border="0" cellpadding="0" cellspacing="0">
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r1_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r3_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r4_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			  <tr>
				<td><a href="Jsp_Proscenium/M_ShowProduct.jsp" target="_parent"><img src="Img_Proscenium/d_r11_5_r5_c1.jpg" width="268" height="60" border="0" /></a></td>
			  </tr>
			</table>
		</td>
	  </tr>
		 <c:forEach items="${listnews }" var="lst">
			 	<tr>
			 		<td height="22">
			 			<li style="list-style:none;">&nbsp;<a target="_parent" href="#">${lst.ntitle }&nbsp;&nbsp;&nbsp;<span style="color: red;">[${lst.ndate}]</span></a></li>
			 		</td>
			 	</tr>
			 </c:forEach>
			  	<tr>
					<td><img src="Img_Proscenium/d03.jpg" width="352" height="1" /></td>
	  		 	</tr>
	  <tr>
		<td><div align="right"><a href="Jsp_Proscenium/M_ShowNews.jsp" target="_parent"><img src="Img_Proscenium/d_r11_c15.jpg" width="50" height="33" border="0" /></a></div></td>
	  </tr>
	</table>
  </body>
</html>
