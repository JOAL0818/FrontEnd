<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<%
		//세션을 초기화 - id가 없으므로 로그아웃된 효과 발생
		session.invalidate();
	%>
	로그아웃 하셨습니다.
	3초 후 메인페이지로 이동합니다. 
	<script>
		//3초후에 동작하는 타이머를 이용해서 main.jsp로 이동
		setTimeout(function(){
			location.href='main.jsp';
		}, 3000);	
	</script>
	
</body>
</html>