<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<%-- 
		<form action="<%=request.getContextPath()%>/member/login.do" method="post">
	--%>
	<%-- 
		주의사항.
		form 태그의 매핑값은 슬래시로 시작하면 안 된다.
		<form action="/member/login.do" method="post">
	--%>
	<form action="<%=request.getContextPath()%>/member/login.do" method="post">
		아이디<br/>
		<input type="text" name="id" /><br/><br/>
		비밀번호<br />
		<input type="password" name="pw" /><br /><br />
		<button>로그인</button>
	</form>
</body>
</html>