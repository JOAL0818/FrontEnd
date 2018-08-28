<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<%
		//post방식에서 파라미터 인코딩처리 
		request.setCharacterEncoding("utf-8");
	
		//처리하는 쪽에서 항상 가장 먼저 해야할 일 
		//ㄴlogin.jsp에서 전송해분 파라미터 읽기 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw"); 
		
	 	if(id.equals("system")&&pw.equals("1234")){
	 		//화면에 제대로 나오는지 출력해봤다.
	 		//out.println("로그인성공");
	 		
	 		//로그인 정보를 세션에 저장 
	 		session.setAttribute("id",id);
	 		session.setAttribute("nick","관리자");
	 		//main.jsp 파일로 리다이렉트 
	 		//새로고침 했을 때 로그인을 다시하면 안되기 때문에 리다이렉트한다. 
	 		response.sendRedirect("main.jsp");
	 		
	 	}else{
	 		out.println("로그인실패");
	 		//키와 데이터를 입력 
	 		session.setAttribute("msg","아이디나 비밀번호가 틀렸습니다.");
	 		response.sendRedirect("login.jsp");
	 	}
	%>
</body>
</html>