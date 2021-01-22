<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>view05.jsp</h3>
	<h3>no param</h3>
	<ul>
		<li>${personDto.name}</li>
		<li>${personDto.age}</li>
		<li>${hi}</li>
	</ul>
	<h3>param</h3>
	<ul>
		<li>${param.name}</li>
		<li>${param.age}</li>
		<li>${param.hi}</li>
	</ul>
</body>
</html>