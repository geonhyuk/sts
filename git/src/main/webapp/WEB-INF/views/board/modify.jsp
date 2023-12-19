<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/modify" method="post">
		<input type="text" value="${vo.title }" name="title">
		<textarea rows="3" cols="50" name="content">${vo.content }</textarea>
		<input type="hidden" name="bno" value="${vo.bno }">
		<input type="submit" value="버튼">
	</form>
</body>
</html>