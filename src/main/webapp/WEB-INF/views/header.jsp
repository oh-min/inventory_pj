<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="left-content">
	<a href="/">Inventory</a>
</div>

<!-- (임시) 매니저 로그인시 -> 매니저, 홀 로그인시 -> 홀, 주방 로그인시 -> 주방 -->
<div class="right-content">

	<!-- 비로그인시 -->
	<c:if test="${empty user}">
	외부인
	</c:if>
	<!-- 로그인시 -->
	<c:if test="${not empty user}">
	${user.username}
	<button class="logout" onClick="location.href='/logout'">logout</button>
	</c:if>

</div>
