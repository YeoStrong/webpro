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
	<script>
		const search = function(){
			var name = frm.name.value;
			var tel = frm.tel.value;
			location.href = 'friendInputList2.jsp?name='+name+'&tel='+tel;
			// friendInputList2.jsp?name=길&tel=9999
		};
	</script>
</head>
<body>
	<form action="friendInputListPro2.jsp" method="post" name="frm">
		<table>
			<tr>
				<th>친구이름</th>
				<td><input type="text" name="name" 
							value='<%
								String name = request.getParameter("name");
								if(name!=null) out.print(name);
							%>'></td>
				<th>전화번호</th>
				<td><input type="text" name="tel" 
								value='<%
								String tel = request.getParameter("tel");
								if(tel!=null) out.print(tel);
							%>'></td>
				<td><input type="button" value="검색" onclick="search()"></td>
				<td><input type="submit" value="추가"></td>
			</tr>
		</table>
		<table>
		<tr><th>번호</th><th>친구이름</th><th>전화번호</th></tr>
		<%
			FriendDao fDao = FriendDao.getInstance();
			ArrayList<FriendDto> friendList = fDao.searchFriends(name, tel);
			if(friendList.isEmpty()){
				out.println("<tr><td colspan='3'>입력된 친구가 없습니다.</td></tr>");
			}else{
				for(int idx=0 ; idx<friendList.size() ; idx++){
					int no = friendList.get(idx).getNo();
					name = friendList.get(idx).getName();
					tel = friendList.get(idx).getTel();
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