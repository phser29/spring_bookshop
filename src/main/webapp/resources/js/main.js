$('#gnb_logout_button').click(function() {
	$.ajax({
		type: "POST",
		url: "/member/logout.do",
		success: function(data) {
			alert('로그아웃 성공');
			document.location.reload();
		}
	});
});