package org.inventroy_pj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.inventory_pj.model.Order_detailVO;
import org.inventory_pj.model.Order_totalVO;
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
					Order_detailVO odvo = new Order_detailVO();

					odvo.setOrder_num(order_num[i]);
					odvo.setTable_num(table_num[i]);
					odvo.setFood(food[i]);
					odvo.setCnt(cnt[i]);
					odvo.setPrice(price[i]);

					System.out.println(odvo);

					os.submit_order(odvo); // OrderVO 객체를 서비스로 전달

				}
				// order list 총 주문 목록(주문 번호, 주문 시간, 테이블 번호, 총 가격)
				Order_totalVO otvo = new Order_totalVO();

				otvo.setOrder_num(order_num[0]);
				otvo.setRegdate(regdate[0]);
				otvo.setTable_num(table_num[0]);
				otvo.setTotal_price(total_price[0]);

				System.out.println(otvo);

				os.submit_order_total(otvo); // OrderVO 객체를 서비스로 전달

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