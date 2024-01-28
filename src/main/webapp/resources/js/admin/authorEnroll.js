/* 등록 버튼 */
$("#enrollBtn").click(function() {
	/*검사 통과 유무 변수 */
	let nameCheck = false;
	let nationCheck = false;
	let introCheck = false;
	
	let authorName = $('input[name=authorName]').val();
	let nationId = $('select[name=nationId]').val();
	let authorIntro = $('input[name=authorIntro]').val();
	
	let wAuthorName = $('#warn_authorName');
	let wNationId = $('#warn_nationId');
	let wAuthorIntro = $('#warn_authorIntro');
	
	if(authorName === '') {
		wAuthorName.css('display', 'block');
		nameCheck = false;
	} else {
		wAuthorName.css('display', 'none');
		nameCheck = true;
	}
	
	if(nationId === 'none') {
		wNationId.css('display', 'block');		
		nationCheck = false;
	} else {
		wNationId.css('display', 'none');
		nationCheck = true;
	}
	
	if(authorIntro === '') {
		wAuthorIntro.css('display', 'block');
		introCheck = false;
	} else {
		wAuthorIntro.css('display', 'none');
		introCheck = true;
	}
	
	/*유효성 검사*/
	if(nameCheck && nationCheck && introCheck) {
		alert("등록");
		$("#enrollForm").submit();
	} else {
		return;
	}
	
});

/* 취소 버튼 */
$("#cancelBtn").click(function() {

	location.href='/admin/authorEnroll.do';
});

