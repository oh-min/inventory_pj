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
		name_cell.setAttribute('name', 'food');
		console.log(name_cell);
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

/* order submit */
function order_form() {
	// ajax를 통해 보내야하는 데이터 배열

	let order_num_str; // 주문번호 = 년월일6글자 + 테이블번호 2글자 + 시간 2글자 + 분 2글자 + 초 2글자 ex) 24072502163004
	let regdate_str; // 주문시간
	let table_num_str = document.getElementById("table_num").value; // 테이블 번호
	let total_price_str = document.getElementById("total_price").value; // 총 가격
	let name_class = document.getElementsByClassName("name_cell_class"); // 음식 이름
	let food = [];
	for (let i = 0; i < name_class.length; i++) {
		let text = name_class[i].textContent;
		food.push(text);
	}
	let cnt_class = document.getElementsByClassName("cnt_cell_class"); // 갯수
	let cnt = [];
	for (let i = 0; i < cnt_class.length; i++) {
		let text = cnt_class[i].textContent;
		cnt.push(text);
	}
	let price_class = document.getElementsByClassName("price_cell_class"); // 가격
	let price = [];
	for (let i = 0; i < price_class.length; i++) {
		let text = price_class[i].textContent;
		price.push(text);
	}


	// 현재 날짜 구하기
	let today = new Date();
	let today_y = today.getFullYear();
	let today_m = today.getMonth() + 1;
	let today_d = today.getDate();

	// 한자리 수인 경우 앞에 0을 넣어 2자리로 맞추기
	let today_y00 = ('' + today_y).slice(-2);
	let today_m00 = ('00' + today_m).slice(-2);
	let today_d00 = ('00' + today_d).slice(-2);



	// 날짜를 비교하기 위해 년도/월/일 형식으로 변경하기
	let today_ymd = today_y00 + today_m00 + today_d00;

	// 현재시간
	let hours = today.getHours();
	let minutes = today.getMinutes();
	let hours_00 = ('00' + hours).slice(-2);
	let minutes_00 = ('00' + minutes).slice(-2);

	let seconds = today.getSeconds();
	let seconds_00 = ('00' + seconds).slice(-2);

	// 주문시간 설정
	regdate_str = today_y + "-" + today_m00 + "-" + today_d00 + " " + hours_00 + ":" + minutes_00 + ":" + seconds_00;

	// 테이블 번호 2자리 맞추기
	table_num_str = ('00' + table_num_str).slice(-2);

	// 주문번호 설정
	order_num_str = today_ymd + table_num_str + hours_00 + minutes_00 + seconds_00;


	// 주문 번호, 테이블 번호, 주문시간, 총 가격 배열로 반복
	// console.log(name_class.length) // 반복해야할 횟수
	let order_num = [];
	for (let i = 0; i < name_class.length; i++) {
		order_num.push(order_num_str);
	}
	let regdate = [];
	for (let i = 0; i < name_class.length; i++) {
		regdate.push(regdate_str);
	}
	let table_num = [];
	for (let i = 0; i < name_class.length; i++) {
		table_num.push(table_num_str);
	}
	let total_price = [];
	for (let i = 0; i < name_class.length; i++) {
		total_price.push(total_price_str);
	}
	console.log(Array.isArray(order_num) + " 주문번호" + order_num);
	console.log(Array.isArray(regdate) + " 주문시간" + regdate);
	console.log(Array.isArray(table_num) + " 테이블 번호" + table_num);
	console.log(Array.isArray(total_price) + " 총 가격" + total_price);
	console.log(Array.isArray(food) + " 음식 이름" + food);
	console.log(Array.isArray(cnt) + " 갯수" + cnt);
	console.log(Array.isArray(price) + " 가격" + price);

	$.ajax({
		url: "/order",
		type: "post",
		traditional: true,	// ajax 배열 넘기기 옵션!
		data: {
			"order_num": order_num,
			"regdate": regdate,
			"table_num": table_num,
			"total_price": total_price,
			"food": food,
			"cnt": cnt,
			"price": price
		},
		dataType: "json",
		success: function(data) {
			console.log(data);
			window.location.href = "/order";

		},
		error: function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});




}
