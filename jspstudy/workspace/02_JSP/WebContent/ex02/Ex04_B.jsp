<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 리다이렉트는 기존 request를 보내주지 않는다.
	// Ex04_C.jsp 로 넘어가는 파라미터는 없습니다.
	// response.sendRedirect("/02_JSP/ex02/Ex04_C.jsp");

	// 리다이렉트를 이용해서 기존 request를 보내주려면
	// 새로운 파라미터로 추가해서 보내줘야 합니다.
	request.setCharacterEncoding("UTF-8");
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	response.sendRedirect("/02_JSP/ex02/Ex04_C.jsp?num1=" + num1 + "&num2=" + num2);
%>