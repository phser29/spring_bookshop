package org.zerock.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorVO {
	//작가 ID
	private int authorId;
	//작가 이름
	private String authorName;
	//국가 ID
	private String nationId;
	//국가 이름
	private String nationName;
	//작가 소개
	private String authorIntro;
	//생성 날짜
	private Date regDate;
	//수정 날짜
	private Date updateDate;
	
	//nationId에 대한 name 지정
	public void setNationId(String nationId) {
		this.nationId = nationId;
		if(nationId.equals("01")) {
			this.nationName = "국내";
		} else {
			this.nationName = "국외";
		}
	}
}
