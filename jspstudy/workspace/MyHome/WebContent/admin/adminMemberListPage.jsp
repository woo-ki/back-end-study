<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/header.jsp">
	<jsp:param value="회원리스트" name="title"/>
</jsp:include>

<style>
	tfoot.paging {
		color: silver;
		text-align: center;
	}
	
	tfoot a {
		text-decoration: none;
		color: silver;
	}
	
	tfoot a:hover {
		color: limegreen;
	}
	
	span.disable {
		font-weight: 900;
		color: limegreen;
	}
</style>

<script>
	onload = function() {
		// 1. 전체 선택이 개별 선택을 조정한다.
		var checkAll = document.getElementById('checkAll');
		checkAll.addEventListener('click', function() {
			var chkList = document.getElementsByName('chk');
			for(var i = 0; i < chkList.length; i++) {
				chkList[i].checked = checkAll.checked;
			}
		});
		
		// 2, 개별 선택이 전체 선택을 조정한다.
		var chkList = document.getElementsByName('chk');
		for(var i = 0; i < chkList.length; i++) {
			chkList[i].addEventListener('click', function() {
				var checkAll = document.getElementById('checkAll');
				for(var j = 0; j < chkList.length; j++) {
					if(chkList[j].checked == false) {
						checkAll.checked = false;
						return;
					}
				}
				checkAll.checked = true;
			});
		}
	}
	
	function fn_adminMemberDelete(f) {
		if(confirm(f.mId.value + '회원을 삭제할까요?')) {
			f.action = '/MyHome/adminMemberDelete.admin';
			f.submit();
		}
	}
	
	function fn_adminSelectMemberDelte() {
		var chkList = $('[name="chk"]:checked');
		var target = '';
		for(var i = 0; i < chkList.length; i++) {
			target = (target + chkList.eq(i).val() + ',');
		}
		if(confirm('총' + $('[name="chk"]:checked').length + '명을 탈퇴시키겠습니까?')) {
			location.href = '/MyHome/adminSelectMemberDelete.admin?page=${page}&target=' + target;
		}
	}
	
	function fn_adminMemberUpdate(f) {
		f.action = '/MyHome/adminMemberUpdate.admin';
		f.submit();
	}
</script>

<%-- 1. 회원 검색 기능 --%>

<%-- 2. 관리자 버튼 --%>
<input type="button" value="신규회원추가" onclick="" />
<input type="button" value="선택회원삭제" onclick="fn_adminSelectMemberDelte()" /><br /><br />


<%-- 3. 회원 목록 --%>
전체 회원 ${totalMemeberCount}명<br/>
<table border="1">
	<thead>
		<tr>
			<td><label>전체 <input type="checkbox" id="checkAll" style="display: none"/></label></td>
			<td>순번</td>
			<td>회원번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>성명</td>
			<td>연락처</td>
			<td>이메일</td>
			<td>주소</td>
			<td>회원가입일</td>
			<td>비고</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="memberDto" items="${list}" varStatus="k">
			<form method="post">
				<tr>
					<td><input type="checkbox" name="chk" value="${memberDto.mNo}" /></td>
					<td>${totalMemeberCount - (page - 1) * recordPerPage - k.index}</td>
					<td>${memberDto.mNo}</td>
					<td>${memberDto.mId}</td>
					<td><input type="password" name="mPw" /></td>
					<td><input type="text" name="mName" value="${memberDto.mName}" /></td>
					<td><input type="text" name="mPhone" value="${memberDto.mPhone}" /></td>
					<td><input type="text" name="mEmail" value="${memberDto.mEmail}" /></td>
					<td><input type="text" name="mAddress" value="${memberDto.mAddress}" /></td>
					<td>${memberDto.mRegDate}</td>
					<td>
						<input type="hidden" name="mNo" value="${memberDto.mNo}"/>
						<input type="hidden" name="mId" value="${memberDto.mId}" />
						<input type="hidden" name="page" value="${page}" />
						<input type="button" value="수정" onclick="fn_adminMemberUpdate(this.form)" />
						<input type="button" value="비밀번호수정" onclick="" />
						<input type="button" value="삭제" onclick="fn_adminMemberDelete(this.form)" />
					</td>
				</tr>
			</form>
		</c:forEach>
	</tbody>
	<tfoot class="paging">
		<tr>
			<td colspan="11">${paging}</td>
		</tr>
	</tfoot>
</table>

<%@ include file="../template/footer.jsp" %>