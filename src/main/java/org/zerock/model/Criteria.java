package org.zerock.model;

import lombok.Data;

@Data
public class Criteria {
	//���� ������ ��ȣ
	private int pageNum;
	//������ ǥ�� ����
	private int amount;
	//������ ��ŵ
	private int skip;
	//�˻� Ÿ��
	private String type;
	//�˻� Ű����
	private String keyword;
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1) * amount;
	}
	
	//�⺻ �Խù� ����
	public Criteria() {
		this(1, 10);
	}
	
	//�˻� Ÿ�� ������ �迭 ��ȯ
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	//������ ����Ʈ ���� �ѱ�� �۾�
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.skip = (pageNum-1) * this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
		this.skip = (this.pageNum -1) * this.amount;
	}

}
