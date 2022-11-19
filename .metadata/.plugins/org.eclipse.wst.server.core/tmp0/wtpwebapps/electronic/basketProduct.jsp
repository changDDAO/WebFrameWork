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
<div align="left">
<h1>장바구니 내용</h1>
<hr>
<%--${session.invalidate()}--%> <%-- session 초기화 한 후 출력결과 test --%>
<c:choose>
    <c:when test="${sessionScope.basketProductList == null}">
		장바구니가 비었습니다.
    </c:when>
    <c:otherwise>
		<c:forEach var = "product" items = "${sessionScope.basketProductList}">
	<p>모델: ${product.model}<br>
	   가격: ${product.price}</p>

</c:forEach>
    </c:otherwise>
</c:choose>


<a href ="/electronic/product/list.do">[목록 보기]</a>


</div>

</body>
</html>