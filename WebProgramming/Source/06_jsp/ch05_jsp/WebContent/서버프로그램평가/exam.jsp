<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>동전이 있는 곳을 맞춰봐</title>
	<link href="<%=conPath %>/css/exam.css" rel="stylesheet">
</head>
<body>
	<form action="examPro.jsp" method="get">
		<button name="no" value="1">1번</button>
		<button name="no" value="2">2번</button>
		<button name="no" value="3">3번</button>
	</form>
	<div id="msg">
		<%
			String msg = request.getParameter("msg");
			if(msg!=null){
				out.println(msg);
			}
		%>
	</div>
</body>
</html>