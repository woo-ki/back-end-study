<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String star = request.getParameter("star");
	String name = request.getParameter("name");
	String sports = request.getParameter("sports");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_reset(f) {
		location.href = '/02_JSP/quiz/Q03_A.jsp';
	}
</script>
</head>
<body>
	<h2><%=name%>님의 선호도 조사 결과</h2>
	<ul>
		<li>좋아하는 연예인: <%=star%></li>
		<li>좋아하는 운동선수: <%=sports%></li>
	</ul>
	
	<input type="button" value="처음부터 다시하기" onclick="fn_reset(this.form)"/>
</body>
</html>