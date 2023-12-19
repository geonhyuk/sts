<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
	    $(document).ready(function() {
	        var alertValue = "${alert}";
	        console.log(alertValue)
	        if (alertValue) {
	            alert(alertValue + "글 등록!");
	        }
	    });
    
        function del(bno) {
            $.ajax({
                type: "POST",
                url: "/board/remove",
                data: {bno: bno},
                success: function(data) {
                	window.location.href = "/board/list";
                },
                error: function(error) {
                    console.error("AJAX 요청 실패:", error);
                    // 필요하면 에러 처리를 수행합니다.
                }
            });
        }
        
    </script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>regdate</th>
		</tr>
		<c:forEach var="vo" items="${boardList }">
			<tr>
				<td><c:out value="${vo.bno}"/></td>
				<td><a href="/board/modify?bno=${vo.bno }"><c:out value="${vo.title}"/></a></td>
				<td><a href="#" class="modify-link" data-url="/board/modify?bno=${vo.bno }"><c:out value="${vo.title}" /></a></td>
				<td><c:out value="${vo.content}"/></td>
				<td><c:out value="${vo.writer}"/></td>
				<td><c:out value="${vo.regdate}"/></td>
				<td><input type="button" value="삭제" onclick="del(${vo.bno})"></td>
				<!-- <td><a href="/board/remove?bno=${vo.bno }">삭제</a>-->
			</tr>
		</c:forEach>
	</table>
	<a href="/board/register">글쓰기</a>
	
</body>
</html>