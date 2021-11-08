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

</script>
<style>
* {
	margin: 0;
	padding: 0;
}

nav {
	width: 100%;
	border-bottom: 1px solid #639578;
}

#search_bar {
	display: flex;
	justify-content: center;
	margin-top: 20px;
	margin-bottom: 20px;
}

section {
	position: relative;
	margin: 0px auto;
	width: 1200px;
	text-align: center;
	padding-top: 40px;
}

#product_list {
	display: inline-block;
	width: 100%;
	height: 600px;
	overflow: auto;
	overflow-x: hidden;
}

#product_list table {
	table-layout: fixed;
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
}

#product_list table thead {
	position: absolute;
	top: 0;
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
</style>
</head>
<body>
	<header> </header>
	<nav>
		<div id="search_bar">
			<form action="price_search.do">
				<input type="text" name="search" placeholder="검색어 입력">
				<button>검색</button>
			</form>
		</div>
	</nav>
	<section>
		<div id="product_list">
			<table>
				<thead>
					<tr>
						<th>제품 이미지</th>
						<th>제품명</th>
						<th>최저가격</th>
						<th>구매처</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${requestScope.searchList }">
						<tr>
							<td><img alt="제품사진" src="${list.image }"></td>
							<td><a href="${list.link }">${list.title }</a></td>
							<td>${list.lprice } 원</td>
							<td>${list.mallName }</td>
							<form action="seeMore.do">
							<td><button id= "btn_seeMore">더보기 ▽</button></td>
							<input type="hidden" name="link" value="${list.link }">
							</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<footer></footer>
</body>
</html>