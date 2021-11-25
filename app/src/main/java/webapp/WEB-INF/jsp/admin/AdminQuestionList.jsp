<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>문의사항 관리자 목록</title>
	  <style>
	   
	  </style>
	</head>
	<body>
	  <h1>문의사항 관리자 목록</h1>
	   <a href='replyAdd'>글쓰기</a><br>
		<table border='1'>
		<thead>
		  <tr>
		    <th>번호</th>
		    <th>문의분야</th>
		    <th>제목</th>
		    <th>작성자</th>
		    <th>등록일</th>
		    <th>조회수</th>
		    <th>답글여부</th>
		      <%--<th>첨부파일</th> --%> 
		  </tr>
		</thead>
		<tbody>
		  <c:if test='${empty questionList}'>
		    <p>작성된 게시글이 없습니다.</p>
		  </c:if>
		
			<c:forEach items="${questionList}" var="QuestionListDTO" >
			<tr>
			    <td>${QuestionListDTO.no}</td>
			    <td>${QuestionListDTO.qnaType.title}</td>
			    <td><a href='questionDetail?questionNo=${QuestionListDTO.no}'>${QuestionListDTO.title}</a></td> 
			    <td>${QuestionListDTO.owner.id}</td> 
			    <td>${QuestionListDTO.registeredDate}</td>
			    <td>${QuestionListDTO.viewCount}</td> 
			    <td>${QuestionListDTO.status}</td>
			    <%--  <td>${QuestionListDTO.fileUpload}</td>
			    <c:if test=''${QuestionListDTO.status eq 1 }>
			     <p>${QuestionListDTO.reply}</p>
			    </c:if>--%>
			</tr>
			</c:forEach>
			<label for='f-search'>검색어</label><input id='f-search' type="text" name='keword'>
	    <button>검색</button>
		</tbody>
		</table>
	</body>
</html>








