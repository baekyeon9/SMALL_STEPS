<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>단체회원상세</title>
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
<h1>단체회원 상세(MVC + EL)</h1>
<form action='update' method="post" enctype="multipart/form-data">
    <label for='f-no'>번호</label> 
    <input id='f-no' type='text' name='no' value='${groupDTO.no}' readonly><br>
    
    <label for='f-id'>아이디</label> 
    <input id='f-id' type='text' name='id' value='${groupDTO.id}' readonly><br>
    
    <label for='f-password'>암호</label> 
    <input id='f-password' type='password' name='password'><br>
    
    <label for='f-name'>사진</label> 
    <a href="../../upload/join/${groupDTO.photo}">
        <img id="f-photo-image" src="../../upload/join/${groupDTO.photo}_100x100.jpg">
    </a>
    <input id='f-photo' type='file' name='photoFile' class="form-control"><br>
    
    <label for='f-name'>이름</label> 
    <input id='f-name' type='text' name='name' value='${groupDTO.name}'><br>
    
    <label for='f-tel'>전화</label> 
    <input id='f-tel' type='tel' name='tel' value='${groupDTO.tel}'><br>
    
    <label for='f-email'>이메일</label> 
    <input id='f-email' type='email' name='email' value='${groupDTO.email}'><br>
    
    <label for='f-postNo'>우편번호</label> 
    <input id='f-postNo' type="number" name='postNo' value='${groupDTO.postNo}'><br>
    
    <label for='f-basicAddress'>기본주소</label> 
    <input id='f-basicAddress' type='text' name='basicAddress' value='${groupDTO.basicAddress}'><br>
    
    <label for='f-detailAddress'>상세주소</label> 
    <input id='f-detailAddress' type='text' name='detailAddress' value='${groupDTO.detailAddress}'><br>
    
    <label for='f-groupCount'>소속인원</label> 
    <input id='f-groupCount' type="number" name='groupCount' value='${groupDTO.groupCount}'><br>
    
    <label for='f-status'>승인여부</label> 
    <input id='f-status' type="text" name='status' value='${groupDTO.status}' readonly><br>
    
    <label for='f-registerDate'>등록일</label> 
    <span id='f-registerDate'>${groupDTO.registerDate}</span><br>
 <button>[변경]</button>
 <a href='delete?no=${groupDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
</form>
</body>
</html>
    