package org.inventory_pj.service;

import org.inventory_pj.mapper.OrderMapper;
import org.inventory_pj.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper om;

	// food detail 개별 주문 목록
	@Override
	public void submit_order(OrderVO ovo) {
		System.out.println("submit_order 서비스 : " + ovo);

		om.submit_order(ovo);
	}

	// order list 총 주문 목록
	@Override
	public void submit_order_total(OrderVO ovo) {
		System.out.println("submit_order_total 서비스 : " + ovo);
		om.submit_order_total(ovo);
	};
}
