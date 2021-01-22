<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="resources/css/member.css" />
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="resources/js/member.js"></script>
	<script>
		/*
			REST : URI + HTTP Method
					URI			Method
			목록	member		GET
			보기	member/{no}	GET
			삽입	member		POST
			수정	member		PUT
			삭제	member/{no}	DELETE
		*/
		$(document).ready(function() {
			memberList();
			memberView();
			memberInsert();
			memberUpdate();
			memberDelete();
			init();
		});
	</script>
</head>
<body>
	<div class="wrap">
		<div class="left">
			<!-- 등록/수정/보기 페이지 -->
			아이디<br/>
			<input type="text" name="id" /><br/><br/>
			이름<br/>
			<input type="text" name="name" /><br/><br/>
			성별<br/>
			<label><input type="radio" name="gender" value="남" />남자</label>
			<label><input type="radio" name="gender" value="여" />여자</label>
			<label><input type="radio" name="gender" value="unknown" checked="checked" />선택안함</label><br/><br/>
			주소<br/>
			<select name="address">
				<option value="">지역 선택</option>
				<option value="서울">서울</option>
				<option value="인천">인천</option>
				<option value="부산">부산</option>
				<option value="제주">제주</option>
				<option value="강원">강원</option>
			</select><br/><br/>
			<input type="hidden" name="no" id="uniqueNo" />
			<input type="button" value="등록" id="btnInsert" />
			<input type="button" value="수정" id="btnUpdate" />
			<input type="button" value="초기화" id="btnInit" />
		</div>
		<div class="right">
			<!-- 목록/삭제 페이지 -->
			<h3>회원 목록</h3>
			<table>
				<thead>
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>성별</th>
						<th>주소</th>
						<th colspan="2">비고</th>
					</tr>
				</thead>
				<tbody id="memberList"></tbody>
			</table>
		</div>
	</div>
</body>
</html>