<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터읽기</title>
</head>
<body>
	<%
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String [] hobbies = request.getParameterValues("hobby");	
	%>
	
	<!-- 읽은 파라미터를 출력해본다. -->
	이메일:<%=email %><br/>
	성별:<%=gender %><br/>
	취미:<% for(String hobby:hobbies){ %>
		<%=hobby %>,
		<% } %>
 
	
</body>
</html>