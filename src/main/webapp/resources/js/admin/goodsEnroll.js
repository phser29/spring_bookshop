let enrollForm = $("#enrollForm");
	
$("#enrollBtn").on("click", function(e) {
	e.preventDefault();
	enrollForm.submit();
});
	
//팝업창
$('.authorId_btn').on("click", function(e) {
	e.preventDefault();
	
	let popUrl = "/admin/authorPop";
	let popOption = "width = 650px, height=550px, top=300px, left=300px, scrollbars=yes";
	
	window.open("/admin/authorPop","작가 찾기",popOption);
});

	
//위젯(jquery)
const config = {
	dateFormat: 'yy-mm-dd',
	showOn : "button",
	buttonText:"날짜 선택",
	prevText: '이전 달',
	nextText: '다음 달',
	monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	dayNames: ['일','월','화','수','목','금','토'],
	dayNamesShort: ['일','월','화','수','목','금','토'],
	dayNamesMin: ['일','월','화','수','목','금','토'],
	yearSuffix: '년',
    changeMonth: true,
    changeYear: true
}
	
$(function() {
	$( "input[name='publeYear']" ).datepicker(config);
});
	
//책 소개
ClassicEditor
	.create(document.querySelector('#bookIntro_textarea'))
	.catch(error => {
		console.error(error);
	})
	
//책 목차
ClassicEditor
	.create(document.querySelector('#bookContents_textarea'))
	.catch(error => {
		console.error(error);
})



