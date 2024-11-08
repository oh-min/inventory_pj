# 재고관리 페이지 H-Inv
## 프로젝트 소개 및 주요 기능
- 아르바이트 중 재고 관리 업무를 맡게 되어 겪은 어려움을 바탕으로, 주문 내역에 따라 자동으로 재고를 계산하고 메일을 보내는 프로젝트를 기획하게 되었습니다.
- 다양한 메뉴와 음료를 주문할 수 있습니다.
- 전체 주문 내역을 불러오거나, 특정 기간을 설정하여 주문 내역을 검색할 수 있습니다.
- 주문 내역을 바탕으로 현재 재고를 파악하고 자동으로 주문해야 할 재고를 계산하여 메일을 발송할 수 있습니다.

## 프로젝트 기간
2024.06 - 2024.11

## 개발 환경
- 프레임워크 및 언어 : Java, JavaScript, SpringMVC, CSS, JSTL
- 데이터베이스 : MySQL
- IDE : Eclipse
- 서버 : Apache Tomcat
- 운영 체제 : macOS

## 페이지별 기능
### 홈 화면
<img width="1000" alt="홈화면" src="https://github.com/user-attachments/assets/2d146ac3-96ea-4275-a651-602dfebd3aa0">

- 유저 이름, 비밀번호를 입력하여 로그인 버튼 클릭하면 메인 페이지로 이동합니다. (test 유저 이름 : manager / test 비밀번호 : 1111)
- 잘못된 정보 입력 시 ‘저장된 정보와 일치하지 않습니다’ 알림창 출력이 되며, 페이지가 그대로 유지됩니다.
### 메인 화면
<img width="1000" alt="메인화면" src="https://github.com/user-attachments/assets/cc8ad5e8-6341-40a6-a776-6520ac5ba618">

- 로그인 시 화면 우측 상단에 유저 이름 출력됩니다.
- 로그아웃 버튼을 클릭하면 로그아웃이 되며 홈 화면으로 이동합니다.
- 주문, 주문 내역, 홀 재고 버튼 클릭 시 각 페이지로 이동합니다.
### 주문 화면
<img width="1000" alt="주문화면" src="https://github.com/user-attachments/assets/86f46110-257a-42f2-b289-42454698a2ed">

- 테이블 번호 1 ~ 10 선택할 수 있습니다.
- 카테고리별로 메뉴를 분류하여 사용자가 메뉴를 선택하면 주문 내역에 출력됩니다.
- 주문 내역에 선택한 메뉴, 가격, 개수, 총 가격을 출력합니다.
- 주문 내역에 표시된 메뉴 목록을 ORDER 버튼을 누르면 주문이 완료됩니다.
### 주문내역 화면
<img width="1000" alt="주문내역화면" src="https://github.com/user-attachments/assets/de911952-9701-4ae7-aa6f-b4de5f5ec422">

- 전체 주문내역을 출력합니다.
- 1주일 / 1개월 / 3개월 / 6개월 / 기간 설정을 옵션으로 설정하여 해당 기간 내의 주문 내역을 출력할 수 있습니다.
- 주문번호를 클릭하면 해당 주문의 디테일 화면으로 이동합니다.
### 주문내역 디테일 화면
<img width="1000" alt="주문내역디테일화면" src="https://github.com/user-attachments/assets/573775d1-2583-43d2-a028-e369e72c9b43">

- 해당 주문번호의 주문내역을 출력합니다.
### 홀재고 화면
<img width="1000" alt="홀재고화면" src="https://github.com/user-attachments/assets/6837d6ae-d5a3-4b99-86a5-6899b3fe2e57">

- 주문 내역 보기 버튼을 클릭하면 지난주 금요일부터 이번 주 목요일까지의 각 메뉴별로 총 주문 개수를 출력합니다.
- 용품 사용량 보기 버튼을 클릭하면 각 메뉴를 포장하는 데 사용한 용품들의 사용량을 출력합니다.
- 필요 수량과 주문 수량을 계산합니다.
- 이메일 내용 작성 버튼을 클릭하면 자동으로 이메일 내용이 작성됩니다.
- 받는 사람 이메일 주소와 메일 제목은 이미 입력되어 있으나, 수정 가능합니다.
- 이메일 발송 버튼을 클릭하면 이메일이 발송됩니다.
