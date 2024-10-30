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
	// console.log(lastFriday);


	/* 오늘 날짜와 비교하여 앞으로 다가올 가장 가까운 목요일 날짜 */

	// 목요일까지의 일수를 계산
	let plusDay = (7 + 4 - todayDate) % 7;

	// 현재 날짜에 계산된 일수를 더하여 다음 목요일 날짜를 구하기
	let nextThursday = new Date(today);
	nextThursday.setDate(today.getDate() + plusDay);
	// console.log(nextThursday);

	nextThursday = nextThursday.getFullYear() + "." + (nextThursday.getMonth() + 1) + "." + nextThursday.getDate();
	// console.log(nextThursday);

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
		orderViewBtn.style.backgroundColor = '#FFC125';
		amountUsedViewBtn.style.backgroundColor = '#f9f9f9';
	});

	amountUsedViewBtn.addEventListener('click', function() {
		orderTable.style.display = 'none';
		amountUsedTable.style.display = 'table';
		orderViewBtn.style.backgroundColor = '#f9f9f9';
		amountUsedViewBtn.style.backgroundColor = '#FFC125';
	});



});

/* 용품 사용량 */
function initialize(orderDataArr) {

	// console.log(orderDataArr)
	// console.log(typeof (orderDataArr)) // String

	let arr1 = []; // cat1
	let arr2 = []; // cat2
	let arr3 = []; // cat3
	let arr4 = []; // cat4
	let arr5 = []; // cat5
	let arr6 = []; // cat6
	orderDataArr.forEach(cat => {
		if (cat.tac_category === 'cat1') {
			// console.log(typeof (cat.total_cnt))
			arr1.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat2') {
			arr2.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat3') {
			arr3.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat4') {
			arr4.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat5') {
			arr5.push(parseFloat(cat.total_cnt));
		} else if (cat.tac_category === 'cat6') {
			arr6.push(parseFloat(cat.total_cnt));
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
	// console.log("cat1 = " + arr1Sum)
	let arr2Sum = 0;
	for (let i = 0; i < arr2.length; i++) {
		arr2Sum += arr2[i];
	}
	// console.log("cat2 = " + arr2Sum)
	let arr3Sum = 0;
	for (let i = 0; i < arr3.length; i++) {
		arr3Sum += arr3[i];
	}
	// console.log("cat3 = " + arr3Sum)
	let arr4Sum = 0;
	for (let i = 0; i < arr4.length; i++) {
		arr4Sum += arr4[i];
	}
	// console.log("cat4 = " + arr4Sum)
	let arr5Sum = 0;
	for (let i = 0; i < arr5.length; i++) {
		arr5Sum += arr5[i];
	}
	// console.log("cat5 = " + arr5Sum)
	let arr6Sum = 0;
	for (let i = 0; i < arr6.length; i++) {
		arr6Sum += arr6[i];
	}
	// console.log("cat6 = " + arr6Sum)

	let paperTac = 0; // 종이 용기
	let sauceTac = 0; // 소스 용기
	let chopstick = 0; // 나무 젓가락
	let tacM = 0; // 포장용기 M
	let tacL = 0; // 포장용기 L
	let spoon = 0; // 나무 숫가락

	if (arr1Sum) {
		// paperTac / sauceTac / chopstick 1개
		paperTac += arr1Sum;
		sauceTac += arr1Sum;
		chopstick += arr1Sum;
	}
	if (arr2Sum) {
		// tacM 1개
		tacM += arr2Sum;
	}
	if (arr3Sum) {
		// tacL 1개 / chopstick 4개
		tacL += arr3Sum;
		chopstick += (arr3Sum * 4);
	}
	if (arr4Sum) {
		// sauceTac / chopstick / spoon 1개 
		sauceTac += arr4Sum;
		chopstick += arr4Sum;
		spoon += arr4Sum;
	}
	if (arr5Sum) {
		// tacL 1개 / chopstick / spoon 4개
		tacL += arr5Sum;
		chopstick += (arr5Sum * 4);
		spoon += (arr5Sum * 4);
	}
	if (arr6Sum) {
		// tacM / chopstick / spoon 1개
		tacM += arr6Sum;
		chopstick += arr6Sum;
		spoon += arr6Sum;
	}
	/*console.log("종이 용기 = " + paperTac)
	console.log("소스 용기 = " + sauceTac)
	console.log("나무 젓가락 = " + chopstick)
	console.log("포장용기 M = " + tacM)
	console.log("포장용기 L = " + tacL)
	console.log("나무 숫가락 = " + spoon)*/

	//.innerHTML 를 사용하여 표에 사용량 넣기
	document.getElementById("paperTac").innerHTML = paperTac;
	document.getElementById("sauceTac").innerHTML = sauceTac;
	document.getElementById("chopstick").innerHTML = chopstick;
	document.getElementById("tacM").innerHTML = tacM;
	document.getElementById("tacL").innerHTML = tacL;
	document.getElementById("spoon").innerHTML = spoon;

	/* 용품 사용량(낱개) -> 사용 재고(박스) 단위로 변환 */
	// 포장 용기 M(tacM) : 1Box -> 20Ea 
	// 포장 용기 L(tacL) : 1Box -> 20Ea 
	// 종이 용기(paperTac) : 1Box -> 20Ea
	// 소스 용기(sauceTac) : 1Box -> 100Ea 
	// 나무 젓가락(chopstick) : 1Box -> 100Ea 
	// 일회용 스푼(spoon) : 1Box -> 100Ea

	let itemsEachBoxTacM = 20;
	let itemsEachBoxTacL = 20;
	let itemsEachBoxPaperTac = 20;
	let itemsEachBoxSauceTac = 100;
	let itemsEachBoxChopstick = 100;
	let itemsEachBoxSpoon = 100;

	let usedTacMBoxes;
	usedTacMBoxes = tacM / itemsEachBoxTacM
	console.log("포장 용기 M 박스단위 사용량 = " + usedTacMBoxes)

	let usedTacLBoxes;
	usedTacLBoxes = tacL / itemsEachBoxTacL
	console.log("포장 용기 L 박스단위 사용량 = " + usedTacLBoxes)

	let usedPaperTacBoxes;
	usedPaperTacBoxes = paperTac / itemsEachBoxPaperTac
	console.log("종이 용기 박스단위 사용량 = " + usedPaperTacBoxes)

	let usedSauceTacBoxes;
	usedSauceTacBoxes = sauceTac / itemsEachBoxSauceTac
	console.log("소스 용기 박스단위 사용량 = " + usedSauceTacBoxes)

	let usedChopstickBoxes;
	usedChopstickBoxes = chopstick / itemsEachBoxChopstick
	console.log("나무 젓가락 박스단위 사용량 = " + usedChopstickBoxes)

	let usedSpoonBoxes;
	usedSpoonBoxes = spoon / itemsEachBoxSpoon
	console.log("일회용 스푼 박스단위 사용량 = " + usedSpoonBoxes)

	document.getElementById("usedTacMBoxes").innerHTML = usedTacMBoxes;
	document.getElementById("usedTacLBoxes").innerHTML = usedTacLBoxes;
	document.getElementById("usedPaperTacBoxes").innerHTML = usedPaperTacBoxes;
	document.getElementById("usedSauceTacBoxes").innerHTML = usedSauceTacBoxes;
	document.getElementById("usedChopstickBoxes").innerHTML = usedChopstickBoxes;
	document.getElementById("usedSpoonBoxes").innerHTML = usedSpoonBoxes;

	/* 현재재고 - 사용재고 */
	let nowInvenTacM = document.getElementById("nowInvenTacM").innerText;
	let nowInvenTacL = document.getElementById("nowInvenTacL").innerText;
	let nowInvenPaperTac = document.getElementById("nowInvenPaperTac").innerText;
	let nowInvenSauceTac = document.getElementById("nowInvenSauceTac").innerText;
	let nowInvenChopstick = document.getElementById("nowInvenChopstick").innerText;
	let nowInvenSpoon = document.getElementById("nowInvenSpoon").innerText;

	console.log(nowInvenTacM - usedTacMBoxes)
	console.log(nowInvenTacL - usedTacLBoxes)
	console.log(nowInvenPaperTac - usedPaperTacBoxes)
	console.log(nowInvenSauceTac - usedSauceTacBoxes)
	console.log(nowInvenChopstick - usedChopstickBoxes)
	console.log(nowInvenSpoon - usedSpoonBoxes)

	document.getElementById("availStockTacM").innerText = nowInvenTacM - usedTacMBoxes;
	document.getElementById("availStockTacL").innerText = nowInvenTacL - usedTacLBoxes;
	document.getElementById("availStockPaperTac").innerText = nowInvenPaperTac - usedPaperTacBoxes;
	document.getElementById("availStockSauceTac").innerText = nowInvenSauceTac - usedSauceTacBoxes;
	document.getElementById("availStockChopstick").innerText = nowInvenChopstick - usedChopstickBoxes;
	document.getElementById("availStockSpoon").innerText = nowInvenSpoon - usedSpoonBoxes;
	
	/* 필요수량 */
	let stdCount = 10; // 기준 갯수
	// 뒤에 수식고쳐야함
	document.getElementById("reqTacM").innerText = (stdCount - (nowInvenTacM - usedTacMBoxes)).toFixed(2);
	document.getElementById("reqTacL").innerText = (stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2);
	document.getElementById("reqPaperTac").innerText = (stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2);
	document.getElementById("reqSauceTac").innerText = (stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2);
	document.getElementById("reqChopstick").innerText = (stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2);
	document.getElementById("reqSpoon").innerText = (stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2);
	
	/* 주문 수량 */
	// 필요 수량을 반올림
	document.getElementById("orderTacM").innerText = Math.round((stdCount - (nowInvenTacM - usedTacMBoxes)).toFixed(2));
	document.getElementById("orderTacL").innerText = Math.round((stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2));
	document.getElementById("orderPaperTac").innerText = Math.round((stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2));
	document.getElementById("orderSauceTac").innerText = Math.round((stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2));
	document.getElementById("orderChopstick").innerText = Math.round((stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2));
	document.getElementById("orderSpoon").innerText = Math.round((stdCount - (nowInvenTacL - usedTacLBoxes)).toFixed(2));

}

