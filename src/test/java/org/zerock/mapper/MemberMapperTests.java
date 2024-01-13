package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.model.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoin() throws Exception {
		MemberVO vo = new MemberVO();
		
		vo.setMemberId("Spring_test");
		vo.setMemberPw("Spring_test");
		vo.setMemberName("Spring_test");
		vo.setMemberMail("Spring_test");
		vo.setMemberAddr1("Spring_test");
		vo.setMemberAddr2("Spring_test");
		vo.setMemberAddr3("Spring_test");
		
		memberMapper.memberJoin(vo);
	}
	
//	@Test
//	public void memberLogin() throws Exception {
//		MemberVO vo = new MemberVO();
//		
//		vo.setMemberId("test2");
//		vo.setMemberPw("test2");
//		
//		memberMapper.memberLogin(vo);
//		log.info("°á°ú °ª: " + memberMapper.memberLogin(vo));
//	}
	
}
