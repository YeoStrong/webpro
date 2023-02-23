<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
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
		int num=0, ref=0, re_step=0, re_indent=0;
		BoardDto dto = new BoardDto(); // 답변글을 위해 들어왔다면 dto에 원글에 대한 정보를 저장할 예정
		if(request.getParameter("num")!=null){
			// 답변글을 쓰려고 온 경우 dto에 원글의 정보를 넣는다
			num = Integer.parseInt(request.getParameter("num"));
			BoardDao bDao = BoardDao.getInstance();
			dto = bDao.getBoardOneLine(num); // 원글의 정보
			ref 	  = dto.getRef(); // 원글의 ref
			re_step   = dto.getRe_step(); // 원글의 re_step
			re_indent = dto.getRe_indent(); // 원글의 re_indent
			System.out.println("writeForm(답변글쓰기)에서 넘어온 원글의 ref : " + ref);
			System.out.println("writeForm(답변글쓰기)에서 넘어온 원글의 re_step : " + re_step);
			System.out.println("writeForm(답변글쓰기)에서 넘어온 원글의 re_indent : " + re_indent);
		}
	%>
	<form action="<%=conPath%>/board/writePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="num" value="<%=num %>">
		<input type="hidden" name="ref" value="<%=ref %>">
		<input type="hidden" name="re_step" value="<%=re_step %>">
		<input type="hidden" name="re_indent" value="<%=re_indent %>">
		<table>
			<caption><%=num==0? "게시판":num+"번 글에 대한 답변" %></caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="subject" required="required" 
				value="<%
						if(dto.getSubject()!=null){
							out.print("답 : " + dto.getSubject());
						}
				%>"></td>
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
					<input type="submit" value="<%= num==0 ? "글쓰기":"답글쓰기"%>" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" 
					onclick="location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>