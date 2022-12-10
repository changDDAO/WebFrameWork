<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오루 발생</title>
</head>
<body>
<h1>오류 발생</h1>
<hr>
<c:if test ="${modify}">
<p>오류 메시지: 수정할 권한이 없습니다.</p>
</c:if>
<c:if test ="${delete}">
<p>오류 메시지: 삭제할 권한이 없습니다.</p>
</c:if>
<a href ="/ex2/list" text_decoration ="under-line">[목록]</a>


</body>
</html>