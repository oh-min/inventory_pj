package org.inventory_pj.mapper;

import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;

public interface OrderMapper {

	// food detail ���� �ֹ� ���
	public void submit_order(Order_detailVO odvo);
	
	//	order list �� �ֹ� ���
	public void submit_order_total(Order_totalVO otvo);
	
}
