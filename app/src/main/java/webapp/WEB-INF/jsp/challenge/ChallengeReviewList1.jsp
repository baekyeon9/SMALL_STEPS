<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지리뷰목록</title>
</head>
<body>
<h1>참여인증&댓글 목록</h1>
<a href='reviewForm?no=${challengeDTO.no}'>참여인증&댓글 등록</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>내용</th>
    <th>작성자</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${challengeReviewList}" var="challengeReviewDTO">
<tr>
    <td>${challengeReviewDTO.reviewNo}</td>
    <td>${challengeReviewDTO.content}</td> 
    <td>${challengeReviewDTO.owner.id}</td> 
    <td>${challengeReviewDTO.registeredDate}</td>
    <td><a href='reviewUpdateDetail?reviewNo=${challengeReviewDTO.reviewNo}&no=${challengeReviewDTO.no}'>[변경]</a></td>
    <td><a href='reviewDelete?reviewNo=${challengeReviewDTO.reviewNo}&no=${challengeReviewDTO.no}'>[삭제]</a></td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>