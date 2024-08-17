<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/login.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
<script src="/resources/js/login.js"></script>
<script src="/resources/js/main.js"></script>

</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<!-- 기본 페이지 -->
		<c:if test="${empty user}">
			<div class="login_container">
				<%@include file="login.jsp"%>
			</div>
		</c:if>
		<!-- 로그인한 페이지 -->
		<c:if test="${not empty user}">
			<div class="main_container">
				<%@include file="main.jsp"%>
			</div>
		</c:if>

	</div>
	<div class="footer_content">
	</div>
</body>
</html>
