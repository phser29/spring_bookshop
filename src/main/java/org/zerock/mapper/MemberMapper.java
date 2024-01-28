package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.model.MemberVO;

@Mapper
public interface MemberMapper {
	
	public void memberJoin(MemberVO member);

	public int idCheck(String memberId);
	
	public MemberVO memberLogin(MemberVO member);
	
}
