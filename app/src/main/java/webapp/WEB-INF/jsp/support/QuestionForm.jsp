<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>문의사항 등록</title>
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
	<h1>문의사항 등록</h1>
	<form action='questionAdd' method="post">

		<%--<c:forEach items="${questionCategory}"  var="questionCategory" >
		    <label for='f-qnaType'>${qnaType.title}</label> 
		    <input id='f-qnaType' type='radio' name='qnaType' value="${qnaType.no}" >
	    </c:forEach>--%>

		<label for='f-qnaType'>문의분야</label> <select id='f-qnaType'
			name='qnaTypeNo'>
			<option value='1'>함께해요 문의</option>
			<option value='2'>나눔이야기 문의</option>
			<option value='3'>모금함 문의</option>
			<option value='4'>챌린지 문의</option>
			<option value='5'>사이트이용 문의</option>
			<option value='6'>기타 문의</option>
		</select> <label for='f-title'>제목</label> <input id='f-title' type='text'
			name='title'><br> <label for='f-content'>내용</label> <input
			id='f-content' type='text' name='content'><br> <label
			for='f-password'>패스워드</label> <input id='f-password' type='password'
			name='qnaPassword' maxlength='4'><br>
		<%--  <label for='f-file'>파일첨부</label> <input id='f-file' type='file' name='fileUpload'><br>--%>
		<button>등록</button>
		<br> <a href='questionList'>[목록]</a>
	</form>
</body>
</html>









