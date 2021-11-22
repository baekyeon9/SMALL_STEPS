<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<<<<<<< HEAD


=======
>>>>>>> 15b7020a22454baf99a7a966d0a35f554969189c

<div class="page-banner bg-img bg-img-parallax overlay-dark"
	style="background-image: url(../../assets/img/bg_image_3.jpg);">
	<div class="container h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col-lg-8">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
						<li class="breadcrumb-item"><a href="#"
							style="font-size: 20px;">함께해요</a></li>
						<li class="breadcrumb-item active" aria-current="page"
							style="font-size: 22px;">봉사목록</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- //page-banner -->

<main>
	<div class="page-section">
		<div class="container">
			<h3 class="widget-title">${volunteer.title}</h3>
			<div class="vol-detail">
				<div class="vol-de-img">
					<img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
				</div>
				<div class="vol-infor-wrap">
					<!-- vol-joiner -->
					<div class="vol-joiner">
						<div style="padding: 10px;">
							<span class="vol-cur">
							  <span class="sr-only">참여인원</span>
							  <b class="vol-count">${volunteer.currentNum}명</b> /
							  <span class="sr-only">총 모집인원</span> ${volunteer.limitNum}명
							</span>
							<div class="progress">
								<div class="progress-bar progress-bar-striped"
									role="progressbar" style="width: 10%" aria-valuenow="10"
									aria-valuemin="0" aria-valuemax="100"></div>
							</div>
							<input type="hidden" id="volunteerNo" value="${volunteer.no}" />
							<button type="button" class="btn btn-primary open" id="btn-modal">봉사
								참여자 목록</button>
						</div>
					</div>
					<!-- //vol-joiner -->
					<div class="vol-owner">
						<!-- vol-owner -->
						<div class="social-mini-button">
							<span class="owner-right"><span>주최자</span> : <b>${volunteer.owner.id}</b></span>
							<span class="owner-right">${volunteer.tel}</span> <span
								class="owner-right">${volunteer.email}</span>
						</div>
					</div>
					<!-- //vol-owner -->

					<!-- vol-detail-infor -->
					<div class="vol-detail-infor">
						<ul>
							<li><span>봉사기간</span> : <span>${volunteer.startDate}
									~ ${volunteer.endDate}</span><span>총
									${volunteerDate.totalDate}일</span></li>
							<li><span>봉사시간</span> : <span>${volunteer.startTime}
									~ ${volunteer.endTime}</span></li>
							<li>D-day ${volunteerDate.remainDate}일</li>
						</ul>
						<a href="join/form?no=${volunteer.no}"
							class="btn btn-primary open" role="button">참여하기</a>
					</div>
					<!-- //vol-detail-infor -->
				</div>
				<!-- //vol-infor-wrap -->

				<!-- modal -->
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
									<c:forEach items="${volunteerList}" var="volunteerJoinDTO">
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
				</div>
				<!-- //modal -->
			</div>
			<!-- //vol-detail -->

<<<<<<< HEAD
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
								<c:forEach items="${volunteerList}" var="volunteerJoinDTO">
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
			</div>
			<!-- 모달 끝 -->

			<div
				style="margin-top: 35px; display: flex; justify-content: center; text-align: center;">
				<div class="vol-con-wrap">
					<p>
						<button class="btn btn-primary" type="button"
							onclick="location.href='detail?no=${volunteer.no}#section1'">
							<a class="widget-title" id="section1">상세보기 (Detail)</a>
						</button>
						<button class="btn btn-primary" type="button"
							onclick="location.href='detail?no=${volunteer.no}#section2'">
							<a class="widget-title" id="section2">참여인증 & 댓글 (Review)</a>
						</button>
						<button class="btn btn-primary" type="button"
							onclick="location.href='detail?no=${volunteer.no}#section3'">
							<a class="widget-title" id="section3">위치 (Location)</a>
						</button>
						<button class="btn btn-primary" type="button"
							onclick="location.href='detail?no=${volunteer.no}#section4'">
							<a class="widget-title" id="section4">문의하기 (Q & A)</a>
						</button>
					</p>
=======
			<!-- tabArea -->
			<div class="tabArea" style="margin-top: 35px; text-align: center;">
				<div class="vol-con-wrap tab">
				  <ul class="tab">
				    <li class="btn btn-primary on"><a href="#!"><span>상세정보</span></a></li>
				    <li class="btn btn-primary"><a href="#!"><span>참여인증 / 댓글</span></a></li>
				    <li class="btn btn-primary"><a href="#!"><span>위치</span></a></li>
				  </ul>
				</div>
				<!-- //tab -->
			<!-- tabBox -->
			<div class="vol-con-wrap tabBox on">
				<h3 class="widget-title" id="scroll-section1"
					style="padding-top: 30px;">상세정보</h3>
				<div class="col-lg-12">
					<div class="widget">
						<div class="widget-box">
							<form action="#" class="form-contact" method="post"
								enctype="multipart/form-data" name="form">
								<div class="row">
									<div class="col-sm-12 py-2">
										<label for="no" class="fg-grey" type="hidden">번호</label> <input
											type="number" class="form-control" id="no" name="no"
											value="${volunteer.no}" readonly>
									</div>
									<!-- //번호 -->
									<div class="col-sm-12 py-2">
										<label for="title" class="fg-grey">제목</label> <input
											type="text" class="form-control" id="title" name="title"
											value="${volunteer.title}" readonly>
									</div>
									<!-- //제목 -->
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">전화번호</label> <input
											type="text" class="form-control" id="tel" name="tel"
											value="${volunteer.tel}" readonly>
									</div>
									<!-- //전화번호 -->
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">이메일</label> <input
											type="email" class="form-control" id="email"
											value="${volunteer.email}" readonly>
									</div>
									<!-- //이메일 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">시작일</label> <input
											type="text" class="form-control" id="startDate"
											value="${volunteer.startDate}" readonly>
									</div>
									<!-- //시작일 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">종료일</label> <input
											type="text" class="form-control" id="endDate"
											value="${volunteer.endDate}" readonly>
									</div>
									<!-- //종료일 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">시작시간</label> <input
											type="text" class="form-control" id="startTime"
											value="${volunteer.startTime}" readonly>
									</div>
									<!-- //시작시간 -->
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">종료시간</label> <input
											type="text" class="form-control" id="endTime"
											value="${volunteer.startTime}" readonly>
									</div>
									<!-- //종료시간 -->
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">총모집인원</label> <input
											type="text" class="form-control" id="limitNum"
											value="${volunteer.limitNum}" readonly>
									</div>
									<!-- //총모집인원 -->
									<div class="col-12 py-2">
										<label for="content" class="fg-grey">내용</label>
										<textarea id="content" rows="8" class="form-control">${volunteer.content}</textarea>
									</div>
									<!-- //내용 -->
								</div>
								<!-- //row -->
							</form>
						</div>
						<!-- //widget-box -->
					</div>
					<!-- //widget -->
>>>>>>> 15b7020a22454baf99a7a966d0a35f554969189c
				</div>
				<!-- //col-lg-12 -->
			</div>
<<<<<<< HEAD
			<!-- style -->


			<div class="vol-con-wrap">
				<h3 class="widget-title" id="scroll-section1"
					style="padding-top: 30px;">상세정보</h3>
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
											value="${volunteer.title}" readonly>
									</div>
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">전화번호</label> <input
											type="text" class="form-control" id="tel" name="tel"
											value="${volunteer.tel}" readonly>
									</div>
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">이메일</label> <input
											type="email" class="form-control" id="email"
											value="${volunteer.email}" readonly>
									</div>
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">시작일</label> <input
											type="text" class="form-control" id="startDate"
											value="${volunteer.startDate}" readonly>
									</div>
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">종료일</label> <input
											type="text" class="form-control" id="endDate"
											value="${volunteer.endDate}" readonly>
									</div>
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">시작시간</label> <input
											type="text" class="form-control" id="startTime"
											value="${volunteer.startTime}" readonly>
									</div>
									<div class="col-6 py-2">
										<label for="subject" class="fg-grey">종료시간</label> <input
											type="text" class="form-control" id="endTime"
											value="${volunteer.startTime}" readonly>
									</div>
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">총모집인원</label> <input
											type="text" class="form-control" id="limitNum"
											value="${volunteer.limitNum}" readonly>
									</div>
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">우편번호</label> <input
											type="email" class="form-control" id="postNo"
											value="${volunteer.postNo}" readonly>
									</div>
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">기본주소</label> <input
											type="email" class="form-control" id="f-basicAddr"
											value="${volunteer.basicAddr}" readonly>
									</div>
									<div class="col-12 py-2">
										<label for="subject" class="fg-grey">상세주소</label> <input
											type="email" class="form-control" id="postNo"
											value="${volunteer.detailAddr}" readonly>
									</div>
									<div class="col-12 py-2">
										<label for="content" class="fg-grey">내용</label>
										<textarea id="content" rows="8" class="form-control">${volunteer.content}</textarea>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- vol-con-wrap -->

			<div class="vol-con-wrap">
				<!--  #scroll-' + page_id-->
				<h3 class="widget-title" id="scroll-section2"
					style="padding-top: 30px;">참여인증 & 댓글</h3>
				<div class="divider"></div>
				<div class="col-lg-12">
					<div class="widget">
						<div class="widget-box">
							<div class="cont-short-list">

=======
			<!-- //tabBox -->

			<!-- tabBox -->
			<div class="vol-con-wrap tabBox">
				<h3 class="widget-title" id="s-section1" style="padding-top: 30px;">
					참여인증 / 댓글</h3>
				<div class="col-lg-12">
					<div class="widget">
						<div class="widget-box">
							<!-- cont-short-list -->
							<div class="cont-short-list">
>>>>>>> 15b7020a22454baf99a7a966d0a35f554969189c
								<c:forEach items="${volunteerShortReviewList}"
									var="volunteerShortReviewDTO">
									<div class="s-review-list">
										<div class="review-view">
											<ul>
												<li>
													<div class="review-section">
														<div class="profile-thumb">
															<img src="${contextPath}/assets/img/level.png"
																alt="프로필사진">
														</div>
														<div class="review-infor">
															<div class="review-post">
																<div class="profile-infor">
																	<span>${volunteerShortReviewDTO.owner.id}</span> <span
																		class="txt_date">${volunteerShortReviewDTO.registeredDate}</span>
																	<%-- <span class="ico_bbs ico_new">새글</span>--%>
																</div>
																<div class="review-post">
																	<p>
																		<span>${volunteerShortReviewDTO.content}</span>
																	</p>
																</div>
																<div class="review-btn">
																	<a href='reviewUpdate?no=${volunteerShortReviewDTO.no}'
																		class="link_menu">[수정]</a> <a
																		href='reviewDelete?no=${volunteerShortReviewDTO.no}'
																		class="link_menu">[삭제]</a>
																</div>
															</div>
														</div>
													</div>
												</li>
											</ul>
										</div>
									</div>
								</c:forEach>
<<<<<<< HEAD
								<!-- //s-review-list -->
							</div>

							<button class="btn btn-primary" type="button"
								onclick="location.href='reviewList?no=${volunteer.no}'">상세정보</button>

							<div class="col-12 my-5">
								<nav aria-label="Page Navigation">
									<ul class="pagination justify-content-center">
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
										</li>
										<li class="page-item"><a class="page-link" href="#">2</a>
										</li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#">Next</a>
										</li>
									</ul>
								</nav>
=======
>>>>>>> 15b7020a22454baf99a7a966d0a35f554969189c
							</div>
							<!-- //cont-short-list -->

							<button class="btn btn-primary" type="button"
								onclick="location.href='reviewList?no=${volunteer.no}'">상세정보</button>
							<!-- col-12 -->
							<div class="col-12 my-5">
								<nav aria-label="Page Navigation">
									<ul class="pagination justify-content-center">
										<li class="page-item disabled"><a class="page-link"
											href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
										<li class="page-item active" aria-current="page"><a
											class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
										</li>
										<li class="page-item"><a class="page-link" href="#">2</a>
										</li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#">Next</a>
										</li>
									</ul>
								</nav>
							</div>
							<!-- //col-12 -->
						</div>
<<<<<<< HEAD
					</div>
				</div>
			</div>
			<!-- vol-con-wrap -->


			<div>
				<h3 class="widget-title" style="padding-top: 30px;"
					id="scroll-section3">위치</h3>
				<div class="divider"></div>

				<!-- <div>
            <h3 class="widget-title" style="padding-top:30px;">위치</h3>
       <div class="divider"></div>
            <div class="content-map">
            구글맵
            
            </div>
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
				<div style="margin-left: 19%;">
					<em>${volunteerQuestionDTO.joinUser.id}</em><br>
				</div>
				<div class="ch-balloon left"
					style="margin-top: 1%; margin-bottom: 1%; margin-left: 18%; float: center">
					<span>
						<div class="class" id="id" style="display: none">${volunteerQuestionDTO.no}</div>
						${volunteerQuestionDTO.content}<br> <small>${volunteerQuestionDTO.registeredDate}</small>
					</span>
				</div>

				<!-- 모달 창 -->
				<c:if
					test="${sessionScope.loginUser.no == volunteerQuestionDTO.joinUser.no}">
					<!-- 아래에서 data-toggle과 data-target 속성에서 data-toggle에는 modal 값을 data-target속성에는 모달 창 전체를 
                     감싸는 div의 id 이름을 지정하면 된다. -->
                  &nbsp;&nbsp;<a data-toggle="modal"
						href="#myModalQuestionU${vs.index}">[변경]</a>
				</c:if>
				<!-- 부트스트랩의 모달 창을 사용할려면 아래의 class 이름들을 그대로 사용해야 한다. 변경하면 모양이 달라진다.-->
				<div class="modal fade" id="myModalQuestionU${vs.index}"
					role="dialog">
					<!-- 사용자 지정 부분① : id명 -->
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">문의 수정</h4>
								<!-- 사용자 지정 부분② : 타이틀 -->
								<button type="button" class="close" data-dismiss="modal">×</button>
							</div>
							<form action='question/update' method="post">
								<div class="modal-body">
									<!-- 
                              <div class= "class" id="id" style="display:none">
                                <label for='f-no'>봉사번호</label> <input id='f-no' type='text' name='no' value='${challengeDTO.no}' readonly>
                              <br></div>
                               -->
									<div class="class" id="id" style="display: none">
										<label for='f-questionNo'>문의번호</label> <input
											id='f-questionNo' type='text' name='no'
											value='${volunteerQuestionDTO.no}' readonly>
									</div>

									<textarea id='f-content' name='content' cols="55" rows="1"
										class="modal-body">${volunteerQuestionDTO.content}</textarea>

									<label for='f-owner'>작성자</label> <span id='f-owner'>${volunteerQuestionDTO.joinUser.id}</span><br>

									<label for='f-registeredDate'>등록일</label> <span
										id='f-registeredDate'>${volunteerQuestionDTO.registeredDate}</span><br>

									<div class="class" id="id" style="display: none">
										<label for='f-volunteerNo'>봉사번호</label> <input
											id='f-volunteerNo' type='text' name='volNo'
											value='${volunteer.no}' readonly>
									</div>
								</div>
								<button>수정완료</button>
								<br>
							</form>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 모달 창 -->
				<c:if
					test="${sessionScope.loginUser.no == volunteerQuestionDTO.joinUser.no}">
					<a
						href='question/delete?no=${volunteerQuestionDTO.no}&volunteerNo=${volunteer.no}'>[삭제]</a>
				</c:if>
			</div>
			<br>

			<c:if test="${volunteerQuestionDTO.reply != null}">
				<div class="ch-balloon right"
					style="margin-bottom: 1%; margin-left: 70%; float: center">
					<span> -관리자 답글-<br> ${volunteerQuestionDTO.reply}
					</span>
				</div>
				<br>
			</c:if>
			</c:forEach>

			<form action='question/add' method="post">

				<div class="class" id="id" style="display: none">
					<label for='f-no'>봉사번호</label> <input id='f-no' type='text'
						name='volNo' value='${volunteer.no}' readonly>
				</div>
				<br>

				<textarea id='f-content' name='content' cols=100% rows="1"
					class="modal-body" style="margin-left: 5%; float: left;"></textarea>

				<button style="margin-left: 1.5%; margin-top: 1.7%;"
					onsubmit="checkValue()">문의등록</button>
			</form>
		</div>
	</div>

	<div class="btn-regi">
		<button type="button" class="btn btn-primary nBtn"
			onclick="location.href='join/detail?no=${volunteer.no}'" )>참여하기</button>
		<button type="button" class="btn btn-primary nBtn"
			onclick="history.go(-1)">이전</button>
	</div>
	<!-- //btn-regi -->
	<!-- //container -->

	<div id="map" style="width: 700x; height: 400px; align-items: center"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=957738e74b502a9fe5576d94da13113d"></script>
	</div>

	<div class="btn-regi">
		<button type="submit" class="btn btn-primary nBtn">참여하기</button>
		<a href="join/add?no=${volunteer.no}"
			class="btn btn-outline-primary nBtn" role="button">참여하기</a> <a
			href="join/list?no=${volunteer.no}"
			class="btn btn-outline-primary nBtn" role="button">참여하기222</a> <a
			href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
</main>
<script>
	$(document).ready(function() {
		var page_url = window.location.href;
		var page_id = page_url.substring(page_url.lastIndexOf("#") + 1);
		alert(page_id);
		if (page_id == 'section1') {
			$('html, body').animate({
				scrollTop : $('#scroll-' + page_id).offset().top
			}, 5000);
		} else if (page_id == 'section2') {
			$('html, body').animate({
				scrollTop : $('#scroll-' + page_id).offset().top
			}, 200);
		} else if (page_id == 'section3') {
			$('html, body').animate({
				scrollTop : $('#scroll-' + page_id).offset().top
			}, 500);
		} else if (page_id == 'section4') {
			$('html, body').animate({
				scrollTop : $('#scroll-' + page_id).offset().top
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


<!-- //page-section -->
<script>
	var volunteerNo = document.querySelector("#volunteerNo");
	var no = volunteerNo.textContent;
	function joinMember() {
		location.href = "join/list?no=" + no
	}
</script>

<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};
	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	var mapTypeControl = new kakao.maps.MapTypeControl();
	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
	var originLocation = $("#f-basicAddr").val();
	var editLocation = originLocation.split(",")[0];
	//주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					editLocation,
					function(result, status) {
						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {
							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);
							var location_link = document
									.querySelector("#f-basicAddr");
							location_link.setAttribute('href',
									'https://map.kakao.com/link/to/${volunteer.detailAddr},'
											+ result[0].y + ',' + result[0].x);
							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});
							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">${volunteer.detailAddr}</div>'
									});
							infowindow.open(map, marker);
							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
=======
						<!-- //widget-box -->
					</div>
					<!-- //widget -->
				</div>
				<!-- //col-lg-12 -->
			</div>
			<!-- //tabBox -->

			<!-- tabBox -->
			<div class="vol-con-wrap tabBox">
				<h3 class="widget-title" id="s-section1" style="padding-top: 30px;">
					위치</h3>
				<div class="col-lg-12">
					<div class="widget">
						<div class="widget-box">
							<div id="map"
								style="width: 700x; height: 400px; align-items: center"></div>

						</div>
						<!-- //widget-box -->
					</div>
				</div>
			</div>
			<!-- //tabBox -->
			</div>
			<!-- //tabArea -->

			
			<button type="button" class="btn btn-primary nBtn"
				onclick="history.go(-1)">이전</button>
			<button type="button" class="goupbtn" onclick="goTop()">맨 위로</button>
		</div>
		<!-- //container -->
	</div>
	<!-- //page-section -->
</main>
<!-- //main -->

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=957738e74b502a9fe5576d94da13113d"></script>

<script src="http://code.jquery.com/jquery-latest.js"></script> 

<script>
$(document).ready(function(){
	  $(".tabArea .tab li a").on("click", function(){
	    // 내 자신의 index 번호를 가져 옴. -> [0], [1]
	    const num = $(".tabArea .tab li a").index($(this));
	    // 인덱스 불러오고 on class삭제
	    $(".tabArea .tab li").removeClass("on");
	    $(".tabArea .tabBox").removeClass("on");

	    // 클릭 후 객체 선택값이 같으면 class 추가
	    $('.tabArea .tab li:eq(' + num + ')').addClass("on");
	    $('.tabArea .tabBox:eq(' + num + ')').addClass("on");

	  });
	});
</script>

<script>
function goTop(){
	  $('html').scrollTop(0);
	}
</script>




<script>
	function checkValue() {
		var content = document.querySelector("#f-content");

		if (content.value == "") {
			alert("내용을 입력해주세요");
			return false;
		}
	}
</script>
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
	var markerPosition = new kakao.maps.LatLng(37.49950381717442,
			127.02906340621007);
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