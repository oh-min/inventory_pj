package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	private String order_num; // �ֹ���ȣ
	private String regdate; // �ֹ��ð�
	private String table_num; // ���̺� ��ȣ
	private String total_price; // �� ����
	private String food; // ���� �̸�
	private String cnt; // ����
	private String price; // �ֹ��� ���� 1�� ���� * ����
}
