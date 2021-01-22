<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 70px;
	}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
	%>
	<h3>연락처를 입력하세요.</h3>
	<form action="<%=application.getContextPath()%>/quiz/q1_C.jsp" method="post">
		<label for="addr">주소</label>
		<input type="text" id="addr" name="addr" /><br/>
		<label for="phone">전화번호</label>
		<input type="text" id="phone" name="phone" /><br/>
		<label for="email">이메일</label>
		<input type="text" id="email" name="email" /><br/>
		<input type="hidden" value="<%=id%>" name="id" />
		<input type="hidden" value="<%=pw%>" name="pw" />
		<input type="hidden" value="<%=name%>" name="name" />
		<br/><br/>
		<button>확인</button>
	</form>
</body>
</html>