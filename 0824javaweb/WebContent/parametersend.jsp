<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 전송</title>
</head>
<body>
	<!-- ?뒤에 오는것이 파라미터 -->
	<a href="parameterreceive.jsp?name=park&age=33">파라미터전송</a>
	
	
	<!-- form을 만들고 그 안에 name을 갖는 개체들을 만든다. -->
	<form action="formreceive.jsp" method="get">
		이메일<input type="email" name="email" /><br/>
		<fieldset>
			<legend>성별</legend>
			<input type="radio" value="woman" name="gender" checked="checked" />여자
			<input type="radio" value="man" name="gender"/>남자
		</fieldset>
		
		<fieldset>
			<legend>취미</legend>
			<input type="checkbox" name="hobby" value="reading" /> 독서
			<input type="checkbox" name="hobby" value="game" /> 게임 
			<input type="checkbox" name="hobby" value="exercise" /> 운동
			<input type="checkbox" name="hobby" value="programming" /> 프로그래밍
		</fieldset>
		
		<br/><input type="submit" value="전송" />
		
		
	</form>
</body>
</html>