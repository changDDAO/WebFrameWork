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
<div align = "left">
<h1>상품 상세 페이지</h1>
<hr>
<p>상품명: ${selProduct.name}</p>
<p>모델: ${selProduct.model}</p>
<p>제조국: ${selProduct.madein}</p>
<p>가격: ${selProduct.price}</p>
<p><a href="/electronic/product/buy.do?id=${selProduct.id}">[상품구매]</a>  <a href ="/electronic/product/list.do">[목록 보기]</a>
<p>전하다 로고 아이콘</p>
<img src ="/electronic/fanlogo.jpg">
<img src ="/electronic/microwavelogo.jpg">
</div>

</body>
</html>