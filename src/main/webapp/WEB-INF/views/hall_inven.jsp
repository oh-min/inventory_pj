<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/hall_inven.css" />
<script src="/resources/js/hall_inven.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="inven_box">
			<div id="week_box">일주일치 주문 내역 및 사용량</div>
			<div id="now_inven_box">현재 재고</div>
			<div id="order_inven_box">주문할 내역</div>
		</div>
		<div class=" email_box">
			<div id="email_btn_box">이메일 발송 API</div>
		</div>

	</div>
	<div class="footer_content"></div>
</body>
</html>