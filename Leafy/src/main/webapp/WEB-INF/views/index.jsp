<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	window.Kakao.init("15741d660068ab4fed2d994e86c2c908");
	function kakaoLogin() {
	    window.Kakao.Auth.login({
	        scope:'profile_nickname,profile_image ,account_email',
	        success: function(authObj){
	            console.log(authObj);
	            window.Kakao.API.request({
	                Url:'/v1/user/me',
	                success: res => {
	                    alert(JSON.stringify(res));
	                    const kakao_account = res.kakao_account;
	                    console.log(kakao_account);
	                    Kakao.Auth.authorize({
	                    	  redirectUri: '{kakaoLogin.do}'
	                    	});
	                    Kakao.Auth.setAccessToken(ACCESS_TOKEN);
	                }
	            });
	        }
	    });
	    
	}
</script>
<style>
	*{
         margin: 0;
         padding: 0;
     }
     .main{
         width: 1920px;
         height: 969px;
         margin: 0 auto;
     }
     .login{
         width: 60%;
         height: 100%;
         float: left;
         background-color: #0000ff58;
     }
     .explanation{
         width:  40%;
         height:40%;
         float: left;
         background-color: #dc143c64;
     }
     .logo{
         width: 40%;
         height: 60%;
         float: left;
         background-color: rgba(0, 255, 255, 0.412);
     }
     .box1{
         border: #639578 5px solid;
         width: 557px;
         height: 641px;
         background-color: #ffffff;
         margin: 0 auto;
         margin-top: 150px;
     }
     .box2{
         border: #639578 3px solid;
         width: 491px;
         height: 565px;
         margin: 0 auto;
         margin-top: 38px;
     }
     
     .logoimg{
         width: 220px;
         height: 120px;
         margin-left: 28%;
         margin-top: 20px;
     }
     .kakaoimg,.naverimg{
     	width: 180px;
     	margin-left: 19%;
     }
     .kakaoimg{
     	height: 40px;
     }
     input{
         width: 264px;
         height: 51px;
         margin-left: 20%;
         border: 1px solid #639578;
         margin-top: 30px;
         border-radius: 5px;
         font-size: 16px;
         padding-left: 30px;
     }
     .passwd{
         margin-top: 15px;
     }
     .login_bt{
         width: 294px;
         height: 51px;
         background-color: #639578;
         color: white;
         border: none;
         border-radius: 5px;
         margin-top: 15px;
         margin-left: 20%;
         font-size: 18px; 
     }
     .find{
         border: none;
         font-size: 18px;
         margin-left: 26%;
         margin-top: 15px;
         color: #639578;
     }
     .find_1{
         border: none;
         font-size: 18px;
         margin-top: 15px;
         color: #639578;
     }
     .social{
         color: #639578;
         margin-left: 14%;
     }
     .social > p{
         margin-left: 30%;
         margin-top: 3%;
         margin-bottom: 2%;
     }
     .social > a{
         margin-right: 5%;
     }
     .Nologin{
        margin-left: 30%;
        text-decoration: none;
     }
     .join{
         margin-left: 41%;
         margin-top: 1%;
         text-decoration: none;
     }
     .explanation > p{
         font-size: 36px;
         text-align: center;
         margin-top: 170px;
     }
     .logo > h2{
         font-size: 72px;
         text-align: center;
         margin-top: 80px;
         margin-bottom: 80px;
     }
     .logo > p{
         font-size: 24px;
         margin-left: 40px;
     }
</style>
</head>
<body>
 <!--???????????????-->
    <div class="main">
        <!--????????? ??????-->
        <div class="login">
            <div class="box1">
                <div class="box2">
                    <div class="Logoin">
                        <img src="./resource/img/logo.png" alt="logo_img" class="logoimg"><br>
						<form action="Login.do" method="post" >
							<input type="text" class="id" name="id" placeholder="???????????????"><br>
							<input type="password" class="passwd" name="passwd"
								placeholder="????????????"><br>
							<button class="login_bt">?????????</button>
							<br>
						</form>
						<button type="button" class="find">????????? ??????</button> ??? <button type="button" class="find_1">???????????? ??????</button><br>
                            <a href="register.do" class="join">????????????</a>
                    </div>
                    <div class="social">
                    
                        <p>???????????????</p>
                         <a href="naver.do" onclick="window.open('naver.do', '???????????? ?????????','width=200, height=100'); return false"><img src="./resource/img/naver_login.png" alt="??????????????????" class="naverimg"></a>
                        <a href="javascript:kakaoLogin();"><img src="./resource/img/kakao_login.png" alt="??????????????????" class="kakaoimg"></a>
                    </div>
                    <a href="Maingo.do" class="Nologin">???????????? ????????? ????????????</a>
                </div>

            </div>

        </div>
        <!--????????? ??????-->
        <div class="explanation">
            <p>?????????????????? 3?????? ?????????????????????.</p>
        </div>
        <!--???????????? ??????-->
        <div class="logo">
            <h2>Leafy</h2><br>
            <p>Leafy??? ???????????? ???,</p>
            <p>"?????? ?????????" ????????? ????????? ?????? ????????????,</p> 
            <p>?????? ???????????? ????????? ???????????? ???????????? ???????????????. </p>
            <br>
        </div>
    </div>
</body>
</html>