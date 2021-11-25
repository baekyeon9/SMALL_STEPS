<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지 참여인증&댓글</title>
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
<h1>챌린지 참여인증&댓글 등록</h1>
<form action='reviewAdd'>
<div class= "class" name="name" id="id" style="display:none">
<label for='f-no'>챌린지번호</label> <input id='f-no' type='text' name='no' value='${challengeDTO.no}' readonly>
<br></div>
<label for='f-content'>내용</label> <input id='f-content' type='text' name='content'><br>
<%-- 챌린지 문의 등록회원 자동으로 들어가게 변경 예정 --%>
<label for='f-owner'>작성자</label> <input id='f-owner' type='number' name='owner'><br>
<button>참여인증&댓글 등록</button><br>
</form>
</body>
</html>









