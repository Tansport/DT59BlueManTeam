<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#province").change(function(){
			var province=$(this).val();
			$.ajax({
				url:"ajax",
				type:"post",
				date:"province="+province,
				dataType:"json",
				success: function(date){
					$arraysele.empty();
					for(var i=0;i<date.length;i++){						
						$arraysele.append("<option>"+date[i]+"</option>")
					}
					
				},
				error:function(){
					alert("ajax error!")
				}												
			});			
		});
	});
</script>
<title>选择城市</title>
</head>
<body>
	省份<select id="arraysel">
		<option>请选择</option>
		<option value="province" name="province"></option>
	</select>
	<br>
	城市<select id="arraysele">
		
	</select>
</body>
</html>