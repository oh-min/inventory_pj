<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/order.css" />
<script src="/resources/js/order.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="header_content">
		<%@include file="header.jsp"%>
	</div>
	<div class="main_content">
		<form id="order_form">
			<div class="num_btn">
				<div class="table">
					Table<select class="cursor-effect" id="table_num">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
				<div class="btn">
					<button onclick="order_form()">ORDER</button>
				</div>
			</div>
			<div class="list_price">
				<div>
					<div class="navigation">
						<a href="#" onclick="showList('list1')">Side Menu</a> <a href="#" onclick="showList('list2')">Soup</a> <a href="#" onclick="showList('list3')">Meals</a>
						<a href="#" onclick="showList('list4')">Bibimbap</a> <a href="#" onclick="showList('list5')">Fried Chicken </a> <a href="#"
							onclick="showList('list6')">Korean Hotpot</a> <a href="#" onclick="showList('list7')">Cold Noodle</a> <a href="#" onclick="showList('list8')">Extra
							Menu</a> <a href="#" onclick="showList('list9')">Drinks</a> <a href="#" onclick="showList('list10')">Alcohol</a>
					</div>

					<div class="list_container" id="list1">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">군만두 Pork Dumpling(Fried) $18</li>
							<li class="list_item" onclick="move_to_cart(this)">해물파전 Seafood Pancake $35</li>
							<li class="list_item" onclick="move_to_cart(this)">부추전 Squid &amp; Chive Pancake $30</li>
							<li class="list_item" onclick="move_to_cart(this)">김치전 Kimchi Pancake $32</li>
							<li class="list_item" onclick="move_to_cart(this)">돼지고기 김치전 Pork Kimchi Pancake $36</li>
							<li class="list_item" onclick="move_to_cart(this)">치즈감자전 Potato Pancake with Cheese $36</li>
							<li class="list_item" onclick="move_to_cart(this)">굴전 Oyster Pancake $34</li>
							<li class="list_item" onclick="move_to_cart(this)">떡갈비 Marinated Grill Beef Patties $20</li>
							<li class="list_item" onclick="move_to_cart(this)">잡채 Sweet Potato Noodles with Pork $24</li>
							<li class="list_item" onclick="move_to_cart(this)">떡볶이 Spicy Rice Cake $21.5</li>
							<li class="list_item" onclick="move_to_cart(this)">계란찜 Steamed Egg $20</li>
						</ul>
					</div>

					<div class="list_container" id="list2" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">소꼬리곰탕 Ox Tail Soup $39</li>
							<li class="list_item" onclick="move_to_cart(this)">도가니탕 Ox Knee Soup $32.5</li>
							<li class="list_item" onclick="move_to_cart(this)">나주곰탕 Naju Beef Bone Soup $30</li>
							<li class="list_item" onclick="move_to_cart(this)">설렁탕 Ox Bone Soup $30</li>
							<li class="list_item" onclick="move_to_cart(this)">왕갈비탕 Beef Rib Soup $30</li>
							<li class="list_item" onclick="move_to_cart(this)">삼계탕 Ginseng Chicken Soup $41</li>
							<li class="list_item" onclick="move_to_cart(this)">차돌국밥 Beef Brisket Soup $32.5</li>
							<li class="list_item" onclick="move_to_cart(this)">돼지국밥 Koran Traditional Pork Soup $30</li>
							<li class="list_item" onclick="move_to_cart(this)">순대국 Korean Sausage Soup $31</li>
							<li class="list_item" onclick="move_to_cart(this)">선지해장국 Ox Blood Hangover Soup $30</li>
							<li class="list_item" onclick="move_to_cart(this)">뼈다귀 해장국 Pork Neck Bone Soup $32.5</li>
							<li class="list_item" onclick="move_to_cart(this)">육칼해장국 Spicy Beef Soup with Noodles $32.0</li>
						</ul>
					</div>

					<div class="list_container" id="list3" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">초당 순두부 Korean Traditional Soft Tofu Soup $25</li>
							<li class="list_item" onclick="move_to_cart(this)">해물 순두부 Seafood Soft Tofu Soup $25</li>
							<li class="list_item" onclick="move_to_cart(this)">돼지 순두부 Pork Soft Tofu Soup $25</li>
							<li class="list_item" onclick="move_to_cart(this)">차돌 된장찌개 Beef Brisket Soybean Soup $25</li>
							<li class="list_item" onclick="move_to_cart(this)">해물 된장찌개 Seafood Soybean Soup $25</li>
							<li class="list_item" onclick="move_to_cart(this)">스팸 김치찌개 Spam Kimchi Stew $25</li>
							<li class="list_item" onclick="move_to_cart(this)">돼지 김치찌개 Pork Kimchi Stew $25</li>
							<li class="list_item" onclick="move_to_cart(this)">알탕 Spicy Fish Roe Stew $25</li>
							<li class="list_item" onclick="move_to_cart(this)">오징어볶음 Spicy Stir-fried Squid Hot Plate $28</li>
							<li class="list_item" onclick="move_to_cart(this)">불고기 쌈밥 Marinated Beef with Vegetables $23</li>
							<li class="list_item" onclick="move_to_cart(this)">제육 쌈밥 Spicy Stir-fried Pork with Vegetables $23</li>
							<li class="list_item" onclick="move_to_cart(this)">영양돌솥밥 Healthy Stone Pot with Rice &amp; Soup $18</li>
							<li class="list_item" onclick="move_to_cart(this)">양념게장 Spicy Marinated Crab $25</li>
							<li class="list_item" onclick="move_to_cart(this)">LA갈비 Marinated Beef Ribs $28</li>
							<li class="list_item" onclick="move_to_cart(this)">등심돈까스 Deep Fried Pork Cutlet $27.5</li>
							<li class="list_item" onclick="move_to_cart(this)">치즈돈까스 Deep Fried Cheese Pork Cutlet $30</li>
							<li class="list_item" onclick="move_to_cart(this)">생선구이 Grilled Fish $18</li>
						</ul>
					</div>
					<div class="list_container" id="list4" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">불고기비빔밥 Bibimbap with Beef &amp; Vegetables $16</li>
							<li class="list_item" onclick="move_to_cart(this)">육회비빔밥 Marinated Raw Beef Bibimbap $16</li>
							<li class="list_item" onclick="move_to_cart(this)">돌솥비빔밥 Stone Pot Bibimbap with Beef and Egg $18</li>
							<li class="list_item" onclick="move_to_cart(this)">오징어돌솥밥 Stone Pot Bibimbap withe Spicy Squid $18</li>
							<li class="list_item" onclick="move_to_cart(this)">제육돌솥밥 Stone Pot Bibimbap withe Spicy Stir-fried Pork $18</li>
						</ul>
					</div>
					<div class="list_container" id="list5" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">치즈 불닭Cheese Spicy Chicken $62</li>
							<li class="list_item" onclick="move_to_cart(this)">간장치킨Soy Fried Chicken $52</li>
							<li class="list_item" onclick="move_to_cart(this)">순살치킨Boneless Fried Chicken $50</li>
							<li class="list_item" onclick="move_to_cart(this)">양념치킨Sweet &amp; Spicy Fried Chicken $52</li>
						</ul>
					</div>
					<div class="list_container" id="list6" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">감자탕 M Spicy Potato &amp; Pork Neck Bone Hot Pot Medium $76</li>
							<li class="list_item" onclick="move_to_cart(this)">감자탕 L Spicy Potato &amp; Pork Neck Bone Hot Pot Large $89</li>
							<li class="list_item" onclick="move_to_cart(this)">돼지국밥전골 Korean Traditional Pork Hot Pot $80</li>
							<li class="list_item" onclick="move_to_cart(this)">순대국밥전골 Korean Sausage (Soon-dae)Hot Pot $84.50</li>
							<li class="list_item" onclick="move_to_cart(this)">도가니 전골 Ox Knee Hot Pot $84.50</li>
							<li class="list_item" onclick="move_to_cart(this)">불고기 버섯 전골 Marinated Beef &amp; Mushroom Hot Pot $84.50</li>
							<li class="list_item" onclick="move_to_cart(this)">불고기 낙지 전골 Marinated Beef &amp; Octopus Hot Pot $89</li>
							<li class="list_item" onclick="move_to_cart(this)">낙곱새 M Spicy Octopus Of Beef Intestine &amp; Prawn Hot Pot M $76</li>
							<li class="list_item" onclick="move_to_cart(this)">낙곱새 L Spicy Octopus Of Beef Intestine &amp; Prawn Hot Pot L $89</li>
							<li class="list_item" onclick="move_to_cart(this)">돼지 묵은지 전골 Pork Rib &amp; Kimchi Hot Pot $84.50</li>
							<li class="list_item" onclick="move_to_cart(this)">해물 전골Spicy Seafood Hot Pot $89</li>
							<li class="list_item" onclick="move_to_cart(this)">만두 전골Dumplings Hot Pot $84.50</li>
							<li class="list_item" onclick="move_to_cart(this)">곱도리탕 Spicy Chicken &amp; Tripe Hot Pot $89</li>
							<li class="list_item" onclick="move_to_cart(this)">대창 전골 Spicy Large Intestines Hot Pot $89</li>
							<li class="list_item" onclick="move_to_cart(this)">부대전골 Spicy Korean Army Hot Pot With Sausages, Ramen, Cheese &amp; Vegetables $84.50</li>
						</ul>
					</div>
					<div class="list_container" id="list7" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">물냉면 Cold Noodle Soup $27.5</li>
							<li class="list_item" onclick="move_to_cart(this)">비빔냉면 Spicy Cold Noodle $27.5</li>
							<li class="list_item" onclick="move_to_cart(this)">물비냉면 Spicy Cold Noodle Soup $27.5</li>
							<li class="list_item" onclick="move_to_cart(this)">열무냉면Young Raddish Cold Noodle Soup $27.5</li>
						</ul>
					</div>
					<div class="list_container" id="list8" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">밥 Rice $3.5</li>
							<li class="list_item" onclick="move_to_cart(this)">라면사리 Ramen $6</li>
							<li class="list_item" onclick="move_to_cart(this)">칼국수사리 Kalguksu $6</li>
							<li class="list_item" onclick="move_to_cart(this)">당면 Potato Noodle $6</li>
							<li class="list_item" onclick="move_to_cart(this)">우동사리 Udon $6</li>
						</ul>
					</div>
					<div class="list_container" id="list9" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">칼피스 Calpis $6</li>
							<li class="list_item" onclick="move_to_cart(this)">우롱차 Oolong Tea $4</li>
							<li class="list_item" onclick="move_to_cart(this)">윈터멜론 Winter Melon Tea $4</li>
							<li class="list_item" onclick="move_to_cart(this)">라이치 Lychee Juice $4</li>
							<li class="list_item" onclick="move_to_cart(this)">쑤안 메이탕 Suan Mei Tang $4</li>
							<li class="list_item" onclick="move_to_cart(this)">웡로캇 Wanglaoji $4</li>
							<li class="list_item" onclick="move_to_cart(this)">밀키스 Milkis $4</li>
							<li class="list_item" onclick="move_to_cart(this)">칠성사이다 Chilsung $4</li>
							<li class="list_item" onclick="move_to_cart(this)">콜라 Coke $4</li>
							<li class="list_item" onclick="move_to_cart(this)">제로콜라 Zero Coke $4</li>
							<li class="list_item" onclick="move_to_cart(this)">레몬에이드 Lemonade $4</li>
							<li class="list_item" onclick="move_to_cart(this)">환타 Fanta $4</li>
							<li class="list_item" onclick="move_to_cart(this)">오렌지 주스 Orange Juice $6</li>
						</ul>
					</div>
					<div class="list_container" id="list10" style="display: none;">
						<ul>
							<li class="list_item" onclick="move_to_cart(this)">아사히 Asahi $9</li>
							<li class="list_item" onclick="move_to_cart(this)">삿포로 Sapporo $9</li>
							<li class="list_item" onclick="move_to_cart(this)">설중매 Plum Wine $24</li>
							<li class="list_item" onclick="move_to_cart(this)">복분자 Raspberry Wine $24</li>
							<li class="list_item" onclick="move_to_cart(this)">청하 Chungha $18</li>
							<li class="list_item" onclick="move_to_cart(this)">별빛 청하 Starlight Chungha $18</li>
							<li class="list_item" onclick="move_to_cart(this)">막걸리 Rice Wine $15</li>
							<li class="list_item" onclick="move_to_cart(this)">알밤 막걸리 Chestnut Rice Wine $16</li>
							<li class="list_item" onclick="move_to_cart(this)">참이슬 Chamisul $16</li>
							<li class="list_item" onclick="move_to_cart(this)">카스 Cass $8</li>
							<li class="list_item" onclick="move_to_cart(this)">진로 Jinro $16</li>
							<li class="list_item" onclick="move_to_cart(this)">자몽 소주 Grapefruit Soju $16</li>
							<li class="list_item" onclick="move_to_cart(this)">청포도 소주 Green Grapes Soju $16</li>
							<li class="list_item" onclick="move_to_cart(this)">클라우드 Kloud $8</li>
							<li class="list_item" onclick="move_to_cart(this)">복숭아 소주 Peaches Soju $16</li>
							<li class="list_item" onclick="move_to_cart(this)">처음처럼 Chum Churm $16</li>
							<li class="list_item" onclick="move_to_cart(this)">새로 Saero $16</li>
						</ul>
					</div>

				</div>
				<div>
					<h3 id="cart_title">주문내역</h3>
					<div id="cart_list_div">
						<table id="cart_list">
							<thead>
								<tr>
									<th id="cart_food">음식명</th>
									<th id="cart_cnt">갯수</th>
									<th id="cart_price">가격($)</th>
									<th id="cart_del"></th>
								</tr>
							</thead>
							<tbody id="cart_list_body">
								<!-- js에서 추가 -->
							</tbody>
						</table>
					</div>
					<div id="total_price_div">
						총액($) : <input type="text" id="total_price" readonly>
					</div>
				</div>

			</div>
		</form>
	</div>
</body>
</html>