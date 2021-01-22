<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../template/header.jsp">
	<jsp:param value="회원가입" name="title"/>
</jsp:include>

<script>
	var check1 = false;
	var check2 = false;
	var check3 = false;
	var check4 = false;
	
	$(function() {
		fn_idCheck();
		fn_pwCheck();
		fn_pwCheck2();
		fn_emailCheck();
		fn_signUp();
		fn_clear();
	});
	
	function fn_signUp() {
		$('#signUpBtn').click(function() {
			if(check1 && check2 && check3 && check4) {
				$.ajax({
					url: '/MyHome/SignUp',
					type: 'post',
					data: $('#f').serialize(),
					dataType: 'json',
					success: function(responseObj) {
						if(responseObj.result) {
							alert('회원 가입에 성공했습니다.');
							location.href = '/MyHome/loginPage.member';
						} else {
							alert('회원 가입에 실패했습니다.');
						}
					},
					error: function() {alert('실패')}
				});
			} else {
				alert('필수사항을 입력하세요.')
			}
		});
	}
	
	function fn_clear() {
		$('#clearBtn').click(function() {
			$('input[type="text"], input[type="password"]').each(function() {
				$(this).val('');
			});
			$('span[id]').each(function() {
				$(this).text('');
			});
			$('#mId').focus();;
		});
	}
	
	function fn_idCheck() {
		// 아이디: 5~20자 사이의 소문자나 숫자를 사용하고, 반드시 첫 글자는 소문자이다.
		var regId = /^[a-z][a-z0-9]{4,19}$/;
		$('#mId').blur(function() {
			if(regId.test($('#mId').val())) {	// 정규식 패턴을 만족한다.
				$.ajax({
					url: '/MyHome/IdCheck',
					type: 'post',
					data: 'mId=' + $('#mId').val(),
					dataType: 'json',
					success: function(responseObj) {
						if(responseObj.result) {
							$('#idCheckResult').text('사용가능한 아이디입니다.').css('color','green');
							check1 = true;
						} else {
							$('#idCheckResult').text('이미 가입된 아이디입니다.').css('color','red');
							check1 = false;
						}
					},
					error: function() {alert('실패')}
				});
			} else {	// 정규식 패턴을 만족하지 않으면
				$('#idCheckResult').text('5~20자 사이의 소문자나 숫자를 사용, 소문자로 시작').css('color','red');
				check1 = false;
			}
		});
	}
	
	function fn_emailCheck() {
		$('#mEmail').blur(function() {
			var regEmail = /^[a-z][a-z0-9-_]+@[a-zA-Z0-9]{3,}(\.[a-zA-Z]{2,6}){1,2}$/;
			if(regEmail.test($('#mEmail').val())) {
				$.ajax({
					url: '/MyHome/EmailCheck',
					type: 'post',
					data: 'mEmail=' + $('#mEmail').val(),
					dataType: 'json',
					success: function(responseObj) {
						if(responseObj.result) {
							$('#emailCheckResult').text('사용가능한 이메일입니다.').css('color','green');
							check2 = true;
						} else {
							$('#emailCheckResult').text('이미 사용중인 이메일입니다.').css('color','red');
							check2 = false;
						}
					},
					error: function() {alert('실패')}
				});
			} else {
				$('#emailCheckResult').text('이메일 형태로 입력해주세요.').css('color','red');
				check2 = false;
			}
		});
	}
	
	function fn_pwCheck() {
		$('#mPw').blur(function() {
			var regPw = /^[A-Za-z0-9!@#%&_]{4,20}$/;
			if(regPw.test($('#mPw').val())) {
				$('#pwCheckResult').text('사용할 수 있는 비밀번호입니다.').css('color','green');
				check3 = true;
			} else {
				$('#pwCheckResult').text('4 ~ 20 사이의 대문자,소문자,숫자,특수문자(!@#%&_)를 사용해야 합니다.').css('color','red');
				check3 = false;
			}
		});
	}
	
	function fn_pwCheck2() {
		$('#mPw2').blur(function() {
			if($('#mPw2').val() == $('#mPw').val()) {
				$('#pwConfirmResult').text('비밀번호가 일치합니다.').css('color','green');
				check4 = true;
			} else {
				$('#pwConfirmResult').text('비밀번호가 일치하지 않습니다.').css('color','red');
				check4 = false;
			}
		})
	}
</script>

<form method="post" id="f">
	<label for="mId">아이디*</label><br/>
	<input type="text" id="mId" name="mId" />
	<span id="idCheckResult"></span><br/><br/>
	
	<label for="mPw">비밀번호*</label><br/>
	<input type="password" id="mPw" name="mPw" />
	<span id="pwCheckResult"></span><br/><br/>
	
	<label for="mPw2">비밀번호 확인*</label><br/>
	<input type="password" id="mPw2" name="mPw2" />
	<span id="pwConfirmResult"></span><br/><br/>

	<label for="mName">성명</label><br/>
	<input type="text" id="mName" name="mName" /><br/><br/>

	<label for="mEmail">이메일*</label><br/>
	<input type="text" id="mEmail" name="mEmail" />
	<span id="emailCheckResult"></span><br/><br/>

	<label for="mPhone">전화번호</label><br/>
	<input type="text" id="mPhone" name="mPhone" /><br/><br/>

	<label for="mAddress">주소</label><br/>
	<input type="text" id="mAddress" name="mAddress" /><br/><br/>
	
	<input type="button" value="가입하기" id="signUpBtn" />
	<input type="button" value="입력취소" id="clearBtn" />
</form>

<%@ include file="../template/footer.jsp" %>