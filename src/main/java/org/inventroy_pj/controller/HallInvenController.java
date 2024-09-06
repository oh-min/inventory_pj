package org.inventroy_pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HallInvenController {
	/* 홀 재고 페이지로 이동하기 */
	@RequestMapping(value = "/hall_inven", method = RequestMethod.GET)
	public void hall_inven() {

	};
}
