<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-banner bg-img bg-img-parallax overlay-dark"
	style="background-image: url(${contextPath}/images/challenge_bg.jpg);">
	<div class="container h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col-lg-8">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
						<li class="breadcrumb-item"><a href="${contextPath}/app/home">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">챌린지</li>
					</ol>
				</nav>
				<h1 class="fg-white text-center">참여인증&댓글</h1>
			</div>
		</div>
	</div>
</div>
<!-- .page-banner -->

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 스크롤 js -->

<main>
	<div class="page-section">
		<div class="container">
			<div class="challgne-item">
				<p class="challgne-type bu">비대면</p>
				<h3>${challengeDTO.title}</h3>
			</div>
			<div class="chall-detail">
				<div class="chall-de-img">
					<img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
				</div>
				<!-- //vol-de-img -->
				<div class="chall-infor-wrap">
					<!-- vol-joiner -->
					<div class="chall-joiner">
						<span class="chall-cur"> <span class="sr-only">참여인원</span>
							<b class="chall-count">0명</b> / <span class="sr-only">총
								모집인원</span> 5명
						</span>
						<div class="progress">
							<div class="progress-bar progress-bar-striped" role="progressbar"
								style="width: 10%" aria-valuenow="10" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<button type="button" class="btn btn-secondary">참여자보기</button>

					</div>
					<!-- //vol-joiner -->
					<!-- vol-owner -->
					<div class="chall-detail-infor">
						<ul>
							<li><span>모집기간</span> <span>${challengeDTO.startDate}~${challengeDTO.endDate}</span><span>총
									00일</span></li>
							<li><span>참여기간</span> <span>${challengeDTO.startDate}~${challengeDTO.endDate}</span>
							</li>
							<li>D-day 00일</li>
							<li>
								<p>획득 포인트:100포인트</p>
							</li>
						</ul>
						<button type="button" class="btn btn-secondary">참여하기</button>
					</div>
				</div>
				<!-- //vol-infor-wrap -->
			</div>
			<!-- //vol-detail -->

			<div class="vol-con-wrap">
				<div>
					<a href='detail?no=${challengeDTO.no}#section1'>
						<h4 class="widget-title" style="padding-top: 30px;">상세정보</h4>
					</a>
				</div>
				<div>
					<h1 class="widget-title" style="padding-top: 30px;"
						id="scroll-section2">
						<a>참여인증&댓글</a>
					</h1>
					<div class="content-box">
						<c:forEach items="${challengeReviewList}" var="challengeReviewDTO">
						<img src="${contextPath}/upload/challenge/${challengeReviewDTO.photo}" alt="챌린지 리뷰 이미지" />
                    ${challengeReviewDTO.reviewNo}
                    ${challengeReviewDTO.content}
                    ${challengeReviewDTO.photo}
                    ${challengeReviewDTO.owner.id}
                    ${challengeReviewDTO.registeredDate}
                    <!-- 모달 창 -->
							<td><div class="modal fade" id="myModalReviewU"
									role="dialog">
									<!-- 사용자 지정 부분① : id명 -->
									<div class="modal-dialog">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<h4 class="modal-title">참여인증&댓글 수정</h4>
												<!-- 사용자 지정 부분② : 타이틀 -->
												<button type="button" class="close" data-dismiss="modal">×</button>
											</div>
											<form
												action='reviewUpdate?reviewNo=${challengeReviewDTO.reviewNo}&no=${challengeReviewDTO.no}'
												method="post" enctype="multipart/form-data">
												<div class="modal-body">
													<div class="class" name="name" id="id"
														style="display: none">
														<label for='f-no'>챌린지번호</label> <input id='f-no'
															type='text' name='no' value='${challengeDTO.no}' readonly>
														<br>
													</div>
													<textarea id='f-content' name='content' cols="55" rows="1"
														class="modal-body">${challengeReviewDTO.content}</textarea>
														
													<label for="f-file">사진첨부</label><input type="file" id="f-file"
                        name='photoFile'>
														
													<label for='f-owner'>작성자</label> <span id='f-owner'>${challengeReviewDTO.owner.id}</span><br>

													<label for='f-registeredDate'>등록일</label> <span
														id='f-registeredDate'>${challengeReviewDTO.registeredDate}</span><br>
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
								</div> <!-- 모달 창 --> <c:if
									test="${sessionScope.loginUser.no == challengeReviewDTO.owner.no}">
											&nbsp;&nbsp;<a data-toggle="modal" href="#myModalReviewU">[변경]</a>
									<td><a
										href='reviewDelete?reviewNo=${challengeReviewDTO.reviewNo}&no=${challengeReviewDTO.no}'>[삭제]</a></td>
								</c:if><br>
						</c:forEach>
						<div class="btn-regi">
							<!-- 부트스트랩의 모달 창을 사용할려면 아래의 class 이름들을 그대로 사용해야 한다. 변경하면 모양이 달라진다.-->
							<!-- Modal -->
							<div class="modal fade" id="myModalReviewA" role="dialog">
								<!-- 사용자 지정 부분① : id명 -->
								<div class="modal-dialog">
									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">챌린지 참여인증&댓글 등록</h4>
											<!-- 사용자 지정 부분② : 타이틀 -->
											<button type="button" class="close" data-dismiss="modal">×</button>
										</div>
										<form action='reviewAdd' method="post" enctype="multipart/form-data">
											<div class="modal-body">
												<div class="class" name="name" id="id" style="display: none">
													<label for='f-no'>챌린지번호</label> <input id='f-no'
														type='text' name='no' value='${challengeDTO.no}' readonly>
													<br>
												</div>
												<textarea id='f-content' name='content' cols="55" rows="1"
													class="modal-body"></textarea>
                        <label for="f-file">사진첨부</label><input type="file" id="f-file"
                        name='photoFile'>
													
											</div>
											<button>참여인증&댓글 등록</button>
											<br>
										</form>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<br />
							<br />
							<!-- 아래에서 data-toggle과 data-target 속성에서 data-toggle에는 modal 값을 data-target속성에는 모달 창 전체를 
                감싸는 div의 id 이름을 지정하면 된다. -->
                <c:if test="${not empty sessionScope.loginUser}">
							&nbsp;&nbsp;<a data-toggle="modal" href="#myModalReviewA"
								class="btn btn-primary nBtn" role="button">참여댓글등록</a>
							</c:if>
						</div>
					</div>
				</div>
				<div>
					<a href='questionList?no=${challengeDTO.no}#section3'>
						<h4 class="widget-title" style="padding-top: 30px;">문의하기</h4>
					</a>
				</div>
			</div>
		</div>

		<div class="btn-regi">
			<button type="submit" class="btn btn-primary nBtn">참여하기</button>
			<input type="button" class="btn btn-outline-primary nBtn" value="이전"
				onClick="history.go(-1)" role="button">
		</div>
	</div>
	<!-- //container -->
	<!-- //page-section -->

	<script>
		$(document).ready(function() {
			var page_url = window.location.href;
			var page_id = page_url.substring(page_url.lastIndexOf("#") + 1);
			// alert(page_id); 
			if (page_id == 'section1') {
				$('html, body').animate({
					scrollTop : $('#scroll-' + page_id).offset().top
				}, 500);
			} else if (page_id == 'section2') {
				$('html, body').animate({
					scrollTop : $('#scroll-' + page_id).offset().top
				}, 500);
			} else if (page_id == 'section3') {
				$('html, body').animate({
					scrollTop : $('#scroll-' + page_id).offset().top
				}, 500);
			}
		});
	</script>
</main>
</body>
</html>