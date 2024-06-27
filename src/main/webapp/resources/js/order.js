/**
 *
 */

/* 메뉴 함수 */
function showList(listId) {
	// 모든 리스트 숨기기
	let lists = document.getElementsByClassName('list_container');
	for (let i = 0; i < lists.length; i++) {
		lists[i].style.display = 'none';
	}

	// 선택된 리스트 보이기
	document.getElementById(listId).style.display = 'block';

	// 네비게이션바에서 active 클래스 제어
	let links = document.getElementsByClassName('navigation')[0].getElementsByTagName('a');
	for (let j = 0; j < links.length; j++) {
		links[j].classList.remove('active');
	}
	event.currentTarget.classList.add('active'); // 선택된 링크에 active 클래스 추가
}

/* 주문목록으로 이동 함수 */
function move_to_cart(element) {

	// 선택한 음식 이름 및 가격
	let text = element.textContent;

	// 정규 표현식으로 한글 추출 => 음식 이름
	let regex_kor = /[가-힣]+/g;
	let kor_match = text.match(regex_kor);
	let food_name_kor = kor_match.join('');

	// $ 뒤에 숫자 추출 => 가격
	let regex_dollar = /\$(\d+)/;
	let food_price = text.match(regex_dollar)[1];


	let new_item = { name: food_name_kor, price: food_price };

	// 기존에 음식이 선택된적 있는지 확인하는 함수 호출
	let cnt_result = for_cnt(new_item.name);

	// console.log(cnt_result);
	if (cnt_result == "true") {
		// console.log("이미 존재하니깐 갯수만 +1 하세요")

		let name_class = document.getElementsByClassName("name_cell_class");
		let cnt_class = document.getElementsByClassName("cnt_cell_class");
		let price_class = document.getElementsByClassName("price_cell_class");

		// 텍스트를 저장할 배열 선언 및 저장
		let all_names = []; // 이름
		for (let i = 0; i < name_class.length; i++) {
			let text = name_class[i].textContent;
			all_names.push(text);
		}
		let all_cnts = []; // 갯수
		for (let i = 0; i < cnt_class.length; i++) {
			let text = cnt_class[i].textContent;
			all_cnts.push(text);
		}
		let all_prices = []; // 가격
		for (let i = 0; i < price_class.length; i++) {
			let text = price_class[i].textContent;
			all_prices.push(text);
		}

		// 해당 음식명이 저장된 배열의 인덱스 번호
		let plus_index = all_names.indexOf(new_item.name);
		// console.log("인덱스 번호 : " + plus_index);

		/* 클릭한 만큼 음식의 갯수 변경 */
		// 해당 인덱스 번호의 갯수
		let before_cnt = all_cnts[plus_index];
		// console.log(`${new_item.name}의 갯수 = ` + before_cnt);

		// 문자열을 숫자로 변환 후 +1
		let num_cnt = parseInt(before_cnt, 10);
		let after_cnt = num_cnt + 1;
		console.log(`추가된 ${new_item.name}의 갯수 = ` + after_cnt);

		// 배열에 +1된 갯수로 내용 변경
		cnt_class[plus_index].textContent = after_cnt;
		// console.log(cnt_class[plus_index].textContent)

		/* 갯수 x 가격 하여 가격 변경 */
		let before_price = all_prices[plus_index];
		// console.log(`${new_item.name}의 가격 = ` + before_price);

		// 문제 발생! 2 -> 3 갯수로 넘어가면 이미 x2된 가격에 x3을 함
		// 1개의 가격을 기준으로 x 갯수 해야됨
		let standard_price = before_price / before_cnt;
		console.log(`${new_item.name}의 1개 가격 = ` + standard_price);

		let after_price = after_cnt * standard_price;
		console.log(`변경된 ${new_item.name}의 가 = ` + after_price);

		// 배열에 변경된 가격으로 내용 변경
		price_class[plus_index].textContent = after_price;
		console.log(price_class[plus_index].textContent)

		/* 총 금액 */
		// 마지막까지 변경된 가격을 변수에 넣어야 되기때문에 가격 다시 변수에 저장
		let total_price = 0;
		for (let i = 0; i < price_class.length; i++) {
			let num_price = parseInt(price_class[i].textContent, 10);
			total_price += num_price;

		}
		console.log("total price = " + total_price)
		let total_price_class = document.getElementById("total_price");
		total_price_class.value = total_price;

	} else {
		// console.log("없으니깐 전체 등록 하세요")
		let tbody = document.getElementById("cart_list_body");

		let row = document.createElement('tr');

		// 음식 이름
		let name_cell = document.createElement('td');
		name_cell.textContent = new_item.name;
		name_cell.className = 'name_cell_class';
		row.appendChild(name_cell);

		// 갯수
		let cnt_cell = document.createElement('td');
		cnt_cell.className = 'cnt_cell_class';
		cnt_cell.textContent = "1";
		row.appendChild(cnt_cell);


		// 가격
		let price_cell = document.createElement('td');
		price_cell.className = 'price_cell_class';
		price_cell.textContent = new_item.price;
		row.appendChild(price_cell);

		// 삭제
		let del_cell = document.createElement('td');
		del_cell.textContent = "삭제";
		row.appendChild(del_cell);

		tbody.appendChild(row);

		/* 총 금액 */
		// 마지막까지 변경된 가격을 변수에 넣어야 되기때문에 가격 다시 변수에 저장
		let price_class = document.getElementsByClassName("price_cell_class");
		let total_price = 0;
		for (let i = 0; i < price_class.length; i++) {
			let num_price = parseInt(price_class[i].textContent, 10);
			total_price += num_price;
		}
		console.log("total price = " + total_price)
		let total_price_class = document.getElementById("total_price");
		total_price_class.value = total_price;
	}

}

/* 기존에 음식이 선택된적 있는지 확인하는 함수 */
function for_cnt(chk) {
	let name_class = document.getElementsByClassName("name_cell_class");

	// 텍스트를 저장할 배열 선언 및 저장
	let all_names = [];
	for (let i = 0; i < name_class.length; i++) {
		let text = name_class[i].textContent;
		all_names.push(text);
	}
	// console.log(all_names); // 전체 
	// console.log(chk) // 일치여부 확인 할 텍스트

	let index = all_names.indexOf(chk);

	// 해당 텍스트의 기존에 선택된 갯수 가져오기
	if (index !== -1) {
		// console.log(`${chk} 는 ${index}에 존재`);
		// 존재하는 경우
		return "true";
	} else {
		// console.log(`${chk} 없음`);
		// 없는 경우
		return "false";
	}
}
