package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.model.BookVO;

@Mapper
public interface AdminMapper {
	
	public void bookEnroll(BookVO book) throws Exception;
	
}
