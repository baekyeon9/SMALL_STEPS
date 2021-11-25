<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

   
      <style>
        html, body{
  background-color: #FFFFFF;
  font-family: 'Roboto', sans-serif;
}
.main{
  width: 80%;
  display: block;
  
}
.content-wrap{
  width: 100%;
  margin:0 auto;
  border: 4px solid rgba(161, 161, 161, 0.5); 
  border-radius: 20px;
  overflow: hidden;
  background: #ddaf35;
}
.content-left{
  background: #0b0809;
  color:#ddaf35;
  float: left;
  width: 100%;
  padding: 30px;
}
.main-wrap{
  text-align: center;
  padding: 20px 0 0 0;
}
.main-day{
  font-size: 30px;
  font-weight: bold;
}
.main-date{
  font-size: 120px;
  font-weight: bold;
  margin: 20px 0;
}
.todo-wrap{
  padding: 0 0 0 40px;
}
.todo-title{
  font-size: 20px;
  font-weight: 100;
  margin: 0 0 10px 0;
}
.input-box{
  width: 50%;
  margin-right: 20px;
  height: auto; 
  background: #0b0809;
  color: #ddaf35;
  line-height : normal;
  padding: .8em .5em 0 0; 
  font-family: inherit;
  border: 0; 
  border-bottom: 1px dashed #ddaf35;; 
  border-radius: 0; 
  outline-style: none; 
  -webkit-appearance: none; 
  -moz-appearance: none; 
  appearance: none;
}
.input-data{
  cursor: pointer;
  font-size: 10px;
  padding: 10px;
  margin: 10px 0 10px 0;
  background: #ddaf35;
  border: none;
  color: #0b0809;
  border-radius: 10px;
}
.input-data:hover{
  background: #ffffff;
  color: #0b0809;
}
.input-list > div{
  font-size: 10px;
  width: 60%;
  float: left;
  color: #ddaf35;
}
.input-list > .checked{
  color: #FFFFFF;
  text-decoration:line-through
}
.del-data{
  display: block;
  color: #ddaf35;
  float: left;
  width: 10%;
  cursor: pointer;
  font-size: 10px;
  padding: 10px;
  background: #0b0809;
  border: none;
  border-radius: 10px;
}
.content-right{
  float: left;
  width: 90%;
  padding: 10px;
}
.sun{
  color:#ef3333;
}
.sat{
  color:#2107e0;
}
.content-right table tr td{
  width: 40px;
  height: 40px;
  text-align: center;
  font-size: 20px;
  font-weight: bold;
}
.active{
  background: #0b0809;
  border-radius: 50%;
  color: #ffffff;
}

@media(min-width: 850px){
  .main{
    display: flex;
    align-items: center;
    justify-content: center;
    width: 72vw;
    height: 100vh;
    xbackground: #ababab;
  }
  .content-wrap{
    width: 800px;
    height: 600px;
    margin:0 auto;
    border: 4px solid rgba(161, 161, 161, 0.5); 
    border-radius: 20px;
    overflow: hidden;
    background: #ddaf35;
  }
  .content-left{
    background: #0b0809;
    color:#ddaf35;
    float: left;
    width: 360px;
    height: 600px;
    padding: 90px 20px 20px 0;
  }
  .main-wrap{
    text-align: center;
    margin: 20px 0 0 0;
  }
  .main-day{
    font-size: 30px;
    font-weight: bold;
  }
  .main-date{
    font-size: 120px;
    font-weight: bold;
    margin: 20px 0;
  }
  .todo-wrap{
    padding: 0 0 0 40px;
  }
  .todo-title{
    font-size: 20px;
    font-weight: 100;
    margin: 0 0 10px 0;
  }
  .input-box{
    width: 70%;
    height: auto; 
    background: #0b0809;
    color: #ddaf35;
    line-height : normal;
    padding: .8em .5em 0 0; 
    font-family: inherit;
    border: 0; 
    border-bottom: 1px dashed #ddaf35;; 
    border-radius: 0; 
    outline-style: none; 
    -webkit-appearance: none; 
    -moz-appearance: none; 
    appearance: none;
  }
  .input-data{
    cursor: pointer;
    font-size: 10px;
    padding: 10px;
    margin: 20px 0 30px 0;
    background: #ddaf35;
    border: none;
    color: #0b0809;
    border-radius: 10px;
  }
  .input-data:hover{
    background: #ffffff;
    color: #0b0809;
  }
  .input-list > div{
    font-size: 10px;
    width: 60%;
    float: left;
    color: #ddaf35;
  }
  .del-data{
    display: block;
    color: #ddaf35;
    float: left;
    width: 10%;
    cursor: pointer;
    font-size: 10px;
    padding: 10px;
    background: #0b0809;
    border: none;
    border-radius: 10px;
  }
  .content-right{
    float: left;
    width: 430px;
    height: 600px;
    padding: 100px 20px 20px 20px;
  }
  .sun{
    color:#ef3333;
  }
  .sat{
    color:#2107e0;
  }
  .content-right table tr td{
    width: 50px;
    height: 50px;
    text-align: center;
    font-size: 20px;
    font-weight: bold;
  }
  .active{
    background: #0b0809;
    border-radius: 50%;
    color: #ffffff;
  }
}



      </style>
      <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
   
    <body>
    

      <h3 class="widget-title" style="padding-top:30px;">봉사캘린더</h3>
      <div class="divider"></div>
      <div class="main">
        
        <div class="content-wrap">
          
          <div class="content-left">
            <div class="main-wrap">
              <div id="main-day" class="main-day"></div>
              <div id="main-date" class="main-date"></div>
            </div>
            <div class="todo-wrap">
              <div class="todo-title">봉사날짜 & 시간을 선택해주세요</div>
              <input type="checkbox" name="xxx" value="yyy" >9시 ~ 10시 <br>
              <input type="checkbox" name="xxx" value="yyy" >11시 ~ 12시 <br>
              <input type="checkbox" name="xxx" value="yyy" >1시 ~ 2시 <br>
              <input type="checkbox" name="xxx" value="yyy" >2시 ~ 3시 <br>
              <input type="checkbox" name="xxx" value="yyy" >3시 ~ 4시 <br>
              <input type="checkbox" name="xxx" value="yyy" >5시 ~ 6시 <br>

              <div class="input-wrap">
                <input type="text" placeholder="please write here!!" id="input-box" class="input-box">
                <button type="button" id="input-data" class="input-data">INPUT</button>
                <div id="input-list" class="input-list"></div>
              </div>
            </div>
          </div>
          <div class="content-right">
            <table id="calendar" align="center">
              <thead>
                <tr class="btn-wrap clearfix">
                  <td>
                    <label id="prev">
                        &#60;
                    </label>
                  </td>
                  <td align="center" id="current-year-month" colspan="5"></td>
                  <td>
                    <label id="next">
                        &#62;
                    </label>
                  </td>
                </tr>
                <tr>
                    <td class = "sun" align="center">일</td>
                    <td align="center">월</td>
                    <td align="center">화</td>
                    <td align="center">수</td>
                    <td align="center">목</td>
                    <td align="center">금</td>
                    <td class= "sat" align="center">토</td>
                  </tr>
              </thead>
              <tbody id="calendar-body" class="calendar-body"></tbody>
            </table>
          </div>
        </div>
      </div>
      <div class="page-section">
        <div class="container">
         <div class="vol-con-wrap">
           <div>
              <h3 class="widget-title" style="padding-top:30px;">${sessionScope.loginUser.name}님의 봉사정보</h3>
              <div class="divider"></div>
                <div class="col-lg-12">
                  <div class="widget">
                    <div class="widget-box">
                      <form action="#" class="form-contact" method="post" enctype="multipart/form-data" name="form" >
                        <div class="row">
                          <div class="col-sm-12 py-2">
                            <label for="title" class="fg-grey">봉사명</label>
                            <input type="text" class="form-control" id="title" name="title" value="${volunteer.title}">
                          </div>
                          <div class="col-sm-12 py-2">
                            <label for="title" class="fg-grey">주최자</label>
                            <input type="text" class="form-control" id="title" name="owner" value="${volunteer.title}">
                          </div>
                          <div class="col-12 py-2">
                            <label for="subject" class="fg-grey">이메일</label>
                            <input type="email" class="form-control" id="email" value="${volunteer.email}">
                          </div>
                          <div class="col-12 py-2">
                            <label for="subject" class="fg-grey">전화번호</label>
                            <input type="text" class="form-control" id="tel" name="tel" value="${volunteer.tel}">
                          </div>
                          <!-- 반복문 -->
                          <div class="col-6 py-2">
                            <label for="subject" class="fg-grey">시작일</label>
                            <input type="text" class="form-control" id="startDate" value="${volunteer.applyDate}">
                          </div>
                         
                          <div class="col-6 py-2">
                            <label for="subject" class="fg-grey">시작시간</label>
                            <input type="text" class="form-control" id="startTime" value="${volunteer.startTime}">
                          </div>
                          <div class="col-6 py-2">
                            <label for="subject" class="fg-grey">종료시간</label>
                            <input type="text" class="form-control" id="endTime" value="${volunteer.startTime}">
                          </div>
                          <div class="col-6 py-2">
                            <label for="subject" class="fg-grey">신청일</label>
                            <input type="text" class="form-control" id="endTime" value="${volunteer.registeredDate}">
                          </div>
                        </div>
                      </form>
                      
                      
                    </div>
                  </div>
                  <button type=>참여하기</button><button>취소하기</button>
              
  
  
          </div> <!-- //btn-regi -->       
        </div>  <!-- //container -->
      </div>  <!-- //page-section -->
            

      <script>
          var currentTitle = document.getElementById('current-year-month');
          var calendarBody = document.getElementById('calendar-body');
          var today = new Date();
          var first = new Date(today.getFullYear(), today.getMonth(),1);
          var dayList = ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'];
          var monthList = ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'];
          var leapYear=[31,29,31,30,31,30,31,31,30,31,30,31];
          var notLeapYear=[31,28,31,30,31,30,31,31,30,31,30,31];
          var pageFirst = first;
          var pageYear;

          if (first.getFullYear() % 4 === 0){
              pageYear = leapYear;
          } else {
              pageYear = notLeapYear;
          }

function showCalendar(){
    let monthCnt = 100;
    let cnt = 1;
    for(var i = 0; i < 6; i++){
        var $tr = document.createElement('tr');
        $tr.setAttribute('id', monthCnt);   
        for(var j = 0; j < 7; j++){
            if((i === 0 && j < first.getDay()) || cnt > pageYear[first.getMonth()]){
                var $td = document.createElement('td');
                $tr.appendChild($td);     
            }else{
                var $td = document.createElement('td');
                $td.textContent = cnt;
                $td.setAttribute('id', cnt);                
                $tr.appendChild($td);
                cnt++;
            }
        }
        monthCnt++;
        calendarBody.appendChild($tr);
    }
}
showCalendar();

function removeCalendar(){
    let catchTr = 100;
    for(var i = 100; i< 106; i++){
        var $tr = document.getElementById(catchTr);
        $tr.remove();
        catchTr++;
    }
}
function prev(){
    inputBox.value = "";
    const $divs = document.querySelectorAll('#input-list > div');
    $divs.forEach(function(e){
      e.remove();
    });

    const $btns = document.querySelectorAll('#input-list > button');
    $btns.forEach(function(e1){
      e1.remove();
    }); 

    if(pageFirst.getMonth() === 1){
        pageFirst = new Date(first.getFullYear()-1, 12, 1);
        first = pageFirst;
        if(first.getFullYear() % 4 === 0){
            pageYear = leapYear;
        }else{
            pageYear = notLeapYear;
        }
    }else{
        pageFirst = new Date(first.getFullYear(), first.getMonth()-1, 1);
        first = pageFirst;
    }
    today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
    currentTitle.innerHTML = monthList[first.getMonth()] + '&nbsp;&nbsp;&nbsp;&nbsp;'+ first.getFullYear();
    removeCalendar();
    showCalendar();
    showMain();
    clickedDate1 = document.getElementById(today.getDate());
    clickedDate1.classList.add('active');
    clickStart();
    reshowingList();
}

function next(){
    inputBox.value = "";
    const $divs = document.querySelectorAll('#input-list > div');
    $divs.forEach(function(e){
      e.remove();
    });
    const $btns = document.querySelectorAll('#input-list > button');
    $btns.forEach(function(e1){
      e1.remove();
    });
    if(pageFirst.getMonth() === 12){
        pageFirst = new Date(first.getFullYear()+1, 1, 1);
        first = pageFirst;
        if(first.getFullYear() % 4 === 0){
            pageYear = leapYear;
        }else{
            pageYear = notLeapYear;
        }
    }else{
        pageFirst = new Date(first.getFullYear(), first.getMonth()+1, 1);
        first = pageFirst;
    }
    today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
    currentTitle.innerHTML = monthList[first.getMonth()] + '&nbsp;&nbsp;&nbsp;&nbsp;'+ first.getFullYear();
    removeCalendar();
    showCalendar(); 
    showMain();
    clickedDate1 = document.getElementById(today.getDate());
    clickedDate1.classList.add('active');  
    clickStart();
    reshowingList();
}

function showMain(){
    mainTodayDay.innerHTML = dayList[today.getDay()];
    mainTodayDate.innerHTML = today.getDate();
}
var clickedDate2 = document.getElementById(today.getDate());
clickedDate2.classList.add('active');
var prevBtn = document.getElementById('prev');
var nextBtn = document.getElementById('next');
prevBtn.addEventListener('click',prev);
nextBtn.addEventListener('click',next);
var tdGroup = [];
 
function clickStart(){
    for(let i = 1; i <= pageYear[first.getMonth()]; i++){
        tdGroup[i] = document.getElementById(i);
        tdGroup[i].addEventListener('click',changeToday);
    }
}
function changeToday(e){
    for(let i = 1; i <= pageYear[first.getMonth()]; i++){
        if(tdGroup[i].classList.contains('active')){
            tdGroup[i].classList.remove('active');
        }
    }
    clickedDate1 = e.currentTarget;
    clickedDate1.classList.add('active');
    today = new Date(today.getFullYear(), today.getMonth(), clickedDate1.id);
    showMain();
    keyValue = today.getFullYear() + '' + today.getMonth()+ '' + today.getDate();
    reshowingList();
}
function reshowingList(){
    keyValue = today.getFullYear() + '' + today.getMonth()+ '' + today.getDate();
    if(todoList[keyValue] === undefined){
        inputList.textContent = '';
        todoList[keyValue] = [];
        const $divs = document.querySelectorAll('#input-list > div');
        $divs.forEach(function(e){
          e.remove();
        });
        const $btns = document.querySelectorAll('#input-list > button');
        $btns.forEach(function(e1){
          e1.remove();
        });
    }else if(todoList[keyValue].length ===0){
        inputList.textContent = "";
        const $divs = document.querySelectorAll('#input-list > div');
        $divs.forEach(function(e){
          e.remove();
        });
        const $btns = document.querySelectorAll('#input-list > button');
        $btns.forEach(function(e1){
          e1.remove();
        });
    }else{
        const $divs = document.querySelectorAll('#input-list > div');
        $divs.forEach(function(e){
          e.remove();
        });
        const $btns = document.querySelectorAll('#input-list > button');
        $btns.forEach(function(e1){
          e1.remove();
        });
        var $div = document.createElement('div');
        for(var i = 0; i < todoList[keyValue].length; i++){
            var $div = document.createElement('div');
            $div.textContent = '-' + todoList[keyValue][i];
            var $btn = document.createElement('button');
            $btn.setAttribute('type', 'button'); 
            $btn.setAttribute('id', 'del-ata');
            $btn.setAttribute('id', dataCnt+keyValue);
            $btn.setAttribute('class', 'del-data');
            $btn.textContent = delText;
            inputList.appendChild($div);
            inputList.appendChild($btn);
            $div.addEventListener('click',checkList);
            $btn.addEventListener('click',deleteTodo);
            inputBox.value = '';
            function deleteTodo(){
                $div.remove();
                $btn.remove();
            }
        }
    }

}
var inputBox = document.getElementById('input-box');
var inputDate = document.getElementById('input-data');
var inputList = document.getElementById('input-list');
var delText = 'X';
inputDate.addEventListener('click',addTodoList);
var dataCnt = 1;
var keyValue = today.getFullYear() + '' + today.getMonth()+ '' + today.getDate();
let todoList = [];
todoList[keyValue] = [];
function addTodoList(){
    var $div = document.createElement('div');
    $div.textContent = '-' + inputBox.value;
    var $btn = document.createElement('button');
    $btn.setAttribute('type', 'button'); 
    $btn.setAttribute('id', 'del-ata');
    $btn.setAttribute('id', dataCnt+keyValue);
    $btn.setAttribute('class', "del-data");
    $btn.textContent = delText;
    inputList.appendChild($div);
    inputList.appendChild($btn);
    todoList[keyValue].push(inputBox.value);
    dataCnt++;
    inputBox.value = '';
    $div.addEventListener('click',checkList);
    $btn.addEventListener('click',deleteTodo);
    function deleteTodo(){
        $div.remove();
        $btn.remove();
    }
}
console.log(keyValue);
function checkList(e){
    e.currentTarget.classList.add('checked');
}
        
      </script>
   














