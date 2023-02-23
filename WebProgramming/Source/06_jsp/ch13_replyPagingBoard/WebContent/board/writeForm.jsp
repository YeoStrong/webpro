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
	<%
		/* pageNum 추가 */
		String pageNum = request.getParameter("pageNum");
	%>
	<form action="<%=conPath%>/board/writePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<table>
			<caption>게시판</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="subject" required="required"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="20" cols="" name="content"></textarea> <!-- cols는 css에서 지정해서 고정돼있음, 여는태그 다음에 들어가는게 실제로 들어가기 때문에 뭘 넣어놓을게 아니라면 서로 붙여놔야한다.\n도 당연히 입력됨 -->
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" 
					onclick="location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>