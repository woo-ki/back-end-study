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
	<!-- for(int i = 0; i < 10; i++ -->
	<c:forEach var="i" begin="0" end="9" step="1">
		${i}<br/>
	</c:forEach>
	<form>
		<select>
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${i}월">${i}월</option>
			</c:forEach>
		</select>
	</form>
</body>
</html>