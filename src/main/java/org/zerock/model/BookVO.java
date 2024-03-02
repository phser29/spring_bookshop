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
public class BookVO {
	//��ǰ ID
	private int bookId;
	//��ǰ �̸�
	private String bookName;
	//�۰� id
	private int authorId;
	//�۰� �̸�
	private String authorName;
	//������
	private String publeYear;
	//���ǻ�
	private String publisher;
	//ī�װ� �ڵ�
	private String cateCode;
	//ī�װ� �̸�
	private String cateName;
	//��ǰ ����
	private int bookPrice;
	//��ǰ ���
	private int bookStock;
	//��ǰ ������
	private double bookDiscount;
	//��ǰ �Ұ�
	private String bookIntro;
	//��ǰ ����
	private String bookContents;
	//��� ��¥
	private Date regDate;
	//���� ��¥
	private Date updateDate;
	
}
