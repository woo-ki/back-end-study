function idCheck(f) {
	var regExp = /^[a-z][a-z0-9]{4,19}$/;
	var id = f.id.value;
	var result = document.getElementById('id-check');
	if(id == '') {
		result.textContent = '필수입력 입니다.'
		result.setAttribute('class', 'id-check-not');
		return false;
	} else {
		if(regExp.test(id)) {
			result.setAttribute('class', 'id-check-ok');
			result.textContent = '사용가능한 아이디 입니다.'
			return true;
		} else {
			result.setAttribute('class', 'id-check-not');
			result.textContent = '사용불가능한 아이디 입니다.'
			return false;
		}
	}
}

function pw1Check(f) {
	var regExp = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#%&_])[A-Za-z0-9!@#%&_]{8,20}$/;
	var pw1 = f.pw1.value;
	var result = document.getElementById('pw1-check');
	if(pw1 == '') {
		result.textContent = '필수입력 입니다.'
		result.setAttribute('class', 'pw1-check-not');
		return false;
	} else {
		if(regExp.test(pw1)) {
			result.setAttribute('class', 'pw1-check-ok');
			result.textContent = '사용가능한 비밀번호 입니다.'
			return true;
		} else {
			result.setAttribute('class', 'pw1-check-not');
			result.textContent = '영문 대소문자, 숫자, 특수문자(!,@,#,%,&,_)를 혼합한 8~20자 사이의 비밀번호'
			return false;
		}
	}
}

function pw2Check(f) {
	var pw1 = f.pw1.value;
	var pw2 = f.pw2.value;
	var result = document.getElementById('pw2-check');
	if(pw1 == '') {
		result.textContent = '필수입력 입니다.'
		result.setAttribute('class', 'pw2-check-not');
		return false;
	} else {
		if(pw1 != '' && pw1 == pw2) {
			result.setAttribute('class', 'pw2-check-ok');
			result.textContent = '비밀번호가 일치합니다..'
			return true;
		} else if(pw1 != '' && pw1 != pw2) {
			result.setAttribute('class', 'pw2-check-not');
			result.textContent = '비밀번호가 일치하지 않습니다.'
			return false;
		}
	}
}

function emailCheck(f) {
	var regExp = /^[a-z][a-z0-9-_]+@[a-zA-Z0-9]{3,}(\.[a-zA-Z]{2,6}){1,2}$/;
	var email = f.email.value;
	var result = document.getElementById('email-check');
	if(email == '') {
		result.textContent = '필수입력 입니다.'
		result.setAttribute('class', 'email-check-not');
		return false;
	} else {
		if(regExp.test(email)) {
			result.setAttribute('class', 'email-check-ok');
			result.textContent = '사용가능한 이메일 입니다.'
			return true;
		} else {
			result.setAttribute('class', 'email-check-not');
			result.textContent = '이메일 형식을 확인하세요.'
			return false;
		}
	}
}

function phone2Check(f) {
	var regExp = /^[0-9]{3,4}$/;
	var phone2 = f.phone2.value;
	var result = document.getElementById('phone-check');
	if(regExp.test(phone2) && phone2.length == 4) {
		f.phone3.focus()
		return true;
	} else if(regExp.test(phone2)) {
		return true;
	} else {
		return false;
	}
}

function personalId(f) {
	var regExp = /^[0-9]{6}$/;
	var p1 = f['personal-id1'].value;
	if(regExp.test(p1) && p1.length == 6) {
		f['personal-id2'].focus();
	}
}

function phone3Check(f) {
	var regExp = /^[0-9]{4}$/;
	var phone3 = f.phone3.value;
	var result = document.getElementById('phone-check');
	if(regExp.test(phone3) && phone2Check(f)) {
		result.setAttribute('class', 'phone-check-ok');
		result.textContent = '사용가능한 전화번호 입니다.'
		return true;
	} else {
		result.setAttribute('class', 'phone-check-not');
		result.textContent = '전화번호 형식을 확인하세요.'
		return false;
	}
}

function fn_personalIdCheck(f) {
	var regExp1 = /^[0-9]{6}$/;
	var regExp2 = /^[0-9]{7}$/;
	var p1 = f['personal-id1'].value;
	var p2 = f['personal-id2'].value;
	var result = document.getElementById('personal-id-check');
	
	if(regExp1.test(p1) && regExp2.test(p2)) {
		fn_personalIdCheck2(f);
	} else {
		result.textContent = "틀린 주민번호 입니다."
		result.setAttribute('class', 'sn-check-not');
		return false;
	}
}

function fn_personalIdCheck2(f) {
	// 주민등록번호 검증 방법
	// 주민등록번호: 801212-123456 7
	//     검증번호: 234567 892345
	
	// 1. 주민등록번호와 검증번호를 1:1로 매칭해서 곱한다. 그 결과를 모두 더한다.(total)
	//    var total = 8*2 + 0*3 + 1*4 + ... + 6*5
	// 2. 주민등록번호 마지막 숫자 = (11 - total % 11) % 10 이면 정상 주민등록번호이다.
	
	var p1 = f['personal-id1'].value;
	var p2 = f['personal-id2'].value;
	var total = 0;
	var result = document.getElementById('personal-id-check');
	
	for(let i = 0; i < p1.length; i++) {
		total += (p1.charAt(i)) * (i + 2);
	} 
	for(let i = 0; i < p2.length - 1; i++) {
		if (i < 2) {
			total += (p2.charAt(i) * (i + 8));
		} else {
			total += (p2.charAt(i) * i);
		}
	}
	if((11 - (total % 11)) % 10 == p2.charAt(6)) {
		result.textContent = '옳바른 주민번호 입니다.';
		result.setAttribute('class', 'sn-check-ok');
		// 생일과 성별 채우기
		switch (p2.charAt(0)) {
			case '1': case '3': case '5': case '7': f.gender.value='m'; break;
			case '2': case '4': case '6': case '8': f.gender.value='f'; break;
		}
		switch (p2.charAt(0)) {
			case '1': case '2': case '5': case '6': f.year.value=19 + p1.substring(0, 2); break;
			case '3': case '4': case '7': case '8': f.year.value=20 + p1.substring(0, 2); break;
		}
		f.month.value=p1.substring(2,4);
		f.day.value=p1.substring(4);
		return true;
	} else {
		result.textContent = "틀린 주민번호 입니다."
		result.setAttribute('class', 'sn-check-not');
		return false;
	}
}

function send(f) {
	if(!idCheck(f)) {
		alert('아이디를 확인하세요')
		f.id.focus();
		return;
	}
	if(!pw1Check(f)) {
		alert('비밀번호를 확인하세요')
		f.pw1.focus();
		return;
	}
	if(!pw2Check(f)) {
		alert('비밀번호확인을 확인하세요')
		f.pw2.focus();
		return;
	}
	if(!emailCheck(f)) {
		alert('이메일을 확인하세요')
		f.email.focus();
		return;
	}
	if(!phone2Check(f)) {
		alert('휴대폰번호를 확인하세요')
		f.phone2.focus();
		return;
	} else if(!phone3Check(f)) {
		alert('휴대폰번호를 확인하세요')
		f.phone3.focus();
		return;
	}
	if(!fn_personalIdCheck(f)) {
		alert('주민번호를 확인하세요')
		f.personal-id1.focus();
		return;
	}
	
	f.action = '#';
	f.method = 'post';
	f.submit();
}