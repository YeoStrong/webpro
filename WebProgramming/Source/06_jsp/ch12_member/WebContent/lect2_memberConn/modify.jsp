<%@page import="com.lec.member.MemberDto"%>
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
	<script>
		// submit 이벤트 추가 : pw와 pwChk, email 유효성 검증
	</script>
</head>
<body>
	<%! String id, name, phone1, phone2, phone3, gender, email, address; // =null 과 같다.
		Date birth; 
	%>
	<%
		MemberDto member = (MemberDto)session.getAttribute("member");
		if(member==null){
			response.sendRedirect("login.jsp?method=modify"); // 파라미터로 메소드를 받을수도, 안받을수도 있다
		}else{
			id = member.getId();
			name = member.getName();
			phone1 = member.getPhone1();
			phone2 = member.getPhone2();
			phone3 = member.getPhone3();
			gender = member.getGender();
			email  = member.getEmail();
			address= member.getAddress();
			birth  = member.getBirth();
		}
	%>
	<form action="modifyOk.jsp" method="post">
		<table>
			<caption>회원정보 수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="<%=id %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>현재비밀번호</th>
				<td><input type="password" name="oldPw" required="required"></td>
			</tr>
			<tr>
				<th>새로운 비밀번호</th>
				<td><input type="password" name="pw" placeholder="비밀번호 수정을 원하지 않으면 빈칸으로 남겨두세요"></td>
			</tr>
			<tr>
				<th>새로운 비밀번호 확인</th>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="<%=name%>" required="required"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<select name="phone1">
						<option></option>
						<option<%if("010".equals(phone1)){out.print(" selected='selected'");} %>>010</option> <!-- NullPointerException 때문에 equals를 사용 시 "010"을 먼저 -->
						<option<%if("02".equals(phone1)){out.print(" selected='selected'");} %>>02</option>
						<option<%if("031".equals(phone1)){out.print(" selected='selected'");} %>>031</option>
						<option<%if("032".equals(phone1)){out.print(" selected='selected'");} %>>032</option>
					</select> - 
					<input type="text" name="phone2" value='<%=phone2==null ? "" : phone2%>' size="2"> - 
					<input type="text" name="phone3" value='<%=phone3==null ? "" : phone3%>' size="2">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<%if("m".equals(gender)){ %>
					<input type="radio" name="gender" value="m" checked="checked">남
					<input type="radio" name="gender" value="f">여
					<%}else if("f".equals(gender)){ %>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f" checked="checked">여
					<%}else { %>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f">여
					<%} %>
				</td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="email" name="email" value='<%=email==null ? "" : email%>'></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="tempBirth" value='<%=birth==null ? "" : birth.toString()%>'></td>
				<%-- Date형의 경우 : birth.toString "1111-11-11"  --%>
				<%-- <td><input type="date" name="tempBirth" value='<%=birth==null ? "" : birth.toString().substring(0,10)%>'></td>
					Timestamp형의 경우 : birth.toString "1111-11-11 00:00:00"  --%>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value='<%=address!=null ? address : ""%>'></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="정보수정">
					<input type="reset" value="취소" onclick="history.back()">
					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>








