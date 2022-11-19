<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<div align="center">
	<h2>전체 회원 리스트</h2>
	<hr> 
	<table border="1">
		<tr>
			<th>아이디</th> <th>이름</th> <th>비밀번호</th> <th>이메일</th> <th>가입일</th> 
		</tr>
		<c:forEach var="member" items="${members}">
			<tr>
				<td align="center"><a href="list/${member.id}">${member.id}</td>
				<td>${member.name} </td>
				<td>${member.password} </td>
				<td>${member.email} </td>
				<td>${member.regdate}</td>
				
			</tr>
		</c:forEach>
	</table>
	<p><a href="addForm">사용자 추가</a></p>
</div>
</body>
</html>