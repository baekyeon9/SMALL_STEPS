<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>함께해요 : 나눔이야기 등록</title>
	  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
  
	  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
	  <script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
	  
	  <style>
	  label {
	    width: 640px;
	  }
  </style>
</head>
<body>
<div class="container">
<h1>봉사 게시글 등록</h1><br>
<form action='boardAdd'>

<div class="mb-3 row">
    <label for='f-owner' class="col-sm-2 col-form-label">작성자</label>
    <div class="col-sm-5">
      <input id='f-owner' type='number' name='owner' class="form-control">
    </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-title' class="col-sm-2 col-form-label">제목</label>
    <div class="col-sm-8">
      <input id='f-title' type='text' name='title' class="form-control">
    </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-content' class="col-sm-2 col-form-label">내용</label> 
        <div class="col-sm-8">
      <textarea id='f-content' name='content' class="form-control" rows="5">
    </textarea>
  </div>
  </div>
  

<%--  <div class="mb-3 row">
    <label for='f-content' class="col-sm-2 col-form-label">내용</label> 
    <div class="col-sm-10">
      <input id='f-content' type='text' name='content' class="form-control">
    </div>
  </div> --%>

  <%--<div class="mb-3 row">
   <label for='f-viewCount' class="col-sm-2 col-form-label">첨부파일</label> 
   <div class="col-sm-10">
     <input id='f-viewCount' type="file" class="form-control-plaintext">
   </div>
  </div>  
   --%>



<button class="btn btn-primary btn-sm">등록</button><br>
</form>
</div><!-- .container -->
</body>
</html>










