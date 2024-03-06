package org.zerock.service;

import java.util.List;

import org.zerock.model.BookVO;
import org.zerock.model.CateVO;

public interface AdminService {
	
	public void bookEnroll(BookVO vo) throws Exception;
	
	public List<CateVO> cateList() throws Exception;
}
