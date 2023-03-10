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
</head>
<body>
	<c:if test="${member == null }">
		<h1>로그인 상태가 아닙니다</h1>
		<hr>
		<input type="button" value="로그인" class="btn" onclick="location.href='${conPath}/loginView.do'">
		<input type="button" value="회원가입" class="btn" onclick="location.href='${conPath}/joinView.do'">
	</c:if>
	<c:if test="${member != null }">
		<h1>안녕하세요, ${member.mname }님</h1>
		<hr>
		<input type="button" value="로그아웃" class="btn" onclick="location.href='${conPath}/logout.do'">
	</c:if>
</body>
</html>