package org.inventory_pj.service;

import org.inventory_pj.mapper.OrderMapper;
import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapper om;

	// food detail ���� �ֹ� ���
	@Override
	public void submit_order(Order_detailVO odvo) {
		System.out.println("submit_order ���� : " + odvo);

		om.submit_order(odvo);
	}

	// order list �� �ֹ� ���
	@Override
	public void submit_order_total(Order_totalVO otvo) {
		System.out.println("submit_order_total ���� : " + otvo);
		om.submit_order_total(otvo);
	};
}
