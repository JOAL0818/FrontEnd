<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery연습</title>
<style>
		<!-- 글자에 밑줄 없애기 -->
		a{
		text-decoration:none
		}
</style>
</head>
<body>
	<%
		session.setAttribute("aa", "jj");
	%>
	프로젝트 이름까지의 경로 : ${pageContext.request.contextPath}
	<input type ="button" value="클릭" id="btn" />
	
	<!-- 로그아웃 링크 -->
	<a href="logout">로그아웃</a> 
	
	<nav>
		<ul>
			<li><a href="login.do">로그인</a></li>
			<li><a href="register.do">회원가입</a></li>
		</ul>		
	</nav>
	
	
</body>
<script src ="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<script>
	//jquery 이벤트처리 
	$('#btn').bind('click',function(){
	console.log("로그를 출력합니다.");
	})
	
	//브라우저 찾을 새로 닫거나 새로 고침을 할때, 
	$(window).bind("beforeunload",function(){
		//서버에게 logout 요청을 ajax로 전송 
		$.ajax({
			url:"logout"//주소를 틀리지 않아야 잘 연결된다!		
		})
	})
	
	
	//스크립트에 $로 시작하면 jquery를 사용하는 
	//문서의 내용을 전부 읽자마자
	//보통 jquery사용은 이것으로 파악한다. 
	$(function(){
		alert("jquery를 사용합니다.")		
	})
</script>

</html>