<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leafy</title>
<script src="https://code.jquery.com/jquery-2.2.0.min.js"
	type="text/javascript"></script>
<script src="./resource/slick-1.8.1/slick/slick.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="./resource/slick-1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="./resource/slick-1.8.1/slick/slick-theme.css">
<script type="text/javascript">
	$(document).on('ready', function() {

		$(".regular").slick({
			dots : true,
			infinite : true,
			slidesToShow : 4,
			slidesToScroll : 4
		});

		$(".lazy").slick({
			lazyLoad : 'progressive', // ondemand progressive anticipated
			infinite : true
		});

		$(".olig").slick({
			dots : true,
			infinite : true,
			slidesToShow : 3,
			slidesToScroll : 3
		});

	});
</script>
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
}

* {
	box-sizing: border-box;
}

.slider {
	width: 1440px;
	margin: 100px auto;
}

.slick-slide {
	margin: 0px 20px;
}

.slick-slide img {
	width: 100%;
}

.slick-prev:before, .slick-next:before {
	color: black;
}

.slick-slide {
	transition: all ease-in-out .3s;
	opacity: .2;
}

.slick-active {
	opacity: .5;
}

.slick-current {
	opacity: 1;
}

.table {
	border: 1px solid black;
	width: 1000px;
	height: 200px;
	margin: 0 auto;
	margin-top: 100px;
	margin-bottom: 200px;
}

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

nav li {
	margin: 0 auto;
	list-style-type: none;
	margin-left: 50px;
	font-size: 20px;
}

/* 섹션 */

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
	margin-bottom: 10px;
}

table {
	border-collapse: collapse;
	margin: 0;
	width: auto;
}

.table {
	width: 1440px;
	overflow-x: auto;
	white-space: nowrap;
}

th, td {
	padding: 5px 83.2px;
	text-align: center;
	font-size: 1.3rem;
}

tr {
	border: 1px black solid;
}

h2 {
	text-align: center;
	border: 1px black solid;
}

.lazy {
	height: 350px;
	margin-top: 0px;
}
.tipboard{
	widows: 1400px;
	height: 500px;
}
h3{
text-align: center;
font-size: 36px;
}
.regular{
margin-top: 20px;
}
.olig{
margin-top: 20px;
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
		<!-- 배경 이미지  -->
		<section class="lazy slider" data-sizes="50vw">
			<div>
				<img
					src="https://cloudfront-ap-northeast-1.images.arcpublishing.com/chosunbiz/V6EPKRP2ONNJE5JV4RVO3DD3AM.png"
					alt="메인광고이미지" width="2000px" height="350px">
			</div>
			<div>
				<img
					src="http://www.ottogi.co.kr/pds/upfile/2021-05-17_43319973.jpg"
					alt="메인광고이미지" width="1700px" height="350px">
			</div>
			<div>
				<img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnBFfiRPPNyLuvJBvx8wEBSAvMoekhZJO-hg&usqp=CAU"
					alt="메인광고이미지" width="1700px" height="350px">
			</div>
			<div>
				<img src="https://i.ytimg.com/vi/hlcrgEeF9nQ/maxresdefault.jpg"
					alt="메인광고이미지" width="1700px" height="350px">
			</div>
			<div>
				<img
					src="http://cdnimage.dailian.co.kr/news/202108/news_1629954636_1026534_m_1.jpeg"
					alt="메인광고이미지" width="1700px" height="350px">
			</div>
			<div>
				<img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwiFt1aUqXXKnjZs3-8nkWiNj5j-oBcOFcwA&usqp=CAU"
					alt="메인광고이미지" width="1700px" height="350px">
			</div>
		</section>



	<div class="tipboard">
	<h3>tip 게시판</h3>
		<section class="regular slider">
			<div>
				 <table>
					<tbody class="result">
			<%-- 			<c:forEach var="tip" items="${requestScope.tblist}">
							<tr>
								<td><a href="tipView.do?tno=${fb.tno}">${tip.tip_title}</a></td>
								<td>${tip.tip_content}</td>
							</tr>
				 	</c:forEach> --%>	
				</table> 
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=2">
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=3">
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=4">
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=5">
			</div>
			<div>
				<img src="/img/instagrm.png">
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=7">
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=8">
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=9">
			</div>
			<div>
				<img src="/img/logo.png">
			</div>
			<div>
				<a href="#">이곳으로이동</a>
			</div>
			<div>
				<img src="http://placehold.it/350x300?text=12">
			</div>
		</section>
</div>

	<div class="ptboard">
		<h3>포토게시판</h3>
		<section class="olig slider">
			<div>
				<img src="/img/facebook.png"> 이미지설명
			</div>
			<div>
				<img src="http://placehold.it/400x300?text=2"> 이미지설명
			</div>
			<div>
				<img src="http://placehold.it/400x300?text=3"> 이미지설명
			</div>
			<div>
				<img src="http://placehold.it/400x300?text=4"> 이미지설명
			</div>
			<div>
				<img src="http://placehold.it/400x300?text=5"> 이미지설명
			</div>
			<div>
				<img src="/img/instagrm.png"> 이미지설명
			</div>
		</section>
		</div>
		
		<div class="table" id="FB">
			<h2>자유게시판</h2>
			<table>
				<c:forEach var="fb" items="${requestScope.fbList }">
					<tr>
						<td>${fb.fb_no }</td>
						<td><a href="freeBoardView.do?fb_no=${fb.fb_no }">${fb.fb_title }</a></td>
						<td>${fb.creator_id }</td>
						<td>${fb.fb_create_date }</td>
						<td>${fb.fb_visit_count }</td>
					</tr>
				</c:forEach>
			</table>
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