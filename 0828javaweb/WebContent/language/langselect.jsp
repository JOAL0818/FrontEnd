<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 언어선택</title>
</head>
<body>
	<%
		//쿠키읽기 - 개별적으로 가져올 수 없으니 몽땅 가져온다. 
		Cookie [] cookies = request.getCookies();
		//쿠키 값을 저장할 변수 - 기본값 설정 
		String lang = "kor";
		//lang이라는 이름의 쿠키의 값을 lang이라는 변수에 저장 
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("lang")){
					lang=cookie.getValue();				
				}
			}
		}
		//eng 선택하면 eng, kor선택하면 kor이 들어온다.
		if(lang.equals("eng")){
			out.println("<h3>English</h3>");
		}else{
			out.println("<h3>한국어</h3>");
		}
	%>

	<!-- form의 데이터를 langsave.jsp로 전송 -->
	<form action = "langsave.jsp">
		<h3>언어 선택</h3>
		<input type="radio" value="eng" name="lang" id="english"/>영어 
		<input type="radio" value="kor" name="lang" id="korean" checked="checked" />한국어  
		<input type="submit" value="선택완료" />
	</form>
	
	<script>
		<%
			if(lang.equals("eng")){
				out.println("document.getElementById('english').checked=true");
			}
		%>
	</script>
</body>
</html>