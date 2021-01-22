<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<script type="text/javascript">
		function fn_emailAuthConfirm(f) {
			let authKey = '${authKey}';
			let userKey = f.userKey.value;
			
			if(authKey != userKey) {
				alert('잘못된 인증코드 입니다.');
			} else {
				alert('인증되었습니다. 게시판으로 이동합니다.')
				location.href = 'boardListPage.do';
			}
		}
	</script>
</head>
<body>
	
	<form>
		여기에 인증코드를 입력하세요<br/><br/>
		<input type="text" name="userKey" />
		<input type="button" value="인증하기" onclick="fn_emailAuthConfirm(this.form)" />
	</form>
	
</body>
</html>