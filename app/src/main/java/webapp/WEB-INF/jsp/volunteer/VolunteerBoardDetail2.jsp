<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <div class="ad-main">
     <div class="ad-main-infor">
       <div class="board-wrap padding-board">
         <h4 class="mb-3">봉사 게시판 상세보기</h4>
         
          <form action='boardUpdate' method="post"> 
          <div class="form-group" >
           <label for='f-no'></label>
            <input id='f-no' type='hidden' name='no' class="form-control col-sm-1" value='${volunteerBoardDTO.no}' readonly>
          </div>
        
          <div class="form-group">
            <label for='f-name' class="col-sm-2 col-form-label">작성자</label>
              <input id='f-name' type='text' name='name' class="form-control" value="${volunteerBoardDTO.owner.id}">
          </div>
          
          <div class="form-group">
            <label for='f-title' class="col-sm-2 col-form-label">제목</label>
              <input id='f-title' type='text' name='title' class="form-control" value="${volunteerBoardDTO.title}">
          </div>
          
          <div class="form-group">
            <label for='f-content' class="col-sm-2 col-form-label">내용</label> 
             <textarea name="content" id="f-content" cols="30" rows="8" class="form-control">${volunteerBoardDTO.content}</textarea>
           </div>
           
              <!-- //파일첨부 -->

          
           <%--         <div class="mb-3 row">
            <label for='f-photo' class="col-sm-2 col-form-label">사진</label> 
            <div class="col-sm-10">
              <a href="../upload/volunteer/${volunteerBoardDTO.fileUpload}" >
                  <img id="f-photo-image" src="../upload/volunteer/${volunteerBoardDTO.fileUpload}_100x100.jpg">
              </a>
              <input id='f-photo' type='file' name='photo' class="form-control">
            </div>
          </div> --%>
          
          <div class="form-group">
            <label for='f-registeredDate' class="col-sm-2 col-form-label">등록일</label> 
              <input id='f-registeredDate' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.registeredDate}">
          </div>
            
          <div class="form-group">
           <label for='f-viewCount' class="col-sm-2 col-form-label">조회수</label> 
             <input id='f-viewCount' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.viewCount}">
          </div>  
       
       
          <c:if test="${sessionScope.loginUser.no == volunteerBoardDTO.owner.no}">
       
          <div class="button-box">
           <button class="btn btn-primary">변경</button>
           <a href='boardDelete?no=${volunteerBoardDTO.no}' class="btn btn-primary">삭제</a>
           <input type="button" class="btn btn-outline-primary nBtn" value="이전" onClick="history.go(-1)" role="button">
           <%-- <a href='commentList?volBoardNo=${volunteerBoardDTO.no}' class="btn btn-primary">댓글</a>--%>
          
         </div>       
          </c:if>
         </form> 
           <br>
       </div>
      </div>
     </div>
     
      <!-- Reply Form {s} -->
      <div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
        <h6 class="border-bottom pb-2 mb-0">COMMENT LIST</h6>
        <div id="replyList"></div>
      </div> 
      
     
      
		 <main> 
		  <div class="page-section padding-board">
		   <div class="container">
		
		       <div class="table-wrap">
		         <table class="table">
		          <thead>
		          <tr>
		            <th>번호</th>
		           <%-- <th>게시글번호</th> --%>
		            <th>내용</th>
		            <th>작성자</th>
		            <th>등록일</th>
		          </tr>
		        </thead>
		        <tbody>
		         <%--  <c:if test='${empty noticeList}'>
		            <p>작성된 게시글이 없습니다.</p>
		          </c:if>--%>
		        
          <c:forEach items="${volunteerBoardCommentList}" var="volunteerBoardCommentDTO" varStatus="vs">
          <tr>
              <td>${volunteerBoardCommentDTO.no}</td> 
              <%-- <td>${volunteerBoardCommentDTO.volBoardNo}</td> --%>
              <td>${volunteerBoardCommentDTO.commentContent}</td> 
              
              <td>${volunteerBoardCommentDTO.owner.id}</td> 
              <td>${volunteerBoardCommentDTO.registeredDate}</td>
         
              
          <c:if test="${sessionScope.loginUser.no == volunteerBoardDTO.owner.no}">
              <td>&nbsp;&nbsp;<a data-toggle="modal" href="#myModalQuestionU${vs.index}">[변경]</a>
              <td><a href='commentDelete?no=${volunteerBoardCommentDTO.no}'>[삭제]</a></td>      
          </c:if>
            <!-- 부트스트랩의 모달 창을 사용할려면 아래의 class 이름들을 그대로 사용해야 한다. 변경하면 모양이 달라진다.-->
                    <div class="modal fade" id="myModalQuestionU${vs.index}" role="dialog"> <!-- 사용자 지정 부분① : id명 -->
                      <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                          <div class="modal-header">
                            <h4 class="modal-title">댓글 수정</h4> <!-- 사용자 지정 부분② : 타이틀 -->
                            <button type="button" class="close" data-dismiss="modal">×</button>
                          </div>
                            <form action='commentUpdate?no=${volunteerBoardCommentDTO.no}' method="post">
                            <div class="modal-body">
                            <div class= "class" id="id" style="">
                                <label for='f-volBoardNo'>게시글 번호</label> 
                                <input id='f-volBoardNo' type='text' name='volBoardNo' value='${volunteerBoardCommentDTO.volBoardNo}' readonly>
                              <br></div>
                              <div class= "class" id="id" style="">
                                <label for='f-no'>댓글 번호</label> <input id='f-no' type='text' name='no' value='${volunteerBoardCommentDTO.no}' readonly>
                              <br></div>
                              <textarea id='f-content' name='commentContent' cols="40" rows="1" class="modal-body">${volunteerBoardCommentDTO.commentContent}</textarea>
                                
                                <label for='f-owner'>작성자</label> 
                                <span id='f-owner'>${volunteerBoardCommentDTO.owner.id}</span><br>
                            
                                <label for='f-registeredDate'>등록일</label> 
                                <span id='f-registeredDate'>${volunteerBoardCommentDTO.registeredDate}</span><br>
                            </div>
                            <button>수정완료</button><br>
                          </form>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- 모달 창 -->
                    

          </tr>
          </c:forEach>
        </tbody>
      </table>
     </div>
    </div>



      

 <form action='commentAdd?volBoardNo=${volunteerBoardDTO.no}' method="post">
      <div class="form" id="form" role="form" >

<input id='f-volBoardNo' type='text' name='volBoardNo' value='${volunteerBoardDTO.no}' readonly><br>
      <div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
        <div class="row">
          <div class="col-sm-10">
            <textarea type="content" name='commentContent' id="content" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></textarea>
          </div> <br>
        
        <c:if test="${sessionScope.loginUser != null}">
          <div class="col-sm-2">
          <button>등록</button><br>
          </div>
        </c:if>
             </div> 
      </div>
        </div>
        </form>
        </div>  

  </main> 

