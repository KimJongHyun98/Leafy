<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	
	제목 : ${requestScope.mrmRequest.mtm_request_title }<br>
	작성자 : ${requestScope.mrmRequest.id}, 작성일 : ${requestScope.mrmRequest.mtm_request_date}<br>
	답변 상태 : ${requestScope.mrmRequest.mtm_request_status}, 
	<br>
	내용<br> ${requestScope.mrmRequest.content}
	<hr>
	첨부파일 목록<br>
	<!-- 파일 링크 출력 -->
	<c:forEach var="f" items="${requestScope.mtmflist }">
		첨부파일 : <a href="fileDownload.do?fno=${f.fno }">${f.originFileName }</a><br>
	</c:forEach>
	<hr>
	<button type="button" class=".btnBack">뒤로가기</button>
	<c:if test="${requestScope.mrmRequest.id == sessionScope.client.id }">
		<button type="button" class="btnUpdate">수정</button>
		<button type="button" class="btnDelete">삭제</button>
	</c:if>
</body>
</html>








