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
		String sports = request.getParameter("sports");
		
		session.setAttribute("sports", sports);
	%>
	<h3><%=session.getAttribute("name")%>님의 선호도 조사 결과</h3>
	<ul>
		<li>좋아하는 연예인: <%=session.getAttribute("entertainer")%></li>
		<li>좋아하는 운동선수: <%=session.getAttribute("sports")%></li>
	</ul>
	<br/><br/>
	<input type="button" value="처음부터 다시하기" onclick="location.hr = '/06_SESSION/quiz/q01_D.jsp'" />
</body>
</html>