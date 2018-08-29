<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터저장 
 	//request.setAttribute("id", "joal1867");
	//request.setAttribute("score", 80);	
	//결과페이지로 포워딩 
	//RequestDispatcher dispatcher = request.getRequestDispatcher("attrdisplay.jsp");
	//dispatcher.forward(request,response);

	
	
	//결과페이지로 리다이렉트 -> request의 데이터는 전달되지 않는다. (session이용)
	session.setAttribute("id", "joal1867");
	session.setAttribute("score", 80);
	response.sendRedirect("attrdisplay.jsp");
%>