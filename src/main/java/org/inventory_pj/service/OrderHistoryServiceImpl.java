package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.mapper.OrderHistoryMapper;
import org.inventory_pj.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	OrderHistoryMapper ohm;

	// order list √— ¡÷πÆ ∏Ò∑œ
	public ArrayList<OrderVO> history_total_list() {
		return ohm.history_total_list();
	};
}
