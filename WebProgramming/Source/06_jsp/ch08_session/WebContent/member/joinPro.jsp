<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		Date birthDate = null;
		Timestamp birthTimestamp = null;
		if(birth!=null && !birth.equals("")){
			birthDate = Date.valueOf(birth);
			birthTimestamp = Timestamp.valueOf(birth + " 00:00:00");
		}
		String[] hobby = request.getParameterValues("hobby");
		String hobbyresult="";
		if(hobby!=null) {
			for(int i=0 ; i<hobby.length ; i++)
				if(i==hobby.length-1)
					hobbyresult += hobby[i];
				else
					hobbyresult += hobby[i] + ", ";
		}else {
			hobbyresult ="없음";
		}
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		String mailresult = "";
		if(mailSend!=null) {
			mailresult = Arrays.toString(mailSend);
		}else {
			mailresult ="모두 거부";
		}
		session.setAttribute("id", id);
		
	%>
	<jsp:include page="../member/header.jsp"/>
	<div id='joinForm_wrap'>
		<div id='join_title'>회원가입정보</div>
		<h2>이름 : <%= name %></h2>
		<h2>아이디 : <%= id %></h2>
		<h2>비번 : <%= pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\{}\\[\\]:;\"'?/<>,\\.]", "*") %></h2>
		<h2>생년월일 : <%= birthTimestamp!=null ? birthTimestamp : "" %></h2>
		<h2>취미 : <%= hobbyresult %> </h2>
		<h2>성별 : <%= gender %></h2>
		<h2>이메일 : <%= email %></h2>
		<h2>메일수신동의 : <%= mailresult %></h2>
		<h2>가입일 : <%=new Date(System.currentTimeMillis()) %></h2>
		<h2>가입IP : <%=request.getRemoteAddr() %></h2>
		<input type="button" value="로그인" class="joinBtn_style" 
											onclick="location.href='<%=conPath%>/member/login.jsp'">
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>