<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script>
		$(function(){
				var person={
					"name":"鲁直伸",
					"age":40,
					"sex":"男",
				};
			$("#btn").click(function(){
				var tt="";
				$.ajax({
					url:"ajax2",
					type:"POST",
					data:JSON.stringify(person),
					success:function(message){
						var mess=eval("("+message+")");
						 for(var i=0;i<mess.length;i++){
							tt+="姓名:"+mess[i]["name"]+"<br/>"
							+"年龄:"+mess[i]["age"]+"<br/>"
							+"性别:"+mess[i]["sex"]
						} 
						
						$("#mydiv").html(tt);
					},
					error:function(){
						alert("ajax error!");
					}
				});
			});
		});
	</script>
</head>
<body>
	<input type="button" id="btn" value="测试JSON"/><br/>
   	<div id="mydiv" style="font-size:24px;color:red;"></div>
</body>
</html>