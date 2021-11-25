<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>모금함대기리스트</title>
<div class="ad-main">
	<div class="ad-main-infor">
		<!-- serch -->
		<div class="serch">
			<label for="inforSerch">검색</label> <input type="text" class=""
				id="inforSerch">
			<button type="submit" class="searchBtn">검색</button>
		</div>
		<!-- //serch -->
		<div class="table01">
			<table class="table">
				<thead>
					<tr>
						<th scope="col"><input type="checkbox"></th>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">주최자</th>
						<th scope="col">카테고리</th>
						<th scope="col">내용</th>
						<th scope="col">개설시작일</th>
						<th scope="col">개설종료일</th>
						<th scope="col">총기간</th>
						<th scope="col">남은기간</th>
						<th scope="col">목표금액</th>
						<th scope="col">첨부파일</th>
						<th scope="col">승인여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${waitDonationList}" var="donationBoardDTO">
						<tr data-no='${donationBoardDTO.no}'>
							<td><input type="checkbox" class="select-box" id='aaa'></td>
							<td>${donationBoardDTO.no}</td>
							<td>${donationBoardDTO.title}</td>
							<td>${donationBoardDTO.leader.name}</td>
							<td>${donationBoardDTO.category.title}</td>
							<td>${donationBoardDTO.content}</td>
							<td>${donationBoardDTO.startDate}</td>
							<td>${donationBoardDTO.endDate}</td>
							<td>${donationBoardDTO.totalDate}</td>
							<td>${donationBoardDTO.remainDate}</td>
							<td><fmt:formatNumber type="number"
									value="${donationBoardDTO.moneyTarget}" maxFractionDigits="3" />원</td>
							<td>${donationBoardDTO.fileNames}</td>
							<td>${donationBoardDTO.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="ad-btn">
				<a href="reject?no=${donationBoardDTO.no}" class="btnSubmit">반려하기</a>
				<!--  <a href="#" class="btnSubmit">수정</a>-->
				<a href="approve?no=${donationBoardDTO.no}" class="btnSubmit">승인하기</a>
			</div>
		</div>
		<!-- //table01 -->
	</div>
	<!-- //form -->

	<div class="col-12 my-5">
		<nav aria-label="Page Navigation">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item active" aria-current="page"><a
					class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
				</li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>

</div>
<!-- //ad-main -->

</div>
<!-- //wrap -->
<script>
document.querySelectorAll(".ad-btn a").forEach((aTag) => {
    aTag.onclick = () => false;
});
var trList = document.querySelectorAll("tbody tr"); // 리턴 객체는 HTMLCollection 타입 객체이다.
trList.forEach(function(trTag) {
    trTag.onclick = (e) => {
        //console.log(e.currentTarget.querySelector("a").href);
        //e.currentTarget.querySelector("a").click();
        //window.location.href = e.currentTarget.querySelector("a").href;
        window.location.href = "approve?no=" + e.currentTarget.getAttribute("data-no");
    };
});

</script>
</body>
</html>
















