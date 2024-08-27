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

	/* �ֹ������������� �̵��ϱ� */
	@RequestMapping(value = "/order_history", method = RequestMethod.GET)
	public String order_history(Model model, CriteriaVO cvo) {

		// �ֹ����� �������� �̵��� �� ���� ��������
		model.addAttribute("history_list", ohs.history_total_list(cvo));

		// ����¡ ó��
		int total = ohs.total();
		model.addAttribute("paging", new PageVO(cvo, total));

		return "/order_history";
	};

	/* �ֹ����� ������ �˾�â �̵��ϱ� */
	@RequestMapping(value = "/order_detail", method = RequestMethod.GET)
	public String order_detail(Order_detailVO odvo, Model model, Order_totalVO otvo) {
		System.out.println("�ֹ����� ������ �˾�â �̵� ��Ʈ�ѷ� ���� ����");

		model.addAttribute("detail", ohs.detail(odvo));
		model.addAttribute("order_total",ohs.order_total(otvo));
		
		return "/order_detail";
	}
}
