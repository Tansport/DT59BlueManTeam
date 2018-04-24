<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script>
		$(function(){
			$("#province").blur(function(){
				var province=$(this).val();
				/* alert("#province"); */
				$.ajax({
					url:"Ajax",
					type:"post",
					date:"province="+province,
					dataType:"json",
					success: function(message){
						$array.empty();
						for(var i=0;i<message.length;i++){						
							$array.append("<option>"+message[i]+"</option>")
						}
						
					},
					error:function(){
						alert("ajax error!")
					}				
				});
			});
			
		});

		
	</script>
</head>
<body>
 省份<select id="arraysel">
		<option>请选择</option>
		<option value="province" name="province" id="province"></option>
	</select>
	<br>
	城市<select id="arraysele">
		
	</select>
</body>
</html>