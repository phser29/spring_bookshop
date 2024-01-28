<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/admin/authorManage.css">
 
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>
</head>
<body>
 
    <%@include file="../includes/admin/header.jsp" %>
    
       <div class="admin_content_wrap">
           <div class="admin_content_subject"><span>작가 관리</span></div>
           
           	<div class="author_table_wrap">
           		<c:if test="${listCheck != 'empty' }">
           			<table class="author_table">
                   	<thead>
                   		<tr>
                   			<td class="th_column_1">작가 번호</td>
                   			<td class="th_column_2">작가 이름</td>
                   			<td class="th_column_3">작가 국가</td>
                   			<td class="th_column_4">등록 날짜</td>
                   			<td class="th_column_5">수정 날짜</td>
                   		</tr>
                   	</thead>
                   	<c:forEach items="${list}" var="list">
	                   	<tr>
	                   		<td><c:out value="${list.authorId}"></c:out> </td>
	                   		<td>
	                   			<a class="move" href='<c:out value="${list.authorId}"/>'>
									<c:out value="${list.authorName}"></c:out>
								</a> 
	                   		</td>
	                   		<td><c:out value="${list.nationName}"></c:out> </td>
	                   		<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd"/></td>
	                   		<td><fmt:formatDate value="${list.updateDate}" pattern="yyyy-MM-dd"/></td>
	                   	</tr>
                   	</c:forEach>
                   </table>
           		</c:if>
           		
           		<c:if test="${listCheck == 'empty' }">
           			<div class="table_empty">
           				등록된 작가가 없습니다.
           			</div>
           		</c:if>
                </div>                    
           </div>
           <div class="search_wrap">
		       <form id="searchForm" action="/admin/authorManage" method="get">
		       	<div class="search_input">
		       		<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
		       		<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum }"></c:out>'>
		       		<input type="hidden" name="amount" value='${pageMaker.cri.amount}'>
		       		<button class='btn search_btn'>검 색</button>
		       	</div>
		       </form>
	       </div>
           <div class="pageMaker_wrap" >
	           <ul class="pageMaker">
	           	<!-- 이전 버튼 -->
	           	<c:if test="${pageMaker.prev}">
	           		<li class="pageMaker_btn prev">
	           			<a href="${pageMaker.pageStart - 1}">이전</a>
	           		</li>
	           	</c:if>
	           	
	           	<!-- 페이지 번호 -->
	           	<c:forEach begin="${pageMaker.pageStart}" end="${pageMaker.pageEnd}" var="num">
	           		<li class="pageMaker_btn ${pageMaker.cri.pageNum == num ? "active":""}">
	           			<a href="${num}">${num}</a>
	           		</li>
	           	</c:forEach>
	           	
	           	<!-- 다음 버튼 -->
	           	<c:if test="${pageMaker.next}">
	           		<li class="pageMaker_btn next">
	           			<a href="${pageMaker.pageEnd + 1 }">다음</a>
	           		</li>
	           	</c:if>
	           	
	           </ul>
           </div>
           <form id="moveForm" action="/admin/authorManage" method="get">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
	 	   </form>
       </div>
                
    <%@include file="../includes/admin/footer.jsp" %>
    
<script type="text/javascript">
/* 작가 등록 성공 경고창 */
$(document).ready(function() {
	let result = "<c:out value='${enroll_result}'/>";
	
	checkResult(result);
	
	function checkResult(result) {
		if(result === '') {
			return;
		}
		
		alert("작가 '${enroll_result}'을 등록하였습니다.");
	}
});

//페이지 이동
let moveForm = $('#moveForm');

$('.pageMaker_btn a').on("click", function(e) {
	e.preventDefault();
	
	moveForm.find("input[name='pageNum']").val($(this).attr("href"));
	moveForm.submit();
})

//작가 검색 버튼 동작
let searchForm = $('#searchForm'); 

$('#searchForm button').on("click", function(e) {
	e.preventDefault();
	
	if(!searchForm.find("input[name='keyword']").val()) {
		alert("키워드를 입력하십시오");	
		return false;
	}
	
	searchForm.find("input[name='pageNum']").val("1");
	searchForm.submit();
})

</script>
</body>
</html>