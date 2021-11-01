<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
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
        
        /* 임시 */
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
        cursor:pointer;
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
<style>
    /* 공통 */
    /* 서비스 메뉴 */
    .customer_service_box {
        margin-top: 70px;
        display: flex;
        flex-direction: row;
    }

    .info_box {
        width: 300px;
        height: 150px;
        text-align: center;
        background-color: #cfcfcf;
    }
    .info_box p:nth-child(1) {
        font-size: 25px;
        color: white;
        font-weight: bold;
        padding-top: 45px;
    }
    .info_box p:nth-child(2) {
        color: #555555;
    }
    .service_menu ul {
        list-style-type: none;
    }
    .service_menu li {
        width: 300px;
        height: 80px;
        border-bottom: 1px solid #cfcfcf ;
    }
    .service_menu li p {
        margin-left: 20px;
        padding-top: 30px;
        color: #333333;
        cursor: pointer;
    }
    /* 서비스 내용 */

     /* 고객센터 헤더 */
     .service_box {
         margin-left: 50px;
         margin-top: 15px;
        }

    @font-face {
        font-family: 'TTTogether';
        src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/TTTogetherA.woff') format('woff');
        font-weight: normal;
        font-style: normal;
    }
    .service_header {
        width: 800px;
        height: 120px;
    }
    .service_header p:nth-child(1) {
        float: left;
        font-family: 'TTTogether';
        font-size: 32px;
        color: #639578;
        margin-left: 250px;
        margin-top: 10px;
    }
    .service_header p:nth-child(2) {
        float: left;
        font-family: 'TTTogether';
        color: #333333;
        font-size: 27px;
        margin-top: 15px;
        margin-left: 5px;
    }
    .service_header p:nth-child(3) {
        float: left;
        font-size: 20px;
        margin-top: 20px;
        margin-left: 5px;
        font-weight: bold;
    }
    .header_bottom {
        font-size: 12px;
        margin-left: 225px;
        margin-top: -5px;
    }
    /* 내용 틀 */
    .service_content {
        width: 800px;
        height: 1000px;
        margin-top: 20px;
        border: 1px solid #cfcfcf;
    }
    /* 공지 사항(메인) */
    .notice {
        margin: 40px 30px;
    }
    .notice_text {
        height: 40px;
        font-size: 20px;
        font-weight: bold;
        padding-left: 10px;
        border-bottom: 1px solid #cfcfcf;
    }
    .notice_board {
        height: 40px;
        margin-top: 15px;
        padding-left: 10px;
        border-bottom: 1px solid #cfcfcf;
        display: flex;
    }
   .notice_board p:nth-child(1) {
       width: 620px;
   }
   .notice_board p:nth-child(2) {
       font-size: 15px;
   }

    /* FAQ */
    .faq {
        display: none;
    }


    /* 1:1문의 */
    .one_on_one {
        display: none;
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
        <div class="back"></div> <!-- 배경 이미지  -->
         <div class="customer_service_box">
            <div  class="service_menu">
                <div class="info_box">
                    <p>고객센터</p>
                    <p>CUSTOMER SERVICE</p>
                </div>
                <ul>
                    <li><p>공지사항</p></li>
                    <li><p>FAQ</p></li>
                    <li><p>1:1 문의</p></li>
                </ul>
            </div>
            <div class="service_box">
                <div class="service_header">
                    <p>LEAFY </p> <p>고객센터</p> <p>입니다.</p>
                    <br> <br> <br>
                    <p class="header_bottom">궁금하신 사항을 문의해주시면 정성을 다해 답변 드리겠습니다.</p>
                </div>
                <div class="service_content">
                    <!-- 바뀌어야할 내용 부분  -->
                    <!-- 공지사항 -->
					<table>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
						<c:forEach var="n" items="${requestScope.noticelist}">
							<tr>
								<td>${n.nbno }</td>
								<td>${n.id }</td>
								<td><a href="noticeView.do?nbno=${n.nbno }">${n.notice_title}</a></td>
								<td>${n.notice_date }</td>
								<td>${n.notice_visit }</td>
							</tr>
						</c:forEach>
						<!-- 페이징 처리 -->
						 <tr>
		<td colspan="7">
			<c:if test="${requestScope.pagging.priviousPageGroup }">
				<a href="NoticeList.do?pageNo=${requestScope.pagging.startPageOfPageGroup-1 }"> ＜＜ </a>			
			</c:if>			
			<c:forEach var="i" begin="${requestScope.pagging.startPageOfPageGroup}" end="${requestScope.pagging.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${i == requestScope.pagging.currentPageNo }">
						${i }
					</c:when>
					<c:otherwise>
						<a href="NoticeList.do?pageNo=${i} ">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${requestScope.pagging.nextPageGroup }">
				<a href="NoticeList.do?pageNo=${requestScope.pagging.endPageOfPageGroup+1 }"> ＞＞ </a>			
			</c:if>			
		</td>
	</tr> 
					</table>
				</div>
            </div>

        </div>
        
       
    </section>

    <footer>
        <div class="headset"><img src="resource/img/headset.png"></div>
        <img id="bottom" src="resource/img/bottom_img.png">
        <div class="footer_info_box">
            <div class="footer_text_box">
                <p>(주)내츄럴그린 </p><p>|</p>
                <p>서울특별시 마포구 서강로 136 (마포구 노고산동 106-5) </p><p>|</p>
                <p>대표전화 : 00-0000-0000 </p><p>|</p>
                <p>개인정보처리방침</p><br>
            </div>
            <p>copyright (c) leafy.com all rights reserved.</p>
        </div>
    </footer>
</body>
</html>