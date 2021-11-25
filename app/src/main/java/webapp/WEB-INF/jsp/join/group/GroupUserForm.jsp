<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
	 <!---------------------------------------- main ---------------------------> 
		 <main>
		   <div class="page-section">
			<div class="container">
			<form action="add" name="form" method="post" onsubmit="validLoginForm(); return false;" enctype="multipart/form-data" class="needs-validation" novalidate>
				<h1 class="title-h">회원가입 - 단체</h1>
				<div class="join-wrap">
				 <h5>기본정보<span class="required_title"><em class="icon_required">·</em>표시는 반드시 입력하셔야 합니다.</span></h5>
				   <div class="base-table">
					 <table class="join-table">
					   <caption>개인회원 기본정보</caption>
						<tbody>
						 <tr>
						   <th><em class="icon_required">·</em><span>아이디</span></th>
						   <td>
							 <label for='f-id' class="sr-only sr-cont">아이디</label> 
							 <input id='f-id' class="form-control form-sub-control box-input" type='text' name='id' placeholder="아이디">
							 <button type="button" class="btnj btn btn-primary" id="person-id">중복확인</button>
							
						   </td>
						 </tr>
						 <!-- //아이디 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>비밀번호</span></th>
						   <td>
							 <label for='f-password' class="sr-only">비밀번호</label> 
							 <input id='f-password' class="form-control box-input" type='password' name='password' placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함">
						   </td>
						 </tr>
						 <!-- //비밀번호 -->
						 <tr>
							<th><em class="icon_required">·</em><span>비밀번호확인</span></th>
							<td>
							  <label for='f-passwordConfirm' class="sr-only">비밀번호확인</label> 
							  <input id='f-passwordConfirm' class="form-control box-input" type='password' name='passwordConfirm' placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함">
							</td>
						  </tr>
						  <tr>
               <th><span>사진</span></th>
               <td>
               <label for='f-photo' class="sr-only">사진</label> 
               <input id='f-photo' class="form-control box-input" type='file' name='photoFile'>
               </td>
             </tr>
						 <tr>
						   <th><em class="icon_required">·</em><span>이름</span></th>
						   <td>
							 <label for='f-name' class="sr-only">이름</label> 
							 <input id='f-name' class="form-control box-input" type='text' name='name'>
						   </td>
						 </tr>
						 <!-- //이름 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>휴대폰번호</span></th>
						   <td>
							 <label for='f-tel' class="sr-only">휴대폰번호</label> 
							 <input id='f-tel' class="form-control box-input" type='tel' name='tel'>
						   </td>
						 </tr>
						 <!-- //휴대폰번호 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>이메일</span></th>
						   <td>
							 <label for='f-email' class="sr-only">이메일</label> 
							 <input id='f-email' class="form-control box-input" type='email' name='email'>
						   </td>
						 </tr>
						 <!-- //이메일 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>주소</span></th>
						   <td>
							 <div>
							   <label for='f-postNo' class="sr-only">우편번호</label> 
							   <input  type='text' id='f-postNo' class="form-control form-sub-control box-input" name='postNo' placeholder="우편번호" readonly>
								 <input type="button" onclick="findByPostNo()" value="우편번호 찾기" class="btnj btn btn-primary" id="post-no"></input><br>
							 </div>
							 <div>
								 <label for='f-basicAddress' class="sr-only sr-cont">기본주소</label> 
							   <input id='f-basicAddress' class="form-control form-sub-control postfo box-input" type='text' name='basicAddress' placeholder="기본주소" readonly><br>       
							 </div>
							 <div>
							   <label for='f-detailAddress' class="sr-only sr-cont">상세주소</label> 
							   <input id='f-detailAddress' class="form-control form-sub-control postfo box-input" type='text' name='detailAddress' placeholder="상세주소" >
							 </div>
						   </td>
						 </tr>
						 <!-- //주소 -->
						 <tr>
						   <th><em class="icon_required">·</em><span>소속인원</span></th>
						   <td>
							 <label for='f-groupCount' class="sr-only">소속인원</label> 
							 <input id='f-groupCount' class="form-control box-input" type='number' name='groupCount'>
						   </td>
						 </tr>
						 <!-- //이름 -->
						</tbody>
					 </table>
				   </div>
				   <div class="btn-regi">
					   <button type="submit" class="btn btn-primary nBtn">회원가입</button>
					   <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
				   </div>
				 </div>  <!-- //join-wrap -->
				
			   </form>
					 </div> <!-- //container -->
				 </div>
			 </main>  


			 <script>
				 document.querySelector("#person-id").onclick = () => {
					 var name = document.querySelector("#f-id");
					 if (name.value == "") {
						 alert("이미 존재하는 아이디입니다!");
						 name.focus();
						 return; 

						} else {
							alert("사용 가능한 아이디입니다!");
						}
					}
						
					// 유효성 검사 메서드
					function validLoginForm() {
					// onsubmit="validLoginForm(this); return false;"도 가능
					var form = document.form; // name으로 form tag 찾기
					//var form = document.querySelector("form"); // form태그 바로 찾기
					//var form = document.querySelector("#id-tag"); // id로 찾기 
					//var form = document.querySelector(".ccc"); // class로 찾기

					var loadForm = false;
					if (loadForm) {
						alert("처리중입니다. 잠시만 기다려주세요");
						return;
					}

					form.id.value = form.id.value.trim(); // 공백제거
					
					if(form.id.value.length == 0) {
						alert("로그인 아이디를 입력해주세요!");
						form.id.focus();
						return;
					}

					form.password.value = form.password.value.trim();
					
					if(form.password.value.length == 0) {
						alert("로그인 비밀번호를 입력해주세요!");
						form.password.focus();
						return;
					}

					form.passwordConfirm.value = form.passwordConfirm.value.trim();

					if (form.password.value != form.passwordConfirm.value ) {
						alert("비밀번호가 일치하지 않습니다! 다시 입력해주세요");
						form.passwordConfirm.focus();
						return;
					}

					form.name.value = form.name.value.trim();
					
					if(form.name.value.length == 0) {
						alert("이름을 입력해주세요!");
						form.name.focus();
						return;
					}

					form.tel.value = form.tel.value.trim();
					
					if(form.tel.value.length == 0) {
						alert("전화번호를 입력해주세요!");
						form.tel.focus();
						return;
					} else if (form.tel.value.indexOf("-") == -1) {
						alert("-를 포함해서 입력해주세요! ex) 010-xxxx-xxxx");
						form.tel.focus();
						return;
					}

					form.email.value = form.email.value.trim();
					
					if(form.email.value.length == 0) {
						alert("이메일을 입력해주세요!");
						form.email.focus();
						return;

					} else if (form.email.value.indexOf("@") == -1) {
						alert("@를 포함해서 입력해주세요! ex) sample@naver.com");
						form.email.focus();
						return;
					}

					form.groupCount.value = form.groupCount.value.trim();

					if(form.groupCount.value.length == 0) {
						alert("소속인원를 입력해주세요!");
						form.groupCount.focus();
						return;
					}

					form.submit();
					loadForm = true;
				}

//document.querySelector("button").addEventListener("click", validLoginForm());


			</script>

			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script>
				function findByPostNo() {
					new daum.Postcode({
						oncomplete: function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if(data.userSelectedType === 'R'){
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if(data.buildingName !== '' && data.apartment === 'Y'){
								extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if(extraAddr !== ''){
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("f-detailAddress").value = extraAddr;
						
						} else {
							document.getElementById("f-detailAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('f-postNo').value = data.zonecode;
						document.getElementById("f-basicAddress").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("f-detailAddress").focus();
					}
					}).open();
				}
			</script> <!--우편번호찾기 API -->
		 