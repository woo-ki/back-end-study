<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/07b67006ce.js"></script>
<c:if test="${not empty insertResult}">
	<script>
		if('${insertResult}' > 0) {
			alert('저장되었습니다.');
		} else {
			alert('저장에 실패하였습니다.');
		}
	</script>
</c:if>

<c:if test="${not empty deleteResult}">
	<script type="text/javascript">
		if('${deleteResult}' > 0) {
			alert('삭제가 성공하였습니다.');
		} else {
			alert('삭제에 실패하였습니다.');
		}
	</script>
</c:if>
<style>
	tfoot.paging {
		color: silver;
		text-align: center;
	}
	
	tfoot a {
		text-decoration: none;
		color: silver;
	}
	
	tfoot a:hover {
		color: limegreen;
	}
	
	span.disable {
		font-weight: 900;
		color: limegreen;
	}
</style>
</head>
<body>

	<h3>게시글 목록</h3>
	${totalRecord}개 게시글
	<input type="button" value="새글작성하러가기" onclick="location.href='simpleInsertPage.do'" />
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="simpleDto" items="${list}" varStatus="k">
					<tr>
						<td>${totalRecord - ((page - 1) * recordPerPage) - k.index}</td>
						<td>${simpleDto.writer}</td>
						<td>
							<a href="simpleViewPage.do?no=${simpleDto.no}&page=${page}">
								${simpleDto.title}
							</a>
						</td>
						<td>${simpleDto.regDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot class="paging">
			<tr>
				<td colspan="4">
					${paging}
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>