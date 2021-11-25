<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <main> 
  <div class="page-section padding-board">
   <div class="container">
      <h4>봉사게시판 - 게시글 댓글 목록</h4>

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
				
					<c:forEach items="${volunteerBoardCommentList}" var="volunteerBoardCommentDTO">
					<tr>
					    <td>${volunteerBoardCommentDTO.no}</td> 
					    <%-- <td>${volunteerBoardCommentDTO.volBoardNo}</td> --%>
					    <td>${volunteerBoardCommentDTO.commentContent}</td> 
					    <td>${volunteerBoardCommentDTO.owner.id}</td> 
					    <td>${volunteerBoardCommentDTO.registeredDate}</td>
					    <td><a href='commentUpdateDetail?no=${volunteerBoardCommentDTO.no}'>[변경]</a></td>
					    <td><a href='commentDelete?no=${volunteerBoardCommentDTO.no}'>[삭제]</a></td>
					</tr>
					</c:forEach>
        </tbody>
			</table>
         <c:if test="${sessionScope.loginUser != null}">
         <div class="form-btn">
        <a href='commentForm?volBoardNo=${volunteerBoardDTO.no}' class="btnSubmit">댓글 작성</a>
        </div>
        </c:if>
		 </div>
    </div>
   </div>
  </main> 







