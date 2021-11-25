<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main>
   <div class="page-section">
      <div class="container">
         <div class="btn-regi" style="text-align: right;">
            <a href="form" class="btn btn-outline-primary nBtn btn-sm"
               role="button" style="padding: 8px 20px">개설신청</a>
         </div>
         <!-- //filterable-btn -->
         <div class="filterable-btn">
            <button class="btn active" data-filter="*">전체</button>
            <button class="btn" data-filter=".web">비대면</button>
            <button class="btn" data-filter=".mobile">아동</button>
            <button class="btn" data-filter=".desktop">청소년</button>
            <button class="btn" data-filter=".desktop">노인</button>
            <button class="btn" data-filter=".desktop">장애인</button>
            <button class="btn" data-filter=".desktop">동물</button>
            <button class="btn" data-filter=".desktop">환경</button>
            <button class="btn" data-filter=".desktop">기타</button>
         </div>
         <!-- //filterable-btn -->

         <!-- card_body -->
         <div class="card_body "
            style="overflow: hidden; box-sizing: border-box; width: 100%; margin-top: 45px;">
            <c:forEach items="${donationBoardList}" var="donationBoardDTO">
               <!-- 모금함목록 -->
               <div class="card card-item"
                  style="width: 33.33%; float: left; padding: 0 5%; border: none;"
                  data-no="${donationBoardDTO.no}">
                  <span class="vol-type bu-d">${donationBoardDTO.category.title}</span>
                  <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png"
                     class="card-img-top" alt="...">
                  <div class="card-body">
                     <h5 class="card-title vol-title">
                        <a href='detail?no=${donationBoardDTO.no}'>${donationBoardDTO.title}</a>
                     </h5>
                     <p class="card-text">
                        <span class="text-muted">${donationBoardDTO.startDate}~${donationBoardDTO.endDate}</span>
                     </p>
                  </div>
                  <ul class="list-group list-group-flush">
                     <li class="list-group-item" style="font-weight: bold;"><span
                        class="vol-cur"> <span class="sr-only">기부금액</span> <!--  <b class="vol-count">${donationBoardDTO.moneyTarget}</b>
                  /--> <span class="sr-only">총 목표금액</span> <fmt:formatNumber
                              type="number" value="${donationBoardDTO.moneyTarget}"
                              maxFractionDigits="3" />원
                     </span> <span
                        style="padding-left: 13px; font-weight: normal; font-size: 14px; color: #777;">${donationBoardDTO.tel}</span>
                     </li>
                     <li class="list-group-item">~${donationBoardDTO.remainDate}일
                        남음</li>
                  </ul>
                  <div class="card-footer">
                     <small class="text-muted">${donationBoardDTO.leader.name}</small>
                  </div>
               </div>
            </c:forEach>
         </div>
      </div>
      <!-- .container -->
   </div>
   <!-- .page-section -->
</main>






