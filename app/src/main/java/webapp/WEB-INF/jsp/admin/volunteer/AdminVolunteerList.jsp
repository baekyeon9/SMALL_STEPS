
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
                 <input type="checkbox">
               </th>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
              <th scope="col">주최자</th>
              <th scope="col">카테고리</th>
              <th scope="col">전화번호</th>
              <th scope="col">총모집인원</th>
              <th scope="col">총날짜</th>                
                <th scope="col">남은기간</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${volunteerList}" var="volunteerRequestDTO" >
              <tr>
                <td><input type="checkbox" class="select-box"></td>
                             <td>${volunteerRequestDTO.no}</td>
              <td><a href='detail?no=${volunteerRequestDTO.no}'>${volunteerRequestDTO.title}</a></td> 
              <td>${volunteerRequestDTO.owner.id}</td> 
              <td>${volunteerRequestDTO.category.title}</td> 
              <td>${volunteerRequestDTO.tel}</td> 
              <td>${volunteerRequestDTO.limitNum}<span>명</span></td>
              <td>${volunteerRequestDTO.totalDate}<span>일</span></td>
              <td>${volunteerRequestDTO.remainDate}<span>일</span></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          <div class="ad-btn">
            <a href='approvedList' class="btnSubmit">[승인목록]</a>
            <a href='rejectedList' class="btnSubmit">[반려목록]</a>
            <a href='waitList' class="btnSubmit">[대기목록]</a>
          </div>
        </div>
        <!-- //table01 -->
      </div>
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
    













