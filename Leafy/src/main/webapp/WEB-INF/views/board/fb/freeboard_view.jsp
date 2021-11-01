<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	*{
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
	
	/* 본문 내용 */
	.fb_view_container{
		width: 1200px;
		margin: 0 auto;	
		padding: 10px;
	}
	hr{
		width: 1200px;
		margin: 0 auto;
	}
	.tbl_insert_comment{
		margin-top: 30px;
	}
	.tbl_list_comment{
		margin-top: 30px;
	}
	.fb_recommand_count{
		text-decoration: none;
		color: black;
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
<script type="text/javascript">
	$(function(){
		$(".fb_recommand_count").click(function(e){
			e.preventDefault();
			$.ajax({
				url : $(this).attr("href"),
				type : "get",
				dataType : "json",
				success:function(r){
					alert(r.msg);
					if(r.code == 400)
						location.href="/";
					else
						location.reload();
				}
			});
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
        <div class="back"></div> <!-- 배경 이미지  -->
		<!-- 본문 작업 부분 -->
		<div class="fb_view_container">
			<a href="javascript:history.back()" style="font-size: 12px; text-decoration: none; color: red">자유게시판 목록</a><br>
			<p style="font-size: 30px;font-weight: bold">${requestScope.fBoard.fb_title }</p>
			
			<!-- 아이디 옆 메세지 버튼 눌리면 게시글 작성자에 메세지 보낼 수 있는 기능 필요 -->
			<form action="sendMessage.do">
				<p style="font-size: 15px">${requestScope.fBoard.creator_id } <button type="button">메세지</button></p>
			</form>
			<p style="font-size: 10px">${requestScope.fBoard.fb_create_date }</p> 
			<hr>
	
			<p style="height: 500px">${requestScope.fBoard.fb_content }</p>

			<p style="font-size: 20px; text-align: center">
				<!-- 
					추천수 누르면 추천 올라가는 기능 필요 
					조회수는 게시글 볼때마다 자동으로 올라가는 기능 필요	
				-->
				<a href="freeBoardRecommand.do?fb_no=${requestScope.fBoard.fb_no }" class="fb_recommand_count">
					<img alt="추천수" src="/resource/img/recommend.png" width="20px" height="20px">${requestScope.fBoard.fb_recommand_count }
				</a>
				<img alt="조회수" src="/resource/img/view.png" width="20px" height="20px"> ${requestScope.fBoard.fb_visit_count }
			</p>
			<hr>
	
			<!-- 댓글 작업 부분 -->
			<p style="font-size: 15px; font-weight: bold">댓글</p>
			<form action="freeBoardInsertComment.do">
			<table class="tbl_insert_comment">
				<tr>
					<td width = "100px">${sessionScope.fbComment.commentor_id }</td>
					<td width = "900px"><textarea style="resize:none; width: 900px; height: 50px" placeholder="댓글을 입력해주세요"></textarea></td>
					<td width = "200px" style="text-align: center"><button>등록</button></td>
				</tr>
			</table>
			</form>
		
			<table class="tbl_list_comment">
				<tr>
					<th width="100px">작성자</th>
					<th width="900px">내용</th>
					<th width="200px">작성일</th>
				</tr>
			<c:forEach var="fbc" items="${requestScope.fbclist }">
				<tr>
					<td>${fbc.commentor_id } </td>
					<td>${fbc.fb_comment_content } </td>
					<td style="text-align: center">${fbc.fb_comment_date } </td>
				</tr>	
			</c:forEach>
			</table>
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