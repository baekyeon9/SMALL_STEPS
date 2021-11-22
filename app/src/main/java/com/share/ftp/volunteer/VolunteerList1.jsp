
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>봉사목록</title>
  
  
   <!--  <link href="/css/layout.css" type="text/css" rel="stylesheet" />--> 
</head>


<body>
  <h1>[ happyshare 봉사 목록]</h1>
  <a href='form'>봉사 신청하기</a><br>
    <table border='1'>
      <thead>
			  <tr>
			    <th>번호</th>
			    <th>제목</th>
			    <th>주최자</th>
			    <th>카테고리</th>
			    <th>전화번호</th>
			    <th>총모집인원</th>
			    <th>총날짜</th>
			    <th>남은기간</th>
			  </tr>
      </thead>
      <tbody>
        <c:forEach items="${volunteerList}" var="volunteerRequestDTO" >
					<tr>
					    <td>${volunteerRequestDTO.no}</td>
					    <td><a href='detail?no=${volunteerRequestDTO.no}'>${volunteerRequestDTO.title}</a></td> 
					    <td>${volunteerRequestDTO.owner.id}</td> 
					    <td>${volunteerRequestDTO.category.title}</td> 
					    <td>${volunteerRequestDTO.tel}</td> 
					    <td>${volunteerRequestDTO.limitNum}<span>명</span></td>
					    <td>${volunteerRequestDTO.totalDate}<span>일</span></td>
					    <td>${volunteerRequestDTO.remainDate}<span>일</span></td>
					</tr>
        </c:forEach>
      </tbody>
    </table>
 
  </body>
</html>









