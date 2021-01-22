<%@page import="java.net.URLDecoder"%>
<%@page import="com.koreait.mybatis3.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<style type="text/css">
		img {
			width: 40%;
		}
	</style>
	<script type="text/javascript">
		function fn_boardDelete(f) {
			if(confirm('삭제할까요?')) {
				f.action = 'boardDelete.do';
				f.submit();
			}
		}
	</script>
</head>
<body>
	<form method="post">
		작성자<br/>
		<input type="text" name="writer" value="${boardDto.writer}" readonly="readonly" /><br/><br/>
		제목<br/>
		<input type="text" name="title" value="${boardDto.title}" /><br/><br/>
		내용<br/>
		<input type="text" name="content" value="${boardDto.content}" /><br/><br/>
		첨부이미지 <a href="download.do?filename=${boardDto.filename}">첨부파일 다운로드</a>
		<input type="hidden" name="no" value="${boardDto.no}" />
		<input type="hidden" name="filename" value="${boardDto.filename}" />
		<input type="button" value="삭제하기" onclick="fn_boardDelete(this.form)" /><br/>
		<img alt="${boardDto.filename}" src="resources/storage/${boardDto.filename}" /><br/><br/>
		<input type="button" value="목록으로 돌아가기" onclick="location.href='boardListPage.do'" />
	</form>
</body>
</html>