<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>


    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../../assets/img/bg_image_3.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
               <li class="breadcrumb-item"><a href="${contextPath}/app/home">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">함께해요</li>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->
    
  <main>
    <div class="page-section">
      <div class="container">
        <h3 class="widget-title">${volunteer.title}</h3>
        <div class="divider"></div>
        <div class="vol-detail">
          <div class="vol-de-img">
           <img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
          </div>
          
          <!-- //vol-de-img -->
          <div class="vol-infor-wrap">

            
             <!-- vol-joiner -->
             <div class="vol-joiner">
               <div style="padding:10px;">
              <span class="vol-cur">
                
                <span class="sr-only">참여인원</span>
                <b class="vol-count">${volunteer.currentNum}명</b>
                /
                <span class="sr-only">총 모집인원</span>
                ${volunteer.limitNum}명
              </span>
              <div class="progress">
                <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <input type="hidden" id="volunteerNo" value="${volunteer.no}"/>
              <button type="button"  onclick="joinMember();" class="btn btn-secondary" style="margin: 25px 165px;">참여자보기</button>
               <a href="join/list?no=${volunteer.no}" class="btn btn-outline-primary nBtn" style="margin: 25px 165px; role="button" >참여자보기22</a>
            </div>
             </div>  <!-- //vol-joiner -->
            
             <!-- vol-owner -->
             <div class="vol-owner">
              <div class="social-mini-button">
                <span class="owner-right"><span>주최자</span> : <b>${volunteer.owner.id}</b></span>
                <span class="owner-right">${volunteer.tel}</span>
                <span class="owner-right">${volunteer.email}</span>
              </div>
             </div> <!-- //vol-owner -->
           
             <div class="vol-detail-infor">
               <ul>
                 <li>
                   <span>봉사기간</span> :
                   <span>${volunteer.startDate} ~ ${volunteer.endDate}</span><span>총 ${volunteerDate.totalDate}일</span>
                 </li>
                 <li>
                   <span>봉사시간</span> :
                   <span>${volunteer.startTime} ~ ${volunteer.endTime}</span>
                 </li>
                 <li>
                    D-day ${volunteerDate.remainDate}일
                 </li>
               </ul>
             </div>  <!-- //vol-detail-infor -->
          </div>  <!-- //vol-infor-wrap -->
       </div>   <!-- //vol-detail -->
       
       
        <div class="vol-con-wrap">
            <h3 class="widget-title" id="scroll-section1" style="padding-top:30px;" >상세정보</h3>
            <div class="divider"></div>
              <div class="col-lg-12">
                <div class="widget">
                  <div class="widget-box">
                test
                  </div>
               </div>
            </div>
          </div> <!-- vol-con-wrap -->
    

         <div>
            <h3 class="widget-title" style="padding-top:30px;">위치</h3>
            <div class="divider"></div>
            <div class="content-map">
            </div>
         </div>
         
            <h1 class="widget-title" style="padding-top:30px;"><a>문의하기</a></h1>
            <div class="content-box chall-box" style="background: #81BEF7">
              <c:forEach items="${volunteerQuestion}" var="volunteerQuestionDTO" varStatus="vs">
              <div class="ch-balloon left" style="margin-top: 1%; margin-bottom: 1%; margin-left:18%; float:center"><span>
                <div class= "class" id="id" style="display: none">
                    ${volunteerQuestionDTO.no}
                </div>
                    -${volunteerQuestionDTO.joinUser.id}-<br>
                    ${volunteerQuestionDTO.content}<br>
                    ${volunteerQuestionDTO.registeredDate}</span>
                    <!-- 모달 창 -->
                    <c:if test="${sessionScope.loginUser.no == volunteerQuestionDTO.joinUser.no}">
                    <!-- 아래에서 data-toggle과 data-target 속성에서 data-toggle에는 modal 값을 data-target속성에는 모달 창 전체를 
                     감싸는 div의 id 이름을 지정하면 된다. -->
                  &nbsp;&nbsp;<a data-toggle="modal" href="#myModalQuestionU${vs.index}">[변경]</a>
                    </c:if>
                    <!-- 부트스트랩의 모달 창을 사용할려면 아래의 class 이름들을 그대로 사용해야 한다. 변경하면 모양이 달라진다.-->
                    <div class="modal fade" id="myModalQuestionU${vs.index}" role="dialog"> <!-- 사용자 지정 부분① : id명 -->
                      <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                          <div class="modal-header">
                            <h4 class="modal-title">문의 수정</h4> <!-- 사용자 지정 부분② : 타이틀 -->
                            <button type="button" class="close" data-dismiss="modal">X</button>
                          </div>
                          
                            <form action='question/update' method="post">
                               <div class="modal-body">
                                 <div class= "class" id="id" style="display:none">
	                                <label for='f-questionNo'>문의번호</label> <input id='f-questionNo' type='text' name='no' value='${volunteerQuestionDTO.no}' readonly>
                                 </div>
	                                 
                                  <textarea id='f-content' name='content' cols="55" rows="1" class="modal-body">${volunteerQuestionDTO.content}</textarea>
	                                <label for='f-owner'>작성자</label> 
	                                <span id='f-owner'>${volunteerQuestionDTO.joinUser.id}</span><br>
	                            
	                                <label for='f-registeredDate'>등록일</label> 
                                   <span id='f-registeredDate'>${volunteerQuestionDTO.registeredDate}</span><br>
                                  </div>
                                  
                                  <div class= "class" id="id" style="display:none">
                                      <input id='f-owner' type='text' name='owner' value='${volunteerQuestionDTO.joinUser.id}' readonly>
                                  </div>
	                                  
                                  <div class= "class" id="id" style="display:none">
                                      <input id='f-registeredDate' type='text' name='registeredDate' value='${volunteerQuestionDTO.registeredDate}' readonly>   
                                  </div>
                                   <button>수정완료</button><br>
                             </form>
                          
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <!-- 모달 창 -->
                    <c:if test="${sessionScope.loginUser.no == volunteerQuestionDTO.joinUser.no}">
                    <a href='question/delete?no=${volunteerQuestionDTO.no}'>[삭제]</a>
                    </c:if>
                    
                  <c:if  test="${volunteerQuestionDTO.reply != null}" >
                <div class="ch-balloon right" style="margin-bottom: 1%; margin-left: 70%; float:center"><span>
                    -관리자 답글-<br>
                    ${volunteerQuestionDTO.reply}
                </span></div><br>
                  </c:if>
              </c:forEach>
              <form action='question/add' method="post">
                <div class="questionAdd">
                  <div class= "class" id="id" style="display:none">
                    <label for='f-no'>봉사번호</label> <input id='f-no' type='text' name='no' value='${volunteer.no}' readonly>
                  </div><br>
                     <textarea id='f-content' name='content' cols=100% rows="1" class="modal-body" style="margin-left:10%; float: left;"></textarea>
                </div>
                    <button style="margin-left:3%; margin-top:1.7%;">문의등록</button>
              </form>
            </div>
         </div> <!-- col-lg-12 -->
         
         
       </div>
        <div class="btn-regi">
          <button type="button" class="btn btn-primary nBtn" onclick="location.href='join/detail?no=${volunteer.no}'")>참여하기</button>
          <button type="button" class="btn btn-primary nBtn" onclick="history.go(-1)")>참여하기111</button>
            <input type="button" class="btn btn-outline-primary nBtn" value="이전" onClick="history.go(-1)" role="button">
        </div> <!-- //btn-regi -->       
      </div>  <!-- //container -->
    </div>  <!-- //page-section -->
  </main>

<script>
var volunteerNo = document.querySelector("#volunteerNo");
var no = volunteerNo.textContent;
function joinMember() {
  location.href = "join/list?no="+no;
}
</script>
<script>
    $(document).ready(function () { 
      var page_url = window.location.href; 
      var page_id = page_url.substring(page_url.lastIndexOf("#") + 1); 
      // alert(page_id); 
      if (page_id == 'section1') { 
        $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 500); 
        } else if (page_id == 'section2') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 500); 
        } else if (page_id == 'section3') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 500); 
        } 
      });
    </script>










