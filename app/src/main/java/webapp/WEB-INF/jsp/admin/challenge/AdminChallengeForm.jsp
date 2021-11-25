<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>새챌린지</title>
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
<h1>새챌린지(MVC)</h1>
<form action='add' method='post' enctype="multipart/form-data">
<label for='f-title'>제목</label> <input id='f-title' type='text' name='title'><br>
<label for='f-content'>내용</label> <input id='f-content' type='text' name='content'><br>
<label for='f-startDate'>시작일</label> <input id='f-startDate' type='date' name='startDate'><br>
<label for='f-endDate'>종료일</label> <input id='f-endDate' type='date' name='endDate'><br>
<label for='f-photo'>사진첨부</label> <input id='f-photo' type='file' name='photoFile'><br>
<button>등록</button><br>
</form>
</body>
</html>









