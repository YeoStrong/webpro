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
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
	<script>
		window.onload = function(){
			document.querySelector('form').onsubmit = function(){
				var cpw = document.getElementById('cpw');
				var cpwChk = document.getElementById('cpwChk');
				var cemail = document.getElementById('cemail');
				if(cpw.value != cpwChk.value){
					alert('비밀번호를 확인하세요');
					cpw.value = '';
					cpwChk.value = '';
					cpw.focus();
					return false;
				}
			};
		};
	</script>
</head>
<body>
	<%! String cid, cpw, cname, ctel, cemail, caddress, cgender; // =null 과 같다.
		Date cbirth, rdate; 
	%>
	<%
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer==null){
			response.sendRedirect("login.jsp?method=modify");
		}else{
			cid = customer.getCid();
			cpw = customer.getCpw();
			cname = customer.getCname();
			ctel = customer.getCtel();
			cemail = customer.getCemail();
			caddress = customer.getCaddress();
			cbirth = customer.getCbirth();
			cgender = customer.getCgender();
		}
	
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">회원가입</div>
		<form action="modifyPro.jsp" method="post">
			<input type="hidden" name="hiddenParam" value="xx">
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" class="cid" value="<%=cid %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th><label for="cpw">현재 비밀번호</label></th>
					<td><input type="password" name="oldPw" id="oldPw" class="oldPw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpwChk">새 비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw" class="cpw" placeholder="비밀번호 수정을 원하지 않으면 빈칸으로 남겨두세요"></td>
				</tr>
				<tr>
					<th><label for="cpwChk">새 비밀번호확인</label></th>
					<td><input type="password" name="cpwChk" id="cpwChk" class="cpwChk"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname" class="cname" value="<%=cname%>"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화번호</label></th>
					<td><input type="text" name="ctel" id="ctel" class="ctel" value='<%=ctel==null ? "" : ctel%>'></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="text" name="cemail" id="cemail" class="cemail" value='<%=cemail==null ? "" : cemail%>'></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" class="caddress" value='<%=caddress==null ? "" : caddress%>'></td>
				</tr>
				<tr>
					<th><label for="cbirth">생년월일</label></th>
					<td><input type="date" name="tempBirth" id="cbirth" class="cbirth" value='<%=cbirth==null ? "" : cbirth.toString()%>'></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
					<%if("m".equals(cgender)){ %>
					<input type="radio" name="cgender" value="m" checked="checked">남
					<input type="radio" name="cgender" value="f">여
					<%}else if("f".equals(cgender)){ %>
					<input type="radio" name="cgender" value="m">남
					<input type="radio" name="cgender" value="f" checked="checked">여
					<%}else { %>
					<input type="radio" name="cgender" value="m">남
					<input type="radio" name="cgender" value="f">여
					<%} %>
					</td>
				</tr>
				<tr>
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="정보수정" class="joinBtn_style">
						<input type="reset" value="취소" class="joinBtn_style" onclick="history.back()">
						<input type="button" value="로그아웃" class="joinBtn_style" 
											onclick="location.href='<%=conPath%>/customer/logout.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
	<%-- <%@ include file="footer.jsp" %> --%>
</body>
</html>