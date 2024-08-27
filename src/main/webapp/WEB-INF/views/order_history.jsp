<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/history.css" />
<script src="/resources/js/order_history.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- Datepicker jQuery UI CSS 파일 -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Datepicker jQuery 기본 js 파일 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- Datepicker jQuery UI 라이브러리 js 파일 -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="history_box">
			<div class="search_box">
				<!--  <select onchange="javascript:period(this)"> -->
				<select>
					<option>전체</option>
					<option id="one_w" value="one_w">1주일</option>
					<option id="one_m" value="one_m">1개월</option>
					<option id="three_m" value="three_m">3개월</option>
					<option id="six_m" value="six_m">6개월</option>
				</select> <input type="text" id="start_date" name="start_date" readonly oninput="done_fcn(5)"> <input type="text" id="end_date" name="end_date"
					readonly oninput="done_fcn(5)"> <input type="button" value="Search">
			</div>
			<div class="content_box">
				<table>
					<tr>
						<th>주문 번호</th>
						<th>총 가격($)</th>
						<th>테이블 번호</th>
						<th>주문 시간</th>
					</tr>
					<c:forEach items="${history_list}" var="history_list">
						<tr>
							<td class="on"><a href="/order_detail?order_num=${history_list.order_num}">${history_list.order_num}</a></td>
							<td>${history_list.total_price}</td>
							<td>${history_list.table_num}</td>
							<td>${history_list.regdate}</td>
						</tr>
					</c:forEach>


				</table>
			</div>
			<div class="paging_box">
				<div class="prev_btn">
					<c:if test="${paging.prev}">
						<a href="/order_history?page_num=${paging.start_page-1}&amount=${paging.cvo.amount}">&lt;</a>
					</c:if>
				</div>
				<div class="paging_num">
					<c:forEach begin="${paging.start_page}" end="${paging.end_page}" var="num">
						<a href="/order_history?page_num=${num}&amount=${paging.cvo.amount}" id="${num}" class="nomal_num">${num}</a>
					</c:forEach>
				</div>
				<div class="next_btn">
					<c:if test="${paging.next}">
						<a href="/order_history?page_num=${paging.end_page+1}&amount=${paging.cvo.amount}">&gt;</a>
					</c:if>
				</div>

			</div>
		</div>

	</div>
	<div class="footer_content"></div>
</body>
</html>