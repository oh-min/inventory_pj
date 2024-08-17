<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			${history_list}
				<table>
					<tr>
						<th>주문 번호</th>
						<th>총 가격($)</th>
						<th>테이블 번호</th>
						<th>주문 시간</th>
					</tr>
					<tr>
						<td>1111111111111</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>22222222222</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>3333333333</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>4444444444444</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>5555555555</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>666666666666</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>77777777777</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>8888888888</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>99999999999999</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>1010101010101010</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>1111111111111111</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>12121212121212</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>13131313131313</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>14141414141414</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>
					<tr>
						<td>15151515151515</td>
						<td>43</td>
						<td>2</td>
						<td>2023-12-02 10:30:23</td>
					</tr>

				</table>
			</div>
			<div class="paging_box">1 2 3 4 5 6 7 8 9</div>
		</div>

	</div>
	<div class="footer_content"></div>
</body>
</html>