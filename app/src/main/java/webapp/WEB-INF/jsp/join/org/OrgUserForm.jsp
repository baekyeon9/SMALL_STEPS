<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
    	
    <main>
      <div class="page-section">
				<div class="container">
				<form action="add" name="form" method="post" onsubmit="validLoginForm(); return false;" enctype="multipart/form-data">
					<h1 class="title-h">회원가입 - 기관</h1>
				  <div class="join-wrap">
            <h5>기본정보<span class="required_title"><em class="icon_required">·</em>표시는 반드시 입력하셔야 합니다.</span></h5>
              <div class="base-table">
                <table class="join-table">
                  <caption>단체 회원 기본정보</caption>
									<tbody>
                 <tr class="mb-3 row-7">
                      <th class="col-sm-2"><em class="icon_required">·</em><span>아이디</span></th>
                      <td class="col-sm-7 ">
                        <label for='f-id' class="sr-only sr-cont">아이디</label> 
                        <input id='f-id' class="form-control form-sub-control box-input" type='text' name='id' placeholder="아이디" required>
		                     <div class="invalid-feedback">
		                       이미 존재하는 아이디입니다.
		                     </div>
                     <div class="col-auto" style="overflow:hidden;">
                        <button id="x-id-check-btn" type="button" class="btnj btn btn-primary">중복확인</button>
                     </div>
                      </td>
                    </tr>
                    <!-- //아이디 -->
	                 <tr class="position-relative">
	                   <th><em class="icon_required">·</em><span>비밀번호</span></th>
	                   <td>
	                     <label for='f-password' class="sr-only">비밀번호</label> 
	                     <input id='f-password' class="form-control box-input pw" type='password'
	                      name='password1' placeholder="4~12자의 영문 대소문자와 숫자로만 입력" required>
	                     <div class="invalid-feedback">
	                       비밀번호를 입력해주세요.
	                     </div>
	                   </td>
	                 </tr>
                    <!-- //비밀번호 -->
		                 <tr>
		                <th><em class="icon_required">·</em><span>비밀번호확인</span></th>
		                <td>
		                  <label for='f-passwordChk' class="sr-only">비밀번호확인</label> 
		                  <input id='f-passwordChk' class="form-control box-input pw" type='password'
		                   name='password' placeholder="4~12자의 영문 대소문자와 숫자로만 입력" onKeyUp="fn_compare_pwd();" required>
		                  <div class="invalid-feedback">
		                    비밀번호를 확인해 해주세요.
		                  </div>
		                  <div id="alert-danger" style="display: none; color: #dc3545; border-color: #dc3545; font-size: 80%">
		                    비밀번호가 일치하지 않습니다.
		                  </div>
		                </td>
		              </tr>
		              <!-- //비밀번호 확인 -->
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
                        <input id='f-name' class="form-control box-input" type='text' name='name' required>
	                     <div class="invalid-feedback">
	                       이름을 입력해주세요.
	                     </div>
                      </td>
                    </tr>
                    <!-- //이름 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>휴대폰번호</span></th>
                      <td>
                        <label for='f-tel' class="sr-only">휴대폰번호</label> 
                        <input id='f-tel' class="form-control box-input" type='tel' name='tel' required>
	                     <div class="invalid-feedback">
	                       휴대폰번호를 입력해주세요.
	                     </div>
                      </td>
                    </tr>
                    <!-- //휴대폰번호 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>이메일</span></th>
                      <td>
                        <label for='f-email' class="sr-only">이메일</label> 
                        <input id='f-email' class="form-control box-input" type='email' name='email' required>
	                     <div class="invalid-feedback">
	                       이메일을 입력해주세요.
	                     </div>
                      </td>
                    </tr>
                    <!-- //이메일 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>주소</span></th>
                      <td>
                        <div>
                          <label for='f-postNo' class="sr-only">우편번호</label> 
                          <input id='f-postNo' class="form-control form-sub-control box-input" type='text' name='postNo' readonly>
	                        <button type="button" onclick="findByPostNo()" value="우편번호 찾기" class="btnj btn btn-primary" id="post-no">>우편번호</button>
                        </div>
                        <div>
	                        <label for='f-basicAddress' class="sr-only sr-cont">기본주소</label> 
                          <input id='f-basicAddress' class="form-control form-sub-control postfo box-input" type='text' name='basicAddress' placeholder="기본주소" readonly>          
                        </div>
                        <div>
                          <label for='f-detailAddress' class="sr-only sr-cont">상세주소</label> 
                          <input id='f-detailAddress' class="form-control form-sub-control postfo box-input" type='text' name='detailAddress' placeholder="상세주소" required>
                        </div>
	                     <div class="invalid-feedback">
	                       주소를 입력해주세요.
	                     </div>
                      </td>
                    </tr>
                    <!-- //주소 -->
                    <tr>
                      <th><em class="icon_required">·</em><span>사업자번호</span></th>
                      <td>
                        <label for='f-corpNo' class="sr-only">사업자번호</label> 
                        <input id='f-corpNo' class="form-control box-input" type='tel' name='corpNo' required>
                       <div class="invalid-feedback">
                         사업자 번호를 입력해주세요.
                       </div>
                      </td>
                    </tr>
                    <!-- //사업자번호 -->
                    <tr>
                      <th><span>팩스번호</span></th>
                      <td>
                        <label for='f-fax' class="sr-only">팩스번호</label> 
                        <input id='f-fax' class="form-control box-input" type='tel' name='fax'>
                      </td>
                    </tr>
                    <!-- //팩스 -->
                    <tr>
                      <th><span>홈페이지</span></th>
                      <td>
                        <label for='f-homepage' class="sr-only">홈페이지</label> 
                        <input id='f-homepage' class="form-control box-input" type='url' name='homepage'>
                      </td>
                    </tr>
                    <!-- //홈페이지 -->
									</tbody>
                </table>
              </div>
              <div class="btn-regi">
	              <button type="submit" id="x-add-btn" class="btn btn-primary nBtn">회원가입</button>
	              <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
              </div>
            </div>
            <!-- //join-wrap -->
            
				</form>
				</div>
        <!-- //container -->
			</div>
		</main>  
		
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
       <script>
       //비밀번호 재확인
       $('.pw').focusout(function () {
           var pwd1 = $("#f-password").val();
           var pwd2 = $("#f-passwordChk").val();
     
           if ( pwd1 != '' && pwd2 == '' ) {
               null;
           } else if (pwd1 != "" || pwd2 != "") {
               if (pwd1 == pwd2) {
                   $("#alert-danger").css('display', 'none');
               } else {
                   $("#alert-danger").css('display', 'inline-block');
               }
           }
       });
       
       // 아이디 중복검사
       var addBtn = document.querySelector("#x-add-btn");
       var idTag = document.querySelector("#f-id");
       addBtn.setAttribute("disabled", "disabled");

       document.querySelector("#x-id-check-btn").onclick = () => {
           var xhr = new XMLHttpRequest();
           xhr.addEventListener("load", function() {
             if (this.responseText == "false") {
                 addBtn.removeAttribute("disabled");
                 idTag.classList.remove("is-invalid");
             } else {
               addBtn.setAttribute("disabled", "disabled");
               idTag.classList.add("is-invalid");
             }
           })
           xhr.open("get", "checkId?id=" + idTag.value);
           xhr.send();
       };
       
       //입력창 확인
       document.querySelectorAll("input").forEach(input => {
           input.addEventListener("invalid", () => {
             
             // 검증 후 폼에 was-validated 클래스로 표시
             document.forms[0].classList.add("was-validated")
           })
         })
         
       window.addEventListener('load', function () {
            var forms = document.getElementsByClassName('needs-validation');

            var validateGroup = document.getElementsByClassName('validate-me');

            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }

                    for (var i = 0; i < validateGroup.length; i++) {
                        validateGroup[i].classList.add('was-validated');
                    }
                }, false);
            });
        }, false); 
            

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


        </script>
		
