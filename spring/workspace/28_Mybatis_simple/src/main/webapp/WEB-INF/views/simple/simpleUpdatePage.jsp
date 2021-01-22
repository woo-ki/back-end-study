<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form action="simpleUpdate.do" method="post">
		<h3>${simpleDto.no}번 게시글 수정하기</h3>
		작성자<br/>
		<input type="text" name="writer" value="${simpleDto.writer}" /><br/>
		제목<br/>
		<input type="text" name="title" value="${simpleDto.title}" /><br/>
		내용<br/>
		<input type="text" name="content" value="${simpleDto.content}" /><br/>
		<input type="hidden" name="no" value="${simpleDto.no}" />
		<input type="hidden" name="page" value="${page}" />
		<button>수정하기</button>
	</form>
</body>
</html>