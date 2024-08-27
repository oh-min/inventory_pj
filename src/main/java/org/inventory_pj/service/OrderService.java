package org.inventory_pj.service;

import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;

public interface OrderService {

	// food detail 개별 주문 목록
	public void submit_order(Order_detailVO odvo);
	
	//	order list 총 주문 목록
	public void submit_order_total(Order_totalVO otvo);
}
