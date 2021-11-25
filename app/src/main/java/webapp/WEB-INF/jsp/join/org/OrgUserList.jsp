<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>관리자페이지 : 회원관리</title>
  
  <!-- link -->
  <link rel="stylesheet" href="../../assets/css/bootstrap.css">
  <link rel="stylesheet" href="../../assets/css/maicons.css">
  <link rel="stylesheet" href="../../assets/vendor/animate/animate.css">
  <link rel="stylesheet" href="../../assets/vendor/owl-carousel/css/owl.carousel.css">
  <link rel="stylesheet" href="../../assets/vendor/fancybox/css/jquery.fancybox.css">
  <link rel="stylesheet" href="../../assets/css/theme.css">
  <link rel="stylesheet" href="../../assets/css/admin.css">
</head>

<body>
  <div id="wrap">
    <div class="head">
      <div class="container">
        <div class="header">
          <h6 class="navbar-brand">Happy<b class="text-primary logo">Share</b></h6>
          <div class="btn-logoout">
            <button type="button" class="btn btn-primary btn-sm btn-logo">로그아웃</button>
          </div>
        </div>
      </div>
    </div>
    <!-- //head -->
    
    <div class="menu">
      <ul>
        <li><a href="#" class="on">회원정보조회</a></li>
        <li><a href="#">봉사활동관리</a></li>
        <li><a href="#">모금함활동관리</a></li>
        <li><a href="#">공지사항관리</a></li>
        <li><a href="#">문의사항관리</a></li>
        <li><a href="#">챌린지사항관리</a></li>
      </ul>
    </div>
    <!-- //menu -->
    
    <div class="ad-main">
      <div class="ad-main-infor">
        <!-- serch -->
        <div class="serch">
          <label for="inforSerch">검색</label>
          <input type="text" class="" id="inforSerch">
          <button type="submit" class="searchBtn">검색</button>
        </div>
        <!-- //serch -->
        <div class="table01">
          <table class="table">
            <thead>
              <tr>
               <th scope="col">
                 <input type="checkbox" id="check_all" class="input_check">
               </th>
                <th scope="col">번호</th>
                <th scope="col">아이디</th>
                <th scope="col">이름</th>
                <th scope="col">전화</th>
              <th scope="col">이메일</th>
              <th scope="col">우편번호</th>
              <th scope="col">기본주소</th>
              <th scope="col">상세주소</th>
              <th scope="col">승인상태</th>
              <th scope="col">회원유형</th>
              <th scope="col">등록일</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${orgUserList}" var="orgDTO">
              <tr>
                <td scope="col"><input type="checkbox" class="input_check"></td>
                <td scope="col">${orgDTO.no}</td>
                <td scope="col"><a href='detail?no=${orgDTO.no}'>${orgDTO.id}</a></td>
                <td scope="col">${orgDTO.name}</td>
                <td scope="col">${orgDTO.tel}</td>
              <td scope="col">${orgDTO.email}</td>
              <td scope="col">${orgDTO.postNo}</td>
              <td scope="col">${orgDTO.basicAddress}</td>
              <td scope="col">${orgDTO.detailAddress}</td>
              <td scope="col">${orgDTO.status}</td>
              <td scope="col">${orgDTO.type}</td>
              <td scope="col">${orgDTO.registerDate}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <div class="ad-btn">
            <a href="../statusUpdate" class="btnSubmit" value=0>추방</a>
            <a href="../statusUpdate" class="btnSubmit" value=3>반려하기</a>
            <a href="../statusUpdate" class="btnSubmit" value=1>승인하기</a>
            <!--  <a href="#" class="btnSubmit">수정</a>-->
            
          </div>
        </div>
        <!-- //table01 -->
      </div>
      
      <script>
      $(function(){
      $("#check_all").click(function(){
        var chk = $(this).is(":checked");//.attr('checked');
        if(chk) $(".select_subject input").attr('checked', true);
        else  $(".select_subject input").attr('checked', false);
      });
    });
      </script>
      
      <!-- //form -->
      
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
    <!-- //ad-main -->
    
  </div>
  <!-- //wrap -->
</body>
</html>
 