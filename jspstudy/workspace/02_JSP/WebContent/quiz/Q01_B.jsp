<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String site = request.getParameter("sites");
	response.sendRedirect(site);
%>
<%-- <script type="text/javascript">
	location.href = '<%=site%>';
</script> --%>