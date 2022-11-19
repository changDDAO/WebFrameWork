<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
<h2>상품 게시판</h2>
<table border= "1">
<tr><th>상품명</th><th>모델</th><th>조회수</th></tr>
	<c:forEach var="product" items="${requestScope.productList}">
			<tr>
				<td>${product.name}</td>
				<td><a href="/electronic/product/detail.do?id=${product.id}">${product.model}</a> </td>
				<td>${product.readcnt} </td>
				
			</tr>
		</c:forEach>
		
	</table>
	<p><a href = "/electronic/basketProduct.jsp">[장바구니]</a></p>
	<p>전하다 imageFiles </p>
	<img src ="/electronic/refrigerator.jpg" id="refrigerator">
	
     <img src ="/electronic/washmachine.jpg"id="washmachine">
	
</div>


</body>
</html>