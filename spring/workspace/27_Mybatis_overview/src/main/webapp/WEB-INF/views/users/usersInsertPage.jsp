<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form action="userInsert.do" method="post">
		이름<br/>
		<input type="text" name="name" autofocus="autofocus" /><br/><br/>
		전화<br/>
		<input type="text" name="phone" /><br/><br/>
		<button>작성완료</button>
		<input type="button" value="목록보기" onclick="location.href='usersListPage.do'" />
	</form>
</body>
</html>