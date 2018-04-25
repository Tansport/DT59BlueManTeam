<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("select[id='province']").change(
				function() {
					//alert($(this).val());
					var province = $(this).val();
					var pro = {
						"pro" : province
					};//json格式
					$.ajax({
						url : "ajax",
						type : "POST",
						data : JSON.stringify(pro),
						dataType : "json",
						success : function(message) {
							//alert(message.length);
							$("select[id='city']>option").remove();
							for (var i = 0; i < message.length; i++) {
								$("#city").append(
										"<option>" + message[i] + "</option>");
							}
						},
						error : function() {
							alert("ajax error!");
						}
					});
				});
	});
</script>
</head>
<body>
	<select id=province name="province">
		<option value="湖北">湖北</option>
		<option value="广东">广东</option>
		<option value="江西">江西</option>
	</select>省
	<select id=city>
		<option>请选择城市</option>
	</select>
</body>
</html>