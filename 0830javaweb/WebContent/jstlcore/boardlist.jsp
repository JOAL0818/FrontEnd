<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*"%>
<%
	List<Map<String, Object>> list = new ArrayList<>();

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("num",2);
	map.put("title","가입인사");
	map.put("nickname","조아라");
	map.put("regdate","2018-08-30");
	map.put("readcnt",100);
	
	list.add(map);
	
	
	map = new HashMap<String, Object>();
	map.put("num",1);
	map.put("title","테스트");
	map.put("nickname","관리자");
	map.put("regdate","2018-07-30");
	map.put("readcnt",10);
	
	list.add(map);
	
	
	//결과 페이지에 전달하기 위해서 데이터 저장  
	request.setAttribute("list", list);
	//결과페이지로 포워딩 
	RequestDispatcher dispatcher = request.getRequestDispatcher("boardview.jsp");
	dispatcher.forward(request, response);		
%>	
	