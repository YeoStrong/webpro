<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String conPath = request.getContextPath(); %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="<%=conPath %>/3_innerObject/ex2_scope.jsp">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="password" name="pw"></p>
		<p>name <input type="text" name="name"></p>
		<p><input type="submit"></p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageVaulue");
		request.setAttribute("requestName", "requestValue"); // ★
		session.setAttribute("sessionName", "sessionValue"); // ★
		application.setAttribute("applicationName", "applicationValue");
		// response.sendRedirect("ex2_scope.jsp?id=aaa&pw=111&name=hong");
		// 자바에서 forward할 객체 생성
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("ex2_scope.jsp?id=aaa&pw=111&name=hong");
		dispatcher.forward(request, response);
	%>
	<%-- <jsp:forward page="ex2_scope.jsp">
		<jsp:param value="aaa" name="id"/>
		<jsp:param value="111" name="pw"/>
		<jsp:param value="hong" name="name"/>
	</jsp:forward> --%>
	<h3>페이지 내 attribute : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 내 attribute : <%=request.getAttribute("requestName") %></h3>
	<h3>session 내 attribute : <%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 attribute : <%=application.getAttribute("applicationName") %></h3>
	<hr>
	<h3>페이지 내 attribute : ${pageScope.pageName }</h3>
	<h3>request 내 attribute : ${requestScope.requestName }</h3>
	<h3>session 내 attribute : ${sessionScope.sessionName }</h3>
	<h3>application 내 attribute : ${applicationScope.applicationName }</h3>
	<hr>
	<h3>페이지 내 attribute : ${pageName }</h3>
	<h3>request 내 attribute : ${requestName }</h3>
	<h3>session 내 attribute : ${sessionName }</h3>
	<h3>application 내 attribute : ${applicationName }</h3>
</body>
</html>












