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
	<c:if test="${session.member eq 1}">
		<script>alert('로그인 성공');</script>
	</c:if>
	<c:if test="${session.member eq 0}">
		<script>
			alert('아이디나 비밀번호를 확인해주세요');
			history.back();
		</script>
	</c:if>
	<c:if test="${joinResult eq 1}">
		<script>alert('회원가입에 성공했습니다');</script>
	</c:if>
	<c:if test="${joinResult eq 0}">
		<script>
			alert('회원가입에 실패했습니다');
			history.back();
		</script>
	</c:if>
	<form action="${conPath }/login.do" method="post">
		<table>
			<tr><td>아이디</td>
			<td><input type="text" name="mid" required="required" autofocus="autofocus"
			value="${param.mid }">
			</td>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="mpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" class="btn">
					<input type="button" value="회원가입"  class="btn" onclick="location.href='${conPath}/joinView.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>