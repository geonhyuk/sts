<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/register" method="post">
		<label>Title</label>
		<input type="text" name="title">
		
		<label>Content</label>
		<textarea rows="3" cols="50" name="content"></textarea>
		
		<label>Writer</label>
		<input type="text" name="writer">
		
		<input type="submit" > 
		
	</form>
</body>
</html>