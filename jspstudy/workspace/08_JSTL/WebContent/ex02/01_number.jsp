<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<c:set var="n" value="123456789.123456789" />
	
	디폴트 패턴: <fmt:formatNumber value="${n}" /><br/>
	쉼표(,) 처리: <fmt:formatNumber value="${n}" groupingUsed="true" /><br/>
	쉼표(,) 처리: <fmt:formatNumber value="${n}" groupingUsed="false" /><br/>
	
	쉼표(,)O + 정수: <fmt:formatNumber value="${n}" pattern="#,##0" /><br/>
	쉼표(,)O + 소수1자리: <fmt:formatNumber value="${n}" pattern="#,##0.0" /><br/>
	쉼표(,)O + 소수2자리: <fmt:formatNumber value="${n}" pattern="#,##0.00" /><br/>

	쉼표(,)X + 정수: <fmt:formatNumber value="${n}" pattern="0" /><br/>
	쉼표(,)X + 소수1자리: <fmt:formatNumber value="${n}" pattern="0.0" /><br/>
	쉼표(,)X + 소수2자리: <fmt:formatNumber value="${n}" pattern="0.00" /><br/>
	
	퍼센트(%): <fmt:formatNumber value="${n}" type="percent" /><br/>
	
	통화(원화): <fmt:formatNumber value="${n}" type="currency" currencySymbol="₩" /><br/>
	통화(달러): <fmt:formatNumber value="${n}" type="currency" currencySymbol="$" /><br/>
</body>
</html>