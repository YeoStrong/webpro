<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- modify.jsp에서 전달받은 파라미터 : 
	id, pw(바꾸고싶은 새 비번), name, phone1, phone2, phone3, gender, email, address (MemberDto)
	tempBirth, oldPw(현 비번) (dto에 없는 파라미터 변수)
	--%>
	<% request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")){
			dto.setBirth(Date.valueOf(tempBirth));
			// dto.setBirth(Timestamp.valueOf(tempBirth + "00:00:00"));
		}
		MemberDto member = (MemberDto)session.getAttribute("member"); // session의 pw가 필요
		String sessionPw = null;
		if(member!=null){
			sessionPw = member.getPw(); // session의 member의 pw(로그인에 성공한 진짜 현재 pw)			
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			// 현재 비밀번호를 맞게 입력한 경우 정보 수정 진행
			if(dto.getPw()==null){
				// 새 비밀번호를 현 비밀번호로
				dto.setPw(oldPw);
			}
			MemberDaoConn mDao = new MemberDaoConn();
			int result = mDao.modifyMember(dto);
			if(result== MemberDaoConn.SUCCESS){
				// 정보 수정 성공
				session.setAttribute("member", dto); // 수정된 정보를 session 속성으로 수정
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