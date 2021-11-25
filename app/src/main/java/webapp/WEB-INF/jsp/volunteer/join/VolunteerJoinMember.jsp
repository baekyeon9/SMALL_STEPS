
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  
  


  <h1>[ 참여자 목록 ]</h1>
    <table border='1'>
      <thead>
        <tr>
          <th>번호</th>
          <th>아이디</th>
          <th>이름</th>
          <th>시작시간</th>
          <th>신청일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${volunteerList}" var="volunteerJoinDTO" >
          <tr>
              <td>${volunteerJoinDTO.volunteer.no}</td> 
              <td>${volunteerJoinDTO.joinUser.id}</td> 
              <td>${volunteerJoinDTO.joinUser.name}</td> 
              <td>${volunteerJoinDTO.startTime}</td> 
              <td>${volunteerJoinDTO.registeredDate}</td> 
          </tr>
        </c:forEach>
        
      </tbody>
 
    </table>
    
    <a href='../detail?no=${volNo}'>[목록]</a>
    
    
    
    
    










