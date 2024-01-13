package org.zerock.mapper;

import org.zerock.model.MemberVO;

public interface MemberMapper {
	
	public void memberJoin(MemberVO member);

	public int idCheck(String memberId);
	
	public MemberVO memberLogin(MemberVO member);
	
}
