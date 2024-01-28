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
	
	private int authorId;
	private String authorName;
	private String nationId;
	private String nationName;
	private String authorIntro;
	private Date regDate;
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
