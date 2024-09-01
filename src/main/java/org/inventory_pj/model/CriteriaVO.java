package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CriteriaVO {
	private int page_num; // 페이지 번호
	private int amount; // 한 페이지 당 게시물 갯수
	
	private String start_date; // 시작 날짜
	private String end_date; // 끝 날짜
	private String search_period; // 검색 기간

	public CriteriaVO() {
		this(1, 10);
	}

	public CriteriaVO(int page_num, int amount) {
		this.page_num = page_num;
		this.amount = amount;
	}

}
