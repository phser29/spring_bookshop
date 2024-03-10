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
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>출판일</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="publeYear" >
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>출판사</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="publisher">
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
                    			</div>
                    		</div>      
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 가격</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="bookPrice" value="0">
                    			</div>
                    		</div>               
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 재고</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="bookStock" value="0">
                    			</div>
                    		</div>          
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 할인율</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="bookDiscount" value="0">
                    			</div>
                    		</div>          		
                    		<div class="form_section">
                    			<div class="form_section_title">
                    			 	<label>책 소개</label>
                    			</div>
                    			<div class="form_section_content">
                    				<textarea name="bookIntro" id="bookIntro_textarea"></textarea>
                    			</div>
                    		</div>       		
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>책 목차</label>
                    			</div>
                    			<div class="form_section_content">
                    				<textarea name="bookContents" id="bookContents_textarea"></textarea>
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

<script type="text/javascript" src="../resources/js/admin/goodsEnroll.js"></script>
<script type="text/javascript">
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
	cateSelect2.append("<option value='none'>선택</option>");
	
	for(let i=0; i<cate2Array.length; i++) {
		if(selectVal1 === cate2Array[i].cateParent) {
			
		}
	}
})

</script>
</body>
</html>
