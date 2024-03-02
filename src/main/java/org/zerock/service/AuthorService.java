package org.zerock.service;

import java.util.List;

import org.zerock.model.AuthorVO;
import org.zerock.model.Criteria;

public interface AuthorService {
	
	public void authorEnroll(AuthorVO author) throws Exception;
	
	public List<AuthorVO> authorGetList(Criteria cri) throws Exception;
	
	public int authorGetTotal(Criteria cri) throws Exception;
	
	public AuthorVO authorGetDetail(int authorId) throws Exception;
	
	public int authorModify(AuthorVO authorVO) throws Exception;
}
