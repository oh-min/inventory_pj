package org.inventory_pj.mapper;

import java.util.ArrayList;

import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.OrderVO;

public interface OrderHistoryMapper {
	// order list 총 주문 목록
	public ArrayList<OrderVO> history_total_list(CriteriaVO cvo);
	
	// 전체 건수
	public int total();
}
