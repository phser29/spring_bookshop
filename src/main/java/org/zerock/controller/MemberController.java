package org.zerock.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
//	@Autowired
//	private JavaMailSender mailSender;
	
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
	public String LoginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {
	    HttpSession session = request.getSession();
	    
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
	public void logoutPOST(HttpServletRequest request) {
		
		log.info("logout");
		
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	/* 이메일 인증 */
//	@RequestMapping(value="/mailCheck", method=RequestMethod.GET)
//	@ResponseBody
//	public String mailCheckGET(String email) throws Exception{
//		
//		/* 뷰(View)로부터 넘어온 데이터 확인 */
//		log.info("이메일 데이터 전송 확인");
//		log.info("이메일 : " + email);
//				
//		/* 인증번호(난수) 생성 */
//		Random random = new Random();
//		int checkNum = random.nextInt(888888) + 111111;
//		log.info("인증번호 " + checkNum);
//		
//		/* 이메일 보내기 */
//		String setFrom = "sjinjin6@naver.com";
//		String toMail = email;
//		String title = "회원가입 인증 이메일 입니다.";
//		String content = 
//				"홈페이지를 방문해주셔서 감사합니다." +
//				"<br><br>" + 
//				"인증 번호는 " + checkNum + "입니다." + 
//				"<br>" + 
//				"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";		
//		
//		try {
//			
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//			helper.setFrom(setFrom);
//			helper.setTo(toMail);
//			helper.setSubject(title);
//			helper.setText(content,true);
//			mailSender.send(message);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}		
//		
//		String num = Integer.toString(checkNum);		
//		
//		return num;
//		
//	}	
	
}
