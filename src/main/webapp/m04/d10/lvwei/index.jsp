<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="result.jsp" method="post" enctype="multipart/form-data">
				<p>
					<label> 标题
					</label> <input name="ntitle" type="text"
						class="opt_input" value="" />
				</p>
				<p>
					<label> 作者 </label> <input name="nauthor" type="text"
						class="opt_input" value="" />
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" cols="40" rows="3">摘要</textarea>
				</p>
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" cols="70" rows="10">内容</textarea>
				</p>
				<p>
					<label> 上传图片 </label> <input name="upload" type="file"
						class="opt_input" />
				</p>
				<input type="submit" name="sub" value="提交" class="opt_sub" /> <input
					type="reset" value="重置" class="opt_sub" />
			</form>
</body>
</html>