<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String filename = id + ".txt";
		String realPath = application.getRealPath("quiz/" + filename);
		
		boolean isSuccess = false;
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(realPath));
			bw.write("가입 아이디: " + id + "\n");
			bw.write("가입 비밀번호: " + pw + "\n");
			bw.write("가입 성명: " + name + "\n");
			isSuccess = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {bw.close();}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	%>
	<h1>가입되었습니다.</h1>
	<h3>가입내용</h3>
	<br/>
	가입 아이디: <%=id%><br/>
	가입 비밀번호: <%=pw%><br/>
	가입 성명: <%=name%><br/><br/>
	<input type="button" value="탈퇴" onclick="fn_delete()" />
	<script type="text/javascript">
		function fn_delete() {
			<% 
				File f = new File(realPath);
				if(f.exists()) {
					if(f.delete()) { %>
						alert('탈퇴되었습니다.');
						location.href="<%=request.getContextPath()%>/quiz/Q06_A.jsp"
			<%		} else { %>
						alert('탈퇴 실패하였습니다.');
			<%		}
				} else { %>
					alert('일치하는 아이디가 없습니다.')
			<%	}
			%>
		}
	</script>
</body>
</html>