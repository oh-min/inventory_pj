package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order_totalVO {
	private String order_num; // 주문번호
	private String regdate; // 주문시간
	private String table_num; // 테이블 번호
	private String total_price; // 총 가격
}
