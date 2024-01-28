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
	
	//nationId�� ���� name ����
	public void setNationId(String nationId) {
		this.nationId = nationId;
		if(nationId.equals("01")) {
			this.nationName = "����";
		} else {
			this.nationName = "����";
		}
	}
}