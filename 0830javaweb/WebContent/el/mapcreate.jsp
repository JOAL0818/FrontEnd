<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Map 생성</title>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%
		//Map 데이터 생성
		//Map <String, Object> map = new HashMap<>();
		//map.put("name","조아라");
		//map.put("age",29);
		
		//request에 저장
		//request.setAttribute("map", map);
		
		
		vo.Person person = new vo.Person();
		person.setName("조아라");
		person.setAge(30);
		request.setAttribute("map", person);
		
				
		//결과페이지로 포워딩 
		RequestDispatcher dispatcher = request.getRequestDispatcher("mapdisplay.jsp");
		dispatcher.forward(request, response);		
	%>
</body>
</html>