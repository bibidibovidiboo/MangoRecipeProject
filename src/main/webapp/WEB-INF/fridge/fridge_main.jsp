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
                            <h5>Popular Ingredient</h5>
                            <div class="blog__sidebar__recent">
                            
                                <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <img style="width: 100px;height: 70px;" src="data:image/jpeg;base64,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" alt="">
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h4 style="font-family: Montserrat">감자</h4>
                                    </div>
                                </a>
                                
                                 <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <img style="width: 100px;height: 70px;" src="data:image/jpeg;base64,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" alt="">
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h4 style="font-family: Montserrat">고구마</h4>
                                    </div>
                                </a>
                                
                                 <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <img style="width: 100px;height: 70px;" src="https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/2JVJ/image/UwxZ2-5sMK5rD5Ldk-kmrq5dDJk.jpg" alt="">
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h4 style="font-family: Montserrat">귤</h4>
                                    </div>
                                </a>
                                
                                 <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <img style="width: 100px;height: 70px;" src="https://t1.daumcdn.net/cfile/tistory/222DD8425899BA1231" alt="">
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h4 style="font-family: Montserrat">배추</h4>
                                    </div>
                                </a>
                                
                                <a href="#" class="blog__sidebar__recent__item">
                                    <div class="blog__sidebar__recent__item__pic">
                                        <img style="width: 100px;height: 70px;" src="https://hobbyen.co.kr/news/data/20191127/p179555408699785_667.png" alt="">
                                    </div>
                                    <div class="blog__sidebar__recent__item__text">
                                        <h4 style="font-family: Montserrat">계란</h4>
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