package org.inventroy_pj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.inventory_pj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		String[] arrStr = req.getParameterValues("arrStr");
		try {
			if (arrStr != null && arrStr.length > 0) {
				for (int i = 0; i < arrStr.length; i++) {
					System.out.println("ajax traditional result : " + i + " : " + arrStr[i]);
				}
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	/*
	 * @RequestMapping(value = "/order", method = { RequestMethod.POST }) public
	 * void submit_order(@RequestParam Map<String, Object> map) {
	 * System.out.println(map); System.out.println((String) map.get("order_num"));
	 * // Object여서 형 변환
	 * 
	 * }
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/order", method = RequestMethod.POST) public
	 * Map<String, Object> submit_order2(HttpSession session, HttpServletRequest
	 * req) throws Exception { Map<String, Object> resultMap = new HashMap<String,
	 * Object>();
	 * 
	 * Enumeration<String> parameterNames = req.getParameterNames(); String
	 * param_name; String[] param_values;
	 * 
	 * while (parameterNames.hasMoreElements()) { param_name =
	 * parameterNames.nextElement(); param_values =
	 * req.getParameterValues(param_name); System.out.println(param_name + ": " +
	 * Arrays.toString(param_values));
	 * 
	 * } return null; };
	 */

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/order", method = RequestMethod.POST) public
	 * Map<String, Object> submit_order2(HttpSession session, HttpServletRequest
	 * req) throws Exception { Map<String, Object> resultMap = new HashMap<String,
	 * Object>();
	 * 
	 * Enumeration<String> parameterNames = req.getParameterNames();
	 * 
	 * String param_name; String[] param_values;
	 * 
	 * while (parameterNames.hasMoreElements()) { param_name =
	 * parameterNames.nextElement(); param_values =
	 * req.getParameterValues(param_name); System.out.println(param_name + ": " +
	 * Arrays.toString(param_values));
	 * 
	 * }
	 * 
	 * // String[] order_num_str = req.getParameterValues("order_num_str");
	 * //System.out.println("111order_num_str: " + Arrays.toString(order_num_str));
	 * 
	 * // ajax를 통해 넘어온 배열 데이터 선언 // String[] regdate_str
	 * =req.getParameterValues("regdate_str"); // String[] table_num_str
	 * =req.getParameterValues("table_num_str"); // String[] total_price_str
	 * =req.getParameterValues("total_price_str"); // String[] food_str
	 * =req.getParameterValues("food_str"); // String[] cnt_str
	 * =req.getParameterValues("cnt_str"); // String[] price_str
	 * =req.getParameterValues("price_str");
	 * 
	 * // System.out.println("2order_num_str: " + Arrays.toString(order_num_str));
	 * // System.out.println("2regdate_str: " + Arrays.toString(regdate_str));
	 * //System.out.println("table_num_str: " + Arrays.toString(table_num_str)); //
	 * System.out.println("total_price_str: " + Arrays.toString(total_price_str));
	 * // System.out.println("food_str: " + Arrays.toString(food_str));
	 * //System.out.println("cnt_str: " + Arrays.toString(cnt_str));
	 * //System.out.println("price_str: " + Arrays.toString(price_str));
	 * 
	 * // String chk = Arrays.toString(order_num_str); //
	 * System.out.println("====="+ chk); // System.out.println("******" +
	 * order_num_str.length);
	 * 
	 * // int len = order_num_str.length; // System.out.println(len + " 번 반복");
	 * //받아온 데이터 이름, 값 확인
	 * 
	 * 
	 * //try { if (len > 0) { for (int i = 0; i < len; i++) { // OrderVO 객체 생성 for
	 * food_detail // OrderVO ovo = new OrderVO();
	 * 
	 * // 각 필드에 데이터 설정 // ovo.setOrder_num(order_num_str[i]); //
	 * ovo.setTable_num(table_num_str[i]); // ovo.setFood(food_str[i]); //
	 * ovo.setCnt(cnt_str[i]); ovo.setPrice(price_str[i]);
	 * 
	 * // os.submit_order(ovo); // OrderVO 객체를 서비스로 전달
	 * 
	 * // OrderVO 객체 생성 for order list // OrderVO ovo2 = new OrderVO();
	 * 
	 * // ovo2.setOrder_num(order_num_str[0]); //
	 * ovo2.setTable_num(table_num_str[0]); // ovo2.setRegdate(regdate_str[0]); //
	 * ovo2.setTotal_price(total_price_str[0]);
	 * 
	 * // os.submit_order_total(ovo2); // OrderVO 객체를 서비스로 전달
	 * 
	 * // resultMap.put("result", "success"); } else { resultMap.put("result", //
	 * "fault");
	 * 
	 * // } } catch (Exception e) { e.printStackTrace(); resultMap.put("result", //
	 * "error"); }
	 * 
	 * return null; // JSON 응답으로 반환 } } };
	 */

}