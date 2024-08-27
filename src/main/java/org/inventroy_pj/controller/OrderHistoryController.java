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

	/* 주문내역페이지로 이동하기 */
	@RequestMapping(value = "/order_history", method = RequestMethod.GET)
	public String order_history(Model model, CriteriaVO cvo) {

		// 주문내역 페이지로 이동할 때 정보 가져오기
		model.addAttribute("history_list", ohs.history_total_list(cvo));

		// 페이징 처리
		int total = ohs.total();
		model.addAttribute("paging", new PageVO(cvo, total));

		return "/order_history";
	};

	/* 주문내역 디테일 팝업창 이동하기 */
	@RequestMapping(value = "/order_detail", method = RequestMethod.GET)
	public String order_detail(Order_detailVO odvo, Model model, Order_totalVO otvo) {
		System.out.println("주문내역 디테일 팝업창 이동 컨트롤러 연결 성공");

		model.addAttribute("detail", ohs.detail(odvo));
		model.addAttribute("order_total",ohs.order_total(otvo));
		
		return "/order_detail";
	}
}
