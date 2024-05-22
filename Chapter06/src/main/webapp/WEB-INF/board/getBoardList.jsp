<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
	.container{
	text-align:center;
	}
	.container table {
	margin:0 auto;
	}
</style>
<title>Board</title>
</head>
<body>
	<div>
	<h1>게시글 목록</h1>
	<table>
		<tr bgcolor="orange">
			<th width="100">번호</th>
			<th width="200">제목</th>
			<th width="150">작성자</th>
			<th width="150">등록일</th>
			<th width="100">조회수</th>
		</tr>
		<c:forEach var="board" items="${ boardList }">
		<tr>
			<td>${ board.seq }</td>
			<td>
			<a href="getBoard?seq=${ board.seq }">${ board.title }</a>
			</td>
			<td>${ board.writer }</td>
			<td><fmt:formatDate value="${ board.createDate }" pattern="yyyy-MM-dd"/></td>
			<td>${ board.cnt }</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertBoard">새글 등록</a>
	</div>
</body>
</html>