<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
     
    <div class="ad-main">
      <div class="ad-main-infor">
        <div class="write-wrap">
          <h4 class="mb-5">공지사항 등록</h4>
          <form action="noticeAdd" method='post'>
            <div class="form-group">
              <label for="f-title">제목</label>
              <input type="text" class="form-control" id="f-title" name="title">
            </div>
            <!-- //제목 -->
            <div class="form-group">
              <label for="f-content">내용</label>
              <textarea name="content" id="f-content" cols="30" rows="8" class="form-control"></textarea>
            </div>
            <!-- //내용 -->
          <%-- <div class="form-group row">
              <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
              <div class="col-sm-11">
                <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
              </div>
              <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
              <div class="col-sm-11">
                <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
              </div>
              <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
              <div class="col-sm-11">
                <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
              </div>
            </div>
            <!-- //파일첨부 -->--%>
            <div class="form-group">
              <label for="f-content" class="sr-only">등록</label>
              <input type="submit" value="등록" class="btn btn-primary">
              <label for="f-content" class="sr-only">삭제</label>
              <input type="submit" value="이전" class="btn btn-secondary">
            </div>
            <!-- //등록 -->
          </form>
        </div>
        <!-- //write-wrap -->
      </div>
      <!-- //form -->
    </div>
    <!-- //ad-main -->








