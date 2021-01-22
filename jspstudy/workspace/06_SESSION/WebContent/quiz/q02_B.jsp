<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style type="text/css">
	div {
		border-top: 1px dashed black;
		border-bottom: 1px dashed black;
		width: 400px;
		padding: 5px;
	}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("pw", request.getParameter("pw"));
		session.setAttribute("name", request.getParameter("name"));
	%>
	<h3>이용 약관</h3>
	<div>	
		<span>1. 회원 정보는 웹 사이트 운영을 위해서만 사용됩니다.</span>
		<span>2. 원치 않으면 정보 제공을 하지 않을 수 있습니다.</span>
		<span>3. 다만 이 경우 정상적인 웹사이트 이용이 제한됩니다.</span>
	</div>
	위 약관에 동의하십니까?<br/>
	<form action="q02_C.jsp" method="post">
		<input type="radio" name="agree" id="y" value="yes" checked />
		<label for="y">동의 함</label>
		<input type="radio" name="agree" id="n" value="no" />
		<label for="n">동의 안 함</label><br/>
		<button>회원가입</button>
	</form>
</body>
</html>