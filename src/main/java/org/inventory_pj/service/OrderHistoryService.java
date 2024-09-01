package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;

public interface OrderHistoryService {
	// order list 총 주문 목록
	public ArrayList<Order_detailVO> history_total_list(CriteriaVO cvo);

	// 전체 건수
	public int total(CriteriaVO cvo);
	
	// 특정 주문번호의 디테일
	public ArrayList<Order_detailVO> detail(Order_detailVO odvo);
	
	// 특정 주문번호의 total
	public ArrayList<Order_totalVO> order_total(Order_totalVO otvo);
}
