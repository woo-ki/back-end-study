<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_send(f) {
		f.action = '/02_JSP/quiz/Q03_B.jsp';
		f.submit();
	}
</script>
</head>
<body>
	<form>
		설문작성자<br/>
		<input type="text" name="name" /><br/><br/>

		<h2>1. 좋아하는 연예인은 누구인가요?</h2>
		<input type="text" name="star" />
		<input type="button" value="다음" onclick="fn_send(this.form)"/>
	</form>
</body>
</html>