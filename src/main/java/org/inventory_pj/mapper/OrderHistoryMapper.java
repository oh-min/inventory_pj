package org.inventory_pj.mapper;

import java.util.ArrayList;

import org.inventory_pj.model.OrderVO;

public interface OrderHistoryMapper {
	// order list �� �ֹ� ���
	public ArrayList<OrderVO> history_total_list();
}
