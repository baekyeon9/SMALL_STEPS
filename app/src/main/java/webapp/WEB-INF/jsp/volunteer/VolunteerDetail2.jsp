<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>봉사상세보기</title>
  <style>
  
  label {
    margin-right: 10px;
    text-align: right;
    display: inline-block;
    width: 80px;
  }
  
  .form-border {
    border: 2px solid red;
  
  }

  
  </style>
</head>
<body>
    <h1>[ 봉사상세보기 ]</h1>


<form action='update'>
  <div class="form-border">

    <label for='v-no'>번호</label> 
    <input id='v-no' type='text' name='no' value='${volunteer.no}' readonly><br>
    
    <label for='v-title'>제목</label> 
    <input id='v-title' type='text' name='title' value='${volunteer.title}' ><br>
    
    <label for='v-owner'>주최자</label> 
    <input id='v-owner' type='text' name='owner' value='${volunteer.owner.id}' readonly><br>
    
    
    <label for='v-category'>카테고리</label> 
    <input id='v-category' type='text' name='category' value='${volunteer.category.title}' ><br>
     
    <label for='v-tel'>전화번호</label> 
    <input id='v-tel' type='tel' name='tel' value='${volunteer.tel}' ><br>
    
    <label for='v-email'>이메일</label>
    <input id='v-email' type='email' name='email' value='${volunteer.email}' readonly><br>
    
    <label for='v-startdate'>시작일</label> 
    <input id='v-startdate' type='text' name='startDate' value='${volunteer.startDate}'><br>
    
    <label for='v-enddate'>종료일</label> 
    <input id='v-enddate' type='text' name='endDate' value='${volunteer.endDate}'><br>
    
    <label for='v-starttime'>시작시간</label> 
    <input id='v-starttime' type='text' name='startTime' value='${volunteer.startTime}'><br>
    
    <label for='v-endtime'>종료시간</label> 
    <input id='v-endtime' type='text' name='endTime' value='${volunteer.endTime}'><br>
    
    <label for='v-totaldate'>총일수</label> 
    <input id='v-totaldate' type='text' name='totalDate' value='${volunteerDate.totalDate}일' readonly><br>
    
    <label for='v-remaindate'>남은기간</label> 
    <input id='v-remaindate' type='text' name='remainDate' value='${volunteerDate.remainDate}일' readonly><br>
    
    <label for='v-currentnum'>현재인원</label> 
    <input id='v-currentnum' type='text' name='currentNum' value='${volunteer.currentNum}명' readonly><br>
    
    <label for='v-limitnum'>총인원</label> 
    <input id='v-limitnum' type='text' name='limitNum' value='${volunteer.limitNum}명'><br>
    
    <label for='v-content'>내용</label> 
    <input id='v-content' type='text' name='content' value='${volunteer.content}'><br>
    
    </div>
<button>변경</button>


 <a href='delete?no=${volunteer.no}'>[삭제]</a> 
 <a href='list'>[목록]</a>
 <a href='join/list?no=${volunteer.no}'>[참여자 목록]</a><
 <a href='join/add?no=${volunteer.no}'>[참여하기]</a><br>
</form>
</body>
</html>








=======
<!-- 11/21 수정 전 파일 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../../assets/img/bg_image_3.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html" style="font-size:20px;">함께해요</a></li>
                <li class="breadcrumb-item active" aria-current="page" style="font-size:22px;">봉사목록</li>
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
              <button type="button" class="btn btn-primary open" id="btn-modal">봉사 참여자 목록</button>
            </div>
             </div>  <!-- //vol-joiner -->
             <div class="vol-owner">  <!-- vol-owner -->
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
       
      <!-- 모달창 띄우기 -->
    <div id="vol-modal" class="vol-modal-overlay">
        <div class="vol-modal-window ">
            <div class="close-area">X</div>
            <div class="vol-title">
                <h1>[ 참여자 목록 ]</h1>
            </div>
            <div class="vol-content">
					    <table>
					      <thead>
					        <tr>
					          <th>번호</th>
					          <th>아이디</th>
					          <th>이름</th>
					          <th>시작시간</th>
					          <th>신청일</th>
					        </tr>
					      </thead>
					      <tbody>
					        <c:forEach items="${volunteerList}" var="volunteerJoinDTO" >
					          <tr>
					              <td>${volunteerJoinDTO.volunteer.no}</td> 
					              <td>${volunteerJoinDTO.joinUser.id}</td> 
					              <td>${volunteerJoinDTO.joinUser.name}</td> 
					              <td>${volunteerJoinDTO.startTime}</td> 
					              <td>${volunteerJoinDTO.registeredDate}</td> 
					          </tr>
					        </c:forEach>
					      </tbody>
					    </table>
            <%-- <button type="button" class="btn btn-primary" data-toggle="modal" onclick="location.href='join/list?no=${volunteer.no}'" >참여자목록</button>--%>
            </div>
        </div>
    </div> <!-- 모달 끝 -->
    
     <div style="margin-top: 35px; display: flex; justify-content: center; text-align: center;">
      <div class="vol-con-wrap">
       <p>
        <button class="btn btn-primary" type="button"  onclick="location.href='detail?no=${volunteer.no}#section1'" >
          <a class="widget-title" id="section1">상세보기 (Detail)</a>
        </button>
        <button class="btn btn-primary" type="button" onclick="location.href='detail?no=${volunteer.no}#section2'">
           <a class="widget-title" id="section2">참여인증 & 댓글 (Review)</a>
         </button>
        <button class="btn btn-primary" type="button" onclick="location.href='detail?no=${volunteer.no}#section3'">
           <a class="widget-title" id="section3">위치 (Location)</a>
         </button>
        <button class="btn btn-primary" type="button" onclick="location.href='detail?no=${volunteer.no}#section4'">
           <a class="widget-title" id="section4">문의하기 (Q & A)</a>
         </button>
      </p>
    </div>
  </div> <!-- style -->
    
    
        <div class="vol-con-wrap">
            <h3 class="widget-title" id="scroll-section1" style="padding-top:30px;" >상세정보</h3>
            <div class="divider"></div>
              <div class="col-lg-12">
                <div class="widget">
                  <div class="widget-box">
                    <form action="#" class="form-contact" method="post" enctype="multipart/form-data" name="form" >
                      <div class="row">
                        <div class="col-sm-12 py-2">
                          <label for="title" class="fg-grey">제목</label>
                          <input type="text" class="form-control" id="title" name="title" value="${volunteer.title}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">전화번호</label>
                          <input type="text" class="form-control" id="tel" name="tel" value="${volunteer.tel}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">이메일</label>
                          <input type="email" class="form-control" id="email" value="${volunteer.email}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작일</label>
                          <input type="text" class="form-control" id="startDate" value="${volunteer.startDate}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료일</label>
                          <input type="text" class="form-control" id="endDate" value="${volunteer.endDate}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작시간</label>
                          <input type="text" class="form-control" id="startTime" value="${volunteer.startTime}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료시간</label>
                          <input type="text" class="form-control" id="endTime" value="${volunteer.startTime}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">총모집인원</label>
                          <input type="text" class="form-control" id="limitNum" value="${volunteer.limitNum}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="content" class="fg-grey">내용</label>
                          <textarea id="content" rows="8" class="form-control">${volunteer.content}</textarea >
                        </div>
                      </div>
                    </form>
                  </div>
		           </div>
		        </div>
	        </div> <!-- vol-con-wrap -->
	        
	          <div class="vol-con-wrap"> <!--  #scroll-' + page_id-->
               <h3 class="widget-title" id="scroll-section2" style="padding-top:30px;" >참여인증 & 댓글</h3>
              <div class="divider"></div>
              <div class="col-lg-12">
                <div class="widget">
                  <div class="widget-box">
                     <div class="cont-short-list">
								        <c:forEach items="${volunteerShortReviewList}" var="volunteerShortReviewDTO">
								        <div class="s-review-list">
								          <div class="review-view">
								            <ul>
								              <li>
								                <div class="review-section">
								                  <div class="profile-thumb">
								                    <img src="${contextPath}/assets/img/level.png" alt="프로필사진">
								                  </div>
								                  <div class="review-infor">
								                    <div class="review-post">
								                      <div class="profile-infor">
								                        <span>${volunteerShortReviewDTO.owner.id}</span>
								                        <span class="txt_date">${volunteerShortReviewDTO.registeredDate}</span>
								                   <%-- <span class="ico_bbs ico_new">새글</span>--%>          
								                      </div>
								                         <div class="review-post">
								                        <p><span>${volunteerShortReviewDTO.content}</span></p>
								                      </div>
								                      <div class="review-btn">
								                        <a href='reviewUpdate?no=${volunteerShortReviewDTO.no}' class="link_menu">[수정]</a>
								                        <a href='reviewDelete?no=${volunteerShortReviewDTO.no}' class="link_menu">[삭제]</a>
								                      </div>
								                    </div>
								                  </div>
								                 </div>
							                 </li>             
								              </ul>
								            </div>
								          </div>
								          </c:forEach>
								          <!-- //s-review-list -->
								        </div>
								        
								               <button class="btn btn-primary" type="button" onclick="location.href='reviewList?no=${volunteer.no}'">상세정보</button>
								        
									        <div class="col-12 my-5">
									          <nav aria-label="Page Navigation">
									            <ul class="pagination justify-content-center">
									              <li class="page-item disabled">
									                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
									              </li>
									              <li class="page-item active" aria-current="page">
									                <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
									              </li>
									              <li class="page-item">
									                <a class="page-link" href="#">2</a>
									              </li>
									              <li class="page-item"><a class="page-link" href="#">3</a></li>
									              <li class="page-item">
									                <a class="page-link" href="#">Next</a>
									              </li>
									            </ul>
									          </nav>
									        </div>
		                  </div>
		               </div>
		            </div>
		          </div> <!-- vol-con-wrap -->
	                          

         <div>
            <h3 class="widget-title" style="padding-top:30px;" id="scroll-section3">위치</h3>
            <div class="divider"></div>
=======
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>


<div class="page-banner bg-img bg-img-parallax overlay-dark"
	style="background-image: url(../assets/img/bg_image_3.jpg);">
	<div class="container h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col-lg-8">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
						<li class="breadcrumb-item"><a href="index.html"
							style="font-size: 20px;">함께해요</a></li>
						<li class="breadcrumb-item active" aria-current="page"
							style="font-size: 22px;">봉사목록</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- .page-banner -->

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
						<div style="padding: 10px;">
							<span class="vol-cur"> <span class="sr-only">참여인원</span> <b
								class="vol-count">${volunteer.currentNum}명</b> / <span
								class="sr-only">총 모집인원</span> ${volunteer.limitNum}명
							</span>
							<div class="progress">
								<div class="progress-bar progress-bar-striped"
									role="progressbar" style="width: 10%" aria-valuenow="10"
									aria-valuemin="0" aria-valuemax="100"></div>
							</div>
							<input type="hidden" id="volunteerNo" value="${volunteer.no}" />
							<button type="button" onclick="joinMember();"
								class="btn btn-secondary" style="margin: 25px 165px;">참여자보기</button>
							<a href="join/list?no=${volunteer.no}"
								class="btn btn-outline-primary nBtn" style="margin: 25px 165px;"button" >참여자보기22</a>
						</div>
					</div>
					<!-- //vol-joiner -->

					<!-- vol-owner -->
					<div class="vol-owner">
						<div class="social-mini-button">
							<span class="owner-right"><span>주최자</span> : <b>${volunteer.owner.id}</b></span>
							<span class="owner-right">${volunteer.tel}</span> <span
								class="owner-right">${volunteer.email}</span>
						</div>
					</div>
					<!-- //vol-owner -->

					<div class="vol-detail-infor">
						<ul>
							<li><span>봉사기간</span> : <span>${volunteer.startDate}
									~ ${volunteer.endDate}</span><span>총
									${volunteerDate.totalDate}일</span></li>
							<li><span>봉사시간</span> : <span>${volunteer.startTime}
									~ ${volunteer.endTime}</span></li>
							<li>D-day ${volunteerDate.remainDate}일</li>
						</ul>
					</div>
					<!-- //vol-detail-infor -->
				</div>
				<!-- //vol-infor-wrap -->
			</div>
			<!-- //vol-detail -->


			<div
				style="margin-top: 35px; display: flex; justify-content: center; text-align: center;">
				<div class="vol-con-wrap">
					<p>
						<button class="btn btn-primary" type="button"
							data-toggle="collapse" data-target="#vol-detail"
							aria-expanded="false" aria-controls="vol-detail">상세정보</button>
						<button class="btn btn-primary" type="button"
							data-toggle="collapse" data-target="#vol-location"
							aria-expanded="false" aria-controls="vol-location">위치</button>
						<button class="btn btn-primary" type="button"
							data-toggle="collapse" data-target="#vol-attend"
							aria-expanded="false" aria-controls="vol-attend">참여하기</button>
						<button class="btn btn-primary" type="button"
							data-toggle="collapse" data-target="#vol-qna"
							aria-expanded="false" aria-controls="vol-qna">문의하기</button>
					</p>
					<div class="collapse" id="vol-detail">
						<div class="card card-body">봉사세부사항</div>
					</div>
					<div class="collapse" id="vol-location">
						<div class="card card-body">hey no 2</div>
					</div>
					<div class="collapse" id="vol-attend">
						<div class="card card-body">hey no 2</div>
					</div>
					<div class="collapse" id="vol-qna">
						<div class="card card-body">hey no 2</div>
					</div>
				</div>
			</div>

			<div class="vol-con-wrap">
				<div>
					<h3 class="widget-title" style="padding-top: 30px;">상세정보</h3>
					<div class="divider"></div>
					<div class="col-lg-12">
						<div class="widget">
							<div class="widget-box">
								<form action="#" class="form-contact" method="post"
									enctype="multipart/form-data" name="form">
									<div class="row">
										<div class="col-sm-12 py-2">
											<label for="title" class="fg-grey">제목</label> <input
												type="text" class="form-control" id="title" name="title"
												value="${volunteer.title}">
										</div>



										<div class="col-12 py-2">
											<label for="subject" class="fg-grey">전화번호</label> <input
												type="text" class="form-control" id="tel" name="tel"
												value="${volunteer.tel}">
										</div>
										<div class="col-12 py-2">
											<label for="subject" class="fg-grey">이메일</label> <input
												type="email" class="form-control" id="email"
												value="${volunteer.email}">
										</div>
										<div class="col-6 py-2">
											<label for="subject" class="fg-grey">시작일</label> <input
												type="text" class="form-control" id="startDate"
												value="${volunteer.startDate}">
										</div>
										<div class="col-6 py-2">
											<label for="subject" class="fg-grey">종료일</label> <input
												type="text" class="form-control" id="endDate"
												value="${volunteer.endDate}">
										</div>
										<div class="col-6 py-2">
											<label for="subject" class="fg-grey">시작시간</label> <input
												type="text" class="form-control" id="startTime"
												value="${volunteer.startTime}">
										</div>
										<div class="col-6 py-2">
											<label for="subject" class="fg-grey">종료시간</label> <input
												type="text" class="form-control" id="endTime"
												value="${volunteer.startTime}">
										</div>
										<div class="col-12 py-2">
											<label for="subject" class="fg-grey">총모집인원</label> <input
												type="text" class="form-control" id="limitNum"
												value="${volunteer.limitNum}">
										</div>
										<div class="col-12 py-2">
											<label for="content" class="fg-grey">내용</label>
											<textarea id="content" rows="8" class="form-control">${volunteer.content}</textarea>
										</div>
									</div>
								</form>
							</div>
						</div>

						<h3 class="widget-title" style="padding-top: 30px;">위치</h3>

						<!-- <div>
            <h3 class="widget-title" style="padding-top:30px;">위치</h3>
       <div class="divider"></div>
>>>>>>> 7f1c01400a6974d04fd69a7dec0fb458b4cdedae
            <div class="content-map">
            구글맵
            
            </div>
<<<<<<< HEAD
         </div>
         
         
         <div class="vol-con-wrap">
            <h3 class="widget-title" style="padding-top:30px;" id="scroll-section4"><a>문의하기</a></h3>
		           <div class="divider"></div>
		           <div class="col-lg-12">
                 <div class="widget">
                    <div class="widget-box">
                       <div class="content-box chall-box" style="background: #81BEF7">
                        <c:forEach items="${volunteerQuestion}" var="volunteerQuestionDTO" varStatus="vs">
                          <div> <!-- 말풍선 전체 포함 -->
				                     <div style="margin-left: 19%; ">
				                       <em>${volunteerQuestionDTO.joinUser.id}</em><br>
				                     </div>
						                <div class="ch-balloon left" style="margin-top: 1%; margin-bottom: 1%; margin-left:18%; float:center">
						                <span>
					                   <div class="class" id="id" style="display: none">${volunteerQuestionDTO.no}</div>
						                    ${volunteerQuestionDTO.content}<br>
						                  <small>${volunteerQuestionDTO.registeredDate}</small>
		                      </span>
		                      </div>
		                     
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
                            <button type="button" class="close" data-dismiss="modal">×</button>
                          </div>
                            <form action='question/update' method="post">
                              <div class="modal-body">
                            <!-- 
                              <div class= "class" id="id" style="display:none">
                                <label for='f-no'>봉사번호</label> <input id='f-no' type='text' name='no' value='${challengeDTO.no}' readonly>
                              <br></div>
                               -->
	                              <div class= "class" id="id" style="display:none">
	                                <label for='f-questionNo'>문의번호</label> <input id='f-questionNo' type='text' name='no' value='${volunteerQuestionDTO.no}' readonly>
	                             </div>
	                             
                                  <textarea id='f-content' name='content' cols="55" rows="1" class="modal-body">${volunteerQuestionDTO.content}</textarea>
                                  
                                <label for='f-owner'>작성자</label> 
                                <span id='f-owner'>${volunteerQuestionDTO.joinUser.id}</span><br>
                            
                                <label for='f-registeredDate'>등록일</label> 
                                <span id='f-registeredDate'>${volunteerQuestionDTO.registeredDate}</span><br>
                                
                                <div class= "class" id="id" style="display:none">
                                <label for='f-volunteerNo'>봉사번호</label> <input id='f-volunteerNo' type='text' name='volNo' value='${volunteer.no}' readonly>
                                </div>
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
                    <a href='question/delete?no=${volunteerQuestionDTO.no}&volunteerNo=${volunteer.no}'>[삭제]</a>
                    </c:if>
                </div><br>
                
                  <c:if  test="${volunteerQuestionDTO.reply != null}" >
                     <div class="ch-balloon right" style="margin-bottom: 1%; margin-left: 70%; float:center">
			                <span>
			                    -관리자 답글-<br>
			                    ${volunteerQuestionDTO.reply}
			                </span></div><br>
                 </c:if>
              </c:forEach>
              
              <form action='question/add' method="post">
               
                  <div class= "class" id="id" style="display:none">
                    <label for='f-no'>봉사번호</label> <input id='f-no' type='text' name='volNo' value='${volunteer.no}' readonly>
                  </div><br>
                  
                     <textarea id='f-content' name='content' cols=100% rows="1" class="modal-body" style="margin-left:5%; float: left;"></textarea>
            
                    <button style="margin-left:1.5%; margin-top:1.7%;" onsubmit="checkValue()">문의등록</button>
              </form>
            </div>
         </div>
       </div>
                  
                  
                  </div>
               </div>
             </div>
            </div>
       </div>
        <div class="btn-regi">
          <button type="button" class="btn btn-primary nBtn" onclick="location.href='join/detail?no=${volunteer.no}'")>참여하기</button>
          <button type="button" class="btn btn-primary nBtn" onclick="history.go(-1)">이전</button>
        </div> <!-- //btn-regi -->       
      </div>  <!-- //container -->
    </div>  <!-- //page-section -->
  </main>


<script>
    $(document).ready(function() { 
      var page_url = window.location.href; 
      var page_id = page_url.substring(page_url.lastIndexOf("#") + 1); 
       alert(page_id); 
      if (page_id == 'section1') { 
        $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 5000); 
        } else if (page_id == 'section2') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 200); 
        } else if (page_id == 'section3') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 500); 
        }  else if (page_id == 'section4') { 
          $('html, body').animate({ 
            scrollTop: $('#scroll-' + page_id).offset().top 
          }, 500); 
        }
      });
    
    
   function checkValue() {
	  var content = document.querySelector("#f-content");
	   
	   if (content.value == "") {
		   alert("내용을 입력해주세요");
		   return false;
	   }
		   
	   
   }
    </script>
    
   











         </div>   


						<div id="map"
							style="width: 700x; height: 400px; align-items: center"></div>
						<script type="text/javascript"
							src="//dapi.kakao.com/v2/maps/sdk.js?appkey=957738e74b502a9fe5576d94da13113d"></script>


					</div>
					<div class="btn-regi">
						<button type="button" class="btn btn-primary nBtn">참여하기</button>
						<a href="join/add?no=${volunteer.no}"
							class="btn btn-outline-primary nBtn" role="button">참여하기</a> <a
							href="join/list?no=${volunteer.no}"
							class="btn btn-outline-primary nBtn" role="button">참여하기222</a> <a
							href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
					</div>
					<!-- //btn-regi -->
				</div>
				<!-- //container -->
			</div>
			<!-- //page-section -->



			<script>
				var volunteerNo = document.querySelector("#volunteerNo");
				var no = volunteerNo.textContent;
				function joinMember() {
					location.href = "join/list?no=" + no
				}
			</script>

			<script>
				var container = document.getElementById('map');
				var options = {
					center : new kakao.maps.LatLng(37.49950381717442, 127.02906340621007),
					level : 3
				};

				var map = new kakao.maps.Map(container, options);

				var markerPosition = new kakao.maps.LatLng(37.49950381717442, 127.02906340621007);

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
					position : markerPosition
				});

				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);

				var iwContent = '<div style="padding:5px;">여기야여기! <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				iwPosition = new kakao.maps.LatLng(37.49950381717442, 127.02906340621007); //인포윈도우 표시 위치입니다

				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					position : iwPosition,
					content : iwContent
				});

				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker);
			</script>
>>>>>>> 15b7020a22454baf99a7a966d0a35f554969189c
