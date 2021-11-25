<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>개인회원목록</title>
</head>
<body>
<h1>개인회원 목록(MVC + EL + JSTL)</h1>
<div><a href='form'>새회원</a></div>
<table border='1'>

<thead>
  <tr>
    <th>회원번호</th>
    <th>아이디</th>
    <th>이름</th>
    <th>전화</th>
    <th>이메일</th>
    <th>우편번호</th>
    <th>기본주소</th>
    <th>상세주소</th>
    <th>등급</th>
    <th>회원상태</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>

<c:if test="${empty personalUserList}">
<div>
등록된 개인회원이 없습니다.
</div>
</c:if>

<c:forEach items="${personalUserList}" var="personalDTO">
<tr>
	  <td>${personalDTO.no}</td> 
	  <td><a href='detail?no=${personalDTO.no}'>${personalDTO.id}</a></td> 
	  <td>${personalDTO.name}</td> 
	  <td>${personalDTO.tel}</td> 
	  <td>${personalDTO.email}</td> 
	  <td>${personalDTO.postNo}</td> 
	  <td>${personalDTO.basicAddress}</td> 
	  <td>${personalDTO.detailAddress}</td> 
	  <td>${personalDTO.level}</td> 
	  <td>${personalDTO.status}</td> 
	  <td>${personalDTO.registerDate}</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>












    