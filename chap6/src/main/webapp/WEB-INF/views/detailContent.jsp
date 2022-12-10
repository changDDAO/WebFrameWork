<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
</head>
<body>
<div align ="center">
<table border ="1">
<tr>
<th>번호</th><td>${article.article_no}</td>
</tr>
<tr>
<th>작성자</th><td>${name}</td>
</tr>
<tr>
<th>제목</th><td>${article.title}</td>
</tr>
<tr>
<th>내용</th><td>${content}</td>
</tr>
<tr div align ="left"><td colspan="2">
<a href="/ex2/list">[목록]</a>
<a href="/ex2/update?aid=${article.article_no}">[게시글 수정]</a>
<a href="/ex2/delete?aid=${article.article_no}">[게시글 삭제]</a></td></tr>


</table>


</div>

</body>
</html>