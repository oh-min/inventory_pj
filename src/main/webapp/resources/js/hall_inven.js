/**
 * 
 */
window.onload = function() {
	/* 오늘 날짜와 비교하여 가장 최근에 지난 금요일 날짜 */
	let today = new Date(); // 현재 날짜 가져오기

	// 현재 요일을 가져오기 (0 = 일요일, 1 = 월요일, ..., 6 = 토요일)
	let todayDate = today.getDay();

	// 며칠을 빼야 하는지 계산
	let minusDay = (todayDate + 2) % 7;

	// 새로운 날짜 객체를 생성하고, 계산한 날 수 만큼 빼기
	let lastFriday = new Date(today);
	lastFriday.setDate(today.getDate() - minusDay);
	// console.log(lastFriday);

	lastFriday = lastFriday.getFullYear() + "." + (lastFriday.getMonth() + 1) + "." + lastFriday.getDate();
	console.log(lastFriday);


	/* 오늘 날짜와 비교하여 앞으로 다가올 가장 가까운 목요일 날짜 */

	// 목요일까지의 일수를 계산
	let plusDay = (7 + 4 - todayDate) % 7;

	// 현재 날짜에 계산된 일수를 더하여 다음 목요일 날짜를 구하기
	let nextThursday = new Date(today);
	nextThursday.setDate(today.getDate() + plusDay);
	// console.log(nextThursday);

	nextThursday = nextThursday.getFullYear() + "." + (nextThursday.getMonth() + 1) + "." + nextThursday.getDate();
	console.log(nextThursday);

	let period = document.getElementById("period");
	period.value = lastFriday + " ~ " + nextThursday;
	// console.log(period.value)

};

