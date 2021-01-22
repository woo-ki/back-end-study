<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/style/red.css">
<script type="text/javascript">
	function fn_pwUpdate(f) {
		var no = '${param.no}';
		var pw = '${param.pw}';
		
		if(f.pastPw.value != pw) {
			alert('기존 비밀번호가 일치하지 않습니다.');
			f.pastPw.focus();
			return;
		} else if(pw == f.pw.value) {
			alert('기존 비밀번호와 변경할 비밀번호가 같습니다.');
			f.pw.focus();
			return;
		} else if(f.pw.value == '') {
			alert('변경할 비밀번호를 입력하세요.');
			f.pw.focus();
			return;
		} else if(f.pw.value != f.pw2.value) {
			alert('새 비밀번호와 비밀번호 확인이 일치하지 않습니다.')
			f.pw2.focus()
			return;
		} else {
			f.action = '/10_DAO/red/pwUpdate.jsp'
			f.submit();
		}
	}
</script>
</head>
<body>
	<div class="wrap">
		<form method="post">
			<table>
				<thead>
					<tr>
						<td colspan="2">${param.id}님의 비밀번를 수정합니다.</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>기존 비밀번호</td>
						<td><input type="password" name="pastPw" /></td>
					</tr>
					<tr>
						<td>신규 비밀번호</td>
						<td><input type="password" name="pw" /></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="pw2" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="비밀번호수정하기" onclick="fn_pwUpdate(this.form)" />
							<input type="button" value="수정취소하기" onclick="history.go(-2)" />
							<input type="button" value="목록으로이동하기" onclick="location.href='/10_DAO/red/listPage.jsp'" />
						</td>
					</tr>
				</tfoot>
			</table>
			<%-- 회원정보수정, 이동시 넘겨줄 파라미터 --%>
			<input type="hidden" name="no" value="${param.no}" />
		</form>
	</div>
</body>
</html>