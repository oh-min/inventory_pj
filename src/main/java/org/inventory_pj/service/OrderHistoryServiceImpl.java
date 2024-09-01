package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.mapper.OrderHistoryMapper;
import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	OrderHistoryMapper ohm;

	// order list �� �ֹ� ���
	public ArrayList<Order_detailVO> history_total_list(CriteriaVO cvo) {
		return ohm.history_total_list(cvo);
	};

	// ��ü �Ǽ�
	public int total(CriteriaVO cvo) {
		return ohm.total(cvo);
	};

	// Ư�� �ֹ���ȣ�� ������
	public ArrayList<Order_detailVO> detail(Order_detailVO odvo) {
		return ohm.detail(odvo);
	};

	// Ư�� �ֹ���ȣ�� total
	public ArrayList<Order_totalVO> order_total(Order_totalVO otvo) {
		System.out.println("Ư�� �ֹ���ȣ�� total ���� ���� �Ϸ�");
		System.out.println(ohm.order_total(otvo));
		return ohm.order_total(otvo);
	};
}
