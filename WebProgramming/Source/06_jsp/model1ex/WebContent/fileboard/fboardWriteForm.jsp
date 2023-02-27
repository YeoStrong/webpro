<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/content.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div  id="content_form">
		<form action="bookRegisterPro.jsp" method="post" enctype="multipart/form-data">
			<table>
				<caption>글 등 록</caption>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="cid" maxlength="16" value="<%=out.print((String)session.getAttribute("cid")) %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="fsubject" maxlength="33" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th>대표 이미지</th>
					<td><input type="file" name="ffilename"></td>
				</tr>
				<tr>
					<th>책 소개</th>
					<td><textarea rows="5" name="bcontent"></textarea></td>
				</tr>
				<tr>
					<th>할인율</th>
					<td><input type="number" name="bdiscount" min="0" max="100" value="0" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="책 등록" class="btn"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>