<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="resources/css/common.css" />
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이미지</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="boardDto" items="${list}">
					<tr>
						<td>${boardDto.no}</td>
						<td>
							<img alt="${boardDto.filename}" src="resources/storage/${boardDto.filename}" />
						</td>
						<td>${boardDto.writer}</td>
						<td>
							<a href="boardViewPage.do?no=${boardDto.no}">
								${boardDto.title}
							</a>
						</td>
						<td>${boardDto.regDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<a href="boardInsertPage.do">새 글 작성하기</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>