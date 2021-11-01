<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생육 TIP</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		//검색 버튼
		$(".search_img")
				.click(
						function() {
							var d = $(".frm_tip_search").serialize();
							$
									.ajax({
										url : "TipBoardSearch.do",
										data : d,
										type : "get",
										dataType : "json",
										success : function(r) {
											console.log(r);
											var tag = "";
											var arr = r.result;
											for (i = 0; i < arr.length; i++) {
												tag += "<div class='content_number'>";
												tag += "<p>" + arr[i].tb_no
														+ "</p>";
												tag += "</div>";
												tag += "<img class='thumbnail' src='"+ arr[i].tb_addfile_url+"'>'";
												tag += "<div class='title_content_writer'>";
												tag += "<div class='title'>"
														+ arr[i].tb_title
														+ "</div>";
												tag += "<div class='content'>"
														+ arr[i].tb_content
														+ "</div>";
												tag += "<div class='writer'>"
														+ arr[i].tb_id
														+ "</div>";
												tag += "</div>";
												tag += "<div class='view_like_comment_day'>";
												tag += "<div class='view'>";
												tag += "<img src='/resource/img/view.png'>";
												tag += "<p>" + arr[i].tb_visit
														+ "</p>";
												tag += "</div>";
												tag += "<div class='like'>";
												tag += "<img src='/resource/img/empty_heart.png'>";
												tag += "<p>"
														+ arr[i].tb_recommand
														+ "</p>";
												tag += "</div>";
												tag += "<div class='comment'>";
												tag += "<img src='/resource/img/comment.png'>";
												tag += "<p>"
														+ arr[i].tb_comment
														+ "</p>";
												tag += "</div>";
												tag += "<div class='day'>";
												tag += "<p>" + arr[i].tb_date
														+ "</p>";
												tag += "</div>";
												tag += "</div>";
											}
											$(".content_box").html(tag);
										}
									});
						});
	});
</script>
<!-- 기본틀 -->
<style type="text/css">

/* hotpink 색상으로border 잡힌 것은 임시 작업 영역 표시한 것, 추후 삭제 필수  */

/* 기본 베이스 */
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #FFFDF6;
}

/* 헤더 */
header {
	height: 200px;
	box-sizing: border-box;
	border-bottom: 2px solid #639578;
}

.header_box {
	width: 1200px;
	margin: 0 auto;
	display: flex;
	flex-direction: column;
	align-items: flex-end;
}

/* 로그인&회원가입 / 로그아웃&마이페이지 */
.top_box {
	margin-top: 10px;
}

.top_box button {
	border: none;
	background-color: #FFFDF6;
	margin-left: 10px;
}

/* 로고 */
.logo {
	height: 100px;
	margin: 0 auto;
	margin-top: 10px;
	margin-bottom: 10px;
}

/* 카테고리 */
nav {
	align-self: center;
}

nav ul {
	display: flex;
	flex-direction: row;
	margin-top: 12px;
}

nav ul li {
	margin: 0 auto;
	list-style-type: none;
	margin-left: 50px;
	font-size: 20px;
}

/* 섹션 */
section {
	margin: 0 auto;
	width: 1200px;
	/* 임시 */
	height: 1300px;
}

/* 배경 이미지 */
.back {
	width: 1200px;
	height: 95%;
	background-image: url(/resource/img/background_img.png);
	background-repeat: no-repeat;
	opacity: 0.1;
	position: absolute;
	z-index: -1;
}

/* 푸터 */
footer {
	display: flex;
	flex-direction: column;
}

.headset {
	height: 75px;
	position: fixed;
	right: 0;
	bottom: 50px;
}

.headset img {
	margin-right: 30px;
	cursor: pointer;
}

footer #bottom {
	margin-top: -300px;
	opacity: 0.2;
	z-index: -1;
}

.footer_info_box {
	height: 100px;
	background-color: #CBD8D0;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.footer_info_box p {
	color: #333333;
}

.footer_text_box {
	width: 1200px;
	margin: 0 auto;
	display: flex;
	flex-direction: row;
	justify-content: center;
}

.footer_text_box p {
	margin: 0px 15px;
	margin-top: 20px;
}
</style>
<!-- tip 게시판(section) -->
<style type="text/css">
.content_info {
	margin-top: 80px;
	border-bottom: 2px solid #639578;
}

.content_info p {
	margin-left: 20px;
	margin-bottom: 5px;
}

/* 게시글 */
.content_box {
	height: 200px;
	border-bottom: 1px solid #639578;
	margin: 0 auto;
	display: flex;
	flex-direction: row;
}

.content_box .content_number {
	width: 50px;
	margin: 0px 10px;
	text-align: center;
	align-self: center;
}

.thumbnail {
	padding: 10px;
	margin-right: 10px;
}

.title_content_writer {
	width: 800px;
	display: flex;
	flex-direction: column;
}

.title {
	width: 700px;
	margin-top: 20px;
	font-size: 20px;
	font-weight: bold;
}

.content {
	width: 700px;
	height: 70px;
	margin: 15px 0px;
}

.id {
	width: 700px;
	margin-bottom: 20px;
}

.view_like_comment_day {
	width: 100px;
	height: 180px;
	border-left: 1px solid #639578;
	align-self: center;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.view_like_comment_day img {
	width: 25px;
	height: 25px;
	align-self: center;
}

.view_like_comment_day div {
	margin: 8px 0px 8px 10px;
}

.like {
	cursor: pointer;
}

.comment {
	cursor: pointer;
}

/* 하단 페이지 */
.page_box tr {
	width: 100px;
	list-style-type: none;
	display: flex;
	flex-direction: row;
	margin: 0 auto;
}

.page_box tr td {
	margin: 20px 2px;
}

/* 하단 검색바 */
.search_box {
	width: 250px;
	height: 50px;
	margin: 0 auto;
}

.search_box input {
	width: 150px;
	height: 20px;
	border: 1px solid #639578;
	float: left;
}

.search_img {
	margin-left: 2px;
	width: 22px;
	height: 22px;
	background-image: url(resource/img/zoom.png);
	background-repeat: no-repeat;
	background-size: contain;
	float: left;
}

.edit_box button {
	border: none;
	background-color: #FFFDF6;
	cursor: pointer;
}

.search_box select {
	width: 60px;
	height: 22px;
	margin-right: 5px;
	border: 1px solid #639578;
	float: left;
}
</style>
</head>
<body>
	<header>
		<div class="header_box">

			<!-- 로그인/회원가입, 로그아웃/마이페이지 -->
			<div class="top_box">
				<button type="submit">로그인</button>
				<button type="button">회원가입</button>
			</div>
			<!-- 로고 -->
			<img class="logo" src="resource/img/logo.png">
			<!-- 카테고리 -->
			<nav>
				<ul>
					<li>회사 소개</li>
					<li>자유 게시판</li>
					<li>분양</li>
					<li>TIP</li>
					<li>가격 비교</li>
					<li>고객 센터</li>
				</ul>
			</nav>
		</div>
	</header>
	<section>
		<div class="back"></div>
		<div class="content_info">

			<p>번호
			<p>
		</div>
		<!-- 갯수 늘어나기 최대 다섯개의 게시글 -->
			<!-- css 다시하기... -->
				<!-- 임시-->
			<%-- 	<div class="content_number">
					<p>${tb.tb_no}</p>
				</div>
				<img class="thumbnail" src="${tb.tb_addfile_url}">
				<div class="title_content_writer">
					<div class="title">${tb.tb_title}</div>
					<div class="content">${tb.tb_content}</div>
					<div class="id">${tb.tb_id}</div>
				</div>
				<div class="view_like_comment_day">
					<div class="view">
						<img src="/resource/img/view.png">
						<p>${tb.tb_visit}</p>
					</div>
					<div class="like">
						<img src="/resource/img/empty_heart.png">
						<p>${tb.tb_recommand}</p>
					</div>
					<div class="comment">
						<img src="/resource/img/comment.png">
						<p>${tip.tb_comment}</p>
					</div>
					<div class="day">
						<p>${tb.tb_date}</p>
					</div>
				</div> --%>
			<div class="content_box">
		<c:forEach var="tb" items="#{requestScope.list}">
			<table>
				<tr>
				<td>${tb.tb_no}</td>
				<td>${tb.tb_addfile_url}</td>
				<td>${tb.tb_title}</td>
				<td>${tb.tb_content}</td>
				<td>${tb.tb_id}</td>
				<td>${tb.tb_visit}</td>
				<td>${tb.tb_recommand}</td>
				<td>${tb.tb_comment}</td>
				<td>${tb.tb_date}</td>
				</tr>
		</c:forEach>
			</table>
			</div>

		<!-- 페이지 -->
		<div class="page_box">
			<table>
				<tr>
					<td colspan="7"><c:if
							test="${requestScope.pagging.previousPageGroup }">
							<a
								href="freeBoardList.do?pageNo=${requestScope.pagging.startPageOfPageGroup-1 }"><<</a>
						</c:if> <c:forEach var="i"
							begin="${requestScope.pagging.startPageOfPageGroup }"
							end="${requestScope.pagging.endPageOfPageGroup }">
							<c:choose>
								<c:when test="${i == requestScope.pagging.currentPageNo }">
									${i }
								</c:when>
								<c:otherwise>
									<a href="TipBoardList.do?pageNo=${i }">${i }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <c:if test="${requestScope.pagging.nextPageGroup }">
							<a
								href="TipBoardList.do?pageNo=${requestScope.pagging.endPageOfPageGroup+1 }">>></a>
						</c:if></td>
				</tr>
			</table>

		</div>

		<!-- 검색바 -->
		<div class="search_box">
			<form class="frm_tip_search" action="TipBoardSearch.do">
				<select name="kind">
					<option value="title">제목</option>
					<option value="title_content">제목+내용</option>
					<option value="writer">작성자</option>
				</select>
				<div class="edit_box">
					<input type="text" name="search">
					<button class="search_img" type="button"></button>
				</div>
			</form>
		</div>
	</section>

	<footer>
		<div class="headset">
			<img src="resource/img/headset.png">
		</div>
		<img id="bottom" src="resource/img/bottom_img.png">
		<div class="footer_info_box">
			<div class="footer_text_box">
				<p>(주)내츄럴그린</p>
				<p>|</p>
				<p>서울특별시 마포구 서강로 136 (마포구 노고산동 106-5)</p>
				<p>|</p>
				<p>대표전화 : 00-0000-0000</p>
				<p>|</p>
				<p>개인정보처리방침</p>
				<br>
			</div>
			<p>copyright (c) leafy.com all rights reserved.</p>
		</div>
	</footer>
</body>
</html>