<%@page import="java.util.ArrayList"%>
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
		request.setCharacterEncoding("UTF-8");
		String[] foods = request.getParameterValues("foods");
		
		ArrayList<String> list = new ArrayList<>();
		for(String food : foods) {
			list.add(food);
		}
		
		pageContext.setAttribute("list", list);
	%>
	
	<%-- ArrayList와 같은 List 타입은 배열처럼 사용합니다. --%>
	<h3>${list[0]}</h3>
	<h3>${list[1]}</h3>
	<h3>${list[2]}</h3>
</body>
</html>