package org.zerock.model;

import lombok.Data;

@Data
public class PageDTO {
	//������ ���� ��ȣ
	private int pageStart;
	//������ �� ��ȣ
	private int pageEnd;
	//����, ���� ��ư ���� ����
	private boolean next;
	private boolean prev;
	//�� ��ü ����
	private int total;
	
	//���������� ��ȣ(pageNum), �� ǥ�� ��(amount), �˻� Ű����(keyword), �˻� ����(type)
	private Criteria cri;
	
	//������(Ŭ���� ȣ�� �� �� ���� ��)
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		//������ �� ��ȣ
		this.pageEnd = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		//������ ���۹�ȣ
		this.pageStart = this.pageEnd - 9;
		
		//��ü ������ ������ ��ȣ
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount()));
		
		//������ ����ȣ ��ȿ�� üũ
		if(realEnd < pageEnd) {
			this.pageEnd = realEnd;
		}
		
		//���� ��ư
		this.prev = this.pageStart > 1;
		//���� ��ư
		this.next = this.pageEnd < realEnd;
	}
	
}
