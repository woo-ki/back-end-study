<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String star = request.getParameter("star");
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_send(f) {
		f.action = '/02_JSP/quiz/Q03_C.jsp';
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<h2>2. 좋아하는 운동선수는 누구인가요?</h2>
		<input type="text" name="sports" />
		<input type="hidden" name="star" value="<%=star%>" />
		<input type="hidden" name="name" value="<%=name%>" />
		<input type="button" value="결과보기" onclick="fn_send(this.form)"/>
	</form>
</body>
</html>