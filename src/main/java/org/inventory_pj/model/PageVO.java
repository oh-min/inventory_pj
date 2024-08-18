package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {
	private int start_page; // 시작번호
	private int end_page; // 끝번호
	private boolean prev; // 이전버튼
	private boolean next; // 다음버튼
	private CriteriaVO cvo; // CritertaVO를 포함
	private int total; // board테이블의 전체건수를 저장

	public PageVO(CriteriaVO cvo, int total) {
		this.cvo = cvo;
		this.total = total;

		// 시작번호, 끝번호, 이전버튼, 다음버튼 계산
		this.end_page = (int) (Math.ceil(cvo.getPage_num() / 10.0)) * 15; // 끝번호
		this.start_page = this.end_page - 14; // 시작번호
		int realEnd = (int) (Math.ceil((total * 1.0) / cvo.getAmount())); // 마지막 페이지 번호

		// 마지막 페이지 번호 < 끝번호 인 경우
		if (realEnd < this.end_page) {
			this.end_page = realEnd;
		}
		this.prev = this.start_page > 1; // startPage가 1보다 크면 이전버튼 활성화
		this.next = this.end_page < realEnd; // endPage가 realEnd 보다 작으면
	}

}
