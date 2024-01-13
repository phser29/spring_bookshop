package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.MemberMapper;
import org.zerock.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void memberJoin(MemberVO member) throws Exception {
		
		memberMapper.memberJoin(member);
	}

	@Override
	public int idCheck(String memberId) {
		
		return memberMapper.idCheck(memberId);
	}

	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		
		return memberMapper.memberLogin(member);
	}
	
}
