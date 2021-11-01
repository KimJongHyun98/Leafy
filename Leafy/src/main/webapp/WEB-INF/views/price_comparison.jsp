<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$(".btn_seeMore").click(function() {
			var d = $(this).parent().serialize();
					var idx = $(".btn_seeMore").index(this);
			$.ajax({
				url : "seeMore.do",
				data : d,
				type : "get",
				dataType : "json",
				success : function(r) {
					console.log(r);
					var reviewList = r.reviewList;
					var tag = "";
					if(r.code == 500){
						tag += "<span> 리뷰가 없습니다. </span>"
					}else{
						for (i = 0; i < reviewList.length; i++) {
							tag += "<div class = 'reviews'>";
							tag += "<div class='id_score'><span> 아이디 : ";
							tag += reviewList[i].id;
							tag += "</span><span class = 'starscore'><span class = 'starscore_2>'</span></span><span>별점 : " + reviewList[i].score + "</span>";
							tag += "</div>";
							tag += "<div class = 'content'>";
							tag += "<span> 등록 날짜 : " + reviewList[i].reviewDate + "</span>";
							tag += "<span> 선택 품목 : " + reviewList[i].selectProduct + "</span>"
							tag += "<span> 댓글 내용 : " + reviewList[i].reviewContent + "</span>";
							tag += "</div>";
							tag += "</div>";
						}
						
					}
					$(".review_container").eq(idx).html(tag);
				}
			});
		});
	});
</script>
<style>
body{
	min-width: 1300px;
}
.content{
	text-align:left;
	display: flex;
	flex-direction: column;
}
.content > span{
	padding: 5px 0px;
}
.id_score{
	text-align: left;
	display: felx;
	width: 200px;
	padding: 10px 0px;
}
.reviews{
	padding: 10px 200px;
	margin: 0px auto;
	width: 1000px;
	box-sizing: border-box;
	border-top: 1px solid #639578;
}
* {
	margin: 0;
	padding: 0;
}

nav {
	width: 100%;
}

#search_bar {
	display: flex;
	justify-content: center;
	margin-top: 30px;
	margin-bottom: 20px;
}

section {
	position: relative;
	margin: 0px auto;
	width: 1200px;
	box-sizing: border-box;
	text-align: center;
	padding-top: 55px;
}

#product_list {
	display: inline-block;
	width: 100%;
	height: 600px;
	overflow: auto;
	overflow-x: hidden;
	opacity: 1.0;
	z-index: 1;
}

#product_list table {
	table-layout: fixed;
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
}

#product_list table thead {
	position: absolute;
	top: 20px;
}

#product_list table tr {
	display: inline-table;
	table-layout: fixed;
	width: 100%;
}

#product_list table td {
	text-align: center;
}

#product_list table tbody tr {
	display: table-row;
}

#product_list table img {
	width: 100px;
	height: 150px;
}

.btn_seeMore{
	width: 1000px;
	boder: 0;
	outline: 0;
	background-color: white;
	-webkit-appearance: none;
  	-moz-appearance: none;
  	appearance: none;
}
button:active,
button:hover,
button:focus {
  background: var(--button-hover-bg-color);
  outline: 0;
}
button:disabled {
  opacity: 0.5;
}

.btn_seeMore:hover{
	color: #639578;
}

a:link { color: black; text-decoration: none;}
a:visited { color: black; text-decoration: none;}
a:hover { color: #639578; text-decoration: underline;}

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
        background-image: url(./resource/background_img.png);
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
            <img class="logo" src="./resource/logo.png">
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
	<nav>
		<div id="search_bar">
			<form action="price_search.do">
				<input type="text" name="search" placeholder="검색어 입력">
				<select name="sort">
					<option value="sim">정확도순</option>
					<option value="date">날짜순</option>
					<option value="asc">낮은가격</option>
					<option value="dsc">높은가격</option>
				</select>
				<button>검색/정렬</button>
			</form>
		</div>
	</nav>
	<section>
		<div class="back">
	</div>
		<div id="product_list">
			<table>
				<thead>
					<tr>
						<th>제품 이미지</th>
						<th>제품명</th>
						<th>최저가격</th>
						<th>구매처</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${requestScope.searchList }">
						<tr>
							<td><img alt="제품사진" src="${list.image }"></td>
							<td><a href="${list.link }">${list.title }</a></td>
							<td>${list.lprice }원</td>
							<td>${list.mallName }</td>
						</tr>
						<tr>
							<td colspan="4">
								<form class="seemore">
									<button class="btn_seeMore" type="button">REVIEW▽</button> 
									<input type="hidden" name="link" value="${list.link }">
								</form>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<div class = review_container>
								</div>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</section>
	<footer>
	<div class="headset"><img src="./resource/headset.png"></div>
        <img id="bottom" src="./resource/bottom_img.png">
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