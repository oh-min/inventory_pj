package org.inventory_pj.service;

import org.inventory_pj.model.OrderVO;

public interface OrderService {

	// food detail 개별 주문 목록
	public void submit_order(OrderVO ovo);
	
	//	order list 총 주문 목록
	public void submit_order_total(OrderVO ovo);
}
