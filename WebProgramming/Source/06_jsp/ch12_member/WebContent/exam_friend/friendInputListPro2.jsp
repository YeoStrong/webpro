<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		FriendDao fDao = FriendDao.getInstance();
		int result = fDao.addFriend(dto);
		if(result == FriendDao.SUCCESS){
	%>
		<script>
			alert('친구 추가 완료');
			location.href = 'friendInputList.jsp';
		</script>
		
	<%	}else{
				// 회원가입 실패
	%>
		<script>
			alert('친구 추가 실패. 입력 제한 확인');
			history.back();
		</script>
	<%	}%>
</body>
</html>