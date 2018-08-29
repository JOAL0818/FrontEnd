<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러났을때 보여질 페이지</title>
</head>
<body>
	<h3><%=exception.getMessage() %></h3>
	<p>에러가 발생했습니다. 조속한 조취를 취하겠습니다.</p>
</body>
</html>