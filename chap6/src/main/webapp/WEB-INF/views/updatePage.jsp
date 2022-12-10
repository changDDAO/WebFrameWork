<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form method ="post" action="updateArticle/${article.article_no }">
<p><h2>번호:</h2>
	${article.article_no}</p>
	
<p><h2>제목:</h2></p>
<input type ="text" name ="title" value="${article.title }">
<p><h2>내용:</h2></p> <textarea rows="5" cols="50" name ="content" >${content}</textarea>
<p><input type ="submit" value = "글 수정" >
	
	

</form>
</body>
</html>