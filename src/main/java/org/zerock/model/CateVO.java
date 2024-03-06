package org.zerock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CateVO {
	
	//ī�װ� ���
	private int tier;
	//ī�װ� �̸�
	private String cateName;
	//ī�װ� �ѹ�
	private String cateCode;
	//���� ī�װ�
	private String cateParent;
	
}
