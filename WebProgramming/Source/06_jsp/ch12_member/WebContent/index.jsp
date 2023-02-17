<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:forward page="lect1_member/main.jsp"/> conPath설정 필요 --%>
	<%
		response.sendRedirect("lect1_member/main.jsp");
	%>
</body>
</html>