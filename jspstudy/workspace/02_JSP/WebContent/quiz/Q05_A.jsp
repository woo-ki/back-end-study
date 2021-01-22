<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input[type="text"] {
		width: 80px;
	}
</style>
</head>
<body>
	<%
		int a = (int)(Math.random() * 9) + 1;
		int b = (int)(Math.random() * 9) + 1;
		int i = (int)(Math.random() * 5);
		String[] operators = {"+", "-", "*", "/", "%"};
	%>
	<h3>랜덤 계산기</h3>
	<form>
		<span><%=a%> <%=operators[i]%> <%=b%> = </span>
		<input type="text" name="answer" />
		<input type="button" value="제출" onclick="fn_send(this.form)" />
		<input type="hidden" name="a" value="<%=a%>" />
		<input type="hidden" name="b" value="<%=b%>" />
		<input type="hidden" name="operator" value="<%=operators[i]%>" />
	</form>
	<script type="text/javascript">
		function fn_send(f) {
			f.action = "<%=application.getContextPath()%>/quiz/Q05_B.jsp";
			f.submit();
		}
	</script>
</body>
</html>