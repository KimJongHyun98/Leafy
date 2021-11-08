<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포토게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    body {
      background-color: #FFFDF6;
      min-width: 1170px;
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
        min-height: 672px;
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
    .pb_list{
    	width: 1200px;
    	margin: 50px 0px;
    }
    .pb_list_flex_container{
    	margin: 0px auto;
    	display: flex;
    	width: 960px;
    	box-sizing: border-box;
    	flex-flow: wrap;
    }
    .pb_item{
    	margin: 0px 20px;
    }
    .pb_paging{
    	text-align: center;
    }
    .form_container{
    	text-align: center;
    }
    .most_view_list{
    	width: 1200px;
    	margin-top: 50px;
    }
    .mvpb_list_flex_container{
    	margin: 0px auto;
    	display: flex;
    	width: 960px;
    	overflow: hidden;
    	box-sizing: border-box;
    }
    .mvpb_item{
		margin: 20px 20px;    
    }
    .pb_paging{
    	margin-top: 50px;
    }
	.btn_pb_write{
		font-size: 15px;
		text-decoration: none;
		width: 10px;
		height: 10px;
		border: 1px solid black;
		background-color: #639578;
		color: white;
	}
	.btn_pb_search{
		font-size: 15px;
		border: 1px solid black;
		background-color: #639578;
		color: white;	
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
        <div class="back"></div> <!-- 배경 이미지  -->
		<!-- 상단 가장 조회수 많은 게시글 슬라이드 처리 -->        
        <div class="most_view_list">
        	<h2 style="width: 960px; margin: 0px auto">이 달의 식물</h2>
	        <div class="mvpb_list_flex_container">
	        <c:forEach var="mvpb" items="${requestScope.mvpbList}">
	        	<div class="mvpb_item" style="width: 200px; height: 300px">
		        	<a href="photoBoardView.do?pb_no=${mvpb.pb_no }" style="text-decoration: none; color: black; font-size: 12px">
		        		no : ${mvpb.pb_no }<br>
		        		<img src="photoBoardFileDownload.do?pb_fno=${mvpb.pb_thumbnail_fno }" width="200px" height="200px"><br>
		        		${mvpb.creator_id }<br>
		        		${mvpb.pb_title }<br>
		        		<span style="margin-left: 130px">
		        		<img src="/resource/img/recommend.png" width="12px" height="12px" name="pb_recommand_count">${mvpb.pb_recommand_count}
		        		<img src="/resource/img/view.png" width="12px" height="12px" name="pb_visit_count">${mvpb.pb_visit_count}
		        		</span>
		        	</a>
	        	</div>
	        </c:forEach>
	        </div>
        </div>
        <hr>
        
        <!-- 포토 게시판 전체 출력 -->
        <div class="pb_list">
        <div class="pb_list_flex_container">
        <c:forEach var="pb" items="${requestScope.pbList}">
        	<div class="pb_item" style="width: 200px; height: 300px">
	        	<a href="photoBoardView.do?pb_no=${pb.pb_no }" style="text-decoration: none; color: black; font-size: 12px">
	        		no : ${pb.pb_no }<br>
         		<c:if test="${pb.pb_thumbnail_fno != null }">
	        		<img src="photoBoardFileDownload.do?pb_fno=${pb.pb_thumbnail_fno }" width="200px" height="200px"><br>
        		</c:if>
        		<c:if test="${pb.pb_thumbnail_fno == null }">
	        		<img src="/resource/img/plant1.jpg" width="200px" height="200px"><br>
        		</c:if>
	        		${pb.creator_id }<br>
	        		${pb.pb_title }<br>
	        		<span style="margin-left: 130px">
	        		<img src="/resource/img/recommend.png" width="12px" height="12px" name="pb_recommand_count">${pb.pb_recommand_count}
	        		<img src="/resource/img/view.png" width="12px" height="12px" name="pb_visit_count">${pb.pb_visit_count}
	        		</span>
	        	</a>
        	</div>
        </c:forEach>
        </div>
        </div>
        
        <!-- 페이징 -->
        <div class="pb_paging">
			<c:if test="${requestScope.pagging.previousPageGroup }">
				<a href="photoBoardList.do?pageNo=${requestScope.pagging.startPageOfPageGroup-1 }"><<</a>				
			</c:if>
			<c:forEach var="i" begin="${requestScope.pagging.startPageOfPageGroup }" end="${requestScope.pagging.endPageOfPageGroup }">
				<c:choose>
					<c:when test="${i == requestScope.pagging.currentPageNo }">
						${i }
					</c:when>
					<c:otherwise>
						<c:if test="${requestScope.count == null }">
							<a href="photoBoardList.do?pageNo=${i }">${i }</a>
						</c:if>
						<c:if test="${requestScope.count != null }">
							<a href="photoBoardSearch.do?pageNo=${i }&kind=${requestScope.kind }&search=${requestScope.search}">${i }</a>
						</c:if>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${requestScope.pagging.nextPageGroup }">
				<a href="photoBoardList.do?pageNo=${requestScope.pagging.endPageOfPageGroup+1 }">>></a>				
			</c:if>
        </div>
        <!-- 검색 기능 -->
		<div class="form_container">
			<form class="frm_search_PhotoBoard" action="photoBoardSearch.do">
				<select name="kind">
					<option value="title">제목</option>
					<option value="title_content">제목+내용</option>
					<option value="creator_id">작성자</option>
				</select>
				<input type="text" name="search" placeholder="검색어 입력">
				<button class="btn_pb_search">검색</button>
			<c:if test="${sessionScope.client.id != null }">
				<a href="photoBoardWriteView.do" class="btn_pb_write">글쓰기</a>
			</c:if>	
			</form>
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