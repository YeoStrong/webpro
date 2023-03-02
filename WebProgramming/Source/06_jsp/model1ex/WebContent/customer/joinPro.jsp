<%@page import="com.lec.dao.CustomerDao"%>
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
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth"); // "" or "1111-11-11"
		if(!tempBirth.equals("")){
			dto.setCbirth(Date.valueOf(tempBirth));
			// dto의 birth가 Timestamp형이라면 : dto.setBirth(Timestamp.valueOf(tempBirth + "00:00:00"));
		}
		CustomerDao cDao = new CustomerDao();
		int result = cDao.confirmId(dto.getCid());
		if(result == CustomerDao.CUSTOMER_NONEXISTENT){
			result = cDao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				session.setAttribute("cid", dto.getCid());
	
	%>
		<script>
			alert('회원가입 감사합니다');
			location.href = 'loginFrom.jsp';
		</script>
		
	<%		}else{
	%>
		<script>
			alert('회원가입을 실패했습니다. 길이 제한이 있습니다');
			history.back();
		</script>
	<%		}%>
	<%	}else{
	%>
		<script>
			alert('중복된 ID입니다. 다른 아이디를 사용하세요');
			history.back();
		</script>	
		<%} %>	
</body>
</html>