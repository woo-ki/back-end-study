<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 70px;
	}
</style>
</head>
<body>
	<h3>개인정보를 입력하세요</h3>
	<form action="<%=application.getContextPath()%>/quiz/q1_B.jsp" method="post">
		<label for="id">아이디</label>
		<input type="text" id="id" name="id" /><br/>
		<label for="pw">비밀번호</label>
		<input type="password" id="pw" name="pw" /><br/>
		<label for="name">이름</label>
		<input type="text" id="name" name="name" /><br/>
		<br/><br/>
		<button>확인</button>
	</form>
</body>
</html>