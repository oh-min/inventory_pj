package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.OrderVO;

public interface OrderHistoryService {
	// order list �� �ֹ� ���
	public ArrayList<OrderVO> history_total_list(CriteriaVO cvo);

	// ��ü �Ǽ�
	public int total();
}
