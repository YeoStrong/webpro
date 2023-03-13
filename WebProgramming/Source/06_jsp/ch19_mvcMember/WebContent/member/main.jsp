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
	<title>Insert title here</title>
	<style>
		h1, p{text-align: center;}
		p{margin-top: 30px;}
	</style>
</head>
<body>
	<c:if test="${not empty loginErrorMsg }">
		<script>
			alert('${loginErrorMsg}');
			history.back();
			// location.href ='${conPath}/loginView.do';
		</script>         
	</c:if>
	<c:if test="${not empty modifyResult }">
		<script>alert('${modifyResult}');</script>
	</c:if>
	<c:if test="${not empty modifyErrorMsg }">
		<script>
			alert('${modifyErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty withdrawalResult }">
		<script>alert('${withdrawalResult}');</script>
	</c:if>
	<c:if test="${empty member }"> <!-- 로그인 전 화면 -->
		<h1>로그인 상태가 아닙니다</h1>
		<hr>
		<p>
			<input type="button" value="로그인" class="btn" onclick="location.href='${conPath}/loginView.do'">
			<input type="button" value="회원가입" class="btn" onclick="location.href='${conPath}/joinView.do'">
			<input type="button" value="전체 회원 보기" class="btn" onclick="location.href='${conPath}/allView.do'">
		</p>
	</c:if>
	<c:if test="${not empty member }">
		<h1>안녕하세요, ${member.mname }님(${member.mid })</h1>
		<hr>
		<p>
			<input type="button" value="정보 수정" class="btn" onclick="location.href='${conPath}/modifyView.do'">
			<input type="button" value="로그아웃" class="btn" onclick="location.href='${conPath}/logout.do'">
			<input type="button" value="전체 회원 보기" class="btn" onclick="location.href='${conPath}/allView.do'">
		</p>
	</c:if>
</body>
</html>