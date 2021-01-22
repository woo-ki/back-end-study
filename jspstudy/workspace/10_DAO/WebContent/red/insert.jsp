<%@page import="dao.RedDao"%>
<%@page import="dto.RedDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 처리
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
	
	// 2. DB로 보낼 DTO생성
	RedDto redDto = new RedDto(id, pw, name, email, Integer.parseInt(age));

	// 3. DB로 DTO보내고 결과 받기(성공, 실패)
	// 해야 할 일 : insert문
	// DB처리는 모두 RedDao 클래스 담당
	RedDao redDao = RedDao.getInstance();
	int result = redDao.insert(redDto);
	
	// 4.insert문의 결과 처리
	// insert문의 반환 값: 실제 insert된 데이터의 개수
	// 성공하면 1, 실패하면 0이 반환
	if(result == 0) {
		out.print("<script>");
		out.print("alert('가입에 실패했습니다. 다시 시도하세요.');");
		out.print("history.back();");
		out.print("</script>");
	} else {
		out.print("<script>");
		out.print("alert('가입되었습니다.');");
		out.print("location.href='/10_DAO/index.jsp';");
		out.print("</script>");
	}
%>