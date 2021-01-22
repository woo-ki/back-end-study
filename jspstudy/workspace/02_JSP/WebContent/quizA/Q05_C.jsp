<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--나는 에러페이지 --%>
<%@ page isErrorPage="true" %>

<script type="text/javascript">
	alert('결과는 정수만 허용됩니다. 다시 시도하세요.');
	location.href='<%=application.getContextPath()%>/quizA/Q05_A.jsp';
</script>