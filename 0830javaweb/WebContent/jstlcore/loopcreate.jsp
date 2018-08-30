<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%
	//문자열 배열만들기 
	String [] ar = {"Java","JavaScript", "SQL"};
	
	//문자열 리스트 만들기
	List<String> list = new ArrayList<>();
	list.add("HTML5");
	list.add("CSS");
	
	//맵 객체를 생성하고데이터 저장 
	Map<String, Object>map = new HashMap<>();
	map.put("Language","Java");
	map.put("Database","oracle");
	
	//,로구분된 문자열 만들기 
	String db = "Oracle,MySQL,MongoDB";
	
	
	
	//결과 페이지에 전달하기 위해서 데이터 저장  
	request.setAttribute("ar", ar);
	request.setAttribute("list", list);
	request.setAttribute("map", map);
	request.setAttribute("db", db);
	//결과페이지로 포워딩 
	RequestDispatcher dispatcher = request.getRequestDispatcher("loop.jsp");
	dispatcher.forward(request, response);		
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>