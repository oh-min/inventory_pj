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

	public CriteriaVO() {
		this(1, 15);
	}

	public CriteriaVO(int page_num, int amount) {
		this.page_num = page_num;
		this.amount = amount;
	}

}
