<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		document.querySelector('form').onsubmit = function(){
			var num = document.querySelector()
		};
	};
</script>
</head>
<body>
	<%
		String num = request.getParameter("num"); // "  5"
		if(num!=null){
			num = num.trim();
		}
	%>
	<fieldset>
		<legend>숫자 입력</legend>
		<form action="" method="get">
			자연수 <input type="text" name="num" value="<%
													if(num!=null){
														out.print(num);
													}
													%>">
			<input type="submit" value="누적">
		</form>
	</fieldset>
	<%
		if(num!=null){
			int n = Integer.parseInt(num);
			int total = 0;
			for(int i=1 ; i<=n ; i++){
				total += i;
			}
			out.println("<h2>1부터 " + n + "까지의 누적합은 " + total + "입니다</h2>");
		}
	%>
</body>
</html>