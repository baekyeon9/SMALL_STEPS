<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>회원상세</title>
<style>
label {
	margin-right: 10px;
	text-align: right;
	display: inline-block;
	width: 110px;
}
</style>
</head>
<body>
	<h1>회원 상세(MVC + EL)</h1>
	<form action='update'>
		<label for='f-no'>회원번호</label> <input id='f-no' type='text' name='no'
			value='${joinDTO.no}' readonly><br> <label
			for='f-category'>아이디</label> <input id=f-category type="text"
			name='category' value='${joinDTO.id}'><br> <label
			for='f-leader'>이름</label> <input id='f-leader' type="text"
			name='leader' value='${joinDTO.name}'><br> <label
			for='f-title'>나의 기부금액</label> <input id='f-title' type='text'
			name='title'
			<fmt:formatNumber type="number" value="${joinDTO.donationMoney}" maxFractionDigits="3"/>><br>

		<button>[변경]</button>
		<a href='registerList?no=${joinDTO.no}'>[기부자내역]</a> <a
			href='boardList'>[목록]</a> <a
			href='registerForm?boardNo=${joinDTO.no}'>[해당 모금함 기부하기]</a> <a
			href='boardDelete?no=${joinDTO.no}'>[삭제]</a><br>
	</form>
</body>
</html>
