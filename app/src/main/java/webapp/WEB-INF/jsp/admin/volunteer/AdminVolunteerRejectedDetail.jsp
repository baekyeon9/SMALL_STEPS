<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>봉사상세보기</title>
  <style>
  
  label {
    margin-right: 10px;
    text-align: right;
    display: inline-block;
    width: 80px;
  }
  
  .form-border {
    border: 2px solid red;
  
  }

  
  </style>
</head>
<body>
    <h1>[ 봉사상세보기 ]</h1>


<form action='update'>
  <div class="form-border">

    <label for='v-no'>번호</label> 
    <input id='v-no' type='text' name='no' value='${volunteer.no}' readonly><br>
    
    <label for='v-title'>제목</label> 
    <input id='v-title' type='text' name='title' value='${volunteer.title}' ><br>
    
    <label for='v-owner'>주최자</label> 
    <input id='v-owner' type='text' name='owner' value='${volunteer.owner.id}' readonly><br>
    
    
    <label for='v-category'>카테고리</label> 
    <input id='v-category' type='text' name='category' value='${volunteer.category.title}' ><br>
     
    <label for='v-tel'>전화번호</label> 
    <input id='v-tel' type='tel' name='tel' value='${volunteer.tel}' ><br>
    
    <label for='v-email'>이메일</label>
    <input id='v-email' type='email' name='email' value='${volunteer.email}' readonly><br>
    
    <label for='v-startdate'>시작일</label> 
    <input id='v-startdate' type='text' name='startDate' value='${volunteer.startDate}'><br>
    
    <label for='v-enddate'>종료일</label> 
    <input id='v-enddate' type='text' name='endDate' value='${volunteer.endDate}'><br>
    
    <label for='v-starttime'>시작시간</label> 
    <input id='v-starttime' type='text' name='startTime' value='${volunteer.startTime}'><br>
    
    <label for='v-endtime'>종료시간</label> 
    <input id='v-endtime' type='text' name='endTime' value='${volunteer.endTime}'><br>
    
    <label for='v-totaldate'>총일수</label> 
    <input id='v-totaldate' type='text' name='totalDate' value='${volunteerDate.totalDate}일' readonly><br>
    
    <label for='v-remaindate'>남은기간</label> 
    <input id='v-remaindate' type='text' name='remainDate' value='${volunteerDate.remainDate}일' readonly><br>
    
    <label for='v-currentnum'>현재인원</label> 
    <input id='v-currentnum' type='text' name='currentNum' value='${volunteer.currentNum}명' readonly><br>
    
    <label for='v-limitnum'>총인원</label> 
    <input id='v-limitnum' type='text' name='limitNum' value='${volunteer.limitNum}명'><br>
    
    <label for='v-content'>내용</label> 
    <input id='v-content' type='text' name='content' value='${volunteer.content}'><br>
    
    </div>

 <a href='rejectedList'>[목록]</a><br>
</form>
</body>
</html>








