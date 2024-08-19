/**
 * 
 */

window.onload = function() {
	/* 페이징 class 변경 */
	try {
		// url 주소에서 pageNum 값
		let url_param = new URL(location.href).searchParams;
		let page_num = url_param.get('page_num');
		// page_num과 text값이 같은 a태그
		let a_num = document.getElementById(page_num);
		// 현재페이지 번호 색변경
		if (page_num == a_num.text) {
			a_num.className = "now_page";
		}
	} catch (e) {
		console.log(e)
	}

	/* Datepicker 위젯사용 */
	$(function() {
		$("#start_date").datepicker({
			dateFormat: "yy-mm-dd", // 출력 형식
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], // 달력에 요일 표시
			maxDate: "D", //최대 선택일자
			changeYear: true, //option값 년 선택 가능
			changeMonth: true, //option값  월 선택 가능
			showMonthAfterYear: true, // 월- 년 순서가아닌 년도 - 월 순서
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], //달력의 월 부분 텍스트
			onSelect: function() { // end_date의 최소 선택일자를 start_date에서 선택한 날짜보다 이후로 설정
				var minDate = $(this).datepicker('getDate');
				$("#end_date").datepicker('option', 'minDate', minDate);
			}
		})

		$("#end_date").datepicker({
			dateFormat: "yy-mm-dd", // 출력 형식
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], // 달력에 요일 표시
			maxDate: "D", //최대 선택일자(당일)
			changeYear: true, //option값 년 선택 가능
			changeMonth: true, //option값  월 선택 가능
			showMonthAfterYear: true, // 월- 년 순서가아닌 년도 - 월 순서
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], //달력의 월 부분 텍스트
			onSelect: function() { // start_date의 최대 선택일자를 end_date에서 선택한 날짜보다 이전으로 설정
				var maxDate = $(this).datepicker('getDate');
				$("#start_date").datepicker('option', 'maxDate', maxDate);
			}
		})

		$('#end_date').datepicker('setDate', 'today');
	});

	/* <option>전체</option>
					<option id="one_w">1주일</option>
					<option id="one_m">1개월</option>
					<option id="three_m">3개월</option>
					<option id="six_m">6개월</option> */

	/* 기간 선택 select */
	let one_w = document.getElementById("one_w");

	function period(a) {
		alert(a.value)
	}
}