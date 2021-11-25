<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>기관회원목록</title>
</head>
<body>
<h1>기관회원 목록(MVC + EL + JSTL)</h1>
<div><a href='form'>새회원</a></div>
<table border='1'>

<c:if test="${empty orgUserList}">
<div>
등록된 기관회원이 없습니다.
</div>
</c:if>

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
    <th>사업자번호</th>
    <th>팩스</th>
    <th>홈페이지</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${orgUserList}" var="orgDTO">
<tr>
	  <td>${orgDTO.no}</td> 
	  <td><a href='detail?no=${orgDTO.no}'>${orgDTO.id}</a></td> 
	  <td>${orgDTO.name}</td> 
	  <td>${orgDTO.tel}</td> 
	  <td>${orgDTO.email}</td> 
	  <td>${orgDTO.postNo}</td> 
	  <td>${orgDTO.basicAddress}</td> 
	  <td>${orgDTO.detailAddress}</td> 
	  <td>${orgDTO.corpNo}</td> 
	  <td>${orgDTO.fax}</td> 
	  <td>${orgDTO.homepage}</td> 
	  <td>${orgDTO.registerDate}</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>












    