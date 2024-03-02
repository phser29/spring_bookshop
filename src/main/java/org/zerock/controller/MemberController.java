package org.zerock.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	private BCryptPasswordEncoder pwEncoder;
	
	//회원가입 페이지 이동
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
	public String joinPOST(MemberVO member) throws Exception {
		
		String rawPw = "";
		String encodePw = "";
		
		rawPw = member.getMemberPw();
		encodePw = pwEncoder.encode(rawPw);
		member.setMemberPw(encodePw);
		
		memberService.memberJoin(member);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		
		int result = memberService.idCheck(memberId);
		
		if(result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String LoginPOST(HttpSession session, MemberVO member, RedirectAttributes rttr) throws Exception {
	    
	    MemberVO lvo = memberService.memberLogin(member);
	    boolean psMatch = pwEncoder.matches(member.getMemberPw(), lvo.getMemberPw());
	    
	    if (lvo != null && psMatch != false) {
	        lvo.setMemberPw("");
	        session.setAttribute("member", lvo);
	        return "redirect:/main";
	    } else {
	        rttr.addFlashAttribute("result", 0);           
	        return "redirect:/member/login";
	    }
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest request) {
		
		log.info("logoutMainGET메서드 진입");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	@ResponseBody
	public void logoutPOST(HttpServletRequest request) { // REST 방식
		
		log.info("logout");
		
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	
}
