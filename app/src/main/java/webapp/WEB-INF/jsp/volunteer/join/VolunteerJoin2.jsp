<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>

   
      <style>
       * {
    margin: 0;
    padding: 0
}

.custom_calendar_table td {
    text-align: center;
}

.custom_calendar_table thead.cal_date th {
    font-size: 1.5rem;
}

.custom_calendar_table thead.cal_date th button {
    font-size: 1.5rem;
    background: none;
    border: none;
}

.custom_calendar_table thead.cal_week th {
    background-color: #288CFF;
    color: #fff;
}

.custom_calendar_table tbody td {
    cursor: pointer;
}

.custom_calendar_table tbody td:nth-child(1) {
    color: red;
}

.custom_calendar_table tbody td:nth-child(7) {
    color: #288CFF;
}

.custom_calendar_table tbody td.select_day {
    background-color: #288CFF;
    color: #fff;
}




      </style>
      <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
   
    <body>
    

      <h3 class="widget-title" style="padding-top:30px;">봉사캘린더</h3>
      <div class="divider"></div>
      <div class="main">
        <div id="calendarForm"></div> 
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
        (function () {
    calendarMaker($("#calendarForm"), new Date());
})();

var nowDate = new Date();
function calendarMaker(target, date) {
    if (date == null || date == undefined) {
        date = new Date();
    }
    nowDate = date;
    if ($(target).length > 0) {
        var year = nowDate.getFullYear();
        var month = nowDate.getMonth() + 1;
        $(target).empty().append(assembly(year, month));
    } else {
        console.error("custom_calendar Target is empty!!!");
        return;
    }

    var thisMonth = new Date(nowDate.getFullYear(), nowDate.getMonth(), 1);
    var thisLastDay = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, 0);


    var tag = "<tr>";
    var cnt = 0;
    //빈 공백 만들어주기
    for (i = 0; i < thisMonth.getDay(); i++) {
        tag += "<td></td>";
        cnt++;
    }

    //날짜 채우기
    for (i = 1; i <= thisLastDay.getDate(); i++) {
        if (cnt % 7 == 0) { tag += "<tr>"; }

        tag += "<td>" + i + "</td>";
        cnt++;
        if (cnt % 7 == 0) {
            tag += "</tr>";
        }
    }
    $(target).find("#custom_set_date").append(tag);
    calMoveEvtFn();

    function assembly(year, month) {
        var calendar_html_code =
            "<table class='custom_calendar_table'>" +
            "<colgroup>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "<col style='width:81px'/>" +
            "</colgroup>" +
            "<thead class='cal_date'>" +
            "<th><button type='button' class='prev'><</button></th>" +
            "<th colspan='5'><p><span>" + year + "</span>년 <span>" + month + "</span>월</p></th>" +
            "<th><button type='button' class='next'>></button></th>" +
            "</thead>" +
            "<thead  class='cal_week'>" +
            "<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>" +
            "</thead>" +
            "<tbody id='custom_set_date'>" +
            "</tbody>" +
            "</table>";
        return calendar_html_code;
    }

    function calMoveEvtFn() {
        //전달 클릭
        $(".custom_calendar_table").on("click", ".prev", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() - 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
        //다음날 클릭
        $(".custom_calendar_table").on("click", ".next", function () {
            nowDate = new Date(nowDate.getFullYear(), nowDate.getMonth() + 1, nowDate.getDate());
            calendarMaker($(target), nowDate);
        });
        //일자 선택 클릭
        $(".custom_calendar_table").on("click", "td", function () {
            $(".custom_calendar_table .select_day").removeClass("select_day");
            $(this).removeClass("select_day").addClass("select_day");
        });
    }
}
      </script>
      
   














