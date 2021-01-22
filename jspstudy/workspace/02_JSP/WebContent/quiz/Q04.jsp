<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
 	String n1 = request.getParameter("n1");
 	String n2 = request.getParameter("n2");
 	if(n1 == null || n2 == null) {
 		n1 = "";
 		n2 = "";
 	}
 	int a = 0;
 	if(n1 != "") {
 		a = Integer.parseInt(n1);
 	}
 	double b = 0.0;
 	if(n2 != "") {
 		b = Double.parseDouble(n2);
 	}
	String cal = request.getParameter("cal");
	if(cal == null) {
		cal = "1";
	};
	double result = 0.0;
 	switch(cal) {
		case "1": result = a + b; break;
		case "2": result = a - b; break;
		case "3": result = a * b; break;
		case "4": result = a / b; break;
	} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {
		width: 50px;
	}
</style>
</head>
<body>
	<h3>계산기</h3>
	<form action="/02_JSP/quiz/Q04.jsp">
		<input type="text" name="n1" value="<%=n1%>" />
		<select name="cal">
			<option value="1">+</option>
			<option value="2">-</option>
			<option value="3">*</option>
			<option value="4">/</option>
		</select>
		<input type="text" name="n2" value="<%=n2%>" />
		<button>=</button>
		<input type="text" name="result" value="<%=result%>" readonly />
	</form>
</body>
</html>