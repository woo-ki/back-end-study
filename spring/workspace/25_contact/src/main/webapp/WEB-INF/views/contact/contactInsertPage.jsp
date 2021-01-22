<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form action="contactInsert.do" method="post">
		이름<br/>
		<input type="text" name="name" /><br/><br/>
		전화<br/>
		<input type="text" name="phone" /><br/><br/>
		주소<br/>
		<input type="text" name="address" /><br/><br/>
		이메일<br/>
		<input type="text" name="email" /><br/><br/>
		비고<br/>
		<input type="text" name="note" /><br/><br/>
		<button>연락처저장</button>
		<button type="reset">다시작성하기</button>
		<input type="button" value="목록돌아가기" onclick="location.href='contactListPage.do'" />
	</form>
</body>
</html>