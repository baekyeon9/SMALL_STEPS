<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지목록</title>
</head>
<body>
<h1>챌린지 목록</h1>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>시작일</th>
    <th>종료일</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${challengeList}" var="challengeDTO">
<tr>
    <td>${challengeDTO.no}</td>
    <td><a href='detail?no=${challengeDTO.no}'>${challengeDTO.title}</a></td> 
    <td>${challengeDTO.startDate}</td> 
    <td>${challengeDTO.endDate}</td> 
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>