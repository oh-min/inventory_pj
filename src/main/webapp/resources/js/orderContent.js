/**
 * 
 */

function writeContent() {
	// 용품 이름 - 갯수 데이터 가져오기
	// 갯수가 0인 데이터 제외하기
	let nameTacM = document.getElementById('nameTacM');
	let orderTacM = document.getElementById('orderTacM');
	let contentTacM;
	if (orderTacM.innerText != 0) {
		contentTacM = nameTacM.innerText + " " + orderTacM.innerText + "박스";
	}else{
		contentTacM = "";
	}
	console.log(contentTacM)

	let nameTacL = document.getElementById('nameTacL');
	let orderTacL = document.getElementById('orderTacL');
	let contentTacL
	if (orderTacL.innerText != 0) {
		contentTacL = nameTacL.innerText + " " + orderTacL.innerText + "박스";
	}else{
		contentTacL = "";
	}
	console.log(contentTacL)

	let namePaperTac = document.getElementById('namePaperTac');
	let orderPaperTac = document.getElementById('orderPaperTac');
	let contentPaperTac
	if (orderPaperTac.innerText != 0) {
		contentPaperTac = namePaperTac.innerText + " " + orderPaperTac.innerText + "박스";
	}else{
		contentPaperTac = "";
	}
	console.log(contentPaperTac);

	let nameSauceTac = document.getElementById('nameSauceTac');
	let orderSauceTac = document.getElementById('orderSauceTac');
	let contentSauceTac
	if (orderSauceTac.innerText != 0) {
		contentSauceTac = nameSauceTac.innerText + " " + orderSauceTac.innerText + "박스";
	}else{
		contentSauceTac = "";
	}
	console.log(contentSauceTac);

	let nameChopstick = document.getElementById('nameChopstick');
	let orderChopstick = document.getElementById('orderChopstick');
	let contentChopstick
	if (orderChopstick.innerText != 0) {
		contentChopstick = nameChopstick.innerText + " " + orderChopstick.innerText + "박스";
	}else{
		contentChopstick = "";
	}
	console.log(contentChopstick)

	let nameSpoon = document.getElementById('nameSpoon');
	let orderSpoon = document.getElementById('orderSpoon');
	let contentSpoon
	if (orderSpoon.innerText != 0) {
		contentSpoon = nameSpoon.innerText + " " + orderSpoon.innerText + "박스";
	}else{
		contentSpoon = "";
	}
	console.log(contentSpoon)

	// 가져온 데이터를 바탕으로 '(용품이름) (갯수)박스.' 형식으로 내용 자동 작동
	let orderContent = document.getElementById('orderContent');
	// 안녕하세요! H식당입니다. (주문해야하는 용품 목록 / 갯수) 부탁드립니다. 감사합니다!
	orderContent.value = "안녕하세요! H식당입니다.\n" + contentTacM + "\n"+ contentTacL + "\n"+ contentPaperTac + "\n"+ contentSauceTac + "\n"+ contentChopstick + "\n"+ contentSpoon + "\n" + "부탁드립니다. \n감사합니다!";



}