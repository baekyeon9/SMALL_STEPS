<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>개인회원상세</title>
	<style>
	label {
	margin-right: 5px;
	text-align: right;
	display: inline-block;
	 width: 100px;
	 }
	</style>
</head>
<body>
<h1>개인회원 상세(MVC + EL)</h1>
<form action='update'>
    <label for='f-no'>번호</label> 
    <input id='f-no' type='text' name='no' value='${personalDTO.no}' readonly><br>
    
    <label for='f-id'>아이디</label> 
    <input id='f-id' type='text' name='id' value='${personalDTO.id}' readonly><br>
    
    <label for='f-password'>암호</label> 
    <input id='f-password' type='password' name='password'><br>
    
    <label for='f-name'>이름</label> 
    <input id='f-name' type='text' name='name' value='${personalDTO.name}'><br>
    
    <label for='f-tel'>전화</label> 
    <input id='f-tel' type='tel' name='tel' value='${personalDTO.tel}'><br>
    
    <label for='f-email'>이메일</label> 
    <input id='f-email' type='email' name='email' value='${personalDTO.email}'><br>
    
    <label for='f-postNo'>우편번호</label> 
    <input id='f-postNo' type="number" name='postNo' value='${personalDTO.postNo}'><br>
    
    <label for='f-basicAddress'>기본주소</label> 
    <input id='f-basicAddress' type='text' name='basicAddress' value='${personalDTO.basicAddress}'><br>
    
    <label for='f-detailAddress'>상세주소</label> 
    <input id='f-detailAddress' type='text' name='detailAddress' value='${personalDTO.detailAddress}'><br>
    
    <label for='f-birthdate'>생년월일</label> 
    <input id='f-birthdate' type="date" name='birthdate' value='${personalDTO.birthdate}'><br>
    
    <label for='f-level'>회원등급</label> 
    <input id='f-level' type='text' name='level' value='${personalDTO.level}' readonly><br>
    
    <label for='f-status'>승인여부</label> 
    <input id='f-status' type="text" name='status' value='${personalDTO.status}' readonly><br>
    
    <label for='f-registerDate'>등록일</label> 
    <span id='f-registerDate'>${personalDTO.registerDate}</span><br>
 <button>[변경]</button>
 <a href='delete?no=${personalDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
</form>
</body>
</html>
    