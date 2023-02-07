<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% // http://localhost:8090/ch02_semiJSP/5_gugudanSuOut.jsp?su=4
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h2><%=su1 %>단부터 <%=su2 %>단까지 구구단 출력</h2>
	<%for(int j=1 ; j<10 ; j++){%>
		<%for(int i=su1 ; i<=su2 ; i++){ %>
			<%=i + " * " + j + " = " + (i*j) + "    " %>
		<%} %>
		<br/>
	<%} %>
	
</body>
</html>