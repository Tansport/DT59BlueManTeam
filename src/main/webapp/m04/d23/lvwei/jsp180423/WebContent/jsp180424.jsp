<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="js/jquery-1.8.3.js"></script>
	<script src="js/json2.js"></script>
	<script>
		$(function(){
			//定义一个json对象
				var person={
					"id":110,
					"name":"鲁直伸",
					"salary":2000
				};
			$("#btn").click(function(){
				var tt="";
				$.ajax({
					url:"ajax",
					type:"POST",
					data:JSON.stringify(person),
					success:function(message){
						//alert(message);
						//alert(message.length);
						var mess=eval("("+message+")");//解析后台的json数组装的是(ArrayList)
						//alert(mess.length);
						for(var i=0;i<mess.length;i++){//json数组
							//alert(mess[i]["id"]+"  "+mess[i]["name"]+"  "+mess[i]["salary"]);
							tt+=mess[i]["id"]+"-"+mess[i]["name"]+"-"+mess[i]["salary"];
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
   	<input type="button" id="btn" value="异步请求"/><br/>
   	<div id="mydiv" style="font-size:24px;color:red;"></div>
  </body>
</html>
