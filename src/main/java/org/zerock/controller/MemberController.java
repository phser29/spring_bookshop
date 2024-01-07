package org.zerock.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.model.MemberVO;
import org.zerock.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/member")
@Log4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGET() {
		log.info("회원가입 페이지 진입");
	}
	
	//로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		log.info("로그인 페이지 진입");
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public void joinPOST(MemberVO member) throws Exception {
		
		memberService.memberJoin(member);
		
		log.info("join 성공");
	}
	
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		
		int result = memberService.idCheck(memberId);
		
		//log.info("결과값 = " + result);
		
		if(result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public void mailcheckGET(String email) throws Exception {
		
		log.info("데이터 전송확인");
		log.info("인증이메일: " + email);
		
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		log.info("인증번호: " + checkNum);
		
		String setFrom = "quaj628@gmail.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다."+
						 "<br><br>"+
						 "인증 번호는" + checkNum + " 입니다."+
						 "해당 인증번호를 인증번호 확인란에 기입하여 주세요";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
