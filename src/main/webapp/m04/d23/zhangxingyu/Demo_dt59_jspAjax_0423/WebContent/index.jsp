<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/json2.js"></script>
	<script>
		$(function(){
			$("select[id='province']").change(function(){
				//alert($(this).val());
				var province=$(this).val();
				var pro={"pro":province};//json格式
				$.ajax({
					url:"ajax",
					type:"POST",
					data:JSON.stringify(pro),
					dataType:"json",
					success:function(message){
						$("select[id='city']>option").remove();
						for(var i=0;i<message.length;i++){
							$("#city").append("<option>"+message[i]+"</option>");
						}
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
    <select id="province">
    	<option value="湖北">湖北</option>
    	<option value="湖南">湖南</option>
    	<option value="广东">广东</option>
    </select>省
    <select id="city">
    	<option>请选择.......</option>
    </select>
  </body>
</html>
