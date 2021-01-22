<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% session.invalidate(); %>
	<h3>좋아하는 가수 3명을 작성하세요.</h3>
	<form action="Q01_B.jsp">
		<ol>
			<li><input type="text" name="singer" /></li>
			<li><input type="text" name="singer" /></li>
			<li><input type="text" name="singer" /></li>
		</ol>
		<button>전송</button>
	</form>
</body>
</html>