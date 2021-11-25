<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>답글등록/변경</title>
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
<h1>답글 등록/변경</h1>
<form action='replyUpdate' method='post' method="post">
<div class= "class" name="name" id="id" style="display:none">
    <label for='f-no'>챌린지 번호</label> 
    <input id='f-no' type='text' name='no' value='${challengeQuestionDTO.no}' readonly><br>

    <label for='f-questionNo'>번호</label> 
    <input id='f-questionNo' type='text' name='questionNo' value='${challengeQuestionDTO.questionNo}' readonly><br>
<br></div>

    <label for='f-reply'>답글</label> 
    <input id='f-reply' type='text' name='reply' value='${challengeQuestionDTO.reply}'><br>

<button>등록/변경</button>
 <a href='questionList?no=${challengeQuestionDTO.no}'>[취소]</a><br>
</form>

</body>
</html>