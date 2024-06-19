/**
 * 
 */

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

function move_to_cart(element) {
	console.log("hello")
	// 각 li 요소를 선택합니다.
	/*
		let listItems = document.querySelectorAll('.list-item');
		let list_items = document.getElementsByClassName('list-item');
	
		for (let i = 0; i < list_items; i++) {
			lists[i].textContent
			console.log(lists[i].textContent)
		}
		console.log("all = " + listItems.textContent)
		console.log("class = " + list_items.textContent)*/

	let text = element.textContent;
	console.log(`Move '${text}' to cart`);
}


/*
// 선택된 요소가 유효한지 확인 후에 처리합니다.
if (listItems.length > 0) {
	// 유효한 경우에만 forEach를 사용하여 클릭 이벤트 리스너를 추가합니다.
	listItems.forEach(item => {
		item.addEventListener('click', function() {
			// 클릭된 li 요소의 텍스트를 가져와서 콘솔에 출력합니다.
			console.log(this.textContent);
		});
	});
} else {
	console.error('No list items found.');
}*/

