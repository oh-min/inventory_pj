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

	/* 검색 결과 유지 */
//	try {
		let urlParams = new URL(location.href).searchParams;
		let url_start_date = urlParams.get('start_date'); // url 주소에서 start_date 값 추출
		let url_end_date = urlParams.get('end_date'); // url 주소에서 end_date 값 추출
		let url_search_period = urlParams.get('search_period'); // url 주소에서 search_period 값 추출

		// console.log(url_start_date)
		// console.log(url_end_date)
		// console.log(url_search_period)

		let start_date = document.getElementById('start_date');
		let end_date = document.getElementById('end_date');
		let search_period = document.getElementById('search_period');

		if (search_period.value) { // url주소에 keyword가 있는경우 -> 검색한 창에 입력한 값 유지하기
			console.log("기간 정해짐")
			start_date.value = url_start_date
			end_date.value = url_end_date
			search_period.value = url_search_period
		} else {
			console.log("기간 안 정해짐")
			search_period.value = "all"
		}

//	} catch (e) {
//		console.log(e)
	//}
}
