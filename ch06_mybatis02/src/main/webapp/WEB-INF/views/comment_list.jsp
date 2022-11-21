<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr> <th>주석 번호</th> <th>작성자</th> <th>내용</th> <th>작성일</th> </tr>
<c:forEach var="item" items="${comments}">
	<tr>
		<td>${item.commentNo}</td>
		<td>${item.userId}</td>
		<td>${item.commentContent}</td>
		<td>${item.regDate}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>