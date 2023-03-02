<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String conPath = request.getContextPath(); %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		p{text-align: center;}
		p:last-child {color:red; font-weight: bold;}
	</style>
</head>
<body>
	<form action="<%=conPath %>/3_innerObject/quiz.jsp">
		<input type="number" size="2" name="num1" value="<%=(int)(Math.random()*9+1) %>" readonly="readonly"> *
		<input type="number" size="2" name="num2" value="<%=(int)(Math.random()*9+1) %>" readonly="readonly"> =
		<input type="number" size="2" name="result">
		<p><input type="submit" value="확인"></p>
	</form>
	<p>
		${param.num1 } * ${param.num2 } = ${param.result }
		${param.result eq param.num1*param.num2 ? "는 true 정답":"는 false 오답"}
	</p>
</body>
</html>