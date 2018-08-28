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
		Cookie [] cookies = request.getCookies();
		boolean flag = false;
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("popup")){
					flag = true;
					break;
				}
			}
		}
		if(flag == false){
			out.println("<script>");
			out.println("window.open('https://www.google.com','google','width=600, height=300')");			
			out.println("</script>");
		}
		
		//쿠키를 이용해서 설정 내용을 저장하는 용도로 사용할 수 있다.
		//쿠키의 데이터를 저장해두었다가 페이지를 읽을 때 쿠키의 값을 읽어서 서로 다른 내용을 출력하면 된다.
		
	%>
</body>
</html>