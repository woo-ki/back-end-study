<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Q02_B.jsp">
		<h3>일반 forEach 연습</h3>
		아래에 크기를 입력하면 폰트 크기를 확인할 수 있습니다.<br/><br/>
		최소 크기<input type="number" min="1" max="7" name="min" /><br/>
		최대 크기<input type="number" min="1" max="7" name="max" /><br/>
		<br/>
		<h3>향상 forEach 연습</h3>
		<input type="checkbox" name="foods" value="불고기" />불고기
		<input type="checkbox" name="foods" value="닭갈비" />닭갈비
		<input type="checkbox" name="foods" value="순대국" />순대국
		<input type="checkbox" name="foods" value="자장면" />자장면
		<input type="checkbox" name="foods" value="해장국" />해장국<br/><br/>
		<input type="submit" value="전송" />
		<input type="reset" value="취소" />
	</form>
</body>
</html>