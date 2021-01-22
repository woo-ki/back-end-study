<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h3>${simpleDto.no}번 게시글</h3>
	작성자<br/>
	${simpleDto.writer}<br/><br/>
	작성일<br/>
	${simpleDto.regDate}<br/><br/>
	제목<br/>
	${simpleDto.title}<br/><br/>
	내용<br/>
	<pre>${simpleDto.content}</pre><br/><br/>
	
	<form method="post">
		<input type="hidden" name="no" value="${simpleDto.no}" />
		<input type="hidden" name="writer" value="${simpleDto.writer}" />
		<input type="hidden" name="title" value="${simpleDto.title}" />
		<input type="hidden" name="content" value="${simpleDto.content}" />
		<input type="hidden" name="regDate" value="${simpleDto.regDate}" />
		<input type="button" value="수정하기" onclick="fn_simpleUpdatePage(this.form)" />
		<input type="button" value="삭제하기" onclick="fn_simpleDelete(this.form)" />
		<input type="button" value="목록으로돌아가기" onclick="location.href='simpleList.do'" />
	</form>
	<script>
		function fn_simpleUpdatePage(f) {
			f.action = 'simpleUpdatePage.do';
			f.submit();
		}
		function fn_simpleDelete(f) {
			if(confirm('삭제하시겠습니까?')) {
				f.action = 'simpleDelete.do';
				f.submit();
			}
		}
	</script>
</body>
</html>