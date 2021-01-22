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
		String name = request.getParameter("name");
		String entertainer = request.getParameter("entertainer");
		
		session.setAttribute("name", name);
		session.setAttribute("entertainer", entertainer);
	%>
	<form action="/06_SESSION/quiz/q01_C.jsp">
		<h3>2. 좋아하는 운동선수는 누구인가요?</h3>
		<input type="text" name="sports" />
		<button>결과보기</button>
	</form>
</body>
</html>