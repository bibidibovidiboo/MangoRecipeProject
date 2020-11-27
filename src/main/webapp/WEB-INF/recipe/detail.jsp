<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Shop Details Section Begin -->
    <section class="product-details spad">
   
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product__details__img">
                        <div class="product__details__big__img">
                            <img class="big_img" src=${vo.img } alt="">
                        </div>
                       
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <div class="product__label">${vo.chef}</div>
                        <h4>${vo.title }</h4>
                       
                        <p>${vo.summ }</p>
                        <ul>
                            <li>인분: <span>${vo.people }</span></li>
                            <li>요리시간: <span>${vo.cooktime }</span></li>
                            <li>난이도: <span>${vo.lvl }</span></li>
                        </ul>
                        <div class="product__details__option">
                            <!-- <div class="quantity">
                                <div class="pro-qty">
                                    <input type="text" value="2">
                                </div>
                            </div> -->
                            
                            <a href="#" class="heart__btn"><span class="icon_heart_alt"></span></a>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            
                    <h3>관련 맛집 목록</h3>
                    
                    <!-- ========== -->
                    <div class="row">
                    <c:forEach var="vo" items="${rlist }">
                <div class="col-lg-2">
                    <div class="product__details__img">
                        <div class="product__details__big__img">
                        
                            <img class="big_img" src=${vo.img } alt="">
                        </div>
                       
                    </div>
                </div>
                <div class="col-lg-10">
                    <div class="product__details__text">
                       
                        <h4>ㅈㅂㄷㅂㅈㄷ${vo.title }</h4>
                       
                        
                        </div>
                    </div>
                    
                    </c:forEach>
                    
                </div>
            </div>
            <br>
                    <!-- ========== -->
                    
             
        </div>
    </section>
    <!-- Shop Details Section End -->


</body>
</html>