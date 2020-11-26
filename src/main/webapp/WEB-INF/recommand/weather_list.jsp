<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                  <h2>오늘의 요리 추천</h2>
                </div>
            </div>
        </div>
    </div>
  <!-- Breadcrumb End -->
  <!-- Wishlist Section Begin -->
        <div class="container">
            <div class="row">
                <div class="col-lg-8" style="margin-bottom: 50px;">
                    <div class="wishlist__cart__table">
                        <table>
                            <tbody>
                            	<c:forEach var="vo" items="${list }">
                                <tr>
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="${vo.img }" style="width: 100px; height: 100px;">
                                        </div>
                                        <div class="product__item__text" style="text-align: left;">
                                            <h6><a href="weather_detail.do?rno=${vo.rno }">${vo.title }</a></h6>
                                        </div>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    <!-- Wishlist Section End -->
</body>
</html>