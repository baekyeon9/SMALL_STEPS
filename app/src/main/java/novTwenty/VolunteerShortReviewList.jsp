<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../../assets/img/helpinghand.jpg);">
    <div class="container h-100">
      <div class="row justify-content-center align-items-center h-100">
        <div class="col-lg-8">
            <nav aria-label="breadcrumb">
            <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="${contextPath}/app/home">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">소통해요</li>
              </ol>
            </nav>
           <h1 class="fg-white text-center">한 줄후기</h1>
        </div>
      </div>
    </div>
  </div> <!-- .page-banner -->
    
    
  <title>소통해요 : 한줄후기 메인</title>
 <main>
 <form action='reviewAdd' method="post">
  <div class= "class" name="name" id="id" style="display:none"></div>
  <button>등록</button><br>
</form>
  <div class="page-section">
    <div class="container">
      <div class="short-main">
        <img src="https://cdn-icons-png.flaticon.com/512/3349/3349234.png" alt="짧은 후기 메인이미지">
      </div>
      <!-- //short-main -->

      <div class="text-wirte">
        <div class="inner-text-wirte">
          <div class="box-text">
            <textarea maxlength="600" name="content" style="height:80px;"></textarea>
          </div>
          </div> 
         </div>
        <!-- //inner-text-wirte -->
      </div>
      <!-- //text-wirte -->
      <div class="cont-short-list">
        <c:forEach items="${volunteerShortReviewList}" var="volunteerShortReviewDTO">
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
                        <span>${volunteerShortReviewDTO.owner.id}</span>
                        <span class="txt_date">${volunteerShortReviewDTO.registeredDate}</span>
                   <%-- <span class="ico_bbs ico_new">새글</span>--%>          
                      </div>
                         <div class="review-post">
                        <p><span>${volunteerShortReviewDTO.content}</span></p>
                      </div>
                      <div class="review-btn">
                        <a href='reviewUpdate?no=${volunteerShortReviewDTO.no}' class="link_menu">[수정]</a>
                        <a href='reviewDelete?no=${volunteerShortReviewDTO.no}' class="link_menu">[삭제]</a>
                      </div>
                    </div>
                  </div>
                 </div>
                </li>             
              </ul>
            </div>
          </div>
          </c:forEach>
          <!-- //s-review-list -->
        </div>
        
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
  </main>  









