<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
  <head>
    <title>소통해요 : 나눔이야기 댓글 변경</title>
    <style>
    label {
      margin-right: 5px;
      text-align: right;
      display: inline-block;
      width: 60px;
    }
  </style>
</head>
<body>
<h1>봉사게시글 댓글 변경</h1>
<form action='commentUpdate'>
<div class= "class" name="name" id="id" style="display:none">
    <label for='f-volBoardNo'>게시글번호</label>
    <input id='f-volBoardNo' type='text' name='volBoardNo' value='${volunteerBoardCommentDTO.volBoardNo}' readonly> <br>
<br></div>

    <label for='f-no'>댓글 번호</label>
    <input id='f-no' type='text' name='no' value='${volunteerBoardCommentDTO.no}' readonly><br>

    <label for='f-content'>내용</label> 
    <input id='f-content' type='text' name='commentContent' value='${volunteerBoardCommentDTO.commentContent}'><br>
    
    <%-- 댓글 등록회원 자동으로 들어가게 변경 예정 --%>
    <label for='f-owner'>작성자</label> 
    <input id='f-owner' type='text' name='owner' value='${volunteerBoardCommentDTO.owner.id}' readonly><br>

    <label for='f-registeredDate'>등록일</label> 
    <span id='f-registeredDate'>${volunteerBoardCommentDTO.registeredDate}</span><br>


<button>변경</button><br>
 <a href='commentList?volBoardNo=${volunteerBoardCommentDTO.volBoardNo}'>[취소]</a><br>
 
</form>
</body>
</html>