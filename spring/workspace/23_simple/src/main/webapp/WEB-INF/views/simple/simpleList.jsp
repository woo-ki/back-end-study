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
				<td>제목</td>
				<td>글쓴이</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">작성된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="simpleDto" items="${list}">
					<tr>
						<td>${simpleDto.no}</td>
						<td>
							<a href="simpleViewPage.do?no=${simpleDto.no}">
								${simpleDto.title}
							</a>
						</td>
						<td>${simpleDto.writer}</td>
						<td>${simpleDto.regDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<input type="button" value="새글작성하기" onclick="location.href='simpleInsertPage.do'" />
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>