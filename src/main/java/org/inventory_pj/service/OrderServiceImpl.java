package org.inventory_pj.service;

import org.inventory_pj.mapper.OrderMapper;
import org.inventory_pj.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper om;

	// food detail ���� �ֹ� ���
	@Override
	public void submit_order(OrderVO ovo) {
		System.out.println("submit_order ���� : " + ovo);

		om.submit_order(ovo);
	}

	// order list �� �ֹ� ���
	@Override
	public void submit_order_total(OrderVO ovo) {
		System.out.println("submit_order_total ���� : " + ovo);
		om.submit_order_total(ovo);
	};
}
