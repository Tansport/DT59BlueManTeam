<%@page import="java.util.UUID"%>
<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 		
	//上传图片
	SmartUpload su=new SmartUpload();//实例化上传对象
	su.initialize(super.getServletConfig(), request, response);//初始化响应
	String str1="jpg,png,nif";//文件类型
	String str2="exe,rar,jsp";	
	File upload;//文件接收
		
		try{
		    su.setAllowedFilesList(str1);//允许上传类型
			su.setDeniedFilesList(str2);//不允许上传清单
			su.setMaxFileSize(5*1024*1024);//允许上传文件大小
			su.setCharset("utf-8");//编码格式
			su.upload();//执行上传
			upload=su.getFiles().getFile(0);//获取文件
			String path="upload/";//路径
			String filename="";//文件名
	
	
		if(!upload.isMissing()){//若文件存在
		    filename=UUID.randomUUID()+".jpg";//随机唯一编码文件名
		    path+=filename;
		    upload.saveAs(path, su.SAVE_VIRTUAL);//虚拟存储到此路径		    
		}
		String ntitle=su.getRequest().getParameter("ntitle");
		String nauthor=su.getRequest().getParameter("nauthor");
		String nsummary=su.getRequest().getParameter("nsummary");
		String ncontent=su.getRequest().getParameter("ncontent");
		request.setAttribute("ntitle", ntitle);
		request.setAttribute("nauthor", nauthor);
		request.setAttribute("nsummary", nsummary);
		request.setAttribute("ncontent", ncontent);
		request.setAttribute("filename", filename);		
		request.getRequestDispatcher("showInfo.jsp").forward(request, response);
		}catch(Exception e){
		    e.printStackTrace();
		}
				
	
%>

</body>
</html>