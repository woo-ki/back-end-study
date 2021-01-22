<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="boardInsert.do">
		작성자<br/>
		<input type="text" name="writer" /><br/><br/>
		제목<br/>
		<input type="text" name="title" /><br/><br/>
		내용<br/>
		<input type="text" name="content" /><br/><br/>
		첨부<br/>
		<input type="file" name="files" multiple="multiple" /><br/><br/>
		<button>전송하기</button>
	</form>
</body>
</html>