<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>소통해요 : 나눔이야기 등록</title>
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
<br><h4>소통해요 : 나눔이야기 등록</h4><br>
<form action='boardAdd' method="post" enctype="multipart/form-data">

<%--<div class="mb-3 row">
    <label for='f-owner' class="col-sm-2 col-form-label">작성자</label>
    <div class="col-sm-5">
      <input id='f-owner' type='number' name='owner' class="form-control">
    </div>
  </div> --%>
  
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
  
  <div class="mb-3 row">
  <label for='f-photo' class="col-sm-2 col-form-label">사진</label> 
  <div class="col-sm-8">
    <input id='f-photo' type='file' name='photo' class="form-control">
  </div>
</div>
  

  <%--<div class="mb-3 row">
   <label for='f-viewCount' class="col-sm-2 col-form-label">첨부파일</label> 
   <div class="col-sm-10">
     <input id='f-viewCount' type="file" class="form-control-plaintext">
   </div>
  </div>  
   --%>

  <div class="button-box">
    <button class="btn btn-primary" type="submit">등록</button>
    <a class="btn btn-primary" href='boardList' role="button">취소</a>
  </div>
  
</form>
</div><!-- .container -->

<script>
document.querySelector("#volunteer-button").onclick = () => {
  if (document.querySelector("#f-title").value == "" ||
      document.querySelector("#f-content").value == "") {
    //window.alert("필수 입력 항목이 비어 있습니다.")
    Swal.fire("필수 입력 항목이 비어 있습니다.")
    return false;
  }
};
</script>

</body>
</html>
