package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order_totalVO {
	private String order_num; // �ֹ���ȣ
	private String regdate; // �ֹ��ð�
	private String table_num; // ���̺� ��ȣ
	private String total_price; // �� ����
}
