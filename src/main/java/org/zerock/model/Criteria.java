package org.zerock.model;

import lombok.Data;

@Data
public class Criteria {
	//현재 페이지 번호
	private int pageNum;
	//페이지 표시 개수
	private int amount;
	//페이지 스킵
	private int skip;
	//검색 타입
	private String type;
	//검색 키워드
	private String keyword;
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;
	}
	
	//기본 게시물 갯수
	public Criteria() {
		this(1, 10);
	}
	
	//검색 타입 데이터 배열 변환
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	//페이지 리스트 개수 넘기는 작업
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.skip = (pageNum-1) * this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
		this.skip = (this.pageNum -1) * this.amount;
	}

}
