package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.mapper.OrderHistoryMapper;
import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	OrderHistoryMapper ohm;

	// order list 총 주문 목록
	public ArrayList<OrderVO> history_total_list(CriteriaVO cvo) {
		return ohm.history_total_list(cvo);
	};

	// 전체 건수
	public int total() {
		return ohm.total();
	};

	// 디테일
	public ArrayList<OrderVO> detail(OrderVO ovo) {
		System.out.println("디테일 서비스 연결완료");
		return ohm.detail(ovo);
	};
}
