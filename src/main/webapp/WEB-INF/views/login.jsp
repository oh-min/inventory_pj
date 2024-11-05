<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>로그인</h2>
<form action="/login" method="post">
	<label for="username">유저이름</label><input type="text" id="username" name="username" required> <br> <br> <label for="password">비밀번호</label><input
		type="password" id="password" name="pw" required> <br> <br> <input id="login_btn" type="submit" value="로그인"
		onclick="submit_form()">
</form>
