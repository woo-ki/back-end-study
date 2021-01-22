<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String age = request.getParameter("age");
	%>
	<script type="text/javascript">
		alert(<%=age%> + '살은 주류 구매가 불가능합니다.');
		history.go(-1);
	</script>
<%-- 	<h1>미성년자</h1>
	당신의 나이는 <%=age%>살 이므로 주류 구매가 불가능합니다.<br/>
	<a href="Q02_A.jsp">처음으로 이동</a> --%>
</body>
</html>