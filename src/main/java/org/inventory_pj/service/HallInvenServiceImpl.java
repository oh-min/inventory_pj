package org.inventory_pj.service;

import java.util.ArrayList;

import org.inventory_pj.mapper.HallInvenMapper;
import org.inventory_pj.model.Order_detailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallInvenServiceImpl implements HallInvenService {

	@Autowired
	HallInvenMapper him;

	public ArrayList<Order_detailVO> orderData() {
		System.out.println("hall inven service chk");

		return him.orderData();
	}
}
