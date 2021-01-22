<%@page import="dao.RedDao"%>
<%@page import="dto.RedDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int no = Integer.parseInt(request.getParameter("no"));
	
	
	int result = RedDao.getInstance().delete(no);
	
	out.println("<script>");
	if(result == 1) {
		out.println("alert('회원 정보가 삭제되었습니다.')");
	} else {
		out.println("alert('회원 정보가 삭제되지 않았습니다. 다시 시도하세요.')");
	}
	out.println("location.href='/10_DAO/red/listPage.jsp'");
	out.println("</script>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>