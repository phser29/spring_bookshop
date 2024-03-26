package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.model.BookVO;
import org.zerock.model.CateVO;
import org.zerock.model.Criteria;

@Mapper
public interface AdminMapper {
	
	public void bookEnroll(BookVO book) throws Exception;
	
	public List<CateVO> cateList() throws Exception;
	
	public List<BookVO> goodsGetList(Criteria cri);
	
	public int goodsGetTotal(Criteria cri);
}
