<%@page import="java.util.ArrayList"%>
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
	
		Person p1 = new Person();
		p1.setName(request.getParameter("name1"));
		p1.setAge(Integer.parseInt(request.getParameter("age1")));
		p1.setGender(request.getParameter("gender1"));

		Person p2 = new Person();
		p2.setName(request.getParameter("name2"));
		p2.setAge(Integer.parseInt(request.getParameter("age2")));
		p2.setGender(request.getParameter("gender2"));
		
		ArrayList<Person> people = new ArrayList<>();
		people.add(p1);
		people.add(p2);
	%>
	<% 
		String result = "";
		for(Person p : people) { 
			result += "이름: " + p.getName();
			result += ", 나이: " + p.getAge();
			result += ", 성별: " + p.getGender() + "<br/>";
		}
		pageContext.setAttribute("result", result);
	%>
	${result}
</body>
</html>