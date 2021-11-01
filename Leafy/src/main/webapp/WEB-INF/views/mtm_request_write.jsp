<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 글쓰기 페이지</title>
<script src=""></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="/resource/ckeditor/ckeditor.js"></script>
<script>
	$(function() {
		var count = 3;
		$("#plus").click(function() {
			if (count == 5)
				return;
			count++;
			$("form").append("<p><input type='file' name='file'></p>");
		});
		$("#minus").click(function() {
			if (count == 1)
				return;
			count--;
			$("form").children("p").last().remove();
		});

		//ckeditor 뷰 처리 부분
		CKEDITOR.replace('ckeditor', {//해당 아이디속성값으로 된 textarea에 에디터를 적용
			width : '100%',
			height : '400px',
			filebrowserImageUploadUrl : '/imageUpload.do' //여기 경로로 파일을 전달하여 업로드 시킨다.
		});

		CKEDITOR.on('dialogDefinition', function(ev) {
			var dialogName = ev.data.name;
			var dialogDefinition = ev.data.definition;

			switch (dialogName) {
			case 'image':
				dialogDefinition.removeContents('Link');
				dialogDefinition.removeContents('advanced');
				break;
			}
		});
	});
</script>
</head>
<body>
	<c:if test="${sessionScope.client == null }">
		<script>
			alert("로그인 후 이용하세요");
			location.href = "/";
		</script>
	</c:if>
	<form action="mtmWrite.do" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title" placeholder="제목을 입력하세요">
		<br> 내용
		<textarea id="ckeditor" name="content" placeholder="내용을 입력하세요"></textarea>
		<hr>
		<p>
			<input type="file" name="file">
			<button type="button" id="plus">+</button>
			<button type="button" id="minus">-</button>
		</p>
		<p>
			<input type="file" name="file">
		</p>
		<p>
			<input type="file" name="file">
		</p>
		<button>글쓰기</button>
	</form>
</body>
</html>