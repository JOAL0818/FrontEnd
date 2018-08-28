<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지흐름</title>
</head>
<body>
	<%
		//다른 URL로 포워딩 - 현재도메인 내에서만 이동이 가능 
		//프로젝트 안에 있는 파일의 경로를 설정 
		//새로고침을 하면 register.jsp가 새로고침되는 것이 아니고 현재페이지가 새로고침되는 것이다.
		//pageContext.forward("register.jsp");
	
		
		//리다이렉트 - 외부도메인으로 이동가능 
		//URL이 변경된다.
		//새로고침을 하면 register.jsp가 새로고침된다. 
		response.sendRedirect("register.jsp");
		
	%>
</body>
</html>