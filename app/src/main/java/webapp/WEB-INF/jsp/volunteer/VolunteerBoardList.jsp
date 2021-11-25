<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <title>소통해요 : 나눔이야기 목록</title>


    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(${contextPath}/images/volunteer4.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="${contextPath}/app/home">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">소통해요</li>
              </ol>
            </nav>
            <h1 class="fg-white text-center">나눔이야기</h1>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->

 <!-- main -->
<main>
  <div class="page-section">
    <div class="container">

 <label for="f-search"></label>
           <form class="form-inline" style="float:right; margin-bottom:25px">
      <input type="search" class="form-control mr-sm-2 search-box" id="f-search" name="keword">
      <button type="submit" class="btn btn-secondary my-2 my-sm-0 search-btn">검색</button>
      
          </form>

  <div class="table-wrap">
    <table class="table">
          <thead>
            <tr>
              <th scope="col" style="display:none">번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">등록일</th>
              <th scope="col">조회수</th>
            </tr>
          </thead>
            <tbody>
              <c:if test='${empty volunteerBoardList}'>
              <p>작성된 게시글이 없습니다.</p>
              </c:if>
              <c:forEach items="${volunteerBoardList}" var="volunteerBoardDTO">
                <tr>
                <td th scope="col" style="display:none">${volunteerBoardDTO.no}</td>
                <td><a href='boardDetail?no=${volunteerBoardDTO.no}'>${volunteerBoardDTO.title}</a></td> 
                <td>${volunteerBoardDTO.owner.id}</td> 
                <td>${volunteerBoardDTO.registeredDate}</td>
                <td>${volunteerBoardDTO.viewCount}</td> 
                </tr>
              </c:forEach>
            </tbody>
        </table>
  </div>
    <!-- //table-wrap -->

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
      <!-- //container -->

     

     <c:if test="${sessionScope.loginUser != null}">
         <div class="btn-regi" style="text-align:right;">
           <a href="boardForm" class="btn btn-outline-primary nBtn btn-sm" role="button" style="padding:8px 20px">등록</a>
         </div>
    </c:if>

    </div>
      <!-- //page-section -->
  </main>
  
  
  
    </body>
</html>










