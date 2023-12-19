package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		log.info("������ȣ: " + email);
	}
	
	
}
