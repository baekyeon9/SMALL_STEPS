<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
	<div class="page-section">
		<div class="container">
			<h1 class="title-h">후원하기</h1>  
			<div class="join-wrap" style="height: 1100px">
				<div class="wrapper">
				  <!--
					<ul class="steps">
						<li class="is-active">1.후원자 정보 입력</li>
						<li>2.후원금액 입력</li>
						<li>3.결제하기</li>
					</ul>
					-->
					<form class="form-wrapper" action='add?boardNo=${boardNo}'
						method="post">
						<!-- 후원자 정보 -->
						<fieldset class="section">
							<h4 class="form-title">1. 후원자 정보</h4>
							<!--<input id="f-name" class="form-control box-input" type="text"
								name="name" placeholder="이름"> -->
							<div class="jumin">
								<input
								id="f-donationBoard" class="form-control box-input" type="tel"
								name="donationBoard" placeholder="모금함번호 : ${boardNo}" readonly> 
								
								<input id="f-registerationNumber" class="numberJumin"
									type="number" style="width: 27%; padding:15px 20px;" name="registerationNumber"
									placeholder="주민등록번호 앞자리"> <span>-</span> <input
									id="f-registerationNumber" class="numberJumin"
									type="password" style="width: 27%; padding:15px 20px;" name="registerationNumber"
									placeholder="주민등록번호 뒷자리">
							</div>
								<!--
							<input id="f-tel" class="form-control box-input" type="tel"
								name="tel" placeholder="휴대폰번호"> 
								<input
								id="f-email" class="form-control box-input" type="email"
								name="email" placeholder="이메일주소"> 
								-->
								
								<!--  <input type="button"
								name="next" class="button action-button" value="다음" />-->
						</fieldset>
						<!-- //후원자 정보 -->
						<fieldset class="section">
							<h4 class="form-title">2. 후원금액</h4>
							<div class="row cf">
								<!--  <div class="four col">
									<input type="radio" name="donationMoney" id="man" class="dom"
										value="10"> <label for="man">
										<h6>10원</h6>
									</label>
								</div>-->
								<div class="four col">
									<input type="radio" name="donationMoney" id="man" class="dom"
										value="10000"> <label for="man">
										<h6>10,000원</h6>
									</label>
								</div>
								<div class="four col">
									<input type="radio" name="donationMoney" id="sam" class="dom"
										value="30000"><label for="sam">
										<h6>30,000원</h6>
									</label>
								</div>
								<div class="four col">
									<input type="radio" name="donationMoney" id="oh" class="dom"
										value="50000"><label for="oh">
										<h6>50,000원</h6>
									</label>
								</div>
								<div class="four col">
									<input type="radio" name="donationMoney" id="sib" class="dom"
										value="100000"><label for="sib">
										<h6>100,000원</h6>
									</label>
								</div>
								<div class="four col">
									<input type="radio" name="donationMoney" id="sib" class="dom"
										value="200000"><label for="sib">
										<h6>200,000원</h6>
									</label>
								</div>
							</div>
								
							<input type="button" id="check_module" name="next" class="button action-button" value="결제하기" />
						</fieldset>
						<!-- //후원금액 -->
						<!--  <fieldset class="section">
							<h4 class="form-title">3. 결제하기</h4>
							<div class="form-box-do">
								<label for="f-payType" class="container-radio"
									style="padding-right: 9px;">${cardType.title} <input
									type="radio" id="f-payType" name="payType" checked> <span
									class="checkmark"></span>
								</label>
							</div>
							<<input type="button" name="next" class="button action-button" value="결제하기" />
              
							<button id="check_module" type="button"
								class="button action-button">아임 서포트 결제 모듈 테스트 해보기</button>
						</fieldset>-->
						<!-- //결제하기 -->
					</form>
					<!-- //form-wrapper -->
				</div>
				<!-- //wrapper -->
			</div>
			<!-- //join-wrap -->
		</div>
	</div>
	<!-- //page-section -->
</main>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	$("#check_module").click(function() {
		let name = $("#f-name").val();
		let donator = $("#f-donator").val();
		let donationMoney = $("input[name='donationMoney']:checked").val();

		var IMP = window.IMP; // 생략가능
		IMP.init('imp36238857');
		// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		IMP.request_pay({
			pg : 'inicis', // version 1.1.0부터 지원.
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

			pay_method : 'card',
			/*
			 'samsung':삼성페이,
			 'card':신용카드,
			 'trans':실시간계좌이체,
			 'vbank':가상계좌,
			 'phone':휴대폰소액결제
			 */
			merchant_uid : 'merchant_' + new Date().getTime(),
			/*
			 merchant_uid에 경우
			 https://docs.iamport.kr/implementation/payment
			 위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
			 참고하세요.
			 나중에 포스팅 해볼게요.
			 */
			name : '주문명:결제테스트',
			//결제창에서 보여질 이름
			amount : donationMoney,
			//가격
			buyer_email : 'iamport@siot.do',
			buyer_name : name,
			buyer_tel : '010-1234-5678',
			buyer_addr : '서울특별시 강남구 삼성동',
			buyer_postcode : '123-456',
			m_redirect_url : 'https://www.yourdomain.com/payments/complete'
		/*
		 모바일 결제시,
		 결제가 끝나고 랜딩되는 URL을 지정
		 (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
		 */
		}, function(rsp) {
			
			console.log(rsp);
			if (rsp.success) {
			var msg1 = '결제가 완료되었습니다.';
			/* msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num; */
			alert(msg1);
			$(document).ready(function() {
			  var money=$("input[name='donationMoney']:checked").val();
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
			
			
			/* console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				msg += '이름 : ' + rsp.buyer_name;
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			location.href='${contextPath}/app/donation/detail?no=${boardNo}&payMethod=0';
			}
			alert(msg);
			location.href='$add?no=${boardNo}&payMethod=0';
			//window.location.href = "add";

		});
	}); */
</script>











































