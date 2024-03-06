let moveForm = $('#moveForm');
let modifyForm = $('#modifyForm');

$('cancelBtn').on("click", function(e) {
	e.preventDefault();
	
	moveForm.attr("action", "/admin/authorDetail")
	moveForm.submit();
})

//작가 수정 버튼 작동 및 유효성 검사
$('#modifyBtn').on("click", function(e) {
	let authorName = $('.form_section_content input[name="authorName"]').val();
	let authorIntro = $('.form_section_content textarea').val();
	
	let nameCk = false;
	let introCk = false;
	
	e.preventDefault();
	
	if(!authorName) {
		$('#warn_authorName').css("display", "block");
	} else {
		$('#warn_authorName').css("display", "none");
		nameCk = true;
	}
	if(!authorIntro) {
		$('#warn_authorIntro').css("display", "block");
	} else {
		$('#warn_authorIntro').css("display", "none");
		introCk = true;
	}
	
	if(nameCk && introCk) {
		modifyForm.submit();
	} else {
		return false;	
	}
})
		