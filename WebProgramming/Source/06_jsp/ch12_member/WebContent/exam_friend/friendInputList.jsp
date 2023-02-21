<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
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
	<form action="friendInputListPro.jsp" method="post" name="join_frm">
		<table>
			<tr>
				<th>친구이름</th>
				<td><input type="text" name="name"></td>
				<th>전화번호</th>
				<td><input type="text" name="tel"></td>
				<td><input type="submit" value="추가"></td>
			</tr>
		</table>
		<table>
		<tr><th>번호</th><th>친구이름</th><th>전화번호</th></tr>
		<%
			FriendDao fDao = FriendDao.getInstance();
			ArrayList<FriendDto> friendList = fDao.friendList();
			if(friendList.isEmpty()){
				out.println("<tr><td colspan='3'>입력된 친구가 없습니다.</td></tr>");
			}else{
				for(int idx=0 ; idx<friendList.size() ; idx++){
					int no = friendList.get(idx).getNo();
					String name = friendList.get(idx).getName();
					String tel = friendList.get(idx).getTel();
					out.println("<tr><td>" + no + "</td>");
					out.println("<td>" + name + "</td>");
					out.println("<td>" + (tel==null ? "":tel) + "</td></tr>");
				}				
			}
		%>
	</table>
	</form>
</body>
</html>