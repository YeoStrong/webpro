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
	<c:if test="${empty member }">
		<script>location.href='${conPath}/loginView.do';</script>
	</c:if>
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="dbMpw" value="${member.mpw }">
		<input type="hidden" name="dbMphoto" value="${member.mphoto }">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" value="${member.mid }" readonly="readonly" size="3"></td>
				<td rowspan="4">
					<img src="${conPath }/memberPhotoUp/${member.mphoto}" alt="${member.mname } 사진">
				</td>
			</tr>
			<tr>
				<th>현재 비밀번호</th>
				<td><input type="password" name="oldMpw" required="required" size="3"></td>
			</tr>
			<tr>
				<th>새 비밀번호</th>
				<td><input type="password" name="mpw" size="3"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" value="${member.mname }" required="required" size="3"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td colspan="2"><input type="email" name="memail" value="${member.memail }"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td colspan="2"><input type="file" name="mphoto" ></td> <!-- name은 사실 뭐든 상관 없음(따로 받기 때문에) -->
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="2"><input type="text" name="maddress" value="${member.maddress }"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td colspan="2"><input type="date" name="mbirth" value="${member.mbirth }"></td>
			</tr>
			<tr>
				<td colspan="3">
				<input type="submit" value="정보 수정" class="btn">
				<input type="reset" value="초기화" class="btn">
				<input type="reset" value="이전" onclick="history.back()" class="btn">
				<input type="button" value="회원 탈퇴" onclick="location.href='${conPath}/withdrawal.do'" class="btn">				
			</tr>
		</table>
	</form>
</body>
</html>
















