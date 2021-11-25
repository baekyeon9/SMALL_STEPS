<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>문의사항 관리자 등록</title>
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
		<h1>문의사항 관리자 등록</h1>
		<form action='replyAdd'>
		  <label for='f-owner'>작성자</label>
		  <input id='f-owner' type='number' name='owner'><br>
			<label for='f-title'>제목</label>
			<input id='f-title' type='text' name='title'><br>
			<label for='f-content'>내용</label> <input id='f-content' type='text' name='content'><br>
			<label for='f-password'>패스워드</label> <input id='f-password' type='password' name='qnaPassword' maxlength='4'><br>
			<%--  <label for='f-file'>파일첨부</label> <input id='f-file' type='file' name='fileUpload'><br>--%>
			<button>등록</button><br>
			<a href='list'>[목록]</a>
		</form>
	</body>
</html>









