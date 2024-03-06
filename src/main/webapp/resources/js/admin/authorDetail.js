$(document).ready(function() {
	let moveForm = $('#moveForm');		
	
	//작가 관리 페이지 이동 버튼
	$('#cancelBtn').on("click", function(e) {
		e.preventDefault();
		
		$('input[name=authorId]').remove();
		moveForm.attr('action', "/admin/authorManage");
		moveForm.submit();
	})
	
	//작가 수정 페이지로 이동
	$('#modifyBtn').on("click", function(e) {
		e.preventDefault();
		
		moveForm.attr('action', "/admin/authorModify");
		moveForm.submit();
	})
});