<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.blog__item {
    margin-bottom: -2px;
}
.blog__items_border{
/* border: 2px solid #f08632; */
}

.set-bg1 {
   /*  border: 2px solid #f08632; */
    height: 215px;
    top: 57px;
}
.blog__item__pic .blog__pic__inner {
    background: #ffffff;
    position: absolute;
    left: -2px;
    bottom: 210px;
    top: 12px;
    width: calc(100% - 40px);
    padding: 0px 0 0
}
.addBtnTags {
	font-family: 'Montserrat', sans-serif;
	font-weight: bold;
	color: orange;
}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script>
$(function(){
	// 카테고리 클릭했을 때
	$('.favBuyBtnTags').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	});
	$('.favBuyBtnTags').click(function(){
		let title = $(this).text();
		//alert(title);
		//alert(category2)
		$.ajax({
			  type:'get',
			  url:'../fridge/buy_list.do',
			  data:{"title":title},
			  success:function(result)
			  {
				 //alert(result);
				  $('#favBuyList').html(result);
			  }
			  
		});
	});
});
</script>
</head>
<body>
  <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__text">
                        <h2>My Ingredient</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="./index.html">Home</a>
                        <span>My Ingredient</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Blog Section Begin -->
    <section class="blog spad">
        <div class="container">
        	<c:if test="${sessionScope.id!=null }">
        
        
        
        
            <div class="row">
				<div class="col-lg-4">
                    <div class="blog__sidebar">
                        
                        <div class="blog__sidebar__item">
                            <h5>나의 관심 식재료</h5>
                            <div class="blog__sidebar__item__categories">
                                <ul>
                                <c:forEach var="vo" items="${list }" varStatus="ss">
                                    <li><a href=# class="favBuyBtnTags">${vo.title }</a></li>
                                    <hr>
								</c:forEach>
                                </ul>
                            </div>
                            
                            <center style="color:orange">상단의 식재료를 클릭하세요</center>
                        </div>
                        
                        
                        
                        
                    </div>
                </div>
                <!--col-lg-8------------------------------------------------------------------------------>
                <div class="col-lg-8">
          
                <!-- 카테고리별 재료 리스트 Start -->
	                <div class="blog__sidebar__item">
	                            <h5>최저가 TOP 10 </h5>


						
										<div class="wishlist__cart__table">
										
											<table>
												<thead>
													<tr>
														<th>Product</th>
														<th>Price</th>
														<th>Buy</th>
													</tr>
												</thead>
												<tbody id="favBuyList">
													

												</tbody>
												
											</table>
										</div>

					</div>
                
                
                
                
                
                
               
                    
                    
                </div>
               
                
                
            </div>
            </c:if>
            <c:if test="${sessionScope.id==null }">
            	<center>로그인 후 사용 가능합니다.</center>
            </c:if>
        </div>
    </section>
    <!-- Blog Section End -->
</body>
</html>