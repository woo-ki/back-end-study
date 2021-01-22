<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="Q05_C.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	String sOperator = request.getParameter("operator");
	String sResult = request.getParameter("answer");
	int result = Integer.parseInt(sResult);
	int cal = 0;
	switch(sOperator) {
		case "+": cal = a + b; break;
		case "-": cal = a - b; break;
		case "*": cal = a * b; break;
		case "/": cal = a / b; break;
		case "%": cal = a % b; break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(result == cal) { %>
		<%=a + sOperator + b + "=" + result%><br/>
		<span>정답입니다.</span>
	<% }else { %>
		<span>제출 : </span><%=a + sOperator + b + "=" + result%><br/>
		<span>정답 : </span><%=a + sOperator + b + "=" + cal%>
	<% } %>
	<br/><br/>
	<a href="<%=application.getContextPath()%>/quiz/Q05_A.jsp">다시풀기</a>

</body>
</html>