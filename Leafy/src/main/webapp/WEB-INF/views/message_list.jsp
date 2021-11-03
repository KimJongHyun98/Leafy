<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        height: 2000px;
        
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
        <div class = "msg-container">
        	<div class="messaging">
        		<div class="inbox_msg">
        		<!-- 메세지 목록 영역 -->
        			<div class="inbox_people">
        				<div class="headind_srch">
        					<div class="recent_heading">
        						<h4>Recent</h4>
        					</div>
        					<!-- 메세지 검색 -->
        					<div class="srch_bar">
        						<div class="stylish-input-group">
        							<input type="text" class="search-bar" placeholder="Search">
        							<span class="input-group-addon">
        								<button type="button"><i class="fa fa-search" aria-hidden="true"></i></button>
        							</span>
        						</div>
        					</div>
        				</div>
        				
        				<!-- 메세지 리스트 -->
        				<div class="inbox_chat">
        				
        				</div>
        			</div>
        		<!-- 메세지 내용 영역 -->
        			<div class="mesgs">
        				<!-- 메세지 내용 목록 -->
        				<div class="msg_history" name="contentList">
        					<!-- 메세지 내용이 올 자리 -->
        				</div>
        				<div class="send_message">
        				</div>
        				<!-- 메세지 입력란이 올자리 -->
        			</div>
        		</div>
        	</div>
      	</div>
      	<script>
      	// 처음 메세지 리스트를 가져온다.
      	const FirstMessageList = function(){
      		$.ajax({
      			url:"message_ajax_list.do",
      			method:"get",
      			data:{
      			},
      			success:function(data){
      				console.log("메세지 리스트 리로드 성공");
      				
      				$('.inbac_chat').html(data);
      				
      				//메세지 리스트중 하나를 클릭했을때
      				$('.chat_list').on('click', function(){
      					
      					let room = $(this).attr('room');
      					let other_nick = $(this).attr('other-nick');
      					
      					//선택한 메세지 빼고 나머지는 active 효과 해제하기
      					$('.chat_list_box').not('.chat_list_box.chat_list_box' + room).removeClass('active_chat');
      					//선택한 메세지만 active 효과 주기
      					$('chat_list_box' + room).addClass('active_chat');
      					
      					let send_msg = "";
      					send_msg += "<div class = 'type_msg'>";
      					send_msg += "	<div class = 'input_msg_write row'>";
      					send_msg += "		<div class='col-11'";
      					send_msg += "			<input type='text' class='write_msg form-control' placeholder='메세지를 입력...' />	";
      					send_msg += "		</div>";
      					send_msg += "		<div class='col-1'>";
      					send_msg += "			<button class='msg_send_btn' type='button><i class='fa fa-paper-plane-o' aria-hidden='true'></i></button>";
      					send_msg += "		</div>";
      					send_msg += "	</div>";
      					send_msg += "</div>";
      					
      					//메세지 입력, 전송 칸을 보인다.
      					$('.send_message').html(send_msg);
      					
      					//메세지 전송 버튼을 눌렀을 때
      					$('.msg_send_btn').on('click', function(){
      						
      						//메세지 전송 함수 호출
      						SendMessage(room, other_nick);
      						
      						//전송 버튼을 누르면 메세지 리스트가 리로드 되면서 현재 열린 메세지의 선택됨 표시가 사라진다.
      						// 이걸 해결하기 위해 메세지 전송 버튼을 누르고 메세지 리스트가 리로드 되면 메세지 리스트의 첫번째 메세지(현재 열린 메세지)가 선택됨 표시 되도록 한다.
      						//$('.chat_list_box:first').addClass('active_chat');
      					});
      					
      					//메세지 내용을 불러오는 함수 호출
      					MessageContentList(room);
      					
      				});
      			}
      		});
      	};
      	
      	//메세지 리스트를 다시 가져온다.
      	const MessageList = function(){
      		$.ajax({
      			url:"message_ajax_list.do",
      			method:"get",
      			data:{
      			},
      			success:function(data){
      				console.log("메세지 리스트 리로드 성공");
      				
      				$('.inbox_chat').html(data)
      				
      				// 메세지 리스트중 하나를 클릭했을 때
      				$('.chat_list').on('click', function(){
      					let room = $(this).attr('room');
      					let other_nick = $(this).attr('other-nick');
      					
      					//선택한 메세지 빼고 나머지는 active 효과 해제하기
      					$('.chat_list_box').not('.chat_list_box.chat_list_box' + room).removeClass('active_chat');
      					//선택한 메세지만 active 효과 주기
      					$('chat_list_box' + room).addClass('active_chat');
      					
      					let send_msg = "";
      					send_msg += "<div class = 'type_msg'>";
      					send_msg += "	<div class = 'input_msg_write row'>";
      					send_msg += "		<div class='col-11'";
      					send_msg += "			<input type='text' class='write_msg form-control' placeholder='메세지를 입력...' />	";
      					send_msg += "		</div>";
      					send_msg += "		<div class='col-1'>";
      					send_msg += "			<button class='msg_send_btn' type='button><i class='fa fa-paper-plane-o' aria-hidden='true'></i></button>";
      					send_msg += "		</div>";
      					send_msg += "	</div>";
      					send_msg += "</div>";
      					
      					//메세지 입력, 전송 칸을 보인다.
      					$('.send_message').html(send_msg);
      					
      					//메세지 전송 버튼을 눌렀을 때
      					$('.msg_send_btn').on('click', function(){
      						
      						//메세지 전송 함수 호출
      						SendMessage(room, other_nick);
      						
      						//전송 버튼을 누르면 메세지 리스트가 리로드 되면서 현재 열린 메세지의 선택됨 표시가 사라진다.
      						// 이걸 해결하기 위해 메세지 전송 버튼을 누르고 메세지 리스트가 리로드 되면 메세지 리스트의 첫번째 메세지(현재 열린 메세지)가 선택됨 표시 되도록 한다.
      						//$('.chat_list_box:first').addClass('active_chat');
      					});
      					
      					//메세지 내용을 불러오는 함수 호출
      					MessageContentList(room);
      				});
      				//전송 버튼을 누르면 메세지 리스트가 리로드 되면서 현재 열린 메세지의 선택됨 표시가 사라진다.
					// 이걸 해결하기 위해 메세지 전송 버튼을 누르고 메세지 리스트가 리로드 되면 메세지 리스트의 첫번째 메세지(현재 열린 메세지)가 선택됨 표시 되도록 한다.
					$('.chat_list_box:first').addClass('active_chat');
      			}
      		});
      	};
      	
      	// 메세지 내용을 가져온다.
      	// 읽지 않은 메세지들을 읽음으로 바꾼다.
      	const MessageContentList = function(room){
      		
      		$.ajax({
      			url:"message_content_list.do",
      			method:"get",
      			data:{
      				room : room,
      			},
      			success:function(data){
      				console.log("메세지 내용 가져오기 성공");
      				
      				//메세지 내용을 html에 넣는다
      				$('.msg_history').html(data);
      				
      				//이 함수로 메세지 내용을 가져올때마다 스크롤을 맨아래로 가게 한다.
      				$(".msg_history").scrollTop($(".msg_history")[0].scrollHeight);
      			},
      			error : function(){
      				alert('서버 에러');
      			}
      		});
      		
      		$('.unread'+room).empty();
      	};
      	
      	//메세지를 전송하는 함수
      	const SendMessage = function(room, other_nick){
      		
      		let content = $('.write_msg').val();
      		
      		content = content.trim();
      		
      		if(content == ""){
      			alert("메세지를 입력하세요!");
      		}else{
      			$.ajax({
      				url:"message_send_inlist.do",
      				method:"get",
      				data:{
      					room : room,
      					other_nick: other_nick,
      					content : content
      				},
      				success:function(data){
      					console.log("메세지 전송 성공");
      					
      					//메세지 입력칸 비우기
      					$('.write_msg').val("");
      					
      					//메세지 내용 리로드
      					MessageContentList(room);
      					
      					//메세지 리스트 리로드
      					MessageList();
      					
      				},
      				error : function(){
      					alert('서버 에러');
      				}
      			});
      		}
      	};
      	
      	$(document).ready(function(){
      		// 메세지 리스트 리로드
      		FirstMessageList();
      	});
      	</script>
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