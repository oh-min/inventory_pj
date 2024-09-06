/**
 * 
 */
window.onload = function() {

	// 오늘 날짜 (임시로 날짜 입력할 예정)
	let today = new Date(); // 현재 날짜
	console.log(today) // Sat Sep 07 2024 00:22:37 GMT+0900 (한국 표준시)

	let year = today.getFullYear(); // 년도
	let month = today.getMonth() + 1; // 월
	let date = today.getDate(); // 날짜
	let day = today.getDay(); // 요일
	console.log(year) // 2024
	console.log(month) // 9
	console.log(date) // 7
	console.log(day) // 6

	let hours = today.getHours(); // 시
	let minutes = today.getMinutes();  // 분
	let seconds = today.getSeconds();  // 초
	let milliseconds = today.getMilliseconds(); // 밀리초
	console.log(hours) // 0
	console.log(minutes) // 27
	console.log(seconds) //14
	console.log(milliseconds) // 772
	
	// 오늘 날짜와 비교하여 가장 최근에 지난 금요일 날짜
	// 오늘 날짜와 비교하여 앞으로 다가올 가장 가까운 목요일 날짜

}
