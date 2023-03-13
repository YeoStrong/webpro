<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dto.MemberDto"%>
<%@page import="com.lec.ex.dao.MemberDao"%>
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
</head>
<body>
	<h1>5. 회원 정보 수정(aaa회원 정보 수정)</h1>
	<%
		String mid = "aaa";
		MemberDao dao = new MemberDao();
		MemberDto member = dao.getMember(mid);
		out.println("<p>수정 전 : " + member + "</p>");
		member.setMname("박박박");
		member.setMemail(null);
		member.setMaddress(null);
		dao.modifyMember(member); // 회원정보 수정
		out.println("<p>수정 후 : " + member + "</p>");
	%>
	
	<h1>6. 회원 리스트(4~6)</h1>
	<% 
		ArrayList<MemberDto> members = dao.getMemberlist(4, 6);
		for(MemberDto m:members){
			out.println(m + "<br>");
		}
	%>
	<h1>7. 회원 수</h1>
	<%=dao.getMemberTotCnt()%>명
	<h1>8. 회원 탈퇴</h1>
	<%
		int result = dao.withdrawalMember(mid);
		out.println(result == MemberDao.SUCCESS? "탈퇴 완료":"탈퇴 실패");
	%>
</body>
</html>