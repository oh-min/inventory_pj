<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/login.css" />
<script src="/resources/js/login.js"></script>

</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<div class="login_content">
			<h2>로그인</h2>
			<form action="/login" method="post">
				<label for="username">유저이름</label><input type="text" id="username" name="username" required> <br> <br> <label for="password">비밀번호</label><input
					type="password" id="password" name="password" required> <br> <br> <input id="login_btn" type="submit" value="로그인"
					onclick="submit_form()">
			</form>
			<input id="find_pw" type="button" value="비밀번호 찾기">

		</div>
	</div>

</body>
</html>
