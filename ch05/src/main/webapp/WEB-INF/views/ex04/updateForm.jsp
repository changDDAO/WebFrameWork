<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>회원정보 수정/삭제</h2>
<br>
<form method ="post">
	<table border="1">
	
		<tr>
			<td>이름<input type="hidden" name="id" value="${member.id}"> </td>
			<td> <input type="text" name="name" value="${member.name}"></td>
			
		</tr>
		<tr>
			<td>비밀번호</td>
			<td> <input type="password" name="password" value="${member.password}"> </td>
		</tr>
		<tr>
			<td>이메일</td>
			<td> <input type="text" name="email" value="${member.email}"> </td>
		</tr>
		<tr>
			<td>가입일</td>
			<td> <input type="text" name="regdate" value="${member.regdate}"> </td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="수정" formaction="/chap5/ex1/update">
			
			<input type="reset" value="취소">
			
			<input type="submit" value="삭제" formaction="/chap5/ex1/delete/${member.id}"> 
			
			
		</tr>
	</table>
</form>
</div>
</body>
</html>