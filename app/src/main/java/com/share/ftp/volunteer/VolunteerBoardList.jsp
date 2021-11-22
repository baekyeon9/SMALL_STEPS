<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>함께해요 : 나눔이야기 목록</title>
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
  
  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
  
  <style>
      .container {
          width:640px;      
      }
    </style>
</head>
<body>
<div class="container">
<h1>봉사 게시판 목록</h1>
<br>
<table class="table table-hover">
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${volunteerBoardList}" var="volunteerBoardDTO">
<tr>
    <td>${volunteerBoardDTO.no}</td>
    <td><a href='boardDetail?no=${volunteerBoardDTO.no}'>${volunteerBoardDTO.title}</a></td> 
    <td>${volunteerBoardDTO.owner.id}</td> 
    <td>${volunteerBoardDTO.registeredDate}</td>
    <td>${volunteerBoardDTO.viewCount}</td> 
</tr>
</c:forEach>

</tbody>
</table>
      <label for='f-search'>검색어</label>
      <input id='f-search' type="text" name='keword'>
      <button class="btn btn-outline-primary btn-sm">검색</button> 
      <%-- <a href='boardDelete?no=${volunteerBoardDTO.no}' class="btn btn-primary"></a> --%>
      <a href='boardForm' class="btn btn-outline-primary btn-sm float: right">게시글 작성</a><br>
</div><!-- container -->

<div class="quick_menu">
    <ul>
        <li><a href="/commentList" class="store">매장찾기</a></li>
        <li><a href="/commentList" class="donation">물품기부</a></li>
        <li><a href="/commentList" class="sponsor">후원하기</a></li>

    </ul>
</div>

</body>
</html>








