<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript">
	$(function() {
		$("select[id='province']").change(function(){
			alert($(this).val());
			var province=$(this).val();/* 改变的值传递过去 */
			var pro={"pro":province};//json格式
			$.ajax({
				url:"ajax",
				type:"POST",
				data:JSON.stringify(pro),
				dataType:"json",//json指得是回调函数返回得数据类型
				success: function(message){
					$("select[id='city']>option").remove();
					for(var i=0;i<message.length;i++){
						
						$("#city").append("<option>"+message[i]+"</option>");//追加
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
 <select id="province">
    	<option value="湖北">湖北</option>
    	<option value="湖南">湖南</option>
    	<option value="广东">广东</option>
    </select>省
    <select id="city">
    	<option>请选择.......</option>
    </select>市
</body>
</html>