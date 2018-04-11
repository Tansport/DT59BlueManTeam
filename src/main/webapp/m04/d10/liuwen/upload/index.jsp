<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
    
%>
<body>
	<form action="result.jsp" method="post" enctype="multipart/form-data">
		<p>
			<label> 标题 </label> <input name="ntitle" type="text"
				class="opt_input" value="" />
		</p>
		<p>
			<label> 作者 </label> <input name="nauthor" type="text"
				class="opt_input" value="" />
		</p>
		<p>
			<label> 摘要 </label>
			<textarea name="nsummary" cols="40" rows="3"></textarea>
		</p>
		<p>
			<label> 内容 </label>
			<textarea name="ncontent" cols="70" rows="10"></textarea>
		</p>
		<lable>上传的文件:</lable>
		<input type="file" name="upload" /><br /> <input type="submit"
			value="上传" />
	</form>
</body>
</html>