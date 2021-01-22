/**
 * 
 */

// 현재 시간을 보여주는 time 메소드
function time() {
	setTimeout(function () {
		var now = new Date();
		var result = '';
		result += now.getFullYear() + '년 ';
		result += now.getMonth() + '월 ';
		result += now.getDate() + '일 ';
		result += now.getHours() + '시 ';
		result += now.getMinutes() + '분 ';
		result += now.getSeconds() + '초';
		document.getElementById('time').textContent = result;
		time();
	}, 1000);
}