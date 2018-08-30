<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl의 core기능을 사용하기 위한 태그 라이브러리 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach var="temp" items="${ar}">
		<li>${temp}</li>
	</c:forEach><br/>
	<c:forEach var="temp" items="${list}">
		<li>${temp}</li>
	</c:forEach><br/>
	<c:forEach var="temp" items="${map}">
		<li>${temp}</li>
	</c:forEach><br/>
	<c:forEach var="temp" items="${db}">
		<li>${temp}</li>
	</c:forEach><br/>
</body>
</html>