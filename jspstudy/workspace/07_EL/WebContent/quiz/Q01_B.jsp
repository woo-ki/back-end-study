<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String[] singer = request.getParameterValues("singer");
	ArrayList<String> list = new ArrayList<>();
	for(String s : singer) {
		list.add(s);
	}
	
	request.setAttribute("list", list);
%>

<%-- 포워드 태그 --%>
<jsp:forward page="Q01_C.jsp" />