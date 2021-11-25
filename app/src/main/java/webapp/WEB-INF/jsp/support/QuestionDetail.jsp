<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<div class="ad-main">
    <div class="ad-main-infor">
      <div class="board-wrap padding-board">
        <h4 class="mb-5">문의사항</h4>
        <form action='questionUpdate' method="post" id="qna-form" enctype="multipart/form-data">
          <div class="form-group">
            <label for="f-no">번호</label>
            <input id="f-no" class="form-control col-sm-1"  type='text' name='questionNo' value='${questionListDTO.no}' readonly>
          </div>
          <!-- //번호 -->
          <div class="form-group">
            <label for="f-qnaType">문의분야</label>
            <input id="f-qnaType" class="form-control col-sm-3"  type='text' name='qnaType' value='${questionListDTO.qnaType.title}' readonly>
          </div>
          <!-- //문의분야 -->
          <div class="form-group">
            <label for="f-title">제목</label>
            <input id="f-title" type="text" class="form-control"  name="title" value="${questionListDTO.title}">
          </div>
          <!-- //제목 -->
          <div class="form-group">
            <label for="f-content">내용</label>
            <textarea id="f-content" name="content"  cols="30" rows="8" class="form-control">${questionListDTO.content}</textarea>
          </div>
          <!-- //내용 -->
          <div class="form-group">
            <label for='f-password'>패스워드</label>
            <input id='f-password' class="form-control col-sm-2" type='password' name='qnaPassword' value='${questionListDTO.qnaPassword}' readonly>
          </div>
          <!-- //비밀번호 -->
          <label for='f-owner'>작성자</label> 
          <span id='f-owner'>${questionListDTO.owner.id}</span><br>
          <label for='f-registeredDate'>등록일</label> 
          <span id='f-registeredDate'>${questionListDTO.registeredDate}</span><br>
          <label for='f-viewCount'>조회수</label> 
          <span id='f-viewCount'>${questionListDTO.viewCount}</span><br>
          <%--<label for='f-file'>첨부파일</label> 
          <input id='f-file' type='file' name='fileUpload' value='${questionListDTO.fileUpload}'>  --%>
          <button>수정</button>
          <a href='questionDelete?questionNo=${questionListDTO.no}'>[삭제]</a>
          <a href='questionList'>[목록]</a><br>
          <a href='questionList'>[답글쓰기]</a><br>
        </form>
       </div>
    </div>
    <!-- //ad-main-infor -->
   </div>
   <!-- //ad-main -->