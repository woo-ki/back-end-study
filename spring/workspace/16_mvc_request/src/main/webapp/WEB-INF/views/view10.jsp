<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<%-- request에 포함된 파라미터(controller로 전달한 값) --%>
	<ul>
		<li>${param.name}</li>
		<li>${param.age}</li>
	</ul>
	<%-- model이 저장한 속성(controller에서 전달된 값) --%>
	<ul>
		<li>${personDto.name}</li>
		<li>${personDto.age}</li>
	</ul>
</body>
</html>