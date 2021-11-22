<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>소통해요 : 한줄후기 등록</title>
	  <style>
	  label {
	    margin-right: 5px;
	    text-align: right;
	    display: inline-block;
	    width: 60px;
	  }
  </style>
</head>
<body>
<h1>봉사 후기 등록</h1>
<form action='reviewAdd'>

<%--<label for='f-owner'>작성자</label> 
<input id='f-owner' type='number' name='owner'><br>--%>

<label for='f-volNo'>봉사번호</label> 
<input id='f-volNo' type='number' name='f-volNo'><br>

<label for='f-content'>내용</label> 
<input id='f-content' type='text' name='content'><br>


<button>등록</button><br>
</form>
</body>
</html>










