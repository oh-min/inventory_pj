package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;

public interface OrderHistoryService {
	// order list 목록
	public ArrayList<Order_detailVO> history_total_list(CriteriaVO cvo);

	// 전체 개수
	public int total(CriteriaVO cvo);
	
	// 상세 정보 가져오기
	public ArrayList<Order_detailVO> detail(Order_detailVO odvo);
	
	// 상세 정보 total
	public ArrayList<Order_totalVO> order_total(Order_totalVO otvo);
}
