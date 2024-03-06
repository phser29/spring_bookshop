package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.model.BookVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMapperTests {
	
	@Autowired
	private AdminMapper mapper;
	
	@Test
	public void bookEnrollTest() throws Exception {
		BookVO book = new BookVO();
		
		book.setBookName("mapper �׽�Ʈ");
		book.setAuthorId(123);
		book.setPubleYear("2021-03-18");
		book.setPublisher("���ǻ�");
		book.setCateCode("0231");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("å �Ұ�");
		book.setBookContents("å ����");
		
		mapper.bookEnroll(book);
	}
	
	@Test
	public void cateListTest() throws Exception {
		log.info("cateList().." + mapper.cateList());
		
	}
	
}
