package org.inventroy_pj.controller;

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
	public void order_history(Model model) {

		// �ֹ����� �������� �̵��� �� ���� ��������
		model.addAttribute("history_list", ohs.history_total_list());
	};
}
