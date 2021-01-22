<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_send(f) {
		f.action='/02_JSP/quiz/Q02_B.jsp';
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<label for="age">당신의 나이는?</label>
		<input type="text" id="age" name="age" />
		<input type="button" value="확인" onclick="fn_send(this.form)" />
	</form>
	
</body>
</html>