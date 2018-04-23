<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
<script>
	function abc() {
		var tby = document.getElementById("tby");
		var ct = tby.children;//tby对象所有子节点<tr>
		for (var i = 0; i < ct.length; i++) {
			//alert(ct[i].children[3].innerHTML);
			//alert(ct[i].children[2].children[1].value);
			ct[i].children[5].children[0].value = ct[i].children[3].innerHTML
					* ct[i].children[2].children[1].value;
		}
	}
	window.onload = function() {
		abc();
		//先算加法
		var add = document.getElementsByName("add");
		for (var i = 0; i < add.length; i++) {
			add[i].onclick = function() {
				//获取值
				var num = this.parentNode.children[1].value;
				//alert(num);
				//用函数转型 加1
				var n = parseInt(num) + 1;
				//重新赋值
				this.parentNode.children[1].value = n;
				abc();
			}
		}
		//减法
		var jf = document.getElementsByName("jf");
		for (var j = 0; j < jf.length; j++) {
			jf[j].onclick = function() {
				var num = this.parentNode.children[1].value;
				var n = num - 1;
				if (n <= 0) {
					n = 1;
				}
				this.parentNode.children[1].value = n;
				abc();
			}
		}
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>购物车系统</title>
</head>
<body>
	<%
	    double d = Math.random();
	    String flag = Double.toString(d);
	    session.setAttribute("flag", flag);
	%>
	<table align="center" border="1">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>商品单价</th>
			<th>商品描述</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<tbody id="tby">
			<c:forEach items="${map }" var="map">
				<tr>
					<td>${map.value.spid }</td>
					<td>${map.value.spname }</td>
					<td><a href="javascript:;" name="jf"
						style="text-decoration: none">-</a> <input type="text" id="num"
						name="num" value="${map.value.num }" size="7" /> <a
						href="javascript:;" name="add" style="text-decoration: none">+</a>
					</td>
					<td>${map.value.spprice }</td>
					<td>${map.value.spdesc }</td>
					<td><input type="text" id="price" name="price" value="0"
						size="10" /></td>
					<td><a href="#">购买</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>