<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/exam.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String noStr = null;
		noStr = request.getParameter("no");
		if(noStr==null){
			response.sendRedirect("exam.jsp");
		}
		if(noStr!=null){
			int no = Integer.parseInt(request.getParameter("no"));
			int ranNo = (int)(Math.random()*3+1);
			if(no!=ranNo){
				String msg = "<h2>Wrong! Try Again!</h2><br><h2>("+ no +"은(는) 아니고 정답은 " + ranNo + ")</h2>";
				msg = URLEncoder.encode(msg, "utf-8");
				response.sendRedirect("exam.jsp?msg=" + msg);
			}
	%>
	<h2>정답입니다</h2>
	<p>동전이 있던 곳은 <%=no %></p>
	<button onclick="location.href='exam.jsp'">다시 도전</button>
</body>
</html>
	<%
        }
	%>