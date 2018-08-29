<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>id:${id}</h3>
	<h3>점수:${score+5}</h3>
	
	<!-- 직접지정하고자 하는 경우, 이렇게 할 수 있지만 잘 사용x -->
	<h3>id:${sessionScope.id}</h3>
	<h3>점수:${sessionScope.score+5}</h3>
</body>
</html>