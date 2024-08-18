package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {
	private int start_page; // ���۹�ȣ
	private int end_page; // ����ȣ
	private boolean prev; // ������ư
	private boolean next; // ������ư
	private CriteriaVO cvo; // CritertaVO�� ����
	private int total; // board���̺��� ��ü�Ǽ��� ����

	public PageVO(CriteriaVO cvo, int total) {
		this.cvo = cvo;
		this.total = total;

		// ���۹�ȣ, ����ȣ, ������ư, ������ư ���
		this.end_page = (int) (Math.ceil(cvo.getPage_num() / 10.0)) * 15; // ����ȣ
		this.start_page = this.end_page - 14; // ���۹�ȣ
		int realEnd = (int) (Math.ceil((total * 1.0) / cvo.getAmount())); // ������ ������ ��ȣ

		// ������ ������ ��ȣ < ����ȣ �� ���
		if (realEnd < this.end_page) {
			this.end_page = realEnd;
		}
		this.prev = this.start_page > 1; // startPage�� 1���� ũ�� ������ư Ȱ��ȭ
		this.next = this.end_page < realEnd; // endPage�� realEnd ���� ������
	}

}
