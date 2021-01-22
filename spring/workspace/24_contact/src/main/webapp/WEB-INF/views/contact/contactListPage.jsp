<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>전화</td>
				<td>주소</td>
				<td>이메일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="contactDto" items="${list}">
					<tr>
						<td>${contactDto.no}</td>
						<td>
							<a href="contactViewPage.do?no=${contactDto.no}">
								${contactDto.name}
							</a>
						</td>
						<td>${contactDto.phone}</td>
						<td>${contactDto.address}</td>
						<td>${contactDto.email}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<a href="contactInsertPage.do">신규 연락처 등록하기</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>