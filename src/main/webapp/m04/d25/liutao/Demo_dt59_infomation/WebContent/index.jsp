<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript">
$(function(){
	var person={
			"name":"汪洋",
			"age":21,
			"sex":"男",
			"jop":"学生",
			"address":"北京市海淀区上地西里X号楼X单元X号",
			"phone":"13600000000"			
	}
	$("#btn").click(function(){
		var tt="";
		$.ajax({
			url:"ajax",
			type:"POST",
			data:JSON.stringify(person),
			dataType:"json",
			success:function(mess){
				//var mess=eval("("+message+")");
				//alert(mess);
				for(var i=0;i<mess.length;i++){
					//alert("name"+mess[i]["name"]+"<br>"+"age"+mess[i]["age"]+"<br>");
					tt+="name:"+mess[i]["name"]+"<br>"+"age:"+mess[i]["age"]+"<br>"+"sex:"+mess[i]["sex"]+"<br>"+
					"jop:"+mess[i]["jop"]+"<br>"+"address:"+mess[i]["address"]+"<br>"+"phone:"+mess[i]["phone"]+"<br>"+"name:"+mess[i]["name"]+"<br>";
				}
				$("#mydiv").html(tt);
				
			},
			error:function(){
				alert("ajax error!")
			}
		});
	});
});

</script>
<title>Insert title here</title>
</head>
<body>
<input type="button" value="测试" id="btn">
<div id="mydiv" style="font-size:24px;color:red;"></div>
</body>
</html>