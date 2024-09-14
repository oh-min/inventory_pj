/**
 * 
 */
window.addEventListener('load', function() {



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

	/* 주문내역 보기 <-> 용품 사용량 보기 */
	let orderTable = document.getElementById('orderDataT');
	let amountUsedTable = document.getElementById('amountUsedT');

	let orderViewBtn = document.getElementById('orderViewBtn');
	let amountUsedViewBtn = document.getElementById('amountUsedViewBtn');

	orderViewBtn.addEventListener('click', function() {
		orderTable.style.display = 'table';
		amountUsedTable.style.display = 'none';
	});

	amountUsedViewBtn.addEventListener('click', function() {
		orderTable.style.display = 'none';
		amountUsedTable.style.display = 'table';
	});

	/* 용품 사용량 */


});

function initialize(orderDataArr) {

	// console.log(orderDataArr)
	// console.log(typeof (orderDataArr)) // String


	let arr1 = [];
	let arr2 = [];
	let arr3 = [];
	let arr4 = [];
	let arr5 = [];
	orderDataArr.forEach(cat => {
		if (cat.tac_category === 'cat1') {
			console.log(typeof (cat.total_cnt))
			arr1.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat2') {
			arr2.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat3') {
			arr3.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat4') {
			arr4.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat5') {
			arr5.push(parseFloat(cat.total_cnt));
		}
	});
	//console.log(arr1)
	//console.log(arr2)
	//console.log(arr3)
	//console.log(arr4)
	//console.log(arr5)

	let arr1Sum = 0;
	for (let i = 0; i < arr1.length; i++) {
		arr1Sum += arr1[i];
	}
	console.log(arr1Sum)
	let arr2Sum = 0;
	for (let i = 0; i < arr2.length; i++) {
		arr2Sum += arr2[i];
	}
	console.log(arr2Sum)
	let arr3Sum = 0;
	for (let i = 0; i < arr3.length; i++) {
		arr3Sum += arr3[i];
	}
	console.log(arr3Sum)
	let arr4Sum = 0;
	for (let i = 0; i < arr4.length; i++) {
		arr4Sum += arr4[i];
	}
	console.log(arr4Sum)
	let arr5Sum = 0;
	for (let i = 0; i < arr5.length; i++) {
		arr5Sum += arr5[i];
	}
	console.log(arr5Sum)

}

