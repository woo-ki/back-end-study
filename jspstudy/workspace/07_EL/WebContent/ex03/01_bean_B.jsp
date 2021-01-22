<%@page import="bean.Person"%>
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
	%>
	
	<%-- 1. tag로 bean 생성 --%>
	<%--
	<jsp:useBean id="p" class="bean.Person" />
	<jsp:setProperty property="*" name="p"/>
	--%>
	
	<%-- 2. java로 bean 생 --%>
	<% 
		Person p = new Person();
		p.setName(request.getParameter("name"));
		p.setAge(Integer.parseInt(request.getParameter("age")));
		p.setGender(request.getParameter("gender"));
		
		// EL사용을 위해서 pageContext에 올려둔다.
		pageContext.setAttribute("p", p);
	%>
	
	<h3>이름: ${p.name}</h3>
	<h3>나이: ${p.age}</h3>
	<h3>성별: ${p.gender}</h3>
</body>
</html>