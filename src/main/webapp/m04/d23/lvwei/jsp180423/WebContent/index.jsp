<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#province").change(function() {
			var a = $("#province").val();
			//alert(a);
			var pro = {
				"pro" : a
			};
			$.ajax({
				url : "ajax",
				type : "POST",
				data : JSON.stringify(pro),
				//data : "pro=" + a,

				dataType : "json",
				success : function(date) {
					//alert(date);

					$("select>option").remove();
					for (var i = 0; i < date.length; i++) {
						var option = "<option>" + date[i] + "</option>";
						$("#city").append(option);

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
	<label>省份：</label>
	<input type="text" id="province" name="province">
	<br>
	<label>城市：</label>
	<select id="city">
		<option>请选择</option>

	</select>
	<br>


</body>
</html>