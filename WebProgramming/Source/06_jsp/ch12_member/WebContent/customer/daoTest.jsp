<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
	<h1>테스트 페이지</h1>
	<%
		CustomerDao dao = new CustomerDao();
		String id = "aaa";
		String pw = "111";
		int result = dao.confirmId(id);
		if(result == CustomerDao.CUSTOMER_EXISTENT){
			out.println("<h2>1. confirmId결과 : " + id + "는 이미 존재하는 아이디입니다. 회원가입이 불가합니다.</h2>");
		}else{
			out.println("<h2>1. confirmId결과 : " + id + "는 사용 가능한 아이디입니다. 회원가입이 가능합니다.</h2>");
		}
		
		 CustomerDto dto = new CustomerDto(id, "111", "김길동", null, null, null, null, "m", null);
		 /* result = dao.joinCustomer(dto);
		 if(result == CustomerDao.SUCCESS){
			out.println("<h2>2. join 결과 : 회원가입 성공</h2>");
		}else{
			out.println("<h2>2. join 결과 : 회원가입 실패</h2>");
		} */
		
		result = dao.loginCheck(id, pw);
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.println("<h2>3. loginCheck 결과 : 로그인 성공</h2>");
		}else{
			out.println("<h2>3. loginCheck 결과 : 로그인 실패. 올바르지 않은 아이디입니다.</h2>");	
		}
		
		out.print("<h2>4. id로 dto가져오기</h2>");
		dto = dao.getCustomer("aaa");
		out.println("<h2>aaa 아이디인 customer : " + dto + "</h2><br>");
		dto = dao.getCustomer("qqq");
		out.println("<h2>qqq 아이디인 customer : " + dto + "</h2><br>");
		
		out.println("<h2>5. 회원정보 수정</h2>");
		dto = new CustomerDto("aaa", "111", "김정은", null, null, null, null, null, null);
		result = dao.modifyCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			out.println("수정완료<br>");
			out.println("<h2>db의 수정된 데이터 : " + dao.getCustomer(dto.getCid()) + "</h2><br>");
		}else{
			out.println("<h2>" + dto.getCid() + "는 없는 아이디입니다.</h2><br>");
		}
	%>
</body>
</html>