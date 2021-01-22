<%@page import="dto.RedDto"%>
<%@page import="dao.RedDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	// DB에서 RED 테이블 전체 목록을 가져온다.
	ArrayList<RedDto> list = RedDao.getInstance().list();
	// EL 처리를 위해서
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("size", list.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/style/red.css">
<script src="https://kit.fontawesome.com/07b67006ce.js"></script>
<style type="text/css">
	a {
		color: black;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h3>
			현재 등록 인원은 ${size}명 입니다.
			<input type="button" value="메인페이지 돌아가기" onclick="location.href='/10_DAO'">
		</h3><br/><br/>
		<input style="text-align: left" type="button" value="삽입하기" onclick="location.href='/10_DAO/red/insertPage.jsp'" />
		<table>
			<thead>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>이름</th>
					<th>나이</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>삭제</th>
				<tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="7">명단 없음</td>
					</tr>
				</c:if>
				<c:if test="${not empty list}">
					<c:forEach var="redDto" items="${list}">
						<tr>
							<td>${redDto.no}</td>
							<td><a href="/10_DAO/red/viewPage.jsp?no=${redDto.no}">${redDto.id}</a></td>
							<td>${redDto.name}</td>
							<td>${redDto.age}</td>
							<td>${redDto.email}</td>
							<td>${redDto.regDate}</td>
							<td>
								<form method="post">
									<input type="hidden" name="no" value="${redDto.no}" />
									<button onclick="fn_delete(this.form)">
										<i class="fas fa-trash"></i>
									</button>
								</form>
								<script type="text/javascript">
									function fn_delete(f) {
										if(confirm('삭제할까요?')) {
											f.action = '/10_DAO/red/delete.jsp';
											f.submit();
										}
									}
								</script>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>