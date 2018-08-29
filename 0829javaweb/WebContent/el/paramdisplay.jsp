<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터와 쿠키를 출력</title>
</head>
<body>
	<% String attr=application.getInitParameter("user"); 
		System.out.println(attr);%>
	<p>파라미터:${param.query}</p>	
	<p>쿠키:${cookie.sessionid.value}</p>
	<p>초기화 파라미터:${initParam.user}</p> 
	
</body>
</html>