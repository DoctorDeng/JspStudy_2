<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试servlet</title>
</head>
<body>
	<h1>我的第一个Servlet小示例</h1>
	<a href="servlet/HelloServlet">使用Get访问Servlet</a>
	<form action="servlet/HelloServlet" method="POST">
		<input type="submit" value="PSOT方式请求Servlet">
	</form>
</body>
</html>