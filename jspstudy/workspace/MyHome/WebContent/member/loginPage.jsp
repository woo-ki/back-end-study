<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 머리글 포함(파라미터title)가 있으므로 동적 페이지 포함 --%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="로그인" name="title"/>
</jsp:include>

	<script type="text/javascript">
		function fn_login(f) {
			if(f.mId.value == '' || f.mPw.value == '') {
				alert('아이디와 비밀번호를 모두 입력하세요');
				return;
			}
			f.action = '/MyHome/login.member';
			f.submit();
		}
	</script>
	<div class="login-box">
		<form method="post">
			<label for="mId">아이디</label><br/>
			<input type="text" name="mId" id="mId" autofocus /><br/><br/>
			<label for="mPw">비밀번호</label><br/>
			<input type="password" name="mPw" id="mPw" /><br/><br/>
			<input type="button" value="로그인" onclick="fn_login(this.form)" /><br/>
			<a href="/MyHome/findIdPage.member">아이디 찾기</a>
			<a href="/MyHome/findPwPage.member">비밀번호 찾기</a>
		</form>
	</div>

<%-- 바닥글 포함(파라미터가 없으므로 정적 페이지 포함) --%>
<%@ include file="../template/footer.jsp" %>