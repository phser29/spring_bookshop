let idCheck = false;
let idckCheck = false;
let pwCheck = false;
let pwckCheck = false;
let nameCheck = false;
let mailFormCheck = false;
let addressCheck = false;

$(document).ready(function() {
	$('.mail_input').on("propertychange change keyup paste input", function() {
		let email = $(".mail_input").val(); 
		let form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		
		if(form.test(email)) {
			$('.mail_input_box_re1').css('display', 'block');
			$('.mail_input_box_re2').css('display', 'none');
			mailFormCheck = true;
		} else {
			$('.mail_input_box_re1').css('display', 'none');
			$('.mail_input_box_re2').css('display', 'block');
			mailFormCheck = false;
		}	
	});
	
	// 회원가입 함수
	$(".join_button").click(function() {
		let id = $('.id_input').val();
		let pw = $('.pw_input').val();
		let pwck = $('.pwck_input').val();
		let name = $('.user_input').val();
		let mail = $('.mail_input').val();
		let addr = $('.address_input_3').val();
		
		if(id === "") {
			$(".final_id_ck").css('display', 'block');	
			idCheck = false;
		} else {
			$(".final_id_ck").css('display', 'none');
			idCheck = true;
		}
		
		if(pw === "") {
			$('.final_pw_ck').css('display', 'block');
			pwCheck = false;
		} else {
			$('.final_pw_ck').css('display', 'none');
			pwCheck = true;
		}
		
		if(pwck === "") {
			$('.final_pwck_ck').css('display', 'block');
			pwckCheck = false;
		} else {
			$('.final_pwck_ck').css('display', 'none');
			pwckCheck = true;
		}
		
		if(name === "") {
			$('.final_name_ck').css('display', 'block');
			nameCheck = false;
		} else {
			$('.final_name_ck').css('display', 'none');
			nameCheck = true;
		}
		
		if(mail === "") {
			$('.final_mail_ck').css('display', 'block');
			mailCheck = false;
		} else {
			$('.final_mail_ck').css('display', 'none');
			mailCheck = true;
		}
		
		if(addr === "") {
			$('.final_addr_ck').css('display', 'block');	
			addressCheck = false;
		} else {
			$('.final_addr_ck').css('display', 'none');	
			addressCheck = true;
		}
		
		/* 최종 유효성 검사 */
        if(idCheck&&idckCheck&&pwCheck&&pwckCheck&&pwckcorCheck&&nameCheck&&addressCheck&&mailFormCheck){
        	alert("회원가입 완료");
 			$("#join_form").attr("action", "/member/join");
			$("#join_form").submit();
        } else {
        	alert('다시 시도해주세요');
        	return false;
        }
		
	});
});

// 아이디 중복 검사 함수
$(".id_input").on("propertychange change keyup paste input", function() {
	let memberId = $(".id_input").val();
	let data = {memberId : memberId};
	
	$.ajax({
		type : "POST",
		url : "/member/memberIdChk",
		data : data,
		success : function(result) {
			if(result != 'fail'){
				$('.id_input_re_1').css("display", "inline-block");
				$('.id_input_re_2').css("display", "none");
				idckCheck = true;		
			} else {
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display", "none");
				idckCheck = false;		
			}
		}
	});
});

// 비밀번호 확인 일치 유효성 검사
$('.pwck_input').on("propertychange change keyup paste input", function(){
	let pw = $('.pw_input').val();
	let pwck = $('.pwck_input').val();
	$('.final_pwck_ck').css('display', 'none');
	
	if(pw === pwck) {
		$('.pwck_input_re_1').css('display', 'block');
		$('.pwck_input_re_2').css('display', 'none');		
		pwckcorCheck = true;
	} else {
		$('.pwck_input_re_1').css('display', 'none');
		$('.pwck_input_re_2').css('display', 'block');		
		pwckcorCheck = false;
	}
});    


$('.pwck_input').on("propertychange change keyup paste input", function(){
	let pw = $('.pw_input').val();
	let pwck = $('.pwck_input').val();
	$('.final_pwck_ck').css('display', 'none');
	
	if(pw === pwck) {
		$('.pwck_input_re_1').css('display', 'block');
		$('.pwck_input_re_2').css('display', 'none');		
		pwckcorCheck = true;
	} else {
		$('.pwck_input_re_1').css('display', 'none');
		$('.pwck_input_re_2').css('display', 'block');		
		pwckcorCheck = false;
	}
});    


// 인증 이메일 전송
$(".mail_check_button").click(function() {
    let email = $(".mail_input").val(); 
    
    $.ajax({
    	type: "GET",
    	url: "mailCheck?email=" + email
    });
});





