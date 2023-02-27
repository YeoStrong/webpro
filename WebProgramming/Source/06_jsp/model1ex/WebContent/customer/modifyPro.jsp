<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
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
	<% request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")){
			dto.setCbirth(Date.valueOf(tempBirth));
			// dto.setBirth(Timestamp.valueOf(tempBirth + "00:00:00"));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer"); // session의 pw가 필요
		String sessionCpw = null;
		if(customer!=null){
			sessionCpw = customer.getCpw();		
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionCpw.equals(oldPw)){
			// 현재 비밀번호를 맞게 입력한 경우 정보 수정 진행
			if(dto.getCpw()==null){
				// 새 비밀번호를 현 비밀번호로
				dto.setCpw(oldPw);
			}
			CustomerDao cDao = new CustomerDao();
			int result = cDao.modifyCustomer(dto);
			if(result== CustomerDao.SUCCESS){
				// 정보 수정 성공
				session.setAttribute("customer", dto); // 수정된 정보를 session 속성으로 수정
	%>
		<script>
			alert('정보수정이 완료되었습니다');
			location.href='main.jsp';
		</script>
			<%}else{
				// 정보 수정 실패
	%>		
		<script>
			alert('회원정보 수정을 실패했습니다');
			location.href = 'modify.jsp';
		</script>
	<%		}%>
	<%	}else{
			// 현재 비밀번호가 틀린 경우 정보 수정했던 페이지로 넘김
	%>
		<script>
			alert('현재 비밀번호와 일치하지 않습니다. 확인하세요.');
			history.back();
		</script>
		<%} %>
</body>
</html>