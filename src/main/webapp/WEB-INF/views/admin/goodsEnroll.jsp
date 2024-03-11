<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/admin/goodsEnroll.css">
<style type="text/css">
/* 카테고리 css 설정 */
.form_section_content select {		
    width: 92%;
    height: 35px;
    font-size: 20px;
    text-align-last: center;
    margin-left: 5px;
}

.cate_wrap:not(:first-child) {
    margin-top: 20px;
}


</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/41.1.0/classic/ckeditor.js"></script>

</head>
</head>
<body>
 
 		<%@include file="../includes/admin/header.jsp" %>   	
        
	        <div class="admin_content_wrap">
	            <div class="admin_content_subject"><span>상품 등록</span></div>
	            
	              <div class="admin_content_main">
                    	<form action="/admin/goodsEnroll" method="post" id="enrollForm">
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>책 제목</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="bookName">
                    				<span class="ck_warn bookName_warn">책 이름을 입력해주세요.</span>
                    			</div>
                    		</div>
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>작가</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input id="authorName_input" readonly="readonly">
									<input id="authorId_input" name="authorId" type="hidden">
									<button class="authorId_btn">작가 선택</button>
									<span class="ck_warn authorId_warn">작가를 선택해주세요</span>
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>출판일</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="publeYear" >
                    				<span class="ck_warn publeYear_warn">출판일을 선택해주세요.</span>
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>출판사</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="publisher">
                    				<span class="ck_warn publisher_warn">출판사를 입력해주세요.</span>
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>책 카테고리</label>
                    			</div>
                    			<div class="form_section_content">
                    				<div class="cate_wrap">
										<h3>대분류</h3>
										<select class="cate1">
											<option selected value="none">선택</option>
										</select>
									</div>
									<div class="cate_wrap">
										<h3>중분류</h3>
										<select class="cate2">
											<option selected value="none">선택</option>
										</select>
									</div>
									<div class="cate_wrap">
										<h3>소분류</h3>
										<select class="cate3" name="cateCode">
											<option selected value="none">선택</option>
										</select>
									</div>
									<span class="ck_warn cateCode_warn">카테고리를 선택해주세요.</span> 
                    			</div>
                    		</div>      
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 가격</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="bookPrice" value="0">
                    				<span class="ck_warn bookPrice_warn">상품 가격을 입력해주세요.</span>
                    			</div>
                    		</div>               
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 재고</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="bookStock" value="0">
                    				<span class="ck_warn bookStock_warn">상품 재고를 입력해주세요.</span>
                    			</div>
                    		</div>          
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 할인율</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="bookDiscount" value="0">
                    				<span class="ck_warn bookDiscount_warn">상품 할인율을 입력해주세요.</span>
                    			</div>
                    		</div>          		
                    		<div class="form_section">
                    			<div class="form_section_title">
                    			 	<label>책 소개</label>
                    			</div>
                    			<div class="form_section_content">
                    				<textarea name="bookIntro" id="bookIntro_textarea"></textarea>
                    				<span class="ck_warn bookIntro_warn">책 소개를 입력해주세요.</span>
                    			</div>
                    		</div>       		
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>책 목차</label>
                    			</div>
                    			<div class="form_section_content">
                    				<textarea name="bookContents" id="bookContents_textarea"></textarea>
                    				<span class="ck_warn bookContents_warn">책 목차를 입력해주세요.</span>
                    			</div>
                    		</div>
                   		</form>
                   			<div class="btn_section">
                   				<button id="cancelBtn" class="btn">취 소</button>
	                    		<button id="enrollBtn" class="btn enroll_btn">등 록</button>
	                    	</div>
                    </div> 
	        </div>
              
        	<%@include file="../includes/admin/footer.jsp" %>

<script type="text/javascript">
/* 상품 등록 버튼 */
$("#enrollBtn").on("click",function(e){
	e.preventDefault();
	
	/* 체크 변수 */
	let bookNameCk = false;
	let authorIdCk = false;
	let publeYearCk = false;
	let publisherCk = false;
	let cateCodeCk = false;
	let priceCk = false;
	let stockCk = false;
	let discountCk = false;
	let introCk = false;
	let contentsCk = false;
	
	/* 체크 대상 변수 */
	let bookName = $("input[name='bookName']").val();
	let authorId = $("input[name='authorId']").val();
	let publeYear = $("input[name='publeYear']").val();
	let publisher = $("input[name='publisher']").val();
	let cateCode = $("select[name='cateCode']").val();
	let bookPrice = $("input[name='bookPrice']").val();
	let bookStock = $("input[name='bookStock']").val();
	let bookDiscount = $("input[name='bookDiscount']").val();
	let bookIntro = $(".bit p").html();
	let bookContents = $(".bct p").html();
	
	if(bookName){
		$(".bookName_warn").css('display','none');
		bookNameCk = true;
	} else {
		$(".bookName_warn").css('display','block');
		bookNameCk = false;
	}
		
	if(authorId){
		$(".authorId_warn").css('display','none');
		authorIdCk = true;
	} else {
		$(".authorId_warn").css('display','block');
		authorIdCk = false;
	}
		
	if(publeYear){
		$(".publeYear_warn").css('display','none');
		publeYearCk = true;
	} else {
		$(".publeYear_warn").css('display','block');
		publeYearCk = false;
	}	
		
	if(publisher){
		$(".publisher_warn").css('display','none');
		publisherCk = true;
	} else {
		$(".publisher_warn").css('display','block');
		publisherCk = false;
	}
		
	if(cateCode != 'none'){
		$(".cateCode_warn").css('display','none');
		cateCodeCk = true;
	} else {
		$(".cateCode_warn").css('display','block');
		cateCodeCk = false;
	}	
		
	if(bookPrice != 0){
		$(".bookPrice_warn").css('display','none');
		priceCk = true;
	} else {
		$(".bookPrice_warn").css('display','block');
		priceCk = false;
	}	
		
	if(bookStock != 0){
		$(".bookStock_warn").css('display','none');
		stockCk = true;
	} else {
		$(".bookStock_warn").css('display','block');
		stockCk = false;
	}		
		
	if(bookDiscount < 1 && bookDiscount != ''){
		$(".bookDiscount_warn").css('display','none');
		discountCk = true;
	} else {
		$(".bookDiscount_warn").css('display','block');
		discountCk = false;
	}	
		
	if(bookIntro != '<br data-cke-filler="true">'){
		$(".bookIntro_warn").css('display','none');
		introCk = true;
	} else {
		$(".bookIntro_warn").css('display','block');
		introCk = false;
	}	
		
	if(bookContents != '<br data-cke-filler="true">'){
		$(".bookContents_warn").css('display','none');
		contentsCk = true;
	} else {
		$(".bookContents_warn").css('display','block');
		contentsCk = false;
	}
	
	if(bookNameCk && authorIdCk && publeYearCk && publisherCk && cateCodeCk && priceCk && stockCk && discountCk && introCk && contentsCk ){
		enrollForm.submit();
	} else {
		return false;
	}
});

/* 취소 버튼 */
$("#cancelBtn").click(function(){
	
	location.href="/admin/goodsManage"
	
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


//팝업창
$('.authorId_btn').on("click", function(e) {
	e.preventDefault();
	
	let popUrl = "/admin/authorPop";
	let popOption = "width = 650px, height=550px, top=300px, left=300px, scrollbars=yes";
	
	window.open("/admin/authorPop","작가 찾기",popOption);
});

let cateList = JSON.parse('${cateList}');

let cate1Array = new Array();
let cate2Array = new Array();
let cate3Array = new Array();
let cate1Obj = new Object();
let cate2Obj = new Object();
let cate3Obj = new Object();

let cateSelect1 = $(".cate1");		
let cateSelect2 = $(".cate2");
let cateSelect3 = $(".cate3");

// 카테고리 배열 초기화 메서드
function makeCateArray(obj, array, cateList, tier) {
	for(let i = 0; i < cateList.length; i++){
		if(cateList[i].tier === tier){
			obj = new Object();
			
			obj.cateName = cateList[i].cateName;
			obj.cateCode = cateList[i].cateCode;
			obj.cateParent = cateList[i].cateParent;
			
			array.push(obj);	
		}
	}
}	

//배열 초기화
makeCateArray(cate1Obj,cate1Array,cateList,1);
makeCateArray(cate2Obj,cate2Array,cateList,2);
makeCateArray(cate3Obj,cate3Array,cateList,3);

//대분류
for(let i = 0; i < cate1Array.length; i++){
	cateSelect1.append("<option value='"+cate1Array[i].cateCode+"'>" + cate1Array[i].cateName + "</option>");
}

//중분류
$(cateSelect1).on("change", function () {
	let selectVal1 = $(this).find("option:selected").val();
	cateSelect2.children().remove();
	cateSelect3.children().remove();
	cateSelect2.append("<option value='none'>선택</option>");
	cateSelect3.append("<option value='none'>선택</option>");
	
	for(let i=0; i<cate2Array.length; i++) {
		if(selectVal1 === cate2Array[i].cateParent) {
			cateSelect2.append("<option value='"+cate2Array[i].cateCode+"'>" + cate2Array[i].cateName + "</option>");
		}
	}
});

//소분류
$(cateSelect2).on("change", function() {
 	let selectVal2 = $(this).find("option:selected").val();
	cateSelect3.children().remove();
	cateSelect3.append("<option value='none'>선택</option>");
	
	for(let i=0; i<cate3Array.length; i++) {
		if(selectVal2 === cate3Array[i].cateParent) {
			cateSelect3.append("<option value='"+cate3Array[i].cateCode+"'>"+cate3Array[i].cateName+"</option>");
		}
	}
});


</script>
</body>
</html>
