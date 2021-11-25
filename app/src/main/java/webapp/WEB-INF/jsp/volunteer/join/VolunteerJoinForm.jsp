<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
    <div class="vol-con-wrap">
            <h3 class="widget-title" id="scroll-section1" style="padding-top:30px;" >상세정보</h3>
            <div class="divider"></div>
              <div class="col-lg-12">
                <div class="widget">
                  <div class="widget-box">
                    <form action="add?no=${volunteer.no}" class="form-contact" method="post" name="form" >
                      <div class="row">
                        <div class="col-sm-12 py-2">
                            <label for="no" class="fg-grey" type="hidden">번호</label>
                            <input type="number" class="form-control" id="no" name="no" value="${volunteer.no}" readonly>
                          </div>
                        <div class="col-sm-12 py-2">
                          <label for="title" class="fg-grey">제목</label>
                          <input type="text" class="form-control" id="title" name="title" value="${volunteer.title}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">전화번호</label>
                          <input type="text" class="form-control" id="tel" name="tel" value="${volunteer.tel}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작일</label>
                          <input type="date" class="form-control" id="startDate" value="${volunteer.startDate}" readonly>
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료일</label>
                          <input type="date" class="form-control" id="endDate" value="${volunteer.endDate}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">총모집인원</label>
                          <input type="text" class="form-control" id="limitNum" value="${volunteer.limitNum}" readonly>
                        </div>
                        <div class="col-12 py-2">
                          <label for="subject" class="fg-grey">봉사참여일</label>
                          <input type="date" class="form-control" name="applyDate">
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">시작시간</label>
                          <input type="time" class="form-control" name="startTime" value="${volunteer.startTime}">
                        </div>
                        <div class="col-6 py-2">
                          <label for="subject" class="fg-grey">종료시간</label>
                          <input type="time" class="form-control" name="endTime" value="${volunteer.startTime}">
                        </div>
                        <div class="col-12 py-2">
                          <label for="content" class="fg-grey">내용</label>
                          <textarea id="content" rows="8" class="form-control" readonly>${volunteer.content}</textarea >
                        </div>
                      </div>
                      <button class="btn btn-primary">봉사신청하기
						         </button>
                    </form>
                  </div>
               </div>
            </div>
          </div> <!-- vol-con-wrap -->















