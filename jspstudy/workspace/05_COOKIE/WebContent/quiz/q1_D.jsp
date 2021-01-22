<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String birth1 = request.getParameter("birth1");
	String birth2 = request.getParameter("birth2");
	String birth3 = request.getParameter("birth3");
	String birth = birth1 + "년 " + birth2 + "월 " + birth3 + "일";
	String married = request.getParameter("married");
	String job = request.getParameter("job");
	
	String[][] params = {{"id", id}, {"pw", pw}, {"name", name}, {"addr", addr}, {"phone", phone}, 
										{"email", email}, {"birth", birth}, {"married",married}, {"job", job}};
	
	
	for(int i = 0; i < params.length; i++) {
		Cookie cookie = new Cookie(params[i][0], URLEncoder.encode(params[i][1], "UTF-8"));
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
	}
	
	response.sendRedirect(application.getContextPath() + "/quiz/q1_E.jsp");
%>