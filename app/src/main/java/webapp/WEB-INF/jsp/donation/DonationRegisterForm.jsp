<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>모금함 개설신청 양식</title>
<style>
label {
	margin-right: 5px;
	text-align: right;
	display: inline-block;
	width: 100px;
}
</style>
</head>
<body>
	<h1>모금함 개설신청 양식(MVC)</h1>
	<form action="add?boardNo=${boardNo}" method="post"
		data-no="${boardNo}">

		<label for='f-donationBoard'>모금함번호</label> <input id='f-donationBoard'
			type='number' name='donationBoard' value="${boardNo}" readonly><br>

		<!-- 
    <label for='f-donator'>기부자</label> 
    <input id='f-donator' type="number" name='donator'><br>
     -->

		<label for='f-donationMoney'>기부금액</label> <input id='f-donationMoney'
			type='number' name='donationMoney'><br> <label
			for='f-registerationNumber'>주민등록번호</label> <input
			id='f-registerationNumber' type='number' name='registerationNumber'><br>


		<p>
		<p>아임 서포트 결제 모듈 테스트 해보기</p>
		<button id="check_module" type="button">아임 서포트 결제 모듈 테스트 해보기</button>
		</p>

		<br>
		<button id='register-Button'>기부하기</button>
		<br>
	</form>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

	<script>
document.querySelector("#register-Button").onclick = () => {
    var frontRegiNumber = document.querySelector("#f-registerationNumber");
    var backRegiNumber = document.querySelector("#f-backRegisterationNumber");
    if (frontRegiNumber.value.length < 7 && backRegiNumber.value.length < 7) {
      alert("주민등록번호를 다시 입력 해주세요");
      return false; 
    } 
  }
  
$("#check_module").click(function () {
	  var donationBoard = $("#f-donationBoard").val();
	  var donationMoney = $("#f-donationMoney").val();
	  var registerationNumber = $("#f-registerationNumber").val();
	
var IMP = window.IMP; // 생략가능
IMP.init('imp36238857');
// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
IMP.request_pay({
pg: 'inicis', // version 1.1.0부터 지원.
/*
'kakao':카카오페이,
html5_inicis':이니시스(웹표준결제)
'nice':나이스페이
'jtnet':제이티넷
'uplus':LG유플러스
'danal':다날
'payco':페이코
'syrup':시럽페이
'paypal':페이팔
*/
pay_method: 'card',
/*
'samsung':삼성페이,
'card':신용카드,
'trans':실시간계좌이체,
'vbank':가상계좌,
'phone':휴대폰소액결제
*/
merchant_uid: 'merchant_' + new Date().getTime(),
/*
merchant_uid에 경우
https://docs.iamport.kr/implementation/payment
위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
참고하세요.
나중에 포스팅 해볼게요.
*/
name: '주문명:결제테스트',
//결제창에서 보여질 이름
amount: donationMoney,
//가격
buyer_email: 'iamport@siot.do',
buyer_name: '구매자이름',
buyer_tel: '010-1234-5678',
buyer_addr: '서울특별시 강남구 삼성동',
buyer_postcode: '123-456',
m_redirect_url: 'https://www.yourdomain.com/payments/complete'
/*
모바일 결제시,
결제가 끝나고 랜딩되는 URL을 지정
(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
*/
}, function (rsp) {
console.log(rsp);
if (rsp.success) {
var msg1 = '결제가 완료되었습니다.';
/* msg += '고유ID : ' + rsp.imp_uid;
msg += '상점 거래ID : ' + rsp.merchant_uid;
msg += '결제 금액 : ' + rsp.paid_amount;
msg += '카드 승인번호 : ' + rsp.apply_num; */
alert(msg1);
$(document).ready(function() {
	var money=$('#f-donationMoney').val();
	var registeration=$('#f-registerationNumber').val();
location.href='add?boardNo=${boardNo}&money='+money+'&registeration='+ registeration;
});
} else {
var msg = '결제에 실패하였습니다.';
/* msg += '에러내용 : ' + rsp.error_msg; */
alert(msg);
location.href='${contextPath}/app/donation/detail?no=${boardNo}';
}


//window.location.href = "add?boardNo=11";

});
});
</script>
</body>
</html>
