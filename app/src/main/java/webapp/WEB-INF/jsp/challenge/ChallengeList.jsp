<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(${contextPath}/images/challenge_bg.jpg);">
  <div class="container h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-lg-8">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
            <li class="breadcrumb-item"><a href="${contextPath}/app/home">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">챌린지</li>
          </ol>
        </nav>
        <h1 class="fg-white text-center">이달의 챌린지</h1>
      </div>
    </div>
  </div>
</div> <!-- .page-banner -->

  <main>
    <div class="page-section">
      <div class="container">
        <div class="filterable-btn">
          <button class="btn active" data-filter="*">최신순</button>
          <button class="btn" data-filter=".web">인기순</button>
        </div>
        <c:forEach items="${challengeList}" var="challengeDTO">
        <div class="card" style="width: 29%; height: auto; margin-right:3.33%; margin-bottom: 3.33%; float: right; text-align : center;">
          <img src="${contextPath}/upload/challenge/${challengeDTO.photo}" class="card-img-top" alt="..." style="width:150px; height:150px; display: block; margin: 0 auto;">
          <div class="card-body" >
            <h5 class="card-title">${challengeDTO.title}</h5>
            <p class="card-text">${challengeDTO.startDate} ~ ${challengeDTO.endDate}</p>
            <a href='detail?no=${challengeDTO.no}' class="btn btn-primary">자세히 보기</a>
          </div>
        </div>
        </c:forEach>
        </div>
        <div class="mt-5 text-center">
          <button class="btn btn-primary">Load More</button>
        </div>
      </div> <!-- .container -->
  </main>
