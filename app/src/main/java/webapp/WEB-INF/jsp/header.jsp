<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <header>
      <div class="top-bar">
        <div class="container">
          <div class="row align-items-center">          
            <div class="col-md-12 text-right d-none d-md-block">
              <div class="social-mini-button">
               <c:if test="${empty sessionScope.loginUser}">
                  <a href="${contextPath}/app/auth/loginForm" style="font-size:16px; color:#9e9e9e;"><span>로그인</span></a>
                <a href="${contextPath}/app/join/userType" style="font-size:16px; color:#9e9e9e;"><span>회원가입</span></a>
                </c:if>
                <c:if test="${not empty sessionScope.loginUser}">
                     <!-- a태그 마이페이지로 연동시켜야 함 -->
                    <a href="${contextPath}/app/auth/logout" style="font-size:16px;"><span style="color:#ff8184; font-weight:bold;">${sessionScope.loginUser.name} 님</span> <span> 환영합니다!</span></a>
                    <a href="${contextPath}/app/auth/logout" style="font-size:16px; color:#9e9e9e;"><span>로그아웃</span></a>
                </c:if>
                     <!-- 관리자로 로그인 했을 때 보이게 설정하고 아니면 안보이게 설정 조건 주자 -->
                  <a href="${contextPath}/app/auth/loginList" style="font-size:16px; color:#9e9e9e;"><span>관리자</span></a>
              </div>
            </div>
          </div>  <!-- // row -->
        </div> <!-- // container -->
      </div>   <!-- // top-bar -->
    
  
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
           <a href="${contextPath}/app/home" class="navbar-brand" style="color:#5979c2  !important; font-size:28px;">Happy<span class="text-primary logo" style="color:#ff8184 !important;">Share</span></a>
          <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
  
          <div class="navbar-collapse collapse" id="navbarContent">
            <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">함께해요</a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="${contextPath}/app/volunteer/list">봉사목록</a>
                  <a class="dropdown-item" href="${contextPath}/app/volunteer/form">봉사신청</a>
                </div>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">소통해요</a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="${contextPath}/app/volunteer/boardList">나눔이야기</a>
                  <a class="dropdown-item" href="${contextPath}/app/volunteer/reviewList">한줄후기</a>
                </div>
              </li>
              <li class="nav-item">
                <a href="${contextPath}/app/challenge/list" class="nav-link">챌린지</a>
              </li>
              <li class="nav-item">
                <a href="${contextPath}/app/donation/list" class="nav-link">모금함</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">고객센터</a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="${contextPath}/app/support/noticeList">공지사항</a>
                  <a class="dropdown-item" href="${contextPath}/app/support/questionList">문의사항</a>
                </div>
              </li>
            </ul>
          </div>
        </div> <!-- .container -->
      </nav> <!-- .navbar -->
    </header>