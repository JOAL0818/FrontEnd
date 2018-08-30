<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl의 core기능을 사용하기 위한 태그 라이브러리 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록보기</title>
</head>
<body>
	<table frame="above" rules="rows" width="700" align="center" cellpadding="5">
		<tr>
			<th width="50">글번호</th>
			<th width="400">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="50">조회수</th>
		</tr>	
		<c:forEach var="board" items="${list}">
			<tr>
				<td align="right">${board.num}</td>
				<td>${board.title}</td>
				<td align="center">${board.nickname}</td>
				<td>${board.regdate}</td>
				<td>${board.readcnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>