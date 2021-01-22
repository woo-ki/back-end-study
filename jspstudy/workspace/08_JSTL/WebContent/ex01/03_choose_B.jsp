<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="average" value="${(param.kor + param.eng + param.mat) div 3 }" />
	<c:choose>
		<c:when test="${average ge 90}">
			<c:set var="grade" value="A" />
		</c:when>
		<c:when test="${average ge 80}">
			<c:set var="grade" value="B" />
		</c:when>
		<c:when test="${average ge 70}">
			<c:set var="grade" value="C" />
		</c:when>
		<c:when test="${average ge 60}">
			<c:set var="grade" value="D" />
		</c:when>
		<c:otherwise>
			<c:set var="grade" value="F"/>
		</c:otherwise>
	</c:choose>
	<h3>평균: ${average }</h3>
	<h3>학점: ${grade }</h3>
</body>
</html>