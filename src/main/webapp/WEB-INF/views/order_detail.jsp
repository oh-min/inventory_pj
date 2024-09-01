<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/order_detail.css" />
<script src="/resources/js/order_detail.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="detail_box">
			<div class="content_box">
				<table border="1">
					<tr>
						<td colspan="4">주문 번호 : ${order_total[0].order_num}</td>
					</tr>
					<tr>
						<td colspan="2" id="table_num">T ${order_total[0].table_num}</td>
						<td colspan="2">${order_total[0].regdate}</td>
					</tr>
					<tr>
						<td colspan="2">음식</td>
						<td id="cnt">갯수</td>
						<td>가격($)</td>
					</tr>
					<c:forEach items="${detail}" var="detail">
						<tr>
							<td colspan="2">${detail.food}</td>
							<td>${detail.cnt}</td>
							<td>${detail.price}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4">총 액($) ${order_total[0].total_price}</td>
					</tr>
				</table>
			</div>
			<div class="back_box">
				<button id="back_btn" onclick="go_back()">목록으로</button>
			</div>
		</div>
	</div>
	<div class="footer_content"></div>
</body>
</html>