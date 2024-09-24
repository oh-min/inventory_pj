package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.model.InventoryVO;
import org.inventory_pj.model.Order_detailVO;

public interface HallInvenService {
	public ArrayList<Order_detailVO> orderData();
	
	public InventoryVO nowInven();
}
