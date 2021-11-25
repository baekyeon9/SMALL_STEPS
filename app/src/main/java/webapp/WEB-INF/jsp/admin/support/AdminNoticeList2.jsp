<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <div class="ad-main">
      <div class="ad-main-infor">
        <!-- serch -->
        <div class="serch">
          <label for="f-search">검색</label>
          <input type="search" class="" id="f-search" name="keword" placeholder="검색">
          <button type="submit" class="searchBtn">검색</button>
        </div>
        <!-- //serch -->
        <div class="table01">
          <table class="table">
            <thead>
              <tr>
               <th scope="col">
                 <input type="checkbox" id="checkAll" name="checkAll">
               </th>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">등록일</th>
                <th scope="col">조회수</th>
                <th scope="col">첨부파일</th>
              </tr>
            </thead>
            <tbody>
            <c:if test='${empty noticeList}'>
			       <p>작성된 게시글이 없습니다.</p>
			      </c:if>
			      
			      <c:forEach items="${noticeList}" var="noticeDTO" >
              <tr>
                <td><input type="checkbox" name="checkRow" class="select-box" value="${noticeDTO.no}"></td>
                <td>${noticeDTO.no}</td>
                <td><a href='noticeDetail?noticeNo=${noticeDTO.no}'>${noticeDTO.title}</a></td>
                <td>${noticeDTO.registeredDate}</td>
                <td>${noticeDTO.viewCount}</td>
                <td>${noticeDTO.fileUpload}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <div class="ad-btn">
            <a href="noticeForm" class="btnSubmit">글쓰기</a>
            <input type="button" id="delete" value="삭제" onClick="noticeDelete?noticeNo=${noticeDTO.no})">
            <!--<a href="noticeDelete?noticeNo=${noticeDTO.no}" class="btnSubmit">삭제</a>-->
          </div>
        </div>
        <!-- //table01 -->
      </div>
      <!-- //form -->
      
      <div class="col-12 my-5">
        <nav aria-label="Page Navigation">
          <ul class="pagination justify-content-center">
            <li class="page-item disabled">
              <a class="page-link" href="#" tabindex="-1" aria-disabled="true">이전</a>
            </li>
            <li class="page-item active" aria-current="page">
              <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
              <a class="page-link" href="#">다음</a>
            </li>
          </ul>
        </nav>
      </div>
      
    </div>
    <!-- //ad-main -->
    
    <script src="${contextPath}/assets/js/jquery-3.5.1.min.js"></script>
  
	  <!-- script -->
	  <script>
		  $(document).ready(function() {
		    $("#checkAll").click(function() {
		      if($("#checkAll").is(":checked")) 
		    	  $("input[name=checkRow]").prop("checked", true);
		      else $("input[name=checkRow]").prop("checked", false);
		    });
		    
		    $("input[name=checkRow]").click(function() {
		        var total = $("input[name=checkRow]").length;
		        var checked = $("input[name=checkRow]:checked").length;

		        if(total != checked) $("#checkAll").prop("checked", false);
		        else $("#checkAll").prop("checked", true); 
		      });
		  });
		</script>









