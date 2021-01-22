<%@page import="dao.RedDao"%>
<%@page import="dto.RedDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String pw = request.getParameter("pw");
	int no = Integer.parseInt(request.getParameter("no"));
	
	RedDto redDto = new RedDto();
	redDto.setNo(no);
	redDto.setPw(pw);
	
	int result = RedDao.getInstance().pwUpdate(redDto);
	
	out.println("<script>");
	if(result == 1) {
		out.println("alert('비밀번호가 수정되었습니다.')");
		out.println("location.href='/10_DAO/red/viewPage.jsp?no=" + no + "'");
	} else {
		out.println("alert('비밀번호가 수정되지 않았습니다. 다시 시도하세요.')");
		out.println("history.back()");
	}
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