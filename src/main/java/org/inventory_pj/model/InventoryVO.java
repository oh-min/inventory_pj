package org.inventory_pj.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InventoryVO {
	private String tac_category; // 포장용기 카테고리

	private String paperTac; // 종이 용기
	private String sauceTac; // 소스 용기
	private String tacM; // 포장용기 M
	private String tacL; // 포장용기 L
	private String chopstick; // 나무 젓가락
	private String spoon; // 나무 숫가락

}
