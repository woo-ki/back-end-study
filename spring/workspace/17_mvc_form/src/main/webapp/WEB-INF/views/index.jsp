<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<a href="/mvc07/member/loginPage">로그인하러 가기</a>
	<%-- 
		주의사항.
		location.href 태그의 매핑값은 슬래시로 시작하면 안 된다.
	--%>
	
	<input type="button" value="로그인하러 가기" onclick="location.href='member/login.do'" />
</body>
</html>