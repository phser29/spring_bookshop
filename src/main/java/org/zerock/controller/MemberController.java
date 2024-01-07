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
		log.info("ȸ������ ������ ����");
	}
	
	//�α��� ������ �̵�
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() {
		log.info("�α��� ������ ����");
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public void joinPOST(MemberVO member) throws Exception {
		
		memberService.memberJoin(member);
		
		log.info("join ����");
	}
	
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		
		int result = memberService.idCheck(memberId);
		
		//log.info("����� = " + result);
		
		if(result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public void mailcheckGET(String email) throws Exception {
		
		log.info("������ ����Ȯ��");
		log.info("�����̸���: " + email);
		
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		log.info("������ȣ: " + checkNum);
		
		String setFrom = "quaj628@gmail.com";
		String toMail = email;
		String title = "ȸ������ ���� �̸��� �Դϴ�.";
		String content = "Ȩ�������� �湮���ּż� �����մϴ�."+
						 "<br><br>"+
						 "���� ��ȣ��" + checkNum + " �Դϴ�."+
						 "�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���";
		
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
