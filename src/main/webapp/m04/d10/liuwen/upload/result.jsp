<%@page import="com.jspsmart.upload.File"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		/* String ntitle = request.getParameter("ntitle");
		String nauthor = request.getParameter("nauthor");
		String nsummary = request.getParameter("nsummary");
		String ncontent = request.getParameter("ncontent");
		
		request.setAttribute("ntitle", ntitle);
		request.setAttribute("nauthor", nauthor);
		request.setAttribute("nsummary", nsummary);
		request.setAttribute("ncontent", ncontent); */
		
		/* out.print(ntitle); */
	     //1.实例化上传对象
	    SmartUpload su = new SmartUpload();
	    //2.初始化 父类ServletConfig，请求，响应
	    su.initialize(super.getServletConfig(), request, response);
	    //设置格式
	    String one = "jpg,png";
	    String two = "exe,jsp,rar";
	    //接收文件流
	    File upload;
	    try {
	        //设置允许上传的文件格式
	        su.setAllowedFilesList(one);
	        //设置不允许上传的文件格式
	        su.setDeniedFilesList(two);
	        //设置文件的大小，5M
	        su.setMaxFileSize(5 * 1024 * 1024);
	        //设置格式
	        su.setCharset("utf-8");
	        //执行上传
	        su.upload();
	        //String ntitle = su.getRequest().getParameter("ntitle");
	        //ntitle = new String(ntitle.getBytes(),"UTF-8");
	        //获取文件
	        upload = su.getFiles().getFile(0);
	        //思想：用另存为的方式，上传图片
	        String path1="pic\\";//文件路径
	        String filename="";//文件名字
	        if(!upload.isMissing()){
	            //如果文件存在
	           filename = upload.getFileName();
	           path1+=filename;
	           upload.saveAs(path1, su.SAVE_VIRTUAL);
	        }
	        String ntitle = su.getRequest().getParameter("ntitle");
	        String nauthor = su.getRequest().getParameter("nauthor");
	        String nsummary = su.getRequest().getParameter("nsummary");
	        String ncontent = su.getRequest().getParameter("ncontent");
	        
	        request.setAttribute("ntitle", ntitle);
	        request.setAttribute("nauthor", nauthor);
	        request.setAttribute("nsummary", nsummary);
	        request.setAttribute("ncontent", ncontent);
	        
	        request.setAttribute("path1", path1);
	        request.setAttribute("filename", filename);
	        request.getRequestDispatcher("show.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	%>

</body>
</html>