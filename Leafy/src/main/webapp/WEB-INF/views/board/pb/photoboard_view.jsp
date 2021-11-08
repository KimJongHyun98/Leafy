<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포토게시판 상세페이지</title>
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
<<<<<<< HEAD
</style>
=======
    .pb_img_content{
       	margin: 0px auto;
    	display: flex;
    	width: 960px;
    	box-sizing: border-box;
    	flex-flow: wrap;
    }
    .pb_img_item{
    	margin: 20px 20px;
    }
    .pb_insert_comment{
    	margin-bottom: 10px;
    	display: flex;
    	flex-direction: column;
    	position: relative;
    	box-sizing: border-box;
    }

    .pb_comment_list{
    	display: flex;
    	justify-content: center;
    }
    .pb_comment_list > span{
    	padding: 10px 60px 10px 10px;
    	font-size: 1.5em;
    	color: green;
    }
    .pb_comment_list > textarea{
    	resize: none;
    	width: 900px;
    	height: 50px;
    	font-size: 12px;
    }
    .pb_comment_list > .btn_pbc_register{
		font-size: 15px;
		margin-left: 10px;
		border: 1px solid black;
		background-color: #639578;
		color: white;
    }
    
    .tbl_list_comment{
    	border-spacing: 10px;
    	text-align: center;
    }
    .tbl_list_comment > td{
    	text-align: center;
    	font-size: 14px;
    }
    
    .pb_content{
    	margin-top: 50px;
    	min-height: 300px;
    }
    .btnUpdate, .btnDelete{
		font-size: 15px;
		border: 1px solid black;
		background-color: #639578;
		color: white;    
    }    
</style>
<script type="text/javascript">
	$(function(){
		$(".pb_recommand").click(function(e){
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
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
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
		<div class="pb_view_container">
			<a href="javascript:location.href='photoBoardList.do'" style="font-size: 12px; text-decoration: none; color: red">포토게시판 목록</a><br>
			<input type="hidden" value="${requestScope.pBoard.pb_no }" name="pb_no">
			<p style="font-size: 30px;font-weight: bold">${requestScope.pBoard.pb_title }
				<c:if test="${requestScope.pBoard.creator_id == sessionScope.client.id }">
					<button type="button" class="btnUpdate">수정</button>
					<button type="button" class="btnDelete">삭제</button>
					<script>
						var btnUpdate = document.querySelector(".btnUpdate");
						btnUpdate.onclick = function(){
							var chk_confirm = confirm("수정 페이지로 이동하시겠습니까?");
							if(chk_confirm == true){
								location.href = "photoBoardUpdateView.do?pb_no=${requestScope.pBoard.pb_no}";
							}
						}
						var btnDelete = document.querySelector(".btnDelete");
						btnDelete.onclick = function(){
							var chk_confirm = confirm("해당 게시글을 삭제하시겠습니까?");
							if(chk_confirm == true){
								location.href = "photoBoardDelete.do?pb_no=${requestScope.pBoard.pb_no}";
							} else {
								alert("게시글 삭제가 취소되었습니다.");
								return false;
							}
						}
					</script>
				</c:if>
			</p>
			
			<!-- 아이디 옆 메세지 버튼 눌리면 게시글 작성자에 메세지 보낼 수 있는 기능 필요 -->
			<form action="sendMessage.do">
				<p style="font-size: 15px">
					${requestScope.pBoard.creator_id }
					<c:if test="${requestScope.pBoard.creator_id != sessionScope.client.id }">
						<button type="button">메세지</button>
					</c:if> 
				</p>
			</form>
			<p style="font-size: 10px">${requestScope.pBoard.pb_create_date }</p>
			<hr>
			<!-- 이미지 파일 출력 -->
			<div class="pb_img_content">
				<c:forEach items="${requestScope.flist }" var="img">
					<div class="pb_img_item">
						<img src="photoBoardFileDownload.do?pb_fno=${img.pb_fno }" width="200px" height="200px">
					</div>
				</c:forEach>
			</div>
			<div class="pb_content">
				${requestScope.pBoard.pb_content }
			</div>

			<p style="font-size: 18px; text-align: center">
				<a href="photoBoardRecommand.do?pb_no=${requestScope.pBoard.pb_no }" class="pb_recommand" style="padding-right: 20px; text-decoration: none; color: green">
					<img src="/resource/img/recommend.png" width="20px" height="20px" name="pb_recommand_count">${requestScope.pBoard.pb_recommand_count }
				</a>
				<img src="/resource/img/view.png" width="20px" height="20px"> ${requestScope.pBoard.pb_visit_count }
			</p>
			<hr>
			<!-- 파일 링크 출력 -->
			<p style="font-size: 12px; font-weight: bold; margin-top: 5px">첨부파일 목록</p>
			<c:forEach var="f" items="${requestScope.flist }">
				<p style="font-size: 12px; margin: 5px 0px">첨부파일 : <a href="photoBoardFileDownload.do?pb_fno=${f.pb_fno }" style="font-size: 12px">${f.originalFileName}</a></p>
			</c:forEach>
			<hr>
			<!-- 댓글 입력 -->
			<p style="font-size: 12px; font-weight: bold; margin: 5px 0px">댓글</p>
			<form action="photoBoardInsertComment.do">
			<div class="pb_insert_comment">
				<input type="hidden" value="${requestScope.pBoard.pb_no }" name="pb_no">
				<div class="pb_comment_list">	
					<span>${sessionScope.client.id }</span>
					<input type="hidden" value="${sessionScope.client.id }" name="commentor_id">
					<textarea id="pb_comment_content" name="pb_comment_content" style="resize:none; width: 900px; height: 50px" placeholder="댓글을 입력해주세요"></textarea>
					<button class="btn_pbc_register">등록</button>
					<script>
						var btnRegisterCmt = document.querySelector(".btn_pbc_register");
						btnRegisterCmt.onclick = function(){
							if($('#pb_comment_content').val() == ''){
								alert("댓글을 입력하세요");
								return false;
							} else {
								var chk_confirm = confirm("댓글 등록을 하시겠습니까?");
								if(chk_confirm == false){
									alert("댓글 등록이 취소되었습니다.");
									return false;
								} else {
									alert("댓글 등록이 완료되었습니다!");
								}
							}
						}
					</script>						
				</div>
			</div>
			</form>
			<!-- 댓글 출력 -->
			<table class="tbl_list_comment">
				<tr>
					<th><input type="hidden"></th>
					<th width="100px">작성자</th>
					<th width="800px">내용</th>
					<th width="300px">작성일</th>
				</tr>
			<c:forEach var="pbc" items="${requestScope.pbclist }">
				<tr>
					<td><input type="hidden" name="pbc_no" value="${pbc.pbc_no}"></td>
					<td>${pbc.commentor_id } </td>
					<td>${pbc.pb_comment_content } </td>
					<td>
						${pbc.pb_comment_date } 
					<c:if test="${pbc.commentor_id == sessionScope.client.id }">
						<a href = "photoBoardDeleteComment.do?pbc_no=${pbc.pbc_no}&pb_no=${pbc.pb_no}" style="text-decoration: none; color: red; font-size: 12px">삭제</a>
					</c:if>
					</td>
				</tr>
			</c:forEach>
			</table>
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