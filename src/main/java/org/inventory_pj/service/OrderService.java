package org.inventory_pj.service;

import org.inventory_pj.model.OrderVO;

public interface OrderService {

	// food detail ���� �ֹ� ���
	public void submit_order(OrderVO ovo);
	
	//	order list �� �ֹ� ���
	public void submit_order_total(OrderVO ovo);
}
