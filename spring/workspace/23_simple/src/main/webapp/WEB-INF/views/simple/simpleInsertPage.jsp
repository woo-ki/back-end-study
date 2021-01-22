<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form action="simpleInsert.do" method="post">
		작성자<br/>
		<input type="text" name="writer" /><br/>
		제목<br/>
		<input type="text" name="title" /><br/>
		내용<br/>
		<textarea rows="5" cols="40" name="content"></textarea><br/><br/>
		<button>작성하기</button>
	</form>
	
</body>
</html>