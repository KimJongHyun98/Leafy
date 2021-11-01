<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
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

    .back {
        width: 1200px;
        height: 95%;
        background-image: url(/resource/img/background_img.png);
        background-repeat: no-repeat;
        opacity: 0.1;
        position: absolute;
        z-index: -1;
    }
    
    /* 자유게시판 틀 레이아웃 */
	table{
		width: 1200px;
		margin: 0 auto;
	}
	
	th,td{
		text-align: center;
		border-bottom: 1px solid;
		padding: 15px 0px;
	}
	
	a{
		text-decoration: none;
		color: black;
	}
	.form_container{
		width: 1200px;
		margin: 0 auto;
		text-align: center;
	}
	.btn_fb_search{
		font-size: 15px;
		border: 1px solid black;
		background-color: #639578;
		color: white;
	}
	.btn_fb_write{
		font-size: 15px;
		width: 10px;
		height: 10px;
		border: 1px solid black;
		background-color: #639578;
		color: white;
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
<script>

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
	    <!-- 배경 이미지  -->
        <div class="back"></div>
		<!-- 게시판 리스트 -->
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>추천수</th>
					<th>조회수</th>
				</tr>
			</thead>
		<!-- 게시판 리스트 전체 출력 -->
			<tbody class="result">
			<c:forEach var="fb" items="${requestScope.fbList }">
				<tr>
					<td>${fb.fb_no }</td>
					<td><a href="freeBoardView.do?fb_no=${fb.fb_no }">${fb.fb_title }</a></td>
					<td>${fb.creator_id }</td>
					<td>${fb.fb_create_date }</td>
					<td>${fb.fb_recommand_count }</td>
					<td>${fb.fb_visit_count }</td>
				</tr>
			</c:forEach>
			</tbody>
				<!-- 페이징 처리 -->
				<tr>
					<td colspan="6">
						<c:if test="${requestScope.pagging.previousPageGroup }">
							<a href="freeBoardList.do?pageNo=${requestScope.pagging.startPageOfPageGroup-1 }"><<</a>				
						</c:if>
						<c:forEach var="i" begin="${requestScope.pagging.startPageOfPageGroup }" end="${requestScope.pagging.endPageOfPageGroup }">
							<c:choose>
								<c:when test="${i == requestScope.pagging.currentPageNo }">
									${i }
								</c:when>
								<c:otherwise>
									<c:if test="${requestScope.count == null }">
										<a href="freeBoardList.do?pageNo=${i }">${i }</a>
									</c:if>
									<c:if test="${requestScope.count != null }">
										<a href="freeBoardSearch.do?pageNo=${i }&kind=${requestScope.kind }&search=${requestScope.search}">${i }</a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${requestScope.pagging.nextPageGroup }">
							<a href="freeBoardList.do?pageNo=${requestScope.pagging.endPageOfPageGroup+1 }">>></a>				
						</c:if>
					</td>
				</tr>
		</table>
		<div class="form_container">
			<form class="frm_search_FreeBoard" action="freeBoardSearch.do">
				<select name="kind">
					<option value="title">제목</option>
					<option value="title_content">제목+내용</option>
					<option value="creator_id">작성자</option>
				</select>
				<input type="text" name="search" placeholder="검색어 입력">
				<button class="btn_fb_search">검색</button>
				<a href="freeBoardWriteView.do" class="btn_fb_write">글쓰기</a>
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