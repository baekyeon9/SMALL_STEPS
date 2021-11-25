<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<body>

	<section>
		<div class="page-banner home-banner mb-5"
			style="background-color: #fff;">
			<div class="slider-wrapper">
				<div class="owl-carousel hero-carousel">
					<div class="hero-carousel-item">
						<img src="${contextPath}/images/home/main.jpg"
							style="width: 1300px;" alt="메인이미지1">
					</div>
					<div class="hero-carousel-item">
						<img src="${contextPath}/images/home/volunteer4.jpg"
							style="width: 1300px;" alt="메인이미지2">
					</div>
					<div class="hero-carousel-item">
						<img src="${contextPath}/images/home/volunteer.jpg"
							style="width: 1300px;" alt="메인이미지3">
					</div>
				</div>
			</div>
			<!-- //slider-wrapper -->
		</div>
		<!-- //page-banner -->
	</section>

	<main>
		<div class="page-section">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-6 py-3">
						<div class="subhead">HappyShare</div>
						<h2 class="title-section happy-con">
							환영합니다 <span class="" style="color: #ff8184;">HappyShare</span>입니다.
						</h2>

						<p style="line-height: 25px;">
							HappyShare는 개인과 소규모 단체 중심의 봉사 및 모금활동 공간입니다. <br> 봉사에 대한
							진입장벽을 낮추고 참여율을 진작시키고자하는 목표를 품고<br> 봉사활동 뿐만 아니라 기부, 챌린지 등 다양한
							서비스를 지원하고 있습니다.<br> 특히, 챌린지 기능은 많은 회원이 함께 참여하고 인증하는 과정을 통해<br>
							재미는 물론 봉사자들의 성취감을 고취시키고, 커뮤니티를 통해 회원 간<br>소통할 수 있는 공간을
							마련하였습니다.
						</p>

						<a href="about.html" class="btn mt-4 happy-btn">더보기</a>
					</div>
					<div class="col-lg-6 py-3">
						<div class="about-img">
							<img src="${contextPath}/images/volunteer1.jpg" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- //page-section -->



		<div class="page-section">
			<div class="container">
				<div class="text-center">
					<h2 class="title-section happy-con">진행중인 봉사목록</h2>
				</div>

				<div class="owl-carousel team-carousel mt-5">
					<c:forEach items="${volunteerList}" var="volunteerDTO">
						<div class="team-wrap">
							<div class="team-profile">
								<img src="${contextPath}/images/home/main.jpg" alt="봉사사진">
							</div>
							<div class="team-content">
								<h5>${volunteerDTO.title}</h5>
								<div class="text-sm fg-grey">주최자 :
									${volunteerDTO.owner.id}</div>

								<div class="social-button">
									<a href="#"><span class="mai-logo-facebook-messenger"></span></a>
									<a href="#"><span class="mai-call"></span></a> <a href="#"><span
										class="mai-mail"></span></a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- .container -->
		</div>
		<!-- //page-section -->

		
		<div class="page-section">
			<div class="container">
				<div class="text-center">
					<h2 class="title-section happy-con">한줄 봉사참여 후기</h2>
				</div>
				<div class="owl-carousel testimonial-carousel">

					<c:forEach items="${volunteerShortReviewList}"
						var="volunteerShortReviewDTO">
						<div class="card-testimonial">
							<div class="content">${volunteerShortReviewDTO.content}</div>
							<div class="author">
								<div class="avatar">
									<img src="${contextPath}/assets/img/level.png" alt="">
								</div>
								<div class="d-inline-block ml-2">
									<div class="author-name">${volunteerShortReviewDTO.owner.id}</div>
									<div class="author-info">${volunteerShortReviewDTO.registeredDate}</div>
								</div>
							</div>
						</div>
					</c:forEach>


				</div>
				<!-- .row -->

			</div>
			<!-- .container -->
		</div>
		<!-- //page-section -->




		<div class="page-section">
			<div class="container">
				<div class="text-center">
					<h2 class="title-section happy-con">진행중인 모금함 목록</h2>
				</div>

				<div class="owl-carousel team-carousel mt-5">
					<c:forEach items="${donationBoardList}" var="donationBoardDTO">
						<div class="team-wrap">
							<div class="team-profile">
								<img src="${contextPath}/images/donation_main.jpg" alt="모금함사진">
							</div>
							<div class="team-content">
								<h5>${donationBoardDTO.title}</h5>
								<div class="text-sm fg-grey">주최자 :
									${donationBoardDTO.leader.id}</div>

								<div class="social-button">
									<a href="#"><span class="mai-logo-facebook-messenger"></span></a>
									<a href="#"><span class="mai-call"></span></a> <a href="#"><span
										class="mai-mail"></span></a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- .container -->
		</div>
		<!-- //page-section -->


		<div class="page-section">
			<div class="container">
				<div class="text-center">
					<h2 class="title-section happy-con">진행중인 챌린지 목록</h2>
				</div>

				<div class="owl-carousel team-carousel mt-5">
					<c:forEach items="${challengeList}" var="challengeDTO">
						<div class="team-wrap">
							<div class="team-profile">
								<img src="${contextPath}/images/challenge_main.jpg" alt="챌린지사진">
							</div>
							<div class="team-content">
								<h5>${challengeDTO.title}</h5>
								<div class="text-sm fg-grey">${challengeDTO.content}</div>
								<!-- 
                <div class="social-button">
                  <a href="#"><span class="mai-logo-facebook-messenger"></span></a>
                  <a href="#"><span class="mai-call"></span></a>
                  <a href="#"><span class="mai-mail"></span></a>
                </div>
                 -->
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- .container -->
		</div>
		<!-- //page-section -->
	</main>

</body>
</html>


