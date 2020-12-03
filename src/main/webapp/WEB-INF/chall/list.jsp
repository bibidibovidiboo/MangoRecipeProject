<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.title {
	font-size: 31px;
    margin: 36px auto 24px;
}
.c-box {
	padding: 40px 0 65px;
}
.new-btn {
	color: #ffffff;
    background-color: #f08632;
    border-color: #f08632;
	margin-top: 15px;
}
.table-row {
	background-color: #f3f3f3;
}
a {
	color: #222;
}
a:hover {
	color: #f08632;
}
</style>
</head>
<body>
 
    <!-- Wishlist Section Begin -->
    <section class="wishlist spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="wishlist__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th>대결</th>
                                    <th>쉐프</th>
                                    <th>조회수</th>
                                    <th><a href="insert.do" class="btn btn-danger new-btn">새로운 대결</a></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="vo" items="${list }">
                                <tr>
                                
                                    <td class="product__cart__item">
                                        <div class="product__cart__item__pic">
                                            <img src="img/shop/cart/cart-1.jpg" alt="">
                                        </div>
                                        <div class="product__cart__item__text">
                                            <h6>${vo.subject }</h6>
                                        </div>
                                    </td>
                                    <td class="cart__price">${vo.name }</td>
                                    <td class="cart__stock">${vo.regdate }</td>
                                    <td class="cart__btn"><a href="../detail.do" class="primary-btn">대결 신청</a></td>
                                   <!-- <td></td> -->
                                   
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        
                        <table class="table">
         <td class="text-center">
          <a href="#" class="btn btn-sm btn-default">이전</a>
          ${curpage } page / ${totalpage } pages
          <a href="#" class="btn btn-sm btn-default">다음</a>
         </td>
       </table>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Wishlist Section End -->
   
</body>
</html>
