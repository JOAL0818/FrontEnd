<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//파라미터 읽기 
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//콘솔에 파라미터 출력
		System.out.println(id);
		System.out.println(pw);
		
		//결과페이지로 이동
		
		//1)포워딩으로 결과 페이지로 이동하자 : URL이 변경되지 않는다. 
		//RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		//dispatcher.forward(request, response);
		
		//2)리다이렉트로 이동 - URL이 변경된다. 
	  	//response.sendRedirect("result.jsp");
		
		
		
		//리다이렉트로 이동 -> URL변경된다.  (attribute관련) 
		//리퀘스트에 저장 - 소멸된다. (리다이렉트로 이동했으니까)
		//request.setAttribute("data1","리퀘스트");
		//세션에 저장했으므로 이동을 해도 유지가 된다. 
		//session.setAttribute("data2","세션");
		//response.sendRedirect("result.jsp");
		
		
		
	 	//포워딩으로 이동 
	 	//리퀘스트에 저장 -> 유지된다. 
	 	request.setAttribute("data1","리퀘스트");
	 	//세션에 저장 -> 유지된다.
	 	session.setAttribute("data2","세션");
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
	 	
	%>
</body>
</html>