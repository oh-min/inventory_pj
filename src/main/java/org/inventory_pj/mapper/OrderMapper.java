package org.inventory_pj.mapper;

import org.inventory_pj.model.OrderVO;

public interface OrderMapper {

	// food detail ���� �ֹ� ���
	public void submit_order(OrderVO ovo);
	
	//	order list �� �ֹ� ���
	public void submit_order_total(OrderVO ovo);
	
}
