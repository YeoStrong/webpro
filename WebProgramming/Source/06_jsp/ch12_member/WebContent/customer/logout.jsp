<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
	<script>
		var timer = setTimeout(function(){
			location.href="main.jsp"
		}, 3000);
	</script>
</head>
<body>
	<%session.invalidate(); %>
	<jsp:include page="../customer/header.jsp"/>
	<div id="mainForm_wrap">
		<h2>로그아웃 되었습니다.<br>잠시 후 페이지 이동이 있겠습니다</h2>
	</div>
	<jsp:include page="../customer/footer.jsp"/>
</body>
</html>