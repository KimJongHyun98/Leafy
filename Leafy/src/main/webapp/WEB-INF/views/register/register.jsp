<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leafy 회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
       $(function () {
            $(".allcheckbox").click(function(){
                if($(".allcheckbox").prop("checked")){
                    $("#checkbox1").prop("checked",true)
                }else{
                    $("#checkbox1").prop("checked",false)
                }
                
            })

            $(".allcheckbox").click(function(){
                if($(".allcheckbox").prop("checked")){
                    $("#checkbox2").prop("checked",true)
                }else{
                    $("#checkbox2").prop("checked",false)
                }
                
            })

            $(".allcheckbox").click(function(){
                if($(".allcheckbox").prop("checked")){
                    $("#checkbox3").prop("checked",true)
                }else{
                    $("#checkbox3").prop("checked",false)
                }
                
            })

             //버튼을 클릭 했을때 아이디를 입력했는지 체크
            var id = document.getElementById("id");
            var idcheck = document.getElementById("idcheck");
            var id1 = document.getElementById("id1");

            var pass = document.querySelector(".pass");
            var pass1 = document.querySelector(".pass1");
            var pass2 = document.querySelector(".pass2");
            var passcheck = document.querySelector(".passcheck");
            var passcheck1 = document.querySelector(".passcheck1");
            var passcheck2 = document.querySelector(".passcheck2");
            var reg = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
            var pw = $("#password").val();

            var nick = document.querySelector(".nickname");
            var nick1 = document.querySelector(".nickname1");


             idcheck.onclick = function () {
                if (id.value.length < 6) {
                    id1.innerHTML=("아이디는 6글자 이상 입력하세요");
                } else {
                    id1.innerHTML = ("통과");
                }
            }

            // 비밀 번호 입력시 마다 체크 

            pass.onkeyup = function (e) {
                if (pass.value.length < 8 || pass.value.length > 32) {
                    pass1.innerHTML = ("8자리 ~ 32자리 이내로 입력해주세요.");
                    pass2.innerHTML = ("")
                    return false;
                } else if (pass.value.search(/\s/) != -1) {
                    pass1.innerHTML = ("비밀번호는 공백 없이 입력해주세요.");
                    pass2.innerHTML = ("")
                    return false;
                } else if (false === reg.test(pass.value)){
                    pass1.innerHTML = ("비밀번호는 8자 이상이어야 하며, 숫자/소문자/특수문자를 모두 포함해야 합니다.");
                    pass2.innerHTML = ("")
                    return false;
                } else {
                    pass1.innerHTML = ("");
                    pass2.innerHTML = ("통과");
                    return true;
                }
            }
            // 비밀 번호 입력시 마다 체크 

            passcheck.onkeyup = function (e) {
                if (passcheck.value !== pass.value) {
                    passcheck1.innerHTML = ("비밀번호가 같지 않습니다.")
                    passcheck2.innerHTML = ("")
                } else {
                    passcheck1.innerHTML = ("")
                    passcheck2.innerHTML = ("")
                }
                if (passcheck.value === pass.value) {
                    passcheck2.innerHTML = ("비밀번호가 같습니다.")
                }
            }

            // 닉네임 입력시 마다 체크 
            nick.onkeyup = function(e) {

            }
            
            // 회원가입 버튼 눌렀을때 안된것 체크 
            
        });
    </script>
    <style type="text/css">
    *{
    margin: 0;
    padding:0 ;
}
.main{
    background-color: hotpink;
    width: 1440px;
    height: 2000px;
    margin: 0 auto;
}     
h1{
    font-size: 72px;
    margin-left: 150px;
    padding-top: 20px;
    color: white;
    text-shadow: -2px 0 green, 0 2px green,2px 0 green,0 -2px green;
}
p{
    font-size: 24px;
    margin-left: 13%;
    margin-top: 10px;
}
input{
    width: 584px;
    height: 60px;
    border-radius: 10px;
    margin-top: 20px;
    font-size: 36px;
    text-align: center;
}
.id{
    margin-left: 100px;
}
.pass{
    margin-left: 125px;
}
.passcheck{
    margin-left: 75px;
}
.nickname{
    margin-left: 108px;
}
.name{
    margin-left: 132px;
}
select{
    width: 219px;
    height: 60px;
    border-radius: 10px;
    margin-left: 132px;
    margin-top: 20px;
    font-size: 24px;
    text-align: center;
    font-weight: bold;
    border: 1px solid black;
}
.pno1,.pno2{
    width: 370px;
}
.pno1{
    margin-left: 35px;
}
.pno2{
    margin-left: 25px;
}
.address{
    width: 800px;
    margin-left: 130px;
    
}
.address_but{
    width: 200px;
    height: 60px;
    border-radius: 10px;
    margin-left: 20px;
    font-size: 24px;
    background-color: rgb(255, 255, 255);
    box-shadow: -2px 0 rgb(0, 0, 0,0.5), 0 3px rgb(0, 0, 0,0.5),2px 0 rgb(0, 0, 0,0.5),0 -2px rgb(0, 0, 0,0.5);
}
.address_2{
    width: 1020px;
    margin-left: 178px;
}
.E_mail_1,.E_mail_2{
    width: 370px;
}
.E_mail_1{
    margin-left: 105px;
}
.email{
    font-size: 40px;
}
.pon_1,.pon_2,.pon_3{
    width: 260px;
}
.pon_1{
    margin-left: 80px;
}
.pon_but{
    width: 200px;
    height: 60px;
    border-radius:10px ;
    font-size: 24px;
}
.pon_check{
    width: 260px;
    height: 60px;
    margin-left: 70px;
}

.checkbox{
    width: 500px;
    height: 300px;
    border: 1px solid green;
    margin: 0 auto;
    margin-top: 40px;
    text-align: center;
    font-size: 24px;
    background-color: rgb(255, 255, 255,0.5);
}

.checkbox > a{
    text-decoration: none;
}

#checkbox1,#checkbox2,#checkbox3{
    width: 25px;
    height: 25px;
    margin-top: 10px;
}

#allcheckbox{
    width: 200px;
    height: 20px;
    margin-top: 10px;
    margin-left: 150px;
}
.allcheckbox{
    width: 25px;
    height: 25px;
}
span{
    text-align: center;
}
.OK{
    border: 1px solid black;
    width: 176px;
    height: 60px;
    font-size: 24px;
    float: left;
    margin-top: 60px;
    margin-left: 380px;
    text-align: center;
    background-color: white;
    border-radius:10px ;
    padding-top: 20px;
}
.OK > a{
    text-decoration: none;
}
.cancel{
    border: 1px solid black;
    width: 176px;
    height: 60px;
    font-size: 24px;
    float: right;
    margin-top: 60px;
    margin-right: 380px;
    text-align: center;
    background-color: white;
    border-radius:10px ;
    padding-top: 20px;
}
.cancel > a{
    text-decoration: none;
}
#idcheck{
    width: 200px;
    height: 60px;
    border-radius: 10px;
    font-size: 24px;
    margin-left: 50px;
    text-align: center;
}

.pass1,.passcheck1{
    font-size: 24px;
    color: red;
    width: 1000px;
    text-align: center;
    margin-left: 80px;
    margin-top: 10px;
}
.pass2,.passcheck2{
    font-size: 24px;
    color:green;
    width: 1000px;
    text-align: center;
    margin-left: 80px;
    margin-top: 10px;
}

#id1{
    font-size: 24px;
    width: 1000px;
    text-align: center;
    margin-left: 80px;
    margin-top: 10px;
}
    </style>
</head>
<body>
<div class="main">
        <h1>회원가입</h1>
        <p><span>아이디</span> <input type="text" name="id" class="id" id="id"> <button type="button" id="idcheck" name="idcheck">중복확인</button></p>
        <div id="id1"></div>
        <p><span>암호</span> <input type="password" name="pass" class="pass"></p>
        <div class="pass1"></div>
        <div class="pass2"></div>
        <p><span>암호확인</span> <input type="password" name="passcheck" class="passcheck"></p>
        <div class="passcheck1"></div>
        <div class="passcheck2"></div>
        <p><span>닉네임</span><input type="text" name="nickname" class="nickname"></p>
        <div class="nickname1"></div>
        <p><span>이름</span><input type="text" name="name" class="name"></p>
        <p><span>성별</span><select name="gender" class="gender"> 
            <option value="남" selected>남</option>
            <option value="여">여</option>
        </select></p>
        <p><span>주민등록번호</span><input type="text" name="pno1" class="pno1"> <input type="text" name="pno2" class="pno2"></p>
        <p><span>주소</span><input type="text" name="address" class="address"><button type="button" name="address_but" class="address_but">우편번호 검색</button></p>
        <p><input type="text" name="address_2" class="address_2"></p>
        <p><span>이메일</span><input type="text" name="E_mail_1" class="E_mail_1"> <span class="email">@</span> <input type="text" name="E_mail_2" class="E_mail_2"></p>
        <p><span>전화번호</span><input type="text" name="pon_1" class="pon_1"> 
            <input type="text" name="pon_2" class="pon_2"> <input type="text" name="pon_3" class="pon_3">
             <button type="button" name="pon_btu" class="pon_but">인증하기</button></p>
        <p><span>인증번호</span> <input type="text" name="pon_check" class="pon_check"></p>
        <div class="checkbox">

            <div class="checkbox1">
                <span>(필수)Leafy 이용약관 동의 <input type="checkbox" id="checkbox1"></span>
            </div>

            <a href="javascript:void(window.open('Leafy_Main.do', '_blank','width=750px, height=500px'))">Lefay 이용약관 보기</a>

            <div class="checkbox2">
                <span>(필수)개인정보 이용약관 동의 <input type="checkbox" id="checkbox2"></span>
            </div>

            <a href="javascript:void(window.open('Leafy_Privacy.do', '_blank','width=750px, height=500px'))">개인정보 이용약관 보기</a>

            <div class="checkbox3">
                <span>(선택)이벤트성 문자수신약관 동의<input type="checkbox" id="checkbox3"></span>
            </div>

            <a href="javascript:void(window.open('Leafy_Event.do', '_blank','width=750px, height=500px'))">이벤트성 문자수신약관 보기</a>

            <div id="allcheckbox">
                <span>전부동의<input type="checkbox" class="allcheckbox"></span>
            </div>
        </div>
        

       <div class="OK">
        <a href="#">가입하기</a></div> 

        <div class="cancel">
        <a href="#">취소</a></div>
    </div>

</body>
</html>