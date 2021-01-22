<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/header.jsp">
	<jsp:param value="BBS삭제확인" name="title"/>
</jsp:include>

<script type="text/javascript">
	function fn_bbsDelete(f) {
		if('${bbsDto.bbs_pw}' != f.bbs_pw.value) {
			alert('비밀번호가 일치하지 않습니다.');
			f.bbs_pw.focus();
			return;
		}
		if(confirm('삭제할까요?')) {
			f.action = '/MyHome/bbsDelete.bbs';
			f.submit();
		}
	}
</script>

<form method="post">
	삭제비밀번호<br/>
	<input type="password" name="bbs_pw" /><br/><br/>
	
	<input type="hidden" name="page" value="${param.page}" />
	<input type="button" value="삭제하기" onclick="fn_bbsDelete(this.form)" />
</form>

<%@ include file="../template/footer.jsp" %>