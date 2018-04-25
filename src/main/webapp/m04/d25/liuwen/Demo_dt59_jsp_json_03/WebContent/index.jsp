<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="js/jquery-1.8.3.js"></script>
<script src="js/json2.js"></script>
<script>
	$(function() {
		//定义一个json对象
		var person = {
			"name" : "汪洋",
			"age" : 21,
			"sex" : "男",
			"job" : "学生",
			"address" : "北京市",
			"phonenumber" : "13888888888"
		};
		$("#btn").click(
				function() {
					var tt = "";
					$.ajax({
						url : "ajax",
						type : "POST",
						data : JSON.stringify(person),
						success : function(message) {
							//alert(message);
							//alert(message.length);
							//message = message.parseJSON();
							//alert(message);
							var mess = JSON.parse(message);
							//alert(mess.length);
							// var mess = eval("(" + message + ")");//解析后台的json数组装的是(ArrayList)
							//alert(mess.length);
							for (var i = 0; i < mess.length; i++) {//json数组
								//alert(mess[i]["id"]+"  "+mess[i]["name"]+"  "+mess[i]["salary"]);
								tt += "姓名:"+mess[i]["name"] + "<br/>" +"年龄:"+ mess[i]["age"]
										+ "<br/>" +"性别:"+ mess[i]["sex"] + "<br/>"+"职业:"+ mess[i]["job"] + "<br/>"+"住址:"+ mess[i]["address"] + "<br/>"+"电话:"+ mess[i]["phonenumber"] + "<br/>";
							}
							$("#mydiv").html(tt); 
						},
						error : function() {
							alert("error!");
						}
					});
				});
	});
</script>
</head>

<body>
	<input type="button" id="btn" value="异步请求" />
	<br />
	<div id="mydiv" style="font-size: 24px; color: red;"></div>
</body>
</html>