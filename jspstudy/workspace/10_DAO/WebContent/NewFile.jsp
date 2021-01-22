<%@page import="java.sql.Connection"%>
<%@page import="dao.RedDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RedDao redDao = RedDao.getInstance();
	Connection con = redDao.getConnection();
	redDao.close(con, null, null);
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