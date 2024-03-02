package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.model.AuthorVO;
import org.zerock.model.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AuthorMapperTests {
	
	@Autowired
	private AuthorMapper mapper;
	
	@Test
	public void authorEnroll() throws Exception {
		AuthorVO author = new AuthorVO();
		
		author.setNationId("01");
		author.setAuthorName("�׽�Ʈ");
		author.setAuthorIntro("�׽�Ʈ �Ұ�");
		
		mapper.authorEnroll(author);
	}
	
	@Test
	public void authorEetTest() throws Exception {
		Criteria cri = new Criteria(3, 10);
		
		List<AuthorVO> list = mapper.authorGetList(cri);
		
		for(int i=0; i<list.size(); i++) {
			log.info("list" + i + "......." + list.get(i));
		}
	}
	
	@Test
	public void authorGetTotalTest() throws Exception {
		Criteria cri = new Criteria();
		cri.setKeyword("��ȫ��");
		
		int total = mapper.authorGetTotal(cri);
		log.info("total... " + total);
	}
	
	@Test
	public void authorGetDetailTest() {
		int authorId = 30;
		
		AuthorVO author = mapper.authorGetDetail(authorId);
		log.info("author... "+author);
	}
	
	@Test
	public void authorModifyTest() {
		AuthorVO author = new AuthorVO();
		
		author.setAuthorId(1);
		log.info("���� ��.. " + mapper.authorGetDetail(author.getAuthorId()));
		
		author.setAuthorName("update");
		author.setNationId("01");
		author.setAuthorIntro("update complate");		
		
		mapper.authorModify(author);
		log.info("���� ��.. " + mapper.authorGetDetail(author.getAuthorId()));
	}
	
}
