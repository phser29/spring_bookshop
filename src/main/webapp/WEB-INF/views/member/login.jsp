<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/member/login.css">
</head>
<body>

<div class="wrapper">
	
	<div class="wrap">
		<form id="login_form"  method="POST">
			<div class="logo_wrap">
				<span>Book shop</span>
			</div>
			<div class="login_wrap"> 
				<div class="id_wrap">
					<div class="id_input_box">
						<input type="text" class="id_input" name="memberId" placeholder="ID">
					</div>
				</div>
				<div class="pw_wrap">
					<div class="pw_input_box">
						<input type="password" class="pw_iput" name="memberPw" placeholder="PW">
					</div>
				</div>
				
				<c:if test="${result == 0 }">
					<div class="login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다</div>
				</c:if>
				
				<div class="login_button_wrap">
					<input type="button" class="login_button" onkeyup="enterkey()" value="로그인">
				</div>			
			</div>
		</form>
	</div>
</div>
<script src="/resources/js/member/login.js"></script>
</body>
</html>