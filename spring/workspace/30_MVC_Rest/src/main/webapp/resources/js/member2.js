let page = 1;

// 1. 회원 목록
function memberList(url, p) {
	if(p != null && p != '') {
		page = p;
	}
	$.ajax({
		url: url,
		type: 'get',
		data: {"page": page},
		dataType: 'json',
		success: function(responseList) {
			if(responseList.result) {
				memberListTable(responseList.list, responseList.totalRecord, responseList.recordPerPage, responseList.page);
				$('#paging').html('');
				$('#paging').html(responseList.paging);
				page = responseList.page;
			}
		},
		error: function() {
			alert('실패');
		}
	});
}

//서브 함수: 회원 목록을 테이블로 만들어 주는 함수
function memberListTable(list, total, recordPerPage, p) {
	$('#memberList').empty();
	$.each(list, function(idx, member) {
		$('<tr>')
		.append($('<td>').html(total - (recordPerPage * (p - 1)) - idx))
		.append($('<td>').html(member.id))
		.append($('<td>').html(member.name))
		.append($('<td>').html(member.gender))
		.append($('<td>').html(member.address))
		.append($('<input type="hidden" name="no" />').val(member.no))
		.append($('<td>').html('<input type="button" value="조회" id="btnView" />'))
		.append($('<td>').html('<input type="button" value="삭제" id="btnDelete" />'))
		.appendTo('#memberList')
	});
}

// 2. 회원 상세보기
function memberView() {
	$('body').on('click', '#btnView', function() {
		let no = $(this).parents('tr').find('input:hidden[name="no"]').val();	// 부모요소중 tr
		$.ajax({
			url: 'member/' + no,
			type: 'get',
			dataType: 'json',
			success: function(responseObj) {
				if(responseObj.result) {
					$('input:text[name="id"]').val(responseObj.memberDto.id);
					$('input:text[name="id"]').attr('readonly', 'readonly');
					$('input:text[name="name"]').val(responseObj.memberDto.name);
					$('input:radio[name="gender"][value="' + responseObj.memberDto.gender + '"]').prop('checked', true);
					$('select[name="address"]').val(responseObj.memberDto.address);
					$('#uniqueNo').val(responseObj.memberDto.no);
				} else {
					alert('계정정보를 불러오는데 실패하였습니다.');
				}
			},
			error: function() {
				alert('실패');
			}
		});
	})
}

// 3. 회원추가
function memberInsert() {
	$('#btnInsert').click(function() {
		if($('select[name="address"]').val() == '') {
			alert('지역을 선택 해주세요');
			return;
		}
		let id = $('input:text[name="id"]').val();
		let name = $('input:text[name="name"]').val();
		let gender = $('input:radio[name="gender"]:checked').val();
		let address = $('select[name="address"]').val();
		let sendObj = {
			"id": id,
			"name": name,
			"gender": gender,
			"address": address
		};
		
		$.ajax({
			url: 'member',
			type: 'post',
			data: JSON.stringify(sendObj),
			contentType: 'application/json',
			dataType: 'json',
			success: function(responseObj) {
				if(responseObj.result) {
					alert('신규 회원이 등록되었습니다.');
					resetVal();
					memberList('memberPaging', 1);
				} else {
					alert('신규 회원 등록에 실패했습니다.');
				}
			},
			error: function() {
				alert('실패');
			}
		});
	});
}

// 서브함수: 회원추가 후 밸류값들 초기화 시켜주는 함수
function resetVal() {
	$('input:text[name="id"]').val('');
	$('input:text[name="name"]').val('');
	$('input:radio[name="gender"][value="unknown"]').prop('checked', true);
	$('select[name="address"]').val('');
}

// 4. 회원수정
function memberUpdate() {
	$('#btnUpdate').click(function() {
		let no = $('#uniqueNo').val();
		let id = $('input:text[name="id"]').val();
		let name = $('input:text[name="name"]').val();
		let gender = $('input:radio[name="gender"]:checked').val();
		let address = $('select[name="address"]').val();
		let sendObj = {
				"no": no,
				"id": id,
				"name": name,
				"gender": gender,
				"address": address
		};
		$.ajax({
			url: 'member',
			type: 'put',
			data: JSON.stringify(sendObj),
			contentType: 'application/json',
			dataType: 'json',
			success: function(responseObj) {
				if(responseObj.result) {
					alert('정보가 수정 되었습니다.');
					memberList('memberPaging', page);
				} else {
					alert('정보수정에 실패했습니다.');
				}
			},
			error: function() {
				alert('실패');
			}
		});
	});
}

// 5. 회원 삭제
function memberDelete() {
	$('body').on('click', '#btnDelete', function() {
		if(confirm('계정을 삭제할까요?')) {
			let no = $(this).parents('tr').find('input:hidden[name="no"]').val();	// 부모요소중 tr
			$.ajax({
				url: 'member/' + no,
				type: 'delete',
				dataType: 'json',
				success: function(responseObj) {
					if(responseObj.result) {
						alert('계정을 삭제하였습니다.');
						memberList('memberPaging', page);
					} else {
						alert('계정삭제에 실패하였습니다.');
					}
				},
				error: function() {
					alert('실패');
				}
			});
		}
	});
}

// 6. 초기화
function init() {
	$('#btnInit').click(function() {
		$('input:text[name="id"]').val('');
		$('#uniqueNo').val('');
		$('input:text[name="id"]').removeAttr('readonly');
		$('input:text[name="name"]').val('');
		$('input:radio[name="gender"][value="unknown"]').prop('checked', true);
		$('select[name="address"]').val('');
		memberList('memberPaging', page);
	});
}