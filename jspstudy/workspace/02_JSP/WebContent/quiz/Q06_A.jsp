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
		width: 80px;
	}
</style>
</head>
<body>
	<h3>신규 회원 정보를 입력하세요</h3><br/>
	<form action="<%=request.getContextPath()%>/quiz/Q06_B.jsp" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" /><br/>
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" id="pw" /><br/>
		<label for="name">이름</label>
		<input type="text" name="name" id="name" /><br/>
		<button>회원가입</button>
	</form>
</body>
</html>