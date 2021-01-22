<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_send() {
		var f = document.forms.f;
		if(f.title.value == '') {
			alert('제목은 필수사항 입니다.');
			f.title.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="/16_MYBATIS/insert.lime" method="post" name="f" onsubmit="return fn_send()">
		작성자<br/>
		<input type="text" name="writer" /><br/><br/>
		제목<br/>
		<input type="text" name="title" /><br/><br/>
		내용<br/>
		<textarea rows="5" cols="50" name="content"></textarea><br/><br/>
		
		<button>삽입하기</button>
		<input type="reset" value="다시작성하기" />
		<input type="button" value="목록으로이동" onclick="location.href='/16_MYBATIS/listPage.lime'" />
	</form>
</body>
</html>