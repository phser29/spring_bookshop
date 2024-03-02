package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.AuthorMapper;
import org.zerock.model.AuthorVO;
import org.zerock.model.Criteria;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorMapper mapper;
	
	@Override
	public void authorEnroll(AuthorVO author) throws Exception {
		mapper.authorEnroll(author);
	}

	@Override
	public List<AuthorVO> authorGetList(Criteria cri) throws Exception {
		return mapper.authorGetList(cri);
	}

	@Override
	public int authorGetTotal(Criteria cri) throws Exception {
		log.info("cri... " + cri);
		return mapper.authorGetTotal(cri);
	}

	@Override
	public AuthorVO authorGetDetail(int authorId) throws Exception {
		log.info("authorGetDetail.. " + authorId);
		return mapper.authorGetDetail(authorId);
	}

	@Override
	public int authorModify(AuthorVO authorVO) throws Exception {
		int author = mapper.authorModify(authorVO);
		return author;
	}
	
}
