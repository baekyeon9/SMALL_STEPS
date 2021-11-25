
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>봉사승인대기목록</title>
  
  
   <!--  <link href="/css/layout.css" type="text/css" rel="stylesheet" />--> 
</head>


<body>
  <h1>[ happyshare 봉사 승인대기목록]</h1>
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
					    <td><a href='approve?no=${volunteerRequestDTO.no}'>[승인]</a>
					        <a href='reject?no=${volunteerRequestDTO.no}'>[반려]</a></td>
					</tr>
        </c:forEach>
      </tbody>
    </table>
      <a href='list'>[목록]</a>
    
    
    
    
     <!-- ------------------- <footer> --------------------------------------- -->


<!-- 
    <footer id="footer">
        <div class="content-container">
            <h2 id="footer-logo"><img src="images/logo-footer.png" alt="로고정보"></h2>

            <div id="company-info">
                <dl>
                    <dt>주소:</dt>
                    <dd>서울특별시 강남구</dd>
                    <dt>관리자메일:</dt>
                    <dd>admin@happyshare.com</dd>
                </dl>
                
                <dl>
                    <dt>상호:</dt>
                    <dd>happyshare</dd>
                    <dt>전화번호:</dt>
                    <dd>111-1111-1111</dd>
                </dl>
                <dl>
                    <dt>관리자메일:</dt>
                    <dd>admin@happyshare.com</dd>
                </dl>
                <div id="copyright" class="margin-top"> ⓒ 2021 happyshare All Right Reserved.
                   <br> Contact : admin@happyshare.com for more information</div>
            </div>
        </div>
    </footer>
     -->
  </body>
</html>









