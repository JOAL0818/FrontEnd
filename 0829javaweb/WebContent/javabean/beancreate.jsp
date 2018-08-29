<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="vo.Member" scope="request"></jsp:useBean>

<%
	member.setId("joal1867");
	member.setPassword("1234");
	member.setName("관리자");
%>

<!-- 결과페이지로 포워딩 -->
<jsp:forward page="beanuse.jsp" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> 