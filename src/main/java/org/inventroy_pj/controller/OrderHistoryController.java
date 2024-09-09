package org.inventroy_pj.controller;

import org.inventory_pj.model.CriteriaVO;
import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;
import org.inventory_pj.model.PageVO;
import org.inventory_pj.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderHistoryController {

	@Autowired
	OrderHistoryService ohs;

	/* 주문 내역 페이지 이동 */
	@RequestMapping(value = "/order_history", method = RequestMethod.GET)
	public String order_history(Model model, CriteriaVO cvo) {

		// 주문 내역 리스트
		model.addAttribute("history_list", ohs.history_total_list(cvo));

		System.out.println(cvo);
		System.out.println(ohs.history_total_list(cvo));
		
		// 주문 내역 페이징 처리
		int total = ohs.total(cvo);
		model.addAttribute("paging", new PageVO(cvo, total));
		// System.out.println(cvo.getStart_date().getClass().getName());
		return "/order_history";
	};

	/* 주문 상세 내역 */
	@RequestMapping(value = "/order_detail", method = RequestMethod.GET)
	public String order_detail(Order_detailVO odvo, Model model, Order_totalVO otvo) {

		model.addAttribute("detail", ohs.detail(odvo));
		model.addAttribute("order_total",ohs.order_total(otvo));
		
		return "/order_detail";
	}
}
