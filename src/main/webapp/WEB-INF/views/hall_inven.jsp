<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/hall_inven.css" />
<script src="/resources/js/hall_inven.js"></script>
<script type="text/javascript">
	//let orderData = new Array(`${orderData}`);
	//orderData = `${orderData}`;
	//console.log(orderData)
	//console.log(typeof (orderData))

	let orderDataArr = new Array();
	<c:forEach items="${orderData}" var="orderData">
	orderDataArr.push({
		total_cnt : "${orderData.total_cnt}",
		tac_category : "${orderData.tac_category}"
	})
	</c:forEach>

	window.onload = function() {
		initialize(orderDataArr);
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="inven_box">
			<div id="week_box">
				<input type="text" id="period" class="day" readonly>
				<div id="viewBox">
					<input type="button" value="주문 내역 보기" class="viewBtn" id="orderViewBtn"> <input type="button" value="용품 사용량 보기" class="viewBtn"
						id="amountUsedViewBtn">
				</div>
				<!-- 주문 내역 테이블 -->
				<table id="orderDataT">
					<tr id="orderDataTTh">
						<th>음식</th>
						<th>총 주문 갯수</th>
					</tr>
					<c:forEach items="${orderData}" var="orderData">
						<tr>
							<td>${orderData.food}</td>
							<td>${orderData.total_cnt}</td>
						</tr>
					</c:forEach>
				</table>
				<!-- 용품 사용량 테이블 -->
				<table id="amountUsedT" style="display: none;">
					<tr id="amountUsedTTh">
						<th>용품</th>
						<th>사용량</th>
					</tr>
					<tr>
						<td>종이 용기</td>
						<td id="paperTac"></td>
					</tr>
					<tr>
						<td>소스 용기</td>
						<td id="sauceTac"></td>
					</tr>
					<tr>
						<td>나무 젓가락</td>
						<td id="wChopstick"></td>
					</tr>
					<tr>
						<td>포장용기 M</td>
						<td id="tacM"></td>
					</tr>
					<tr>
						<td>포장용기 L</td>
						<td id="tacL"></td>
					</tr>
					<tr>
						<td>나무 숫가락</td>
						<td id="wSpoon"></td>
					</tr>
				</table>
			</div>
			<div id="now_inven_box">
				현재 재고 ${nowInven}${nowInven.chopstick}
				<!-- 주문 내역 테이블 -->
				<table id="nowInvenT">
					<tr id="nowInvenTTh">
						<th>음식</th>
						<th>총 주문 갯수</th>
					</tr>
					<tr>
						<td>포장용기 M</td>
						<td>${nowInven.tacM}</td>
					</tr>
					<tr>
						<td>포장용기 L</td>
						<td>${nowInven.tacL}</td>
					</tr>
					<tr>
						<td>종이용기</td>
						<td>${nowInven.paperTac}</td>
					</tr>
					<tr>
						<td>소스용기</td>
						<td>${nowInven.sauceTac}</td>
					</tr>
<%-- 
					<tr>
						<td>나무젓가락</td>
						<td>${nowInven.wChopstick}</td>
					</tr> --%>
					<%--	<tr>
						<td>나무숫가락</td>
						<td>${nowInven.wSpoon}</td>
					</tr> --%>
				</table>
			</div>
			<div id="order_inven_box">주문할 내역</div>
		</div>
		<div class=" email_box">
			<div id="email_btn_box">이메일 발송 API</div>
		</div>

	</div>
	<div class="footer_content"></div>
</body>
</html>