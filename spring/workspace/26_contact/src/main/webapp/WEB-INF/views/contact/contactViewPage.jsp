<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form method="post">
		이름<br/>
		<input type="text" name="name" value="${contactDto.name}" /><br/><br/>
		전화<br/>
		<input type="text" name="phone" value="${contactDto.phone}" /><br/><br/>
		주소<br/>
		<input type="text" name="address" value="${contactDto.address}" /><br/><br/>
		이메일<br/>
		<input type="text" name="email" value="${contactDto.email}" /><br/><br/>
		비고<br/>
		<input type="text" name="note" value="${contactDto.note}" /><br/><br/>
		<input type="hidden" name="no" value="${contactDto.no}" />
		<input type="button" value="수정하기" onclick="fn_contactUpdate(this.form)" />
		<button type="reset">다시작성하기</button>
		<input type="button" value="목록돌아가기" onclick="location.href='contactListPage.do'" />
		<input type="button" value="삭제하기" onclick="fn_contactDelete(this.form)" />
	</form>
	<script>
		function fn_contactUpdate(f) {
			f.action = 'contactUpdate.do';
			f.submit();
		}
		function fn_contactDelete(f) {
			if(confirm('정말 삭제할까요?')) {
				f.action = 'contactDelete.do';
				f.submit();
			}
		}
	</script>
</body>
</html>