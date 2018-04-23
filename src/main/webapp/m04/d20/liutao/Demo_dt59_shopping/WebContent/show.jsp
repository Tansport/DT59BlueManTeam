<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>
window.onload=function(){
	//1.定义xmlHttpRequest
	var xmlHttpRequest;
	function loadAjax(){
		//看浏览器支持
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttpRequest=new XMLHttpRequest();
		} catch (e) {
			 // Internet Explorer
			try {
				xmlHttpRequest=new ActiveXObject("Msxml2.XMLHTTP");//微软xml2格式
			} catch (e) {
				try {
					xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("你的浏览器步支持AJAX!");
					return false;
					
				}
			}
			
		}
	}
	function abc(){
		var tby=document.getElementById("tby");
		var ct=tby.children;//tby对象所有子节点
		for(var k=0;k<ct.length;k++){
				ct[k].children[5].children[0].value=ct[k].children[3].innerHTML*ct[k].children[2].children[1].value;
			}
	}
			//先算加法
			var add=document.getElementsByName("add");			
			for(var i=0;i<add.length;i++){
					add[i].onclick=function(){
							//获取值
							var num=this.parentNode.children[1].value;
							//alert(num);
							//用函数转型 加1
							var n=parseInt(num)+1;
							//重新赋值
							this.parentNode.children[1].value=n;
							abc();
							loadAjax();
							//2.回调函数
							xmlHttpRequest.onreadystatechange=function(){
								if(xmlHttpRequest.responseText==4){
									alert(xmlHttpRequest.responseXML);
								}
								
							}
							//3.初始化xmlHttpRequest组建
							var spid=this.parentNode.parentNode.children[0].innerHTML;
							var spname=this.parentNode.parentNode.children[1].innerHTML;
							var spcount=this.parentNode.children[1].value;
							var sprice=this.parentNode.parentNode.children[3].innerHTML;
							var spdesc=this.parentNode.parentNode.children[4].innerHTML;
							var sptotle=this.parentNode.parentNode.children[5].children[0].value;
xmlHttpRequest.open("get","ajax?spid="+spid+"&spname="+spname+"&spcount="+spcount+"&sprice="+sprice+"&spdesc="+spdesc+"&sptotle="+sptotle,true);
							//4.发送请求
							xmlHttpRequest.send(null);//发送json格式						
							
						}
				}
			//减法
			var del=document.getElementById("del");
			for(var j=0;j<jf.length;j++){
					del[j].onclick=function(){
							var num=this.parentNode.children[1].value;
							var n=num-1;
							if(n<=0){
									n=1;
								}
							this.parentNode.children[1].value=n;
							abc();
							
						}
		}
	}
</script>
</head>
<body>


<h1>欢迎<span style="color:red;font-size:50px">${uname}</span>进入购物车</h1>
<table align="center" border="1px">
  <tr>
    <th>商品编号</th>
    <th>商品名称</th>
    <th>商品数量</th>
    <th>商品价格</th>
    <th>商品描述</th>
    <th>小计</th>  
    <th>操作</th>    
  </tr>
  <tbody id="tby">
<c:forEach items="${map }" var="m">
  <tr><!-- m.value获取map值的对象-->
    <td>${m.value.spid }</td>
    <td>${m.value.spname }</td>
    <td><a href="javascript:;" name="add" id="add"   style="text-decoration: none;">+</a><input type="text" id="totle" name="totle"  value="${m.value.num}" size="5"><a href="javascript:;" name="del" style="text-decoration: none;">-</a></td>
    <td>${m.value.spprice}</td>
    <td>${m.value.spdesc}</td>
    <td><input type="text" id="" name="" value="${m.value.num*m.value.spprice}"></td>
    <td><a  href="#">购买</a></td>
  </tr> 
</c:forEach>
</tbody>
</table>

</body>
</html>