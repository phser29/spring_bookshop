package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.model.AuthorVO;
import org.zerock.model.Criteria;

@Mapper
public interface AuthorMapper {
	
	public void authorEnroll(AuthorVO author);
	
	public List<AuthorVO> authorGetList(Criteria cri);
	
	public int authorGetTotal(Criteria cri);
	
	public AuthorVO authorGetDetail(int authorId);
	
	public int authorModify(AuthorVO author);
}
