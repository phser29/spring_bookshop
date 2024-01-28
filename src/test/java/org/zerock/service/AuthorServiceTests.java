package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.model.AuthorVO;

import com.mysql.cj.log.Log;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AuthorServiceTests {

	@Autowired
	private AuthorService authorService;
	
	@Test
	public void authorEnrollTest() throws Exception {
		AuthorVO author = new AuthorVO();
		
		author.setNationId("01");
		author.setAuthorName("테스트");
		author.setAuthorIntro("테스트 소개");
		
		authorService.authorEnroll(author);
	}
	
	@Test
	public void authorGetDetailTest() throws Exception {
		int authorId = 20;
		log.info("author... " + authorService.authorGetDetail(authorId));
	}
	
}

