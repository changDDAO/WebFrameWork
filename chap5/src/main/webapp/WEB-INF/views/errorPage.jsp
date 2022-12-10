<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류발생</title>
</head>
<body>
<h1>오류 발생</h1>
<hr>
<c:if test = "${errors.notfound }"><font color ="red">오류 메세지 :동록되지 않은 사용자입니다.</font><br></c:if>
<c:if test = "${errors.mismatch }"><font color ="red">오류 :암호가 일치하지 않습니다.</font><br></c:if>
<c:if test = "${exception }"><font color ="red">오류 :로그인하는데 문제가 있습니다.</font><br></c:if>

<a href ="login">[로그인]</a>

</body>
</html>