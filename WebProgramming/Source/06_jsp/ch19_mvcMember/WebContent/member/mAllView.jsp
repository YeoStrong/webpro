<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
	<style>
		h1, p{text-align: center;}
		p{margin-top: 30px;}
	</style>
</head>
<body>
	<table>
		<caption>전체 회원 보기</caption>
		<tr>
			<c:forEach var="dto" items="${members }">
				<td>
					<img src="${conPath }/memberPhotoUp/${dto.mphoto}" 
						alt="${dto.mname }" width="120">
					<p>
						${dto.mname }<br>
						(${dto.mid })
					</p>
				</td>
			</c:forEach>
		</tr>
	</table>
	<p class="paging">
		<a href="${conPath }/allView.do?pageNum=1">&lt;&lt;</a> <!-- pageNum을 안써도 어차피 1 -->
		&nbsp; &nbsp; &nbsp;
		<c:if test="${BLOCKSIZE < startPage }">
			<a href="${conPath }/allView.do?pageNum=${startPage-1}">&lt;</a>			
		</c:if>
		<c:if test="${BLOCKSIZE >= startPage }">
			&lt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				<b> [ ${i } ]</b>
			</c:if>
			<c:if test="${i != pageNum }">
				<a href="${conPath }/allView.do?pageNum=${i}">[ ${i } ]</a>
			</c:if>
		</c:forEach>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/allView.do?pageNum=${endPage+1}">&gt;</a>
		</c:if>
		<c:if test="${endPage == pageCnt }">
			&gt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<a href="${conPath }/allView.do?pageNum=${pageCnt}">&gt;&gt;</a>
	</p>
	<p><button onclick="location='${conPath}/main.do'">MAIN</button></p>
</body>
</html>







