<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
	// session.removeAttribute("loginUser");
	response.sendRedirect("/06_SESSION/ex02/01_login_A.jsp");
%>