<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	/*  로그인의 성공 실패 여부는 session의 loginDto 존재를 확인하면 된다. */
	if('${loginDto}' != '') {
		alert('${param.mId}님 환영합니다.');
		location.href = '/MyHome/index.member';
	} else {
		alert('존재하지 않는 아이디 또는 비밀번호가 일치하지 않습니다.');
		location.href = '/MyHome/loginPage.member';
	}
</script>