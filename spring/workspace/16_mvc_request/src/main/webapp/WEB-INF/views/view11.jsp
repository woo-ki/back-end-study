<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h3>view11.jsp</h3>
	<ul>
		<li>제목: ${boardDto.title}</li>
		<li>조회수: ${boardDto.hit}</li>
		<li>작성일: ${date}</li>
	</ul>
</body>
</html>