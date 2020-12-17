<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script>
$(function(){
	// 카테고리 클릭했을 때
	$('.cateBtnTags').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	});
	$('.cateBtnTags').click(function(){
		let category2 = $(this).text();
		//alert(category2)
		$.ajax({
			  type:'get',
			  url:'../fridge/ingre_cate.do',
			  data:{"category2":category2},
			  success:function(result)
			  {
				 //alert(result);
				  $('#cateIngreList').html(result);
			  }
			  
		});
	});
});
</script>
<style type="text/css">
.btn-warning {
    color: #f08632;
    background-color: white;
    border-color: #f08632;
}
.table td, .table th {
    padding: .75rem;
    vertical-align: unset;
}

</style>
</head>
<body>

   <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__text">
                        <h2>Register</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="./index.html">Home</a>
                        <span>Register</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
             <!--col-lg-4------------------------------------------------------------------------------>
                <div class="col-lg-4">
                    <div class="blog__sidebar">
                        
                        <div class="blog__sidebar__item">
                            <h5>Categories</h5>
                            <div class="blog__sidebar__item__categories">
                                <ul>
	                                <c:forEach var="cvo" items="${cateList }" varStatus="s">
	                                	<li><a href="#" class="cateBtnTags">${cvo.category2 }</a></li>
									</c:forEach>
                                    <!-- <li><a href="#">Repice</a></li> -->
                                </ul>
                            </div>
                        </div>
                        
                        <div class="blog__sidebar__item">
                            <h5>Popular posts</h5>
                            <div class="blog__sidebar__recent">
                            
                                <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <img src="img/blog/br-1.jpg" alt="">
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h4>Secret To Cooking Vegetables</h4>
                                        <span>13 Nov 2020</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                        
                        
                    </div>
                </div>
                <!--col-lg-4------------------------------------------------------------------------------>
            	<!--col-lg-8------------------------------------------------------------------------------>
                <div class="col-lg-8">
                	<!-- 카테고리별 재료 리스트 Start -->
	                <div class="blog__sidebar__item">
	                            <h5>Ingredient List</h5>
	                          
	                     <div class="product__details__option">
	                     <c:if test="${sessionScope.id !=null }">
	                      		<a href="../fridge/ingre_map.do?id=${sessionScope.id }" class="primary-btn" style="float:right;border-radius: 40px 40px 40px 40px">My Fridge</a>
	                    
	                            <!-- <a href="../fridge/my_fridge.do" class="primary-btn" style="float:right;border-radius: 40px 40px 40px 40px">My Fridge</a> -->
	                     </c:if>
	                     </div>
	                     <div style="height:40px"></div>
	                           
						<!-- 표 Begin -->
	                    <div id="cateIngreList">
	                    	<div class="text-center">
	                    		<center>카테고리를 클릭해주세요</center>
							</div>
						</div>
	                    
                    </div>
                    
                    
                    
                        
                    <!-- 카테고리별 재료 리스트 End -->
                    
                    
                </div>
                <!--col-lg-8------------------------------------------------------------------------------>
                
               
            </div> 	<!-- row End -->
        </div>		<!-- container End -->
    </section>
    <!-- Shopping Cart Section End -->

</body>
</html>