<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.btn2').click(function(){
		let name=$(this).attr("name");
		console.log('name은?'+name);
	})
	$.ajax({
		type:'post',
		url:'../shopping/list.do?category2='+name,
		success:function(result)
		{
			$('.btn_group').html(result);
		}
	})
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
                        <h2>Shop</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="./index.html">Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Section Begin -->
    <section class="shop spad">
        <div class="container">
            <div class="shop__option">
                <div class="row">
                    <div class="col-lg-7 col-md-7">
<!--                             <form action="../shopping/list.do"> -->
                            <!-- "축산","건강식품","수산","농산물","반찬","김치","음료","가공식품","다이어트식품","과자","아이스크림/빙수","냉동/간편조리식품","전통주","쿠킹박스" -->
                            <div id="btn_group">
                            	<button class="btn2" name="축산">축산</button>
                            	<button class="btn2" name="수산">수산</button>
                            	<button class="btn2" name="건강식품">건강식품</button>
                            	<button class="btn2">수산</button>
                            	<button class="btn2">반찬</button>
                            	<button class="btn2">농수산</button>
                            	<button class="btn2">김치</button>
                            	<button class="btn2">음료</button>
                            	<button class="btn2">가공식품</button>
                            	<button class="btn2">다이어트식품</button>
                            	<button class="btn2">과자</button>
                            	<button class="btn2">아이스크림/빙수</button>
                            	<button class="btn2">냉동/간편조리식품</button>
                            	<button class="btn2">전통주</button>
                            	<button class="btn2">쿠킹박스</button>
                            </div>
<!--                             </form> -->
                    </div>
                    <div class="col-lg-5 col-md-5">
                        <div class="shop__option__right">
                            <select>
                                <option value="">Default sorting</option>
                                <option value="축산">축산</option>
                                <option value="수산">수산</option>
                                <option value="">Name</option>
                            </select>
                            <a href="#"><i class="fa fa-list"></i></a>
                            <a href="#"><i class="fa fa-reorder"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
            <c:forEach var="vo" items="${list }">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="${vo.image }">
                            <div class="product__label">
                                <span>${vo.no }.${vo.category2 }</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="../shopping/detail.do?no=${vo.no }&category3=${vo.category3}">${vo.title }</a></h6>
                            <div class="product__item__price">${vo.lprice }원</div>
                            <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
             </c:forEach>
                </div>
             <div class="text-center">
            <a href="../shopping/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-success">이전</a>
              ${curpage } page / ${totalpage } pages
            <a href="../shopping/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-info">다음</a>
          </div>   
              
    <!-- Shop Section End -->
</body>
</html>