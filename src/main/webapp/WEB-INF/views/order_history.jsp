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
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="history_box">
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
							<td>${history_list.order_num}</td>
							<td>${history_list.total_price}</td>
							<td>${history_list.table_num}</td>
							<td>${history_list.regdate}</td>
						</tr>
					</c:forEach>


				</table>
			</div>
			<div class="paging_box">
				<c:if test="${paging.prev}">
					<a href="/order_history?page_num=${paging.start_page-1}&amount=${paging.cvo.amount}">이전</a>
				</c:if>
			
				<c:forEach begin="${paging.start_page}" end="${paging.end_page}" var="num">
					<a href="/order_history?page_num=${num}&amount=${paging.cvo.amount}">${num}</a>
				</c:forEach>
				
				<c:if test="${paging.next}">
					<a href="/order_history?page_num=${paging.end_page+1}&amount=${paging.cvo.amount}">다음</a>
				</c:if>
				
				
				
			</div>
		</div>

	</div>
	<div class="footer_content"></div>
</body>
</html>