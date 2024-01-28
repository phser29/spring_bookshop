package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.model.AuthorVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorServiceTests {

	@Autowired
	private AuthorService authorService;
	
	@Test
	public void authorEnrollTest() throws Exception {
		AuthorVO author = new AuthorVO();
		
		author.setNationId("01");
		author.setAuthorName("�׽�Ʈ");
		author.setAuthorIntro("�׽�Ʈ �Ұ�");
		
		authorService.authorEnroll(author);
	}
	
}

