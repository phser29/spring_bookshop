$('.login_button').on('click', function() {
	$("#login_form").attr("action", "/member/login.do");
    $("#login_form").submit();
	
});

