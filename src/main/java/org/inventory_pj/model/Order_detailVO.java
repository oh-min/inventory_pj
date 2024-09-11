package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order_detailVO {
	private String order_num; // 주문번호
	private String table_num; // 테이블 번호
	private String food; // 음식 일므
	private String cnt; // 갯수
	private String price; // 가격
	private String total_cnt; // 총 갯수
}
