<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <main>
      <div class="page-section">
        <div class="container">
          <div class="join-form">
            <h1 class="title-h">회원가입</h1>
            <h5 class="title-sh">먼저 해당하는 회원 유형을 선택하세요.</h5>
            <div class="row justify-content-center">
              <!-- row -->
              <div class="row col-lg-9">
                <!-- type-box -->
                <div class="col-md-6 col-lg-4 py-3type-box">
                  <div class="type-box">
                    <h6 class="type-h7">누구나 가입 가능</h6>
                    <h5>개인회원</h5>
                    <a href="${contextPath}/app/join/personal/form" class="btn btn-primary btn-sm btn-block">가입하기</a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-4 py-3type-box">
                  <div class="type-box">
                    <h6 class="type-h7">2인 이상</h6>
                    <h5>단체회원</h5>
                    <a href="${contextPath}/app/join/group/form" class="btn btn-primary btn-sm btn-block" >가입하기</a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-4 py-3type-box">
                  <div class="type-box">
                    <h6 class="type-h7">사업자번호를 가지고 있는</h6>
                    <h5>기관회원</h5>
                    <a href="${contextPath}/app/join/org/form" class="btn btn-primary btn-sm btn-block">가입하기</a>
                  </div>
                </div>
                <!-- //type-box -->
              </div>
              <!-- //row -->
            </div>
          </div>
        </div>
        </div>
        <!-- //container -->
    </main>  
    