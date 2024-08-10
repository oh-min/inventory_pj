package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	private String order_num; // 주문번호
	private String regdate; // 주문시간
	private String table_num; // 테이블 번호
	private String total_price; // 총 가격
	private String food; // 음식 이름
	private String cnt; // 갯수
	private String price; // 주문한 음식 1개 가격 * 갯수
}
