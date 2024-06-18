<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/order.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="num_btn">
			<div class="table">
				Table<select>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>
			</div>
			<div class="btn">
				<button>ORDER</button>
			</div>
		</div>
		<div class="list_price">
			<div>음식 및 음료 목록</div>
			<div>
				<div>주문내역</div>
				<div>총액</div>
			</div>
		</div>
	</div>
</body>
</html>