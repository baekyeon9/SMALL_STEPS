<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main>
	<div class="page-section">
		<div class="container">
			<div class="do-detail">
				<!-- do-left -->
				<div class="do-left">
					<h5>
						<a href="#">${donationBoardDTO.category.title}</a>
					</h5>
					<h2>${donationBoardDTO.title}</h2>
					<ul class="do-tap">
						<li id="do-tap-de"><a
							href="${contextPath}/app/donation/detail?no=${donationBoardDTO.no}"
							>모금함 소개</a></li>
						<li id="do-tap-de" class="on"><a
							href="${contextPath}/app/register/list?no=${donationBoardDTO.no}" class="do-on">참여내역</a></li>
					</ul>
					<div class="tab-cont" style="padding:0 25px;">
						<p class="tab-cont-sub">
							<div class="cont-short-list">
								<div class="num-text bo">
									기부자참여 <span class="sr-only">참여인원</span> <b class="num-count">${registerUser}</b>
								</div>
	               <c:forEach items="${donationRegisterList}" var="donationRegisterDTO">
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
				                          <span>${donationRegisterDTO.donator.id}</span> <span
				                            class="txt_date">${donationRegisterDTO.registeredDate}</span>
				                          <span class="ico_bbs ico_new">기부참여내역</span>
				                        </div>
				                        <div class="review-post">
				                          <p>
				                            <span>${donationRegisterDTO.donationMoney}원</span>
				                          </p>
				                        </div>
				                      </div>
				                    </div>
				                  </div> <!-- //review-section -->
				                </li>
				              </ul>
				            </div>
				          </div>
				        </c:forEach>
				        <!-- //s-review-list -->
							</div>
							<!-- //cont-short-list -->
						</p>
					</div>
					<!-- //tab-cont -->
				</div>
				<!-- //do-left -->
				<!-- do-right -->
				<div class="do-right">
					<div class="graph-status">
						<c:set var="moneyTargets"
							value="${remainMoney / donationBoardDTO.moneyTarget  * 100 }" />
						<c:set var="moneys"
							value="${money / donationBoardDTO.moneyTarget  * 100 }" />
						<span class="per"><strong>${moneys}</strong>%</span>
					</div>
					<div class="progress">
						<div class="progress-bar progress-bar-striped" role="progressbar"
							style="width: ${moneys}%" aria-valuenow="${remainMoney}%"
							aria-valuemin="0"
							aria-valuemax="${donationBoardDTO.moneyTarget}%"></div>
					</div>
					<div class="num-area">
						<p class="do-num">
							<span>목표금액 : <strong><fmt:formatNumber
										type="number" value="${donationBoardDTO.moneyTarget}"
										maxFractionDigits="3" /></strong>원
							</span>
						</p>
						<p class="num-status">
							<span>현재기부금액 : <strong><fmt:formatNumber
										type="number" value="${money}" maxFractionDigits="3" /></strong>원
							</span>
						</p>
						<p class="num-status">
							<span>남은기부금액 : <strong><fmt:formatNumber
										type="number" value="${remainMoney}" maxFractionDigits="3" /></strong>원
							</span>
						</p>
					</div>
					<!-- //num-area -->
					<div class="do-date">
						<p>
							<strong>${donationBoardDTO.startDate}~${donationBoardDTO.endDate}</strong>까지
						</p>
						<div class="do-d-day">D-${donationBoardDTO.remainDate}</div>
					</div>
					<!-- //do-date -->
					<div class="do-infor">
						<p>${donationBoardDTO.tel}</p>
						<p>${donationBoardDTO.email}</p>
					</div>
					<div class="do-btn">
						<a
							href="${contextPath}/app/register/form?boardNo=${donationBoardDTO.no}"
							class="do-btn-a">모금함 기부하기</a>
					</div>
				</div>
				<!-- //do-right -->
			</div>
			<!-- //do-detail -->
		</div>
		<!-- //container -->
	</div>
</main>

