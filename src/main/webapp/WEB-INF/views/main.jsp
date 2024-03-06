<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book shop</title>
<link rel="stylesheet" href="resources/css/main.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>
<body>
<div class="wrapper">
	<div class="wrap">
		<div class="top_gnb_area">
			<ul class="list">
				<c:if test="${member == null }">
					<li>
                    	<a href="/member/login">로그인</a>
	                </li>
	                <li>
	                    <a href="/member/join">회원가입</a>
	                </li>
	                <li>
	                    고객센터
	                </li>
				</c:if>
                <c:if test="${member != null }">                    
                	<c:if test="${member.adminCk == 1 }">
                        <li><a href="/admin/admin">관리자 페이지</a></li>
                    </c:if>
                    <li>
                        <a id="gnb_logout_button">로그아웃</a>
                    </li>
                    <c:if test="${member.adminCk != 1}">
                    	<li>
                        	마이룸
                    	</li>
                    	<li>
                        	장바구니
                   		</li>
                    </c:if>
                    <li>
	                    고객센터
	                </li>
                </c:if>   
            </ul>  
		</div>
		<div class="top_area">
			<div class="logo_area">
				<a href="/main"><img class="bookImg" alt="logo" src="/resources/img/book_logo.png"></a>
			</div>
			<div class="search_area">
				<h1>Search area</h1>
			</div>
			<div class="login_area">
				<c:if test="${member == null }">
					<div class="login_button"><a href="/member/login.do">로그인</a></div>
					<span><a href="/member/join">회원가입</a></span>
				</c:if>
				<c:if test="${member != null }">
					<div class="login_success_area">
                        <span>회원 : ${member.memberName}</span>
                        <span>충전금액 :\ ${member.money}</span>
                        <span>포인트 : ${member.point}</span>
                    </div>
				</c:if>
			</div>
			<div class="clearfix"></div>			
		</div>
		<div class="navi_bar_area">
			<h1>navi area</h1>
		</div>
		<div class="content_area">
			<h1>content area</h1>
		</div>
		
        <!-- Footer 영역 -->
        <div class="footer_nav">
            <div class="footer_nav_container">
                <ul>
                    <li>회사소개</li>
                    <span class="line">|</span>
                    <li>이용약관</li>
                    <span class="line">|</span>
                    <li>고객센터</li>
                    <span class="line">|</span>
                    <li>광고문의</li>
                    <span class="line">|</span>
                    <li>채용정보</li>
                    <span class="line">|</span>
                </ul>
            </div>
        </div> <!-- class="footer_nav" -->
        
        <div class="footer">
            <div class="footer_container">
                
                <div class="footer_left">
                    <img src="resources/img/book_logo.png">
                </div>
                <div class="footer_right">
                    (주) BOOK STORE
                    <br>
                    사업자등록번호 : ooo-oo-ooooo
                    <br>
                    대표전화 : oooo-oooo(발신자 부담전화)
                    <br>
                    <br>
                    COPYRIGHT(C) <strong>kimvampa.tistory.com</strong>    ALL RIGHTS RESERVED.
                </div>
                <div class="clearfix"></div>
            </div>
        </div> <!-- class="footer" -->  
	</div>
</div>
<script src="/resources/js/main.js"></script>
</body>
</html>