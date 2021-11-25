

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <main>
    <div class="page-section padding-board">
      <div class="container">
        <h4 class="mb-3">문의사항</h4>
        
        <!-- serch -->
        <div>
          <form class="form-inline" style="float:right; margin-bottom:25px">
            <input class="form-control mr-sm-2 search-box" type="search" placeholder="검색" aria-label="Search">
            <button class="btn btn-secondary my-2 my-sm-0 search-btn" type="submit">검색</button>
          </form>
        </div>
        <!-- //serch -->
        
        <!-- table-wrap -->
        <div class="table-wrap">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">번호</th>
                <th scope="col">문의분야</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">등록일</th>
                <th scope="col">조회수</th>
                <th scope="col">답글여부</th>
                <th scope="col">답글여부</th>
              </tr>
            </thead>
            <tbody>
            
              <c:if test='${empty questionList}'>
               <p>작성된 게시글이 없습니다.</p>
              </c:if>
              
              <c:forEach items="${questionList}" var="QuestionListDTO">
                <tr data-no='${QuestionListDTO.no}'>
                  <td id="qna-no">${QuestionListDTO.no}</td>
                  <td>${QuestionListDTO.qnaType.title}</td>
                  <td><a href='#' data-toggle="modal" data-target="#questionModal" data-no="${QuestionListDTO.no}">
                       ${QuestionListDTO.title}
                     </a>
                  </td> 
                  <td>${QuestionListDTO.owner.id}</td>
                  <td>${QuestionListDTO.registeredDate}</td>
                  <td>${QuestionListDTO.viewCount}</td>
                  <td>${QuestionListDTO.status}</td>
                  <td>${QuestionListDTO.qnaPassword}</td>
                </tr>
              </c:forEach>
              
            </tbody>
          </table>
          
           <!-- modal -->
           <div class="modal fade" id="questionModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <form>
                      <h5 style="text-align:center; padding-bottom:20px;">비밀번호를 입력해주세요.</h5>
                      <div class="form-group">
                        <label for="recipient-name"   class="col-form-label">비밀번호</label>
                        <input type="password" id="pwd" name="qnaPassword" class="form-control" id="recipient-name" maxlength='4' placeholder="숫자 4자리">
                      </div>
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    <button type="submit" id="btnCheck" class="btn btn-primary">입력</button>
                  </div>
                </div>
              </div>
            </div>
            <!-- //modal -->
           
           <!--  <div id='modal'>
           <div id='content'>
             <input type='button' value='X' class="close" id='btnClose'/>
             <div style="display: block; width: auto; font-size: 16px; text-align:center;">
               <label style="margin:0 auto; padding-bottom:20px; display:block;">비밀번호를 입력해주세요.</label>
               <input type='password' id='pwd' name="qnaPassword" style="padding:7px; background-color:#f1f1f1; border: 1px solid #ddd; width:140px; font-size:13px; margin-right:5px;"/>
               <button class="form-btn nooutline" type="submit" id='btnCheck'>입력</button>
             </div>
           </div>
          </div>-->
          
          
          <div class="form-group btn-right">
            <a class="btn btn-primary search-box" href='questionForm'>글쓰기</a><br>
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
                <a class="page-link" href="#">다음</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
      <!-- //table-wrap -->
     </div>
     <!-- //container -->
     </div>
     <!-- //page-section -->
    </main>
    
    <script>
    var modalNo = document.querySelector("#f-no");

    document.querySelectorAll(".x-delete-btn").forEach((tag) => {
      tag.onclick = (e) => {
        e.stopPropagation();
        var no = e.target.getAttribute("data-no");
        var tr = document.querySelector("tbody tr[data-no='" + no + "']");
        
        modalNo.value = no;
      }
    });
    
    // 비밀번호 확인
    var no = document.getElementById('qna-no').textContent;

    btnCheck.onclick = function() {
      
       var password  = document.getElementById('pwd');
       var checkPassword  = document.getElementById('checkPwd');
       
       console.log(password);
       console.log(checkPassword);
      
      if (password.value == checkPassword.value) {
        
      window.location.href= "questionDetail?questionNo="+no;
      }
      
    };
    </script>
