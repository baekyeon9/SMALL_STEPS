<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<main>
	<div class="page-section">
		<div class="container">
			<h1 class="title-h">Happy-share 봉사신청 양식</h1>
			<div class="join-wrap">
				<h5>
					기관<span class="required_title"><em class="icon_required">·</em>표시는
						반드시 입력하셔야 합니다.</span>
				</h5>
				<div class="base-table">
					<form action='add' method="post" enctype="multipart/form-data">
						<table class="join-table">
							<thead></thead>
							<tbody>
								<tr>
									<th><em class="icon_required">·</em><span>카테고리</span></th>
									<td><c:forEach items="${categorys}" var="category">
											<div class="form-check"
												style="display: inline-block; width: 90px;">
												<input id='f-category' type='radio' name='categoryNo'
													value="${category.no}"> <label for='f-category'
													class="form-check-label">${category.title}</label>
											</div>
										</c:forEach></td>
								</tr>
								<!-- //주최자 -->
								<tr>
									<th><em class="icon_required">·</em><span>제목</span></th>
									<td><label for='f-title' class="sr-only">제목</label> <input
										id='f-title' class="form-control box-input" type='text'
										name='title'></td>
								</tr>
								<!-- //제목 -->
								<tr>
									<th><em class="icon_required">·</em><span>내용</span></th>
									<td><label for='f-content' class="sr-only">내용</label> <textarea
											id='f-content' class="form-control box-input" name='content'
											rows="8"></textarea></td>
								</tr>
								<!-- //내용 -->
								<tr>
									<th><em class="icon_required">·</em><span>전화번호</span></th>
									<td><label for='f-tel' class="sr-only">전화번호</label> <input
										id='f-tel' class="form-control box-input" type='tel'
										name='tel'></td>
								</tr>
								<!-- //전화번호 -->
								<tr>
									<th><em class="icon_required">·</em><span>이메일</span></th>
									<td><label for='f-email' class="sr-only">이메일</label> <input
										id='f-email' class="form-control box-input" type='email'
										name='email'></td>
								</tr>
								<!-- //이메일 -->
								<tr>
									<th><em class="icon_required">·</em><span>시작일</span></th>
									<td><label for='f-startDate' class="sr-only">시작일</label> <input
										id="f-startDate" class="form-control box-input" type="date"
										name="startDate"> <!-- //시작일 -->
								<tr>
									<th><em class="icon_required">·</em><span>종료일</span></th>
									<td><label for='f-endDate' class="sr-only">시작일</label> <input
										id="f-endDate" class="form-control box-input" type="date"
										name="endDate"> <!-- //종료일 -->
								<tr>
									<th><em class="icon_required">·</em><span>시작시간</span></th>
									<td><label for='f-startTime' class="sr-only">시작시간</label>
										<input id='f-startTime' class="form-control box-input"
										type='time' name='startTime'></td>
								</tr>
								<!-- //시작시간 -->
								<tr>
									<th><em class="icon_required">·</em><span>종료시간</span></th>
									<td><label for='f-endTime' class="sr-only">종료시간</label> <input
										id='f-endTime' class="form-control box-input" type='time'
										name='endTime'></td>
								</tr>
								<!-- //종료시간 -->
								<tr>
									<th><em class="icon_required">·</em><span>총모집인원</span></th>
									<td><label for='f-limitNum' class="sr-only">총모집인원</label>
										<input id='f-limitNum' class="form-control box-input"
										type='number' name='limitNum'></td>
								</tr>
								<!-- //총모집인원 -->
								<tr>
									<th><span>파일첨부</span></th>
									<td><label for="f-file" class="sr-only">파일첨부</label>
										<div class="col-sm-11">
											<input type="file" class="form-control-file" id="f-file"
												name='photoFile'>
										</div></td>
								</tr>
								<!-- //파일첨부 -->


							</tbody>
						</table>
						<div class="btn-regi">
							<input type='hidden' value='2' name='status'><br>
							<button type="submit" class="btn btn-primary nBtn">봉사신청</button>
							<a href="#" class="btn btn-outline-primary nBtn"
								onClick="history.go(-1)" role="button">이전</a>
						</div>
					</form>

				</div>
			</div>
			<!-- //join-wrap -->
		</div>
		<!-- //container -->
	</div>
</main>
<script>
document.querySelector("#donation-Button").onclick = () => {
    var startDate = document.querySelector("#f-startDate");
    var endDate = document.querySelector("#f-endDate");
    if (startDate.value >= endDate.value) {
      alert("시작일이 종료일보다 같거나 클 수 없습니다.");
      return false; 
    } 
  }
  
</script>