<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/header.jsp">
	<jsp:param value="게시판목록" name="title"/>
</jsp:include>

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

<script>
	function fn_queryBoardListPage(f) {
		if(f.query.value == '') {
			alert('검색어를 입력하세요.');
			f.query.focus();
			return;
		}
		f.action = '/MyHome/queryBoardListPage.board';
		f.submit();
	}
	function fn_boardInsertPage(f) {
		if(${loginDto eq null}) {
			alert('로그인을 해주세요.');
			location.href = '/MyHome/loginPage.member';
			return;
		}
		f.action = '/MyHome/boardInsertPage.board';
		f.submit();
	}
	function fn_myBoardListPage(f) {
		if(${loginDto eq null}) {
			alert('로그인을 해주세요.');
			location.href = '/MyHome/loginPage.member';
			return;
		}
		f.action = '/MyHome/myBoardListPage.board';
		f.submit();
	}
</script>

<%-- 1. 게시판 검색 --%>
<form>
	<select name="column">
		<option value="btitle">제목</option>
		<option value="bcontent">내용</option>
		<option value="mid">작성자</option>
		<option value="both">제목+내용</option>
	</select>
	<input type="text" name="query" />
	<input type="button" value="검색" onclick="fn_queryBoardListPage(this.form)" />
</form>
<br/><br/>

<%-- 2. 게시판 작성(로그인 유저만 보인다.) --%>
<form>
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="mId" value="${loginDto.mId}" />
	<input type="button" value="전체목록보기" onclick="location.href='/MyHome/boardListPage.board'" />
	<c:if test="${loginDto ne null}">
		<input type="button" value="내 게시글 보기" onclick="fn_myBoardListPage(this.form)" />
		<input type="button" value="새 게시글 작성하기" onclick="fn_boardInsertPage(this.form);" />
	</c:if>
</form>
<br/><br/>

<%-- 3. 게시판 목록 --%>
전체 ${totalRecord}개<br/>
<table border="1">
	<thead>
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="5">작성된 게시글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="boardDto" items="${list}" varStatus="k">
					<tr>
						<td>${totalRecord - (page - 1) * recordPerPage - k.index}</td>
						<c:choose>
							<c:when test="${boardDto.bDelete eq 0}">
								<td>
									<a href="/MyHome/boardViewPage.board?bNo=${boardDto.bNo}&page=${page}">
										<!-- 1. 댓글은 댓글 수준(bDepth)만큼 들여쓰기를 한다. -->
										<c:forEach begin="1" end="${boardDto.bDepth}" step="1">
											<i class="fab fa-replyd"></i>
										</c:forEach>
										<!-- 2. 제목을 표시한다. -->
										${boardDto.bTitle}
									</a>
								</td>
								<td>${boardDto.mId}</td>
								<td>${boardDto.bDate}</td>
								<td>${boardDto.bHit}</td>
							</c:when>
							<c:otherwise>
								<td>삭제된 게시글 입니다.</td>
								<td>-</td>
								<td>-</td>
								<td>-</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot class="paging">
		<tr>
			<td colspan="5">${paging}</td>
		</tr>
	</tfoot>
</table>

<%@ include file="../template/footer.jsp" %>