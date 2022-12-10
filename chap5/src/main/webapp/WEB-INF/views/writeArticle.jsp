<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form action ="getWrote" method="post" name = writeForm>
<p>제목:
<input type ="text" name = "title">
</p>
<p>내용:</p>
<textarea rows="5" cols="30" name = "content"></textarea>


<p><input type ="submit" value ="새 글 등록">
</form>

</body>
</html>