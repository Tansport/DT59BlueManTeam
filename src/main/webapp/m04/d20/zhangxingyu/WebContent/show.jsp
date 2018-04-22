<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		function abc(){
			var tby=document.getElementById("tby");//js对象
			//获取范围之内所有子节点
			var tt= tby.children;
			for(var i=0;i<tt.length;i++){//tt[i]某一行
				tt[i].children[5].children[0].value=tt[i].children[2].children[1].value*tt[i].children[3].innerHTML;
			}
		}
		//一进入到当前的页面就加载
		window.onload=function(){
			abc();//方法调用
			var add=document.getElementsByName("add");//js对象
			for(var i=0;i<add.length;i++){
				add[i].onclick=function(){
					//当某一行被点击的时候
					var val=parseInt(this.parentNode.children[1].value);
					val++;
					this.parentNode.children[1].value=val;
					abc();
				}
			}
			var jf=document.getElementsByName("jf");
			for(var j=0;j<jf.length;j++){
				jf[j].onclick=function(){
					var val=parseInt(this.parentNode.children[1].value);
					val--;
					if(val<=0){
						val=1;
					}
					this.parentNode.children[1].value=val;
					abc();
				}
			}
		}
		
		
	</script>

  </head>
  
  <body>
   	<h1>欢迎领导登录购物车页面！</h1>
   	<hr/>
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
    	<tbody id="tby">
    	<c:forEach items="${map }" var="mp">
    	<tr>
    		<td>${mp.value.spid } </td>
    		<td>${mp.value.spname }</td>
    		<td>
    			<a href="javascript:;" name="add">+</a>
    			<input type="text" id="num" name="num" value="${mp.value.num }" size="5"/>		
    			<a href="javascript:;" name="jf">-</a>
    		</td>
    		<td>${mp.value.spprice }</td>
    		<td>${mp.value.spdesc }</td>
    		<td>
    			<input type="text" id="price" name="price" value="${mp.value.num*mp.value.spprice }" size="7"/>		
    		</td>
    		<td>
    			<a href="#">购买</a>
    		</td>
    	</tr>
    	</c:forEach>
    	</tbody>
    	
   	</table>
   	<hr/>
   	<input type="button" value="测试" onclick="abc();"/>
  </body>
</html>
