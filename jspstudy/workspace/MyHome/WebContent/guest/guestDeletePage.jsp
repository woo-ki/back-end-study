<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/header.jsp">
	<jsp:param value="방명록" name="title"/>
</jsp:include>


<script>
	function fn_guestDelete(f) {
		if (f.gPw.value == '') {
			alert('삭제비밀번호를 입력하세요.');
			return;
		} else if (f.gPw.value != '${param.gPw}') {
			alert('삭제비밀번호를 확인하세요.');
			return;
		}
		if(confirm('방명록을 삭제할까요?')) {
			f.action = '/MyHome/guestDelete.guest';
			f.submit();
		} else {
			return;
		}
	}
</script>
<form method="post">
	삭제 비밀번호를 입력하세요.<br/>
	<input type="password" name="gPw" /><br/><br/>
	<input type="hidden" value="${param.gNo}" name="gNo" />
	<input type="hidden" value="${param.gFilename}" name="gFilename" />
	<input type="button" value="삭제하기" onclick="fn_guestDelete(this.form)" />
	<input type="button" value="방명록목록으로이동하기" onclick="location.href='/MyHome/guestListPage.guest'" />
</form>

<%@ include file="../template/footer.jsp" %>