<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${errors.notfound }"><font color ="red">오류 :동록되지 않은 사용자입니다.</font><br></c:if>
<c:if test = "${errors.mismatch }"><font color ="red">오류 :암호가 일치하지 않습니다.</font><br></c:if>

<form action = "login" method ="post">
이메일 : <input type = "text" name ="email">
<p>
암호 : <input type = "password" name ="password">
<p>
<input type = "submit" >



</form>

</body>
</html>