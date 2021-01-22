/**
 * 
 */

/*
	console.log(Math.round(123.456 * 0.01) / 0.01);	// 십의 자리 반올림
	console.log(Math.round(123.456 * 0.1) / 0.1);	// 일의 자리 반올림
	console.log(Math.round(123.456 * 1) / 1);	// 정수 반올림
	console.log(Math.round(123.456 * 10) / 10);	// 소수 1자리 반올림
	console.log(Math.round(123.456 * 100) / 100);	// 소수 2자리 반올림
	console.log(Math.round(123.456 * 1000) / 1000);	// 소수 3자리 반올림
*/
// n자리로 반올림 값을 반환하는 myRound 함수
function myRound(n, digits) {
	digits || (digits = 0);
	return Math.round(n * Math.pow(10, digits)) / Math.pow(10, digits);
}

// n자리로 올림 값을 반환하는 myCeil 함수
function myCeil(n, digits) {
	digits || (digits = 0);
	return Math.ceil(n * Math.pow(10, digits)) / Math.pow(10, digits);
}

// n자리로 내림 값을 반환하는 myFloor 함수
function myFloor(n, digits) {
	digits || (digits = 0);
	return Math.floor(n * Math.pow(10, digits)) / Math.pow(10, digits);
}

// digits 자리수 만큼 n앞에 0을 붙여주는 fillZero 함수
function fillZero(n, digits) {
	var strN = '' + n;
	var lenN = strN.length;
	
	if(lenN >= digits) {
		return strN;
	} else {
		for(var i = 0; i < digits - lenN; i++) {
			strN = '0' + strN;
		}
		return strN;
	}
	
	/*
	var strN = '' + n;
	while(strN.length != distis) {
		strN = '0' + strN;
	}
	return strN;
	*/
}

// 남은 일, 시간 계산하는 dDay 함수
function dDay() {
	setTimeout(function () {
		// D-Day 계산 및 표시
		var d_day = new Date(2020, 11, 3);
		// var d_day = new Date('2020-12-03');
		var today = new Date();
		var restTime = d_day.getTime() - today.getTime();	// 남은 시간이 밀리초 단위로 저장
		var result = '';
		
		if(restTime <= 0) {
			document.getElementById('d-day').textContent = '입니다.';
			return;
		}
		
		// 남은 시간 계산
		restTime = parseInt(restTime / 1000);	// restTime이 초 단위로 변경
		var second = fillZero(restTime % 60, 2);
		var minute = fillZero(parseInt(restTime / 60) % 60, 2);
		var hour = parseInt(restTime / 3600) % 24;
		var day = parseInt(restTime / 3600 / 24);
		
		if(day > 0) {
			result += day + '일 '
		}
		result += (hour + '시 ' +  minute + '분 ' + second + '초');
		
		document.getElementById('d-day').textContent = result;
		if(day == 0) {
			document.getElementById('d-day').style.color = 'red';
		}
		// 재귀호출
		dDay();
	}, 1000);
}