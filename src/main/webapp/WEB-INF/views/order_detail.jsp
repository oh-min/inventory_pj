<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/order_detail.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="detail_box">
			<div class="content_box">${detail}</div>
		</div>
	</div>
	<div class="footer_content"></div>
</body>
</html>