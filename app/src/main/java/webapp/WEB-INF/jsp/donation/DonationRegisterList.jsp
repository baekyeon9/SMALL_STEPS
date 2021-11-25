<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>기부자목록</title>
</head>
<body>
	<h1>기부자 목록(MVC + EL + JSTL1)</h1>
	<div>
		<a href='form'>기부하기</a>
	</div>
	<table border='1'>
		<thead>
			<tr>
				<th>모금함번호</th>
				<th>회원</th>
				<th>기부금액</th>
				<th>기부날짜</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${donationRegisterList}" var="donationRegisterDTO">
				<tr>
					<td>${donationRegisterDTO.donationBoard.no}</td>
					<td><a href='detail?no=${donationRegisterDTO.no}'>${donationRegisterDTO.donator.name}</a></td>
					<td><fmt:formatNumber type="number"
							value="${donationRegisterDTO.donationMoney}"
							maxFractionDigits="3" />원</td>
					<td>${donationRegisterDTO.registeredDate}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>












