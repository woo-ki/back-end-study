<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- name="에밀리", age=20 쿠키에 저장하고 유효시간 10분을 정해서 06_cookie_B --%>
<%
	Cookie name = new Cookie("name", "에밀리");
	Cookie age = new Cookie("age", "20");
	name.setMaxAge(60 * 10);
	age.setMaxAge(60 * 10);
	response.addCookie(name);
	response.addCookie(age);
	
	response.sendRedirect("06_cookie_B.jsp");
%>