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
		<h3>${simpleDto.no}번 게시글</h3>
		작성자<br/>
		<input type="text" name="writer" value="${simpleDto.writer}" /><br/><br/>
		작성일<br/>
		${simpleDto.regDate}<br/><br/>
		제목<br/>
		<input type="text" name="title" value="${simpleDto.title}" /><br/><br/>
		내용<br/>
		<textarea rows="5" cols="40" name="content">${simpleDto.content}</textarea><br/><br/>
		<input type="hidden" name="no" value="${simpleDto.no}" />
		<button>수정하기</button>
		<input type="reset" value="다시작성하기" />
	</form>
</body>
</html>