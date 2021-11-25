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
	<form action='add' method="post">

		<label for='f-donationBoard'>모금함번호</label> <input id='f-donationBoard'
			type='number' name='donationBoard' value="${donationBoardNo}"
			readonly><br>
		<!--  
    <label for='f-donator'>기부자</label> 
    <input id='f-donator' type="number" name='donator'><br>
    -->

		<label for='f-donationMoney'>기부금액</label> <input id='f-donationMoney'
			type='number' name='donationMoney'><br> <label
			for='f-registerationNumber'>주민등록번호</label> <input
			id='f-registerationNumber' type='number' name='registerationNumber'><span>-</span><input
			id='f-backRegisterationNumber' type='password'
			name='registerationNumber'><br>

		<c:forEach items="${payTypes}" var="donationRegisterPayType">
			<label for='f-payType'>${donationRegisterPayType.title}</label>
			<input id='f-payType' type='radio' name='payType'
				value="${donationRegisterPayType.no}">
			<br>
		</c:forEach>
		<br>
		<button id='register-Button'>기부하기</button>
		<br>
	</form>

	<script>
document.querySelector("#register-Button").onclick = () => {
    var frontRegiNumber = document.querySelector("#f-registerationNumber");
    var backRegiNumber = document.querySelector("#f-backRegisterationNumber");
    if (frontRegiNumber.value.length < 7 && backRegiNumber.value.length < 7) {
      alert("주민등록번호를 다시 입력 해주세요");
      return false; 
    } 
  }
</script>
</body>
</html>


<main>
	<div class="page-section">
		<div class="container">
			<h1 class="title-h">후원하기</h1>
			<div class="join-wrap">
				<div class="wrapper">
					<ul class="steps">
						<li class="is-active">1.후원자 정보 입력</li>
						<li>2.후원금액 입력</li>
						<li>3.결제하기</li>
					</ul>
					<form class="form-wrapper" action='add' method="post">
						<!-- 후원자 정보 -->
						<fieldset class="section is-active">
							<h4 class="form-title">1. 후원자 정보</h4>
							<input id="f-name" class="form-control box-input" type="text"
								name="name" placeholder="이름">
							<div class="jumin">
								<input id="f-registerationNumber" class="numberJumin"
									type="number" style="width: 33%;" name="registerationNumber"
									placeholder="주민등록번호 앞자리"> <span>-</span> <input
									id="f-backRegisterationNumber" class="numberJumin"
									type="password" style="width: 33%;" name="registerationNumber"
									placeholder="주민등록번호 뒷자리">
							</div>
							<input id="f-tel" class="form-control box-input" type="tel"
								name="tel" placeholder="휴대폰번호"> <input id="f-email"
								class="form-control box-input" type="email" name="email"
								placeholder="이메일주소"> <input type="button" name="next"
								class="button action-button" value="다음" />
						</fieldset>
						<!-- //후원자 정보 -->
						<fieldset class="section">
							<h4 class="form-title">2. 후원금액</h4>
							<div class="row cf">
								<div class="four col">
									<input type="radio" name="donationMoney" id="man" checked>
									<label for="man">
										<h6>10,000원</h6>
									</label>
								</div>
								<div class="four col">
									<input type="radio" name="donationMoney" id="sam"><label
										for="sam">
										<h6>30,000원</h6>
									</label>
								</div>
								<div class="four col">
									<input type="radio" name="donationMoney" id="oh"><label
										for="oh">
										<h6>50,000원</h6>
									</label>
								</div>
								<div class="four col">
									<input type="radio" name="donationMoney" id="sib"><label
										for="sib">
										<h6>100,000원</h6>
									</label>
								</div>
							</div>
							<input type="button" name="next" class="button action-button"
								value="다음" />
						</fieldset>
						<!-- //후원금액 -->
						<fieldset class="section">
							<h4 class="form-title">3. 결제하기</h4>
							<div class="form-box-do">
								<c:forEach items="${payTypes}" var="donationRegisterPayType">
									<label for="f-payType" class="container-radio"
										style="padding-right: 9px;">카드결제 <input type="radio"
										id="f-payType" name="payType" checked>
								</c:forEach>
								<span class="checkmark"></span> </label>
							</div>
							<input type="button" name="next" class="button action-button"
								value="결제하기" />
						</fieldset>
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
<script>
$(document).ready(function(){
  $(".form-wrapper .button").click(function(){
    var button = $(this);
    var currentSection = button.parents(".section");
    var currentSectionIndex = currentSection.index();
    var headerSection = $('.steps li').eq(currentSectionIndex);
    currentSection.removeClass("is-active").next().addClass("is-active");
    headerSection.removeClass("is-active").next().addClass("is-active");

    $(".form-wrapper").submit(function(e) {
      e.preventDefault();
    });

    if(currentSectionIndex === 3){
      $(document).find(".form-wrapper .section").first().addClass("is-active");
      $(document).find(".steps li").first().addClass("is-active");
    }
  });
});

    </script>
