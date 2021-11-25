<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- //menu -->
    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <div class="ad-main">
      <div class="ad-main-infor">
        <!-- serch -->
        <div class="serch">
          <label for="inforSerch">검색</label>
          <input type="text" class="" id="inforSerch">
          <button type="submit" class="searchBtn">검색</button>
        </div>
        <!-- //serch -->
        <div class="table01">
          <table class="table">
            <thead>
              <tr>
               <!-- <th scope="col">
                 <input type="checkbox">
               </th> -->
                <th scope="col">번호</th>
                <th scope="col">아이디</th>
                <th scope="col">이름</th>
                <th scope="col">전화</th>
                <th scope="col">이메일</th>
                <th scope="col">우편번호</th>
                <th scope="col">기본주소</th>
                <th scope="col">상세주소</th>
                <th scope="col">승인상태</th>
                <th scope="col">회원유형</th>
                <th scope="col">등록일</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${joinUserList}" var="joinDTO" varStatus="vs">
<tr>
<!-- <td><input type="checkbox" class="select-box"></td> -->
    <td>${joinDTO.no}</td> 
    <td>${joinDTO.id}</td> 
    <td>${joinDTO.name}</td> 
    <td>${joinDTO.tel}</td> 
    <td>${joinDTO.email}</td> 
    <td>${joinDTO.postNo}</td> 
    <td>${joinDTO.basicAddress}</td> 
    <td>${joinDTO.detailAddress}</td> 
    <td>${joinDTO.status}</td> 
    <td>${joinDTO.type}</td> 
    <td>${joinDTO.registerDate}</td>
    <td><a data-toggle="modal" href="#myModalLoginL${vs.index}">[관리]</a></td>
</tr>
<!-- 모달 창 -->
              <div class="modal fade" id="myModalLoginL${vs.index}"
                role="dialog">
                <!-- 사용자 지정 부분① : id명 -->
                <div class="modal-dialog">
                  <!-- Modal content-->
                  <div class="modal-content">
                    <div class="modal-header">
                      <h4 class="modal-title">회원 관리</h4>
                      <!-- 사용자 지정 부분② : 타이틀 -->
                      <button type="button" class="close" data-dismiss="modal">×</button>
                    </div>
                      <div class="modal-body">
                        <div class="class" id="id" style="display: none">
                          <label for='f-no'>회원번호</label> <input id='f-no'
                            type='text' name='no' value='${joinDTO.no}' readonly>
                          <br>
                        </div>
                        <label for='f-id'>아이디</label><span id='f-id'>${joinDTO.id}</span><br>
                        <label for='f-name'>이름</label><span id='f-name'>${joinDTO.name}</span><br>
                        <label for='f-tel'>전화번호</label><span id='f-tel'>${joinDTO.tel}</span><br>
                        <label for='f-email'>이메일</label><span id='f-email'>${joinDTO.email}</span><br>
                        <label for='f-postNo'>우편번호</label><span id='f-postNo'>${joinDTO.postNo}</span><br>
                        <label for='f-basicAddress'>기본주소</label><span id='f-basicAddress'>${joinDTO.basicAddress}</span><br>
                        <label for='f-detailAddress'>상세주소</label><span id='f-detailAddress'>${joinDTO.detailAddress}</span><br>
                        <label for='f-status'>승인상태</label><span id='f-status'>${joinDTO.status}</span><br>
                        <label for='f-type'>회원유형</label><span id='f-type'>${joinDTO.type}</span><br>
                        <label for='f-registerDate'>등록일</label><span id='f-registerDate'>${joinDTO.registerDate}</span><br>
                      </div>
							          <div class="ad-btn">
							            <a href="#" class="btnSubmit">추방</a>
							            <a href="#" class="btnSubmit">반려하기</a>
							            <a href="#" class="btnSubmit">승인하기</a>
							            <!--  <a href="#" class="btnSubmit">수정</a>-->
							          </div>
                      <br>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default"
                        data-dismiss="modal">Close</button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- 모달 창 -->
</c:forEach>
            </tbody>
          </table>
        </div>
        <!-- //table01 -->
      </div>
      <!-- //form -->
      
      <div class="col-12 my-5">
        <nav aria-label="Page Navigation">
          <ul class="pagination justify-content-center">
            <li class="page-item disabled">
              <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <li class="page-item active" aria-current="page">
              <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
              <a class="page-link" href="#">Next</a>
            </li>
          </ul>
        </nav>
      </div>
      
    </div>
    <!-- //ad-main -->












    