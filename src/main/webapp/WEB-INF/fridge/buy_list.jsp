<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<c:forEach var="vo" items="${iList }">
		<tr>
			<td class="product__cart__item">
				<div class="product__cart__item__pic">
					<img src="${vo.image }" alt="" width=90px; height="90px">
				</div>
				<div class="product__cart__item__text">
					<h6>${vo.title }</h6>
				</div>
			</td>
			<td class="cart__price">${vo.lprice }</td>
			<td class="cart__btn"><a href="../shopping/detail.do?no=${vo.no }" class="primary-btn">Buy</a></td>
		</tr>
	</c:forEach>
</body>
</html>