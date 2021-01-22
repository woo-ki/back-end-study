<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>하나의 Controller에게 요청하기</h3>
	<input type="button" value="한글인사요청하기" onclick="location.href='/13_MVC/HomeController?cmd=korean'" />
	<input type="button" value="영문인사요청하기" onclick="location.href='/13_MVC/HomeController?cmd=english'" />
	
	<h3>하나의 controller에게 요청하기</h3>
	<form>
		너비 <input type="text" name="width" /><br/>
		높이 <input type="text" name="height" /><br/>
		<input type="button" value="삼각형넓이요청하기" onclick="fn_triangle(this.form)" />
		<input type="button" value="사각형넓이요청하기" onclick="fn_rectangle(this.form)" />
	</form>
	<script type="text/javascript">
		function fn_triangle(f) {
			f.action = "/13_MVC/triangle.do";
			f.submit();
		}
		function fn_rectangle(f) {
			f.action = "/13_MVC/rectangle.do";
			f.submit();
		}
	</script>
	<%-- 
		triangle.do와 rectangle.do는 모두 .do로 끝난다.
		(suffix가 .do이다)
		suffix가 .do 인 모든 요청은 *.do 가 처리할 수 있다.
	 --%>
	 
	<h3>하나의 controller에게 요청하기</h3>
	<input type="button" value="오늘의아침메뉴" onclick="location.href='/13_MVC/morning.meal'" />
	<input type="button" value="오늘의점심메뉴" onclick="location.href='/13_MVC/lunch.meal'" />
	<input type="button" value="오늘의저녁메뉴" onclick="location.href='/13_MVC/evening.meal'" />
</body>
</html>