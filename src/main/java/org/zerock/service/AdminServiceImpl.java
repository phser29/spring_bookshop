package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.AdminMapper;
import org.zerock.model.BookVO;
import org.zerock.model.CateVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public void bookEnroll(BookVO book) throws Exception {
		log.info("service bookEnroll...");
		adminMapper.bookEnroll(book);
	}

	@Override
	public List<CateVO> cateList() throws Exception {
		log.info("service cateList..");
		return adminMapper.cateList();
	}
	
}
