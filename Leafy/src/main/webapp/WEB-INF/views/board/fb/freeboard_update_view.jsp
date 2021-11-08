<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글수정 페이지</title>
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
        margin: 50px auto 0px auto;
        width: 1200px;
<<<<<<< HEAD
        
        /* 임시 */
        height: 2000px;
        
=======
        min-height: 672px;
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
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
<<<<<<< HEAD

    /* 푸터 */
=======
	
	/* 푸터 */
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
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
    .btnUpdate, .btnCancel{
		font-size: 15px;
		border: 1px solid black;
		background-color: #639578;
		color: white;    
	    position: relative;
    	left : 94%;
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
<<<<<<< HEAD
=======
		<!-- 본문 작업 부분 -->
		<div class="fb_view_container">
			<form action="freeBoardUpdate.do" method="post">
				<input id="fb_title" type="text" name="fb_title" style="font-size: 30px;font-weight: bold" value="${requestScope.fbdto.fb_title }">
				<p style="font-size: 10px">${requestScope.fbdto.fb_create_date }</p>
				<hr>
				<textarea id="fb_content" name="fb_content" style="resize: none; width: 1200px; height: 500px">${requestScope.fbdto.fb_content }</textarea>
				<button class="btnUpdate">수정</button>
				<script>
					var btnUpdate = document.querySelector(".btnUpdate");
					btnUpdate.onclick = function(){
						if($('#fb_title').val() == '' || CKEDITOR.instances.fb_content.getData() == ''){
							alert("제목과 내용을 입력해주세요.");
							return false
						} else {
							var chk_confirm = confirm("게시글 수정을 완료하시겠습니까?");
							if(chk_confirm == false){
								alert("게시글 수정이 취소되었습니다.");
								return false;
							} else {
								alert("게시글 수정이 완료되었습니다!");
							}
						}
					}
				</script>
				<button type="button" class="btnCancel" onclick="history.back();">취소</button>
				<input type="hidden" name="fb_no" value="${requestScope.fbdto.fb_no }">
			</form>
		</div>
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
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