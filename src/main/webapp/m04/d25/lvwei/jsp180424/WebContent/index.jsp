<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript">
$(function(){
	//定义一个json对象
		var person={
			"name":"汪洋",
			"age":21,
			"sex":"男",
			"zhiye":"学生",
			"zhuzhi":"北京市海淀区上地西里x号楼x单元x号",
			"phone":"13600000000"
		};
	$("#btn").click(function(){
		var tt="";
		$.ajax({
			url:"ajax",
			type:"POST",
			data:JSON.stringify(person),
			success:function(message){
				var mess=eval("("+message+")");//解析后台的json数组装的是(ArrayList)
				 for(var i=0;i<mess.length;i++){//json数组
					//alert(mess[i]["id"]+"  "+mess[i]["name"]+"  "+mess[i]["salary"]);
					tt+="姓名:"+mess[i]["name"]+"<br/>"
					+"年龄:"+mess[i]["age"]+"<br/>"
					+"性别:"+mess[i]["sex"]+"<br/>"
					+"职业:"+mess[i]["zhiye"]+"<br/>"
					+"住址:"+mess[i]["zhuzhi"]+"<br/>"
					+"电话:"+mess[i]["phone"]+"<br/>";
				} 
				
				$("#mydiv").html(tt);
			},
			error:function(){
				alert("error!");
			}
		});
	});
});
</script>
</head>
<body>
	<input type="button" id="btn" value="获取信息" />
	<br />
	<div id="mydiv" style="font-size: 24px; color: red;"></div>
</body>
</html>