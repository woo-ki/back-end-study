<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.i {
		display: inline-block;
		width: 70px;
	}
	#birth1, #birth2, #birth3 {
		width: 35px;
	}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
	%>
	<h3>추가정보를 입력하세요.</h3>
	<form action="<%=application.getContextPath()%>/quiz/q1_D.jsp" method="post">
		<label for="birth1" class="i">생년월일</label>
		<input type="text" id="birth1" name="birth1" />년
		<input type="text" id="birth2" name="birth2" />월
		<input type="text" id="birth3" name="birth3" />일
		<br/>
		<label class="i">결혼여부</label>
		<input type="radio" id="n" name="married" value="미혼"/>
		<label for="n">미혼</label>
		<input type="radio" id="y" name="married" value="기혼"/>
		<label for="y">기혼</label><br/>
		<label for="job" class="i">직업</label>
		<select name="job" id="job">
			<option value="developer">개발자</option>
			<option value="scientist">과학자</option>
			<option value="teacher">선생님</option>
		</select>
		<input type="hidden" value="<%=id%>" name="id" />
		<input type="hidden" value="<%=pw%>" name="pw" />
		<input type="hidden" value="<%=name%>" name="name" />
		<input type="hidden" value="<%=addr%>" name="addr" /><br/>
		<input type="hidden" value="<%=phone%>" name="phone" /><br/>
		<input type="hidden" value="<%=email%>" name="email" /><br/>
		<br/><br/>
		<button>확인</button>
	</form>
</body>
</html>