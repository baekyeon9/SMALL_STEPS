
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>참여자목록</title>
  
  
   <!--  <link href="/css/layout.css" type="text/css" rel="stylesheet" />--> 
</head>


<body>
  <h1>[ 참여자 목록 ]</h1>
    <table border='1'>
      <thead>
        <tr>
          <th>아이디</th>
          <th>이름</th>
          <th>신청일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${volunteerList}" var="volunteerRequestDTO" >
          <tr>
              <td>${volunteerRequestDTO.applyOwner.id}</td> 
              <td>${volunteerRequestDTO.applyOwner.name}</td> 
              <td>${volunteerRequestDTO.applyDate}</td> 
          </tr>
        </c:forEach>
        <c:forEach items="${members}" var="joinDTO" >
          <tr>
              <td>${joinDTO.id}</td> 
              <td>${joinDTO.name}</td> 
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href='../detail?no=${volNo}'>[목록]</a>
    
    
    
    
     <!-- ------------------- <footer> --------------------------------------- -->


<!-- 
    <footer id="footer">
        <div class="content-container">
            <h2 id="footer-logo"><img src="images/logo-footer.png" alt="로고정보"></h2>

            <div id="company-info">
                <dl>
                    <dt>주소:</dt>
                    <dd>서울특별시 강남구</dd>
                    <dt>관리자메일:</dt>
                    <dd>admin@happyshare.com</dd>
                </dl>
                
                <dl>
                    <dt>상호:</dt>
                    <dd>happyshare</dd>
                    <dt>전화번호:</dt>
                    <dd>111-1111-1111</dd>
                </dl>
                <dl>
                    <dt>관리자메일:</dt>
                    <dd>admin@happyshare.com</dd>
                </dl>
                <div id="copyright" class="margin-top"> ⓒ 2021 happyshare All Right Reserved.
                   <br> Contact : admin@happyshare.com for more information</div>
            </div>
        </div>
    </footer>
     -->
  </body>
</html>









