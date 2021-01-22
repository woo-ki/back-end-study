<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#btn1').click(fn_getText);
			$('#btn2').click(fn_getJSON);
			$('#btn3').click(fn_getXML);
			$('#btn4').click(fn_getJSONByMap);
			$('#btn5').click(fn_getJSONList);
			$('#btn6').click(fn_getXMLList);
			$('#btn7').click(fn_sendJSON);
			$('#btn8').click(fn_sendPath);
		});
		
		function fn_getText() {
			$.ajax({
				url: 'getText',	// @RequestMapping(value="getText")
				type: 'get',	// @RequestMapping(method=RequestMethod.GET)
				dataType: 'text',	//@RequestMapping(produces="text/plain") + @ResponseBody
				success: function(rText) {
					// r은 응답 받은 결과입니다.
					$('#content1').text(rText.trim());
				},
				error: function() {
					alert('실패');
				}
			});
		}
		function fn_getJSON() {
			$.ajax({
				url: 'getJSON',
				type: 'get',
				dataType: 'json',
				success: function(rObj) {
					// JSON데이터는 Javascript의 객체입니다.
					$('#content2').text('이름: ' + rObj.name + ', 나이: ' + rObj.age + '살');
					// $('#content2').text('이름: ' + rObj[name] + ', 나이: ' + rObj[age] + '살');
				},
				error: function() {
					alert('실패');
				}
			});
		}
		function fn_getXML() {
			$.ajax({
				url: 'getXML',
				type: 'get',
				dataType: 'xml',
				success: function(rXML) {
					// rXML;							<name>앨리스</name><age>30</age>
					// $(rXML).find('name');			<name>앨리스</name>
					// $(rXML).find('age');				<age>30</age>
					// $(rXML).find('name').text();		앨리스
					// $(rXML).find('age').text();		30
					$('#content3').text('이름: ' + $(rXML).find('name').text() + ', 나이: ' + $(rXML).find('age').text() + '살')
				},
				error: function() {
					alert('실패');
				}
			});
		}
		function fn_getJSONByMap() {
			$.ajax({
				url: 'getJSONByMap',
				type: 'get',
				dataType: 'json',
				success: function (rObj) {
					$('#content4').text('이름: ' + rObj.name + ', 나이: ' + rObj.age + '살');
				},
				error: function() {
					alert('실패');
				}
			});
		}
		function fn_getJSONList() {
			$.ajax({
				url: 'getJSONList',
				type: 'get',
				dataType: 'json',
				success: function(rObjList) {
					// 자바의 ArrayList는 jackson에 의해 자바스크립트의 배열로 변환된다.
					/*
						rObjList = [
							{"name": "사용자1", "age": 20},
							{"name": "사용자2", "age": 21},
							{"name": "사용자3", "age": 22},
							...
						]
					*/
					let result = '<table border="1"><thead><tr><td>순번</td><td>이름</td><td>나이</td></tr></thead><tbody>';
					for(let i = 0; i < rObjList.length; i++) {
						result += '<tr>';
						result += '<td>' + (i + 1) + '</td>';
						result += '<td>' + rObjList[i].name + '</td>';
						result += '<td>' + rObjList[i].age + '</td>';
						result += '</tr>';
					}
					result += '</tbody></table>';
					$('#content5').html(result);
				},
				error: function() {
					alert('실패');
				} 
			});
		}
		function fn_getXMLList() {
			$.ajax({
				url: 'getXMLList',
				type: 'get',
				dataType: 'xml',
				success: function (rXMLList) {
					/*
						responseList는 아래와 같습니다.
					
						확인하려면 "http://localhost:9090/rest/getXMLList" 실행 후 주소를 입력합니다. 
						<list>	
							<item>
								<name>사용자1</name>
								<age>20</age>
							</item>
							<item>
								<name>사용자2</name>
								<age>21</age>
							</item>
							...
						</list>
					*/
					
					$('table').css('display', 'inline-block');
					$('#content6').empty();
					$(rXMLList).find('item').each(function(idx){
						// $(responseList).find('item') == $(this)
						$('<tr>')
						.append($('<td>').html(idx + 1))
						.append($('<td>').html($(this).find('name').text()))
						.append($('<td>').html($(this).find('age').text()))
						.appendTo('#content6');
					});
				},
				error: function() {
					alert('실패');
				} 
			});
		}
		function fn_sendJSON() {
			let name = $('#name').val();
			let age = $('#age').val();
			let sendObj = {
					'name': name,
					'age': age
			};	// 아직은 자바스크립트의 객체입니다. JSON이 아닙니다.
			$.ajax({
				url: 'sendJSON',
				type: 'post',	//@PostMapping
				data: JSON.stringify(sendObj),	// 컨트롤러로 보내는 데이터(JSON문자열로 바꿔서)
				contentType: 'application/json',	//컨트롤러로 보내는 데이터의 타입입니다.
				dataType: 'json',	//컨트롤러에서 받아오는 데이터 타입입니다.
				success: function(rObj) {
					$('#content7').text('이름: ' + rObj.name + ', 나이: ' + rObj.age + '살');
				},
				error: function() {
					alert('실패');
				}
			})
		}
		function fn_sendPath() {
			let name = $('#name2').val();
			let age = $('#age2').val();
			$.ajax({
				url: 'name/' + name + '/age/' + age,	// @GetMapping(value="name/{name}/age/{age}")
				type: 'get',
				dataType: 'json',
				success: function (rObj) {
					$('#content8').text('이름: ' + rObj.name + ', 나이: ' + rObj.age + '살');
				},
				error: function() {
					alert('실패');
				}
			});
		}
	</script>
</head>
<body>
	<a href="memberManagePage.do">테이블 예제로 이동하기</a><br/><br/>
	<a href="memberManagePage2.do">페이징 예제로 이동하기</a><br/><br/>

	<input type="button" value="텍스트가져오기" id="btn1" /><br/>
	<div id="content1"></div>
	<br/>
	<input type="button" value="JSON가져오기" id="btn2" /><br/>
	<div id="content2"></div>
	<br/>
	<input type="button" value="XML가져오기" id="btn3" /><br/>
	<div id="content3"></div>
	<br/>
	<input type="button" value="Map을 JSON으로 가져오기" id="btn4" /><br/>
	<div id="content4"></div>
	<br/>
	<input type="button" value="JSON List 가져오기" id="btn5" /><br/>
	<div id="content5"></div>
	<br/>
	<input type="button" value="XML List 가져오기" id="btn6" /><br/>
	<table border="1" style="display:none;">
		<thead>
			<tr>
				<td>번호</td>
				<td>성명</td>
				<td>나이</td>
			</tr>
		</thead>
		<tbody id="content6"></tbody>
	</table>
	<br/>
	<form>
		<input type="text" name="name" id="name" placeholder="이름" />
		<input type="text" name="age" id="age" placeholder="나이" />
		<input type="button" value="정보보내기" id="btn7" />
	</form>
	<div id="content7"></div>
	<br/>
	<form>
		<input type="text" name="name2" id="name2" placeholder="이름" />
		<input type="text" name="age2" id="age2" placeholder="나이" />
		<input type="button" value="정보보내기" id="btn8" />
	</form>
	<div id="content8"></div>
</body>
</html>