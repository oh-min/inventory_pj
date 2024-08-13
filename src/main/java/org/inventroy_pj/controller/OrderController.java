package org.inventroy_pj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.inventory_pj.model.OrderVO;
import org.inventory_pj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

	@Autowired
	OrderService os;

	/* 주문페이지로 이동하기 */
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public void order() {

	};

	/* food detail 개별 주문 목록 */
	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Object submit_order(HttpSession session, HttpServletRequest req) throws Exception {
		System.out.println("controller 연결완료"); // 여기 까지 완료

		Map<String, Object> resultMap = new HashMap<String, Object>();
		// ajax를 통해 넘어온 배열 데이터 선언

		String[] order_num = req.getParameterValues("order_num");
		String[] regdate = req.getParameterValues("regdate");
		String[] table_num = req.getParameterValues("table_num");
		String[] total_price = req.getParameterValues("total_price");
		String[] food = req.getParameterValues("food");
		String[] cnt = req.getParameterValues("cnt");
		String[] price = req.getParameterValues("price");

		try {
			if (order_num != null && order_num.length > 0) {
				for (int i = 0; i < order_num.length; i++) {
					System.out.println("주문 번호 : " + i + " : " + order_num[i]);
					System.out.println("주문 시간 : " + i + " : " + regdate[i]);
					System.out.println("테이블 번호 : " + i + " : " + table_num[i]);
					System.out.println("총 가격 : " + i + " : " + total_price[i]);
					System.out.println("음식 : " + i + " : " + food[i]);
					System.out.println("갯수 : " + i + " : " + cnt[i]);
					System.out.println("가격 : " + i + " : " + price[i]);

					// food detail 개별 주문 목록(주문 번호, 테이블 번호, 음식, 갯수, 가격)
					OrderVO ovo2 = new OrderVO();

					ovo2.setOrder_num(order_num[i]);
					ovo2.setTable_num(table_num[i]);
					ovo2.setFood(food[i]);
					ovo2.setCnt(cnt[i]);
					ovo2.setPrice(price[i]);

					System.out.println(ovo2);

					os.submit_order(ovo2); // OrderVO 객체를 서비스로 전달

				}
				// order list 총 주문 목록(주문 번호, 주문 시간, 테이블 번호, 총 가격)
				OrderVO ovo1 = new OrderVO();

				ovo1.setOrder_num(order_num[0]);
				ovo1.setRegdate(regdate[0]);
				ovo1.setTable_num(table_num[0]);
				ovo1.setTotal_price(total_price[0]);

				System.out.println(ovo1);

				os.submit_order_total(ovo1); // OrderVO 객체를 서비스로 전달

				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}


}