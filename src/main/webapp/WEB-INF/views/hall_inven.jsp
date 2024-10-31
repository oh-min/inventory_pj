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
<script src="/resources/js/orderContent.js"></script>
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
				<div id="tableBox1">
					<table id="orderDataT">
						<thead>
							<tr id="orderDataTTh">
								<th>음식</th>
								<th>총 주문 갯수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${orderData}" var="orderData">
								<tr>
									<td>${orderData.food}</td>
									<td>${orderData.total_cnt}</td>
								</tr>
							</c:forEach>
						</tbody>
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
							<td id="chopstick"></td>
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
							<td>일회용 스푼</td>
							<td id="spoon"></td>
						</tr>
					</table>
				</div>
			</div>
			<div id="now_inven_box">
				<p class="tTitle">필요 및 주문 수량 요약</p>
				<!-- 사용 재고 데이터 확인 -->
				<p class="nonDisp" id="usedTacMBoxes"></p>
				<p class="nonDisp" id="usedTacLBoxes"></p>
				<p class="nonDisp" id="usedPaperTacBoxes"></p>
				<p class="nonDisp" id="usedSauceTacBoxes"></p>
				<p class="nonDisp" id="usedChopstickBoxes"></p>
				<p class="nonDisp" id="usedSpoonBoxes"></p>

				<!-- 주문 내역 테이블 -->
				<table id="nowInvenT">
					<tr id="nowInvenTTh">
						<th>용품</th>
						<th>현재 재고</th>
						<th>기준 재고</th>
						<th>필요 수량</th>
						<th>주문 수량</th>
					</tr>
					<tr>
						<td id="nameTacM">포장용기 M</td>
						<td id="nowInvenTacM" class="nonDisp">${nowInven.tacM}</td>
						<td id="availStockTacM" class="fontBold"></td>
						<td>10</td>
						<td id="reqTacM"></td>
						<td id="orderTacM" class="fontBold backY"></td>
					</tr>
					<tr>
						<td id="nameTacL">포장용기 L</td>
						<td id="nowInvenTacL" class="nonDisp">${nowInven.tacL}</td>
						<td id="availStockTacL" class="fontBold"></td>
						<td>10</td>
						<td id="reqTacL"></td>
						<td id="orderTacL" class="fontBold backY"></td>
					</tr>
					<tr>
						<td id="namePaperTac">종이 용기</td>
						<td id="nowInvenPaperTac" class="nonDisp">${nowInven.paperTac}</td>
						<td id="availStockPaperTac" class="fontBold"></td>
						<td>10</td>
						<td id="reqPaperTac"></td>
						<td id="orderPaperTac" class="fontBold backY"></td>
					</tr>
					<tr>
						<td id="nameSauceTac">소스 용기</td>
						<td id="nowInvenSauceTac" class="nonDisp">${nowInven.sauceTac}</td>
						<td id="availStockSauceTac" class="fontBold"></td>
						<td>10</td>
						<td id="reqSauceTac"></td>
						<td id="orderSauceTac" class="fontBold backY"></td>
					</tr>

					<tr>
						<td id="nameChopstick">나무 젓가락</td>
						<td id="nowInvenChopstick" class="nonDisp">${nowInven.chopstick}</td>
						<td id="availStockChopstick" class="fontBold"></td>
						<td>10</td>
						<td id="reqChopstick"></td>
						<td id="orderChopstick" class="fontBold backY"></td>
					</tr>
					<tr>
						<td id="nameSpoon">일회용 스푼</td>
						<td id="nowInvenSpoon" class="nonDisp">${nowInven.spoon}</td>
						<td id="availStockSpoon" class="fontBold"></td>
						<td>10</td>
						<td id="reqSpoon"></td>
						<td id="orderSpoon" class="fontBold backY"></td>
					</tr>
				</table>
				<button id="contentBtn" onclick="writeContent()">이메일 내용 작성 →</button>
			</div>
			<div id="order_inven_box">
				<p class="tTitle">재고 주문 요청</p>
				<textarea id="orderContent"></textarea>
				
			</div>
		</div>
		<div class=" email_box">
			<div id="email_btn_box">이메일 발송 API</div>
		</div>

	</div>
	<div class="footer_content"></div>
</body>
</html>