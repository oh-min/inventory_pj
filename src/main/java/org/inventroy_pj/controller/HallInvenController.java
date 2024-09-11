package org.inventroy_pj.controller;

import java.io.IOException;

import org.inventory_pj.service.HallInvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HallInvenController {

	@Autowired
	HallInvenService his;

	/* 홀 재고관리 페이지 이동 */
	@RequestMapping(value = "/hall_inven", method = RequestMethod.GET)
	public void hall_inven(Model model) throws IOException {
		model.addAttribute("orderData", his.orderData());

		System.out.println(his.orderData());
	};

}
