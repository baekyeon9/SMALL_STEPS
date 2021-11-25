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
            <label for='f-name' class="col-sm-2 col-form-label"><b>작성자</b></label>
              <input id='f-name' type='text' name='name' class="form-control" value="${volunteerBoardDTO.owner.id}" readonly>
          </div>
          
          <div class="form-group">
            <label for='f-title' class="col-sm-2 col-form-label"><b>제목</b></label>
              <input id='f-title' type='text' name='title' class="form-control" value="${volunteerBoardDTO.title}">
          </div>
          
          <div class="form-group">
            <label for='f-content' class="col-sm-2 col-form-label"><b>내용</b></label> 
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
            <label for='f-registeredDate' class="col-sm-2 col-form-label"><b>등록일</b></label> 
              <input id='f-registeredDate' type="text" readonly class="form-control-plaintext" value="${volunteerBoardDTO.registeredDate}">
          </div>
            
          <div class="form-group">
           <label for='f-viewCount' class="col-sm-2 col-form-label"><b>조회수</b></label> 
             <input id='f-viewCount' type="text" name= "viewcount" readonly class="form-control-plaintext" value="${volunteerBoardDTO.viewCount}">
          </div>  
       
       
         <div class="button-box">
           <c:if test="${sessionScope.loginUser.id == volunteerBoardDTO.owner.id}">
            <button class="btn btn-primary">변경</button>
            <a href='boardDelete?no=${volunteerBoardDTO.no}' class="btn btn-primary">삭제</a>
          </c:if>
           <input type="button" class="btn btn-outline-primary nBtn" value="이전" onClick="history.go(-1)" role="button">
           <%-- <a href='commentList?volBoardNo=${volunteerBoardDTO.no}' class="btn btn-primary">댓글</a>--%>
         </div>       
          
         </form> 
           <br>
       </div>
      </div>
     </div>
     
     
     
      <!-- Reply Form {s} -->
      <div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
        <h6 class="border-bottom pb-2 mb-0">COMMENT LIST</h6>

      
		       <%--  <c:if test='${empty noticeList}'>
		            <p>작성된 게시글이 없습니다.</p>
		          </c:if>--%>

        <div class="dap_lo">
         <div class="dap_lo2">
          <c:forEach items="${volunteerBoardCommentList}" var="volunteerBoardCommentDTO" varStatus="vs">
            <div><b>${volunteerBoardCommentDTO.owner.id}</b></div>
            <div class="dap_to comt_edit">${volunteerBoardCommentDTO.commentContent}</div>
            <div class="rep_me dap_to">${volunteerBoardCommentDTO.registeredDate}</div>
            <div class="rep_me rep_menu">       

               <!-- 모달 창 -->
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
                            <div class= "class" id="id" style="display:none">
                                <label for='f-volBoardNo'>게시글 번호</label> 
                                <input id='f-volBoardNo' type='text' name='volBoardNo' value='${volunteerBoardCommentDTO.volBoardNo}' readonly>
                              <br></div>
                              <div class= "class" id="id" style="display:none">
                                <label for='f-no'>댓글 번호</label> <input id='f-no' type='text' name='no' value='${volunteerBoardCommentDTO.no}' readonly>
                              <br></div>
                              <textarea id='f-content' name='commentContent' cols="40" rows="1" class="modal-body">${volunteerBoardCommentDTO.commentContent}</textarea>
                                <div>
                                <label for='f-owner'>작성자</label> 
                                <span id='f-owner'>${volunteerBoardCommentDTO.owner.id}</span><br>
                                </div>
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
                    
            <c:if test="${sessionScope.loginUser.id == volunteerBoardCommentDTO.owner.id}">
            &nbsp;&nbsp;<a data-toggle="modal" href="#myModalQuestionU${vs.index}">[수정]</a>
            <a href='commentDelete?no=${volunteerBoardCommentDTO.no}'>[삭제]</a>
            </c:if>          
        </div>
    </c:forEach>
        </div>
    </div>

 <form action='commentAdd?volBoardNo=${volunteerBoardDTO.no}' method="post">
      <div class="form" id="form" role="form" >

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


