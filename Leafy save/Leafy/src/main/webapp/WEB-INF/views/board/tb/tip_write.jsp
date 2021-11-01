<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팁 게시판 글쓰기 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
* {
	margin: 0px;
	padding: 0px;
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

nav li {
	margin: 0 auto;
	list-style-type: none;
	margin-left: 50px;
	font-size: 20px;
}

/* 섹션 */
section {
	margin: 0 auto;
	width: 1200px;
	height: 1200px;
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

/* 글쓰기 부분*/
.frm_write_FreeBoard {
	margin: 10px auto;
	width: 1200px;
	box-sizing: border-box;
}

.btn_container {
	text-align: right;
}

.fb_write_container {
	margin-top: 10px;
	box-sizing: border-box;
	width: 1200px;
	border: 1px solid black;
}

input {
	box-sizing: border-box;
	border: none;
	width: 1198px;
	font-size: 35px;
}

textarea {
	box-sizing: border-box;
	border: none;
	resize: none;
	width: 1198px;
	height: 1000px;
	font-size: 12px;
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
	margin-bottom: 10px;
}
</style>
<script>
	$(function() {
		var count = 3;
		$("#plus").click(function() {
			if (count == 5)
				return;
			count++;
			$("form").append("<p><input type='file' name='file'></p>");
		});
		$("#minus").click(function() {
			if (count == 1)
				return;
			count--;
			$("form").children("p").last().remove();
		});
	});
</script>
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
					<li>회사소개</li>
					<li>분양</li>
					<li>TIP</li>
					<li>가격비교</li>
					<li>자유게시판</li>
					<li>고객센터</li>
				</ul>
			</nav>
		</div>
	</header>

	<section>
		<div class="back"></div>
		<!-- 배경 이미지  -->
		<c:if test="${sessionScope.client == null }">
			<script>
				alert("로그인 후 이용하세요");
				location.href = "/";
			</script>
		</c:if>
		<form action="TipboardWrite.do" method="post"
			enctype="multipart/form-data">
			제목 : <input type="text" name="title" placeholder="제목을 입력하세요">
			<br>내용
			<textarea name="content" placeholder="내용을 입력하세요"></textarea>
			<hr>
			<p>
				<input type="file" name="file">
				<button type="button" id="plus">+</button>
				<button type="button" id="minus">-</button>
			</p>
			<p>
				<input type="file" name="file">
			</p>
			<p>
				<input type="file" name="file">
			</p>
			<button>작성</button>
		</form>
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