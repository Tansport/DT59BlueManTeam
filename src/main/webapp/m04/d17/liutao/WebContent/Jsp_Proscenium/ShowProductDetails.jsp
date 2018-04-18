<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowProductDetails.jsp' starting page</title>
    <link rel="stylesheet" href="css/jPages.css">
	<script src="js/jquery-1.8.2.min.js"></script>
	<script src="js/jPages.js"></script>
	<link href="css/main.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" >
	
	$(function(){  
		$("div.holder").jPages({  
		  containerID : "itemContainer",  
		  previous : "上一页",  
		  next : "下一页",  
		  perPage : 3,  
		  delay : 50  
		});  
 	});
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	<!--
	.red{
		color: #FF0000;
	}
	a{
		text-decoration:none; color:#000000;
	}
	a:hover{
		text-decoration:none; color:#000000;
	}
	.lt{
		border-left:1px solid;
		border-top:1px solid;
	}
	.ltr{
		border-left:1px solid;
		border-top:1px solid;
		border-right:1px solid;
	}
	.ltb{
		border-left:1px solid;
		border-top:1px solid;
		border-bottom:1px solid;
	}
	.ltrb{
		border-left:1px solid;
		border-top:1px solid;
		border-right:1px solid;
		border-bottom:1px solid;
	}
	-->
	</style>
  </head>
  
  <body>
	<div id="itemContainer">
		<c:if test="${not empty listnews}">
			<c:forEach items="${listnews}" var="p">
				<tr>
					<td>
						<table width="595" border="0" cellspacing="0" cellpadding="0">
						  <tr height="10">
						  	<td colspan="2">&nbsp;</td>
						  </tr>
						  <tr>
						    <td width="103" height="70"><div align="center"><img src="Img_Proscenium/${p.ppicture }" width="70" height="70" /></div></td>
						    <td width="510"><table width="510" height="70" style="border:1px solid;" cellpadding="0" cellspacing="0">
						      <tr>
						        <td><div align="center">
						          <table width="500" height="58" cellpadding="0" cellspacing="0" border="0"  style="font-size:12px; color:#999999;">
						            <tr>
						              <td width="100" height="28" class="lt" bgcolor="#EBEBEB" ><div align="center">产品名称</div></td>
						              <td width="150" class="lt"><div align="left"><a href="http://localhost:8080/company/detailProduct.jsp?productID=10">&nbsp;${p.pname }</a></div></td>
						              <td width="100" class="lt" bgcolor="#EBEBEB" ><div align="center">产品品牌</div></td>
						              <td width="150" class="ltr"><div align="left" class="red">&nbsp;${p.pbrand }</div></td>
						            </tr>
						            <tr>
						              <td height="28" class="ltb" bgcolor="#EBEBEB" ><div align="center">产品型号</div></td>
						              <td class="ltb"><div align="left">&nbsp;${p.pmodel }</div></td>
						              <td class="ltb" bgcolor="#EBEBEB" ><div align="center">产品价格</div></td>
						              <td class="ltrb"><div align="left"><span class="red">&nbsp;${p.pprice }</span>元</div></td>
						            </tr>
						          </table>
						        </div></td>
						      </tr>
						    </table></td>
						  </tr>  
						  <tr>
						    <td height="20" colspan="2" >&nbsp;</td>
						  </tr>
						</table>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td><div align="right"><%-- <a href="<%=path %>/sum?currentpage=${page.currentpage-1}" target="_parent" style="text-decoration:none; color:#999999; font-size:13px;">上一页</a> <span style="font-size:13px; color: #999999;">|</span> <a href="<%=path %>/sum?currentpage=${page.currentpage+1}" target="_parent" style="text-decoration:none; color:#999999; font-size:13px;">下一页</a> --%></div></td>
			<td>&nbsp;</td>
		</tr>
	</div>
	 <div class="holder"></div>
  </body>
</html>
