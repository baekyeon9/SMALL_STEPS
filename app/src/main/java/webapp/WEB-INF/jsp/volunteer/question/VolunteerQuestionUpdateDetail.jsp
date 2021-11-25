<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지문의변경</title>
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
<h1>챌린지 문의 변경</h1>
<form action='questionUpdate' method="post">
<div class= "class" name="name" id="id" style="display:none">
    <label for='f-no'>챌린지 번호</label> 
    <input id='f-no' type='text' name='no' value='${challengeQuestionDTO.no}' readonly><br>
<br></div>

    <label for='f-questionNo'>번호</label> 
    <input id='f-questionNo' type='text' name='questionNo' value='${challengeQuestionDTO.questionNo}' readonly><br>
    
    <label for='f-content'>내용</label> 
    <input id='f-content' type='text' name='content' value='${challengeQuestionDTO.content}'><br>
    
    <label for='f-owner'>작성자</label> 
    <input id='f-owner' type='text' name='owner' value='${challengeQuestionDTO.owner.id}' readonly><br>

    <label for='f-registeredDate'>등록일</label> 
    <span id='f-registeredDate'>${challengeQuestionDTO.registeredDate}</span><br>
<button>변경</button>
 <a href='questionList?no=${challengeQuestionDTO.no}'>[취소]</a><br>
</form>

</body>
</html>