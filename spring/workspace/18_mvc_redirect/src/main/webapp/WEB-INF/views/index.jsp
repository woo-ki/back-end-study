<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>

	<%-- 
		<form action="v01"> 이 부분은
		MyController의 @RequestMapping(value="v01")과 연결됩니다.
	--%>
	<form action="v01">
		이름<br/>
		<input type="text" name="name" /><br /><br />
		나이<br/>
		<input type="text" name="age" /><br /><br />
		<button>전송</button>
	</form>
	<br />
	<form action="v02">
		이름<br/>
		<input type="text" name="name" /><br /><br />
		나이<br/>
		<input type="text" name="age" /><br /><br />
		<button>전송</button>
	</form>
	<br />
	<form action="v04">
		이름<br/>
		<input type="text" name="name" /><br /><br />
		나이<br/>
		<input type="text" name="age" /><br /><br />
		<button>전송</button>
	</form>
</body>
</html>