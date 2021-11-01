<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
</script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8d224481282314345e6322cbe0ed39b0"></script>
<script>
	$(function(){
        var mapContainer = document.getElementById('map'); // 지도를 표시할 div
          mapOption = {
            center: new kakao.maps.LatLng(37.55523284453598, 126.9357960884656), // 지도의 중심좌표
            level: 3, // 지도의 확대 레벨
          };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption);
        
        var markerPosition  = new kakao.maps.LatLng(37.55523284453598, 126.9357960884656); 

    	 // 마커를 생성합니다
		var marker = new kakao.maps.Marker({
        position: markerPosition,
        clickable: true 
        });

     	// 마커가 지도 위에 표시되도록 설정합니다
     	marker.setMap(map);
     	
     	var iwContent = '<div style="padding:5px;">Leafy</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
     	iwPosition = new kakao.maps.LatLng(37.55523284453598, 126.9357960884656);
     	
     	var infowindow = new kakao.maps.InfoWindow({
     	    position : iwPosition, 
     	    content : iwContent 
     	});
     	
     	infowindow.open(map, marker); 

	});
</script>

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Rochester&display=swap');
body {
      background-color: #FFFDF6;
      min-width: 1340px;
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
        height: 2000px;
        
    }

    /* 배경 이미지 */
    .back {
        width: 1200px;
        height: 95%;
        background-image: url(/resource/background_img.png);
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
* {
	margin: 0;
	padding: 0;
}

section {
	width: 1200px;
	margin: 0 auto;
}

.developer {
	display: flex;
	justify-content: center;
}

.developer>div>img {
	width: 200px;
	height: 300px;
}

.developer div {
	width: 200px;
	margin: 0px 8.5px;
}

.developer div>p {
	text-align: center;
	font-size: 18px;
}

.introduce {
	display: flex;
	justify-content: center;
}

.introduce>img {
	width: 360px;
	height: 470px;
}

.introduce>p {
	margin: auto 0;
	display: inline-block;
	width: 700px;
	margin-right: 10px;
	text-align: center;
	font-size: 24px;
}

h1 {
	font-family: 'Rochester', cursive;
	margin: 50px 0px;
	font-size: 64px;
}

#map {
	margin: 0px auto;
}

#waytocome {
	display: flex;
	justify-content: space-around;
	margin-top: 20px;
}

#waytocome>img {
	width: 45px;
	height: 45px;
}

#ridecar, #publictrans {
	width: 450px;
	height: 120px;
}

#ridecar>div, #publictrans>div {
	display: flex;
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
            <img class="logo" src="resource/logo.png">
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
		<h1>Developer</h1>
		<div class="developer">
			<div>
				<img
					src="http://img.khan.co.kr/news/2020/10/16/2020101601001687000138341.jpg"
					alt="안태진" />
				<p>국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 법관이 중대한 심신상의 장해로 직무를
					수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다.</p>
			</div>
			<div>
				<img
					src="http://img.khan.co.kr/news/2020/10/16/2020101601001687000138341.jpg"
					alt="안세영" />
				<p>국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 법관이 중대한 심신상의 장해로 직무를
					수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다.</p>
			</div>
			<div>
				<img
					src="http://img.khan.co.kr/news/2020/10/16/2020101601001687000138341.jpg"
					alt="이희진" />
				<p>국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 법관이 중대한 심신상의 장해로 직무를
					수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다.</p>
			</div>
			<div>
				<img
					src="http://img.khan.co.kr/news/2020/10/16/2020101601001687000138341.jpg"
					alt="김종현" />
				<p>국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 법관이 중대한 심신상의 장해로 직무를
					수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다.</p>
			</div>
			<div>
				<img
					src="http://img.khan.co.kr/news/2020/10/16/2020101601001687000138341.jpg"
					alt="오형석" />
				<p>국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 법관이 중대한 심신상의 장해로 직무를
					수행할 수 없을 때에는 법률이 정하는 바에 의하여 퇴직하게 할 수 있다.</p>
			</div>
		</div>
		<h1>BrandName</h1>
		<div class="introduce">
			<p>대통령은 법률에서 구체적으로 범위를 정하여 위임받은 사항과 법률을 집행하기 위하여 필요한 사항에 관하여
				대통령령을 발할 수 있다. 제1항의 해임건의는 국회재적의원 3분의 1 이상의 발의에 의하여 국회재적의원 과반수의 찬성이
				있어야 한다. 국회의원이 회기전에 체포 또는 구금된 때에는 현행범인이 아닌 한 국회의 요구가 있으면 회기중 석방된다.
				국무위원은 국정에 관하여 대통령을 보좌하며, 국무회의의 구성원으로서 국정을 심의한다. 국가안전보장에 관련되는
				대외정책·군사정책과 국내정책의 수립에 관하여 국무회의의 심의에 앞서 대통령의 자문에 응하기 위하여 국가안전보장회의를 둔다.
				대한민국의 국민이 되는 요건은 법률로 정한다. 중앙선거관리위원회는 법령의 범위안에서 선거관리·국민투표관리 또는 정당사무에
				관한 규칙을 제정할 수 있으며, 법률에 저촉되지 아니하는 범위안에서 내부규율에 관한 규칙을 제정할 수 있다. 국가는 여자의
				복지와 권익의 향상을 위하여 노력하여야 한다. 대통령은 조약을 체결·비준하고, 외교사절을 신임·접수 또는 파견하며,
				선전포고와 강화를 한다.</p>
			<img
				src="http://img.khan.co.kr/news/2020/10/16/2020101601001687000138341.jpg"
				alt="" />
		</div>
		<h1>Way to Come</h1>
		<div id="map" style="width: 1100px; height: 450px"></div>
		<div id="waytocome">
			<div id="ridecar">
				<div>
					<img src="./resource/2526575_transportation_vehicle_icon.png"
						alt="">
					<p>자차 이용시</p>
				</div>
				<p>국회의원의 수는 법률로 정하되, 200인 이상으로 한다. 재의의 요구가 있을 때에는 국회는 재의에 붙이고,
					재적의원과반수의 출석과 출석의원 3분의 2 이상의 찬성으로 전과 같은 의결을 하면 그 법률안은 법률로서 확정된다.</p>
			</div>
			<div id="publictrans">
				<div>
					<img
						src="./resource/2303160_bus_public_road_transport_travel_icon.png"
						alt="">
					<p>대중교통 이용시</p>
				</div>
				<p>국회의원의 수는 법률로 정하되, 200인 이상으로 한다. 재의의 요구가 있을 때에는 국회는 재의에 붙이고,
					재적의원과반수의 출석과 출석의원 3분의 2 이상의 찬성으로 전과 같은 의결을 하면 그 법률안은 법률로서 확정된다.</p>
			</div>
		</div>
	</section>
	<footer>
	 <div class="headset"><img src="resource/headset.png"></div>
	 
        <img id="bottom" src="resource/bottom_img.png">
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