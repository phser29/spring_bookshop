let searchForm = $('#searchForm');
let moveForm = $('#moveForm');

$("#searchForm button").on("click", function(e){
	e.preventDefault()
	
	if(!searchForm.find("input[name='keyword']").val()) {
		alert("키워드를 입력하십시오.");
		return false;
	}
	
	searchForm.find("input[name='pageNum']").val("1");
	searchForm.submit();
});


$('.pageMaker_btn a').on("click", function(e) {
	e.preventDefault();
	
	console.log($(this).attr("href"));
	
	moveForm.find("input[name='pageNum']").val($(this).attr("href"));
	moveForm.submit();
});

// 작가 선택 및 팝업창 담기
$('.move').on("click", function(e) {
	e.preventDefault();
	
	let authorId = $(this).attr("href");
	let authorName = $(this).data("name");
	$(opener.document).find("#authorId_input").val(authorId);
	$(opener.document).find("#authorName_input").val(authorName);
	
	window.close();
});

