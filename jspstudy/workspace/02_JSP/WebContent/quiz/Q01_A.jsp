<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_send(f) {
		f.action = '/02_JSP/quiz/Q01_B.jsp';
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<label for="sites">사이트명</label>
		<select name="sites">
		<% 
			String[][] sites = {
				{"https://www.google.com", "구글"},
				{"https://www.naver.com","네이버"},
				{"https://www.daum.net","다음"},
				{"https://www.nate.com","네이트"}
			};
			for(int i = 0; i < sites.length; i++) {
		%>
			<option value="<%=sites[i][0]%>"><%=sites[i][1]%></option>
		<% } %>
		</select>
		<input type="button" value="확인" onclick="fn_send(this.form)" />
	</form>
</body>
</html>