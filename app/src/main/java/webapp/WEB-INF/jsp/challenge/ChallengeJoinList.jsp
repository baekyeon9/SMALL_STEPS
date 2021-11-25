<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지참여목록</title>
</head>
<body>
<h1>챌린지 참여자 목록</h1>
<table border='1'>
<thead>
  <tr>
    <th>참여자</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${challengeJoinList}" var="challengeDTO">
<tr>
    <td>${challengeDTO.owner.id}</td> 
    <td>${challengeQuestionDTO.registeredDate}</td>
    <td><a href='questionDelete?questionNo=${challengeQuestionDTO.questionNo}'>[삭제]</a></td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>