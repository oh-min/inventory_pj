package org.inventory_pj.service;

import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;

public interface OrderService {

	// food detail ���� �ֹ� ���
	public void submit_order(Order_detailVO odvo);
	
	//	order list �� �ֹ� ���
	public void submit_order_total(Order_totalVO otvo);
}
