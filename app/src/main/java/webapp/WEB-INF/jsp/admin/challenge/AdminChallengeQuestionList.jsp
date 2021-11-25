<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
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
               <th scope="col">
                 <input type="checkbox">
               </th>
                <th scope="col">번호</th>
                <th scope="col">내용</th>
                <th scope="col">작성자</th>
                <th scope="col">등록일</th>
              </tr>
            </thead>
            <tbody>
           <c:forEach items="${challengeQuestionList}" var="challengeQuestionDTO">
              <tr>
                  <td><input type="checkbox" class="select-box"></td>
                  <td>${challengeQuestionDTO.questionNo}</td>
                  <td>${challengeQuestionDTO.content}</td> 
                  <td>${challengeQuestionDTO.owner.id}</td> 
                  <td>${challengeQuestionDTO.registeredDate}</td>
                  <td><a href='replyUpdateDetail?questionNo=${challengeQuestionDTO.questionNo}&no=${challengeQuestionDTO.no}'>[답글등록/변경]</a></td>
              </tr>
                <tr>
                <c:if  test="${challengeQuestionDTO.reply != null}" >
                  <th scope="col">답글</th>
                  <td colspan="4">${challengeQuestionDTO.reply}</td> 
                  <td><form action='replyDelete?questionNo=${challengeQuestionDTO.questionNo}&no=${challengeQuestionDTO.no}' method="post">
                      <button>답글삭제</button><br>
                    </form></td>
                </c:if>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <div class="ad-btn">
            <a href='questionDelete?questionNo=${challengeQuestionDTO.questionNo}&no=${challengeQuestionDTO.no}' class="btnSubmit">문의강제삭제</a>
          </div>
        </div>
        <!-- //table01 -->
      </div>
      <!-- //form -->
    </div>
    <!-- //ad-main -->
</body>
</html>