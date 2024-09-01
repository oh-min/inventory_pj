package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;

public interface OrderHistoryService {
	// order list �� �ֹ� ���
	public ArrayList<Order_detailVO> history_total_list(CriteriaVO cvo);

	// ��ü �Ǽ�
	public int total(CriteriaVO cvo);
	
	// Ư�� �ֹ���ȣ�� ������
	public ArrayList<Order_detailVO> detail(Order_detailVO odvo);
	
	// Ư�� �ֹ���ȣ�� total
	public ArrayList<Order_totalVO> order_total(Order_totalVO otvo);
}
