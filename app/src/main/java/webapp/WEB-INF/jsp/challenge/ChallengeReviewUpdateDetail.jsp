<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>참여인증&댓글 변경</title>
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
<h1>참여인증&댓글 변경</h1>
<form action='reviewUpdate'>
<div class= "class" name="name" id="id" style="display:none">
    <label for='f-no'>챌린지 번호</label> 
    <input id='f-no' type='text' name='no' value='${challengeReviewDTO.no}' readonly><br>
<br></div>

    <label for='f-reviewNo'>번호</label> 
    <input id='f-reviewNo' type='text' name='questionNo' value='${challengeReviewDTO.reviewNo}' readonly><br>
    
    <label for='f-content'>내용</label> 
    <input id='f-content' type='text' name='content' value='${challengeReviewDTO.content}'><br>
    
    <label for='f-owner'>작성자</label> 
    <input id='f-owner' type='text' name='owner' value='${challengeReviewDTO.owner.id}' readonly><br>

    <label for='f-registeredDate'>등록일</label> 
    <span id='f-registeredDate'>${challengeReviewDTO.registeredDate}</span><br>
<button>변경</button>
 <a href='reviewList?no=${challengeReviewDTO.no}'>[취소]</a><br>
</form>

</body>
</html>