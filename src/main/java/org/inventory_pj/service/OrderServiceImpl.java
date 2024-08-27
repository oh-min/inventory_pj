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

	// food detail 개별 주문 목록
	@Override
	public void submit_order(Order_detailVO odvo) {
		System.out.println("submit_order 서비스 : " + odvo);

		om.submit_order(odvo);
	}

	// order list 총 주문 목록
	@Override
	public void submit_order_total(Order_totalVO otvo) {
		System.out.println("submit_order_total 서비스 : " + otvo);
		om.submit_order_total(otvo);
	};
}
