<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>


    <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../assets/img/bg_image_3.jpg);">
      <div class="container h-100">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-lg-8">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
                <li class="breadcrumb-item"><a href="index.html" style="font-size:20px;">함께해요</a></li>
                <li class="breadcrumb-item active" aria-current="page" style="font-size:22px;">봉사목록</li>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </div> <!-- .page-banner -->
    
  <main>
    <div class="page-section">
      <div class="container">
        <h3 class="widget-title">${volunteer.title}</h3>
        <div class="divider"></div>
        <div class="vol-detail">
          <div class="vol-de-img">
           <img src="../assets/img/201612011168_500.jpg" alt="함께해요 상세 이미지" />
          </div>
          
          <!-- //vol-de-img -->
          <div class="vol-infor-wrap">

            
             <!-- vol-joiner -->
             <div class="vol-joiner">
               <div style="padding:10px;">
              <span class="vol-cur">
                
                <span class="sr-only">참여인원</span>
                <b class="vol-count">${volunteer.currentNum}명</b>
                /
                <span class="sr-only">총 모집인원</span>
                ${volunteer.limitNum}명
              </span>
              <div class="progress">
                <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 10%" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
              </div>
              <input type="hidden" id="volunteerNo" value="${volunteer.no}"/>
              <button type="button"  onclick="joinMember();" class="btn btn-secondary" style="margin: 25px 165px;">참여자보기</button>
               <a href="join/list?no=${volunteer.no}" class="btn btn-outline-primary nBtn" style="margin: 25px 165px; role="button" >참여자보기22</a>
            </div>
             </div>  <!-- //vol-joiner -->
            
             <!-- vol-owner -->
             <div class="vol-owner">
              <div class="social-mini-button">
                <span class="owner-right"><span>주최자</span> : <b>${volunteer.owner.id}</b></span>
                <span class="owner-right">${volunteer.tel}</span>
                <span class="owner-right">${volunteer.email}</span>
              </div>
             </div> <!-- //vol-owner -->
           
             <div class="vol-detail-infor">
               <ul>
                 <li>
                   <span>봉사기간</span> :
                   <span>${volunteer.startDate} ~ ${volunteer.endDate}</span><span>총 ${volunteerDate.totalDate}일</span>
                 </li>
                 <li>
                   <span>봉사시간</span> :
                   <span>${volunteer.startTime} ~ ${volunteer.endTime}</span>
                 </li>
                 <li>
                    D-day ${volunteerDate.remainDate}일
                 </li>
               </ul>
             </div>  <!-- //vol-detail-infor -->
          </div>  <!-- //vol-infor-wrap -->
       </div>   <!-- //vol-detail -->
    

       <div style="margin-top: 35px; display: flex; justify-content: center; text-align: center;">
      <div class="vol-con-wrap">
       <p>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#vol-detail" aria-expanded="false" aria-controls="vol-detail">
          상세정보
        </button>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#vol-location" aria-expanded="false" aria-controls="vol-location">
          위치
        </button>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#vol-attend" aria-expanded="false" aria-controls="vol-attend">
          참여하기
        </button>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#vol-qna" aria-expanded="false" aria-controls="vol-qna">
          문의하기
        </button>
      </p>
      <div class="collapse" id="vol-detail" >
        <div class="card card-body">
          봉사세부사항
        </div>
      </div>
      <div class="collapse" id="vol-location">
        <div class="card card-body">
          hey no 2
        </div>
      </div>
      <div class="collapse" id="vol-attend">
        <div class="card card-body">
          hey no 2
        </div>
      </div>
      <div class="collapse" id="vol-qna">
        <div class="card card-body">
          hey no 2
        </div>
      </div>
    </div>
  </div>

       <div class="vol-con-wrap">
         <div>
            <h3 class="widget-title" style="padding-top:30px;">상세정보</h3>
            <div class="divider"></div>
              <div class="col-lg-12">
                <div class="widget">
                  <div class="widget-box">
                    <form action="#" class="form-contact" method="post" enctype="multipart/form-data" name="form" >
                      <div class="row">
                        <div class="col-sm-12 py-2">
                          <label for="title" class="fg-grey">제목</label>
                          <input type="text" class="form-control" id="title" name="title" value="${volunteer.title}">
                        </div>
                       
                       
                       
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">전화번호</label>
                          <input type="text" class="form-control" id="tel" name="tel" value="${volunteer.tel}">
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">이메일</label>
                          <input type="email" class="form-control" id="email" value="${volunteer.email}">
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작일</label>
                          <input type="text" class="form-control" id="startDate" value="${volunteer.startDate}">
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료일</label>
                          <input type="text" class="form-control" id="endDate" value="${volunteer.endDate}">
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작시간</label>
                          <input type="text" class="form-control" id="startTime" value="${volunteer.startTime}">
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료시간</label>
                          <input type="text" class="form-control" id="endTime" value="${volunteer.startTime}">
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">총모집인원</label>
                          <input type="text" class="form-control" id="limitNum" value="${volunteer.limitNum}">
                        </div>
                        <div class="col-12 py-2">
                          <label for="content" class="fg-grey">내용</label>
                          <textarea id="content" rows="8" class="form-control">${volunteer.content}</textarea>
                        </div>
                      </div>
                    </form>
                  </div>
            </div>
            


         <div>
            <h3 class="widget-title" style="padding-top:30px;">위치</h3>
            <div class="divider"></div>
            <div class="content-map">
            </div>
         </div>
       </div>
        <div class="btn-regi">
          <button type="button" class="btn btn-primary nBtn">참여하기</button>
           <a href="join/add?no=${volunteer.no}" class="btn btn-outline-primary nBtn" role="button">참여하기</a>
           <a href="join/list?no=${volunteer.no}" class="btn btn-outline-primary nBtn" role="button">참여하기22</a>
            <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
        </div> <!-- //btn-regi -->       
      </div>  <!-- //container -->
    </div>  <!-- //page-section -->
  </main>

<script>
var volunteerNo = document.querySelector("#volunteerNo");
var no = volunteerNo.textContent;
function joinMember() {
	location.href = "join/list?no="+no
}
</script>










