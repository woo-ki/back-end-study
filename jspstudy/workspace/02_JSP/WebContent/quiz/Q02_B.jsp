<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int age = 0;
	
	if(request.getParameter("age") != null && !request.getParameter("age").isEmpty()) {
		age = Integer.parseInt(request.getParameter("age"));
	}
			
	
	if(age >= 20) {
		request.getRequestDispatcher("/quiz/Q02_D.jsp").forward(request, response);
		// response.sendRedirect("/02_JSP/quiz/Q02_D.jsp?age=" + age);
	} else {
		request.getRequestDispatcher("/quiz/Q02_C.jsp").forward(request, response);
		// response.sendRedirect("/02_JSP/quiz/Q02_C.jsp?age=" + age);
	}
%>