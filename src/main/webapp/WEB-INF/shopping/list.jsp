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
let category2="";
$(function(){
	$.ajax({
		type:'post',
		url:'../shopping/sublist.do',
		data:{"category2":category2},
		success:function(result)
		{
			$('.sublist').html(result);
		}
	});
	$('#choose').click(function(){
		let category2=$('#sorting').val();
		console.log('제발!!!!!'+category2);
		$.ajax({
			type:'post',
			url:'../shopping/sublist.do?category2='+category2,
			success:function(result)
			{
				$('.sublist').html(result);
			}
		})
	});
	$('#category2').click(function(){
		let category2=$(this).attr("value");
		console.log('category2는?'+category2);
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
<!--                             "축산","건강식품","수산","농산물","반찬","김치","음료","가공식품","다이어트식품","과자","아이스크림/빙수","냉동/간편조리식품","전통주","쿠킹박스" -->
    <section class="shop spad">
        <div class="container">
                <div class="row">
                    <div class="col-lg-7 col-md-7">
                    <form>
    						<select name="category2" id="sorting">
    							<option value="축산">축산</option>
                            	<option value="수산">수산</option>
                            	<option value="건강식품">건강식품</option>
                            	<option value="반찬">반찬</option>
                            	<option value="농산물">농산물</option>
                            	<option value="김치">김치</option>
                            	<option value="음료">음료</option>
                            	<option value="가공식품">가공식품</option>
                            	<option value="다이어트식품">다이어트식품</option>
                            	<option value="과자">과자</option>
                            	<option value="아이스크림/빙수">아이스크림/빙수</option>
                            	<option value="냉동/간편조리식품">냉동/간편조리식품</option>
                            	<option value="전통주">전통주</option>
                            	<option value="쿠킹박스">쿠킹박스</option>
    						</select>
                            	<input id="choose" type="button" class="btn btn-md btn-warning" value="적용하기">
    				</form>                
                             
                    </div>
<!--                     <div class="col-lg-5 col-md-5"> -->
<!--                         <div class="shop__option__right"> -->
<!--                             <select> -->
<!--                                 <option value="">Default sorting</option> -->
<!--                                 <option value="축산">축산</option> -->
<!--                                 <option value="수산">수산</option> -->
<!--                                 <option value="">Name</option> -->
<!--                             </select> -->
<!--                             <a href="#"><i class="fa fa-list"></i></a> -->
<!--                             <a href="#"><i class="fa fa-reorder"></i></a> -->
<!--                         </div> -->
<!--                     </div> -->
                </div>
            
 			<div class="row">
           		<div class="sublist">
           			<!-- 데이터출력 -->
           		</div>
           	</div>
           	
             <div class="text-center">
            <a href="..shopping/sublist.do?page=${curpage>1?curpage-1:curpage }&category2=${vo.category2}" class="btn btn-sm btn-success">이전</a>
              ${curpage } page / ${totalpage } pages
            <a href="../shopping/sublist.do?page=${curpage<totalpage?curpage+1:curpage }&category2=${vo.category2}" class="btn btn-sm btn-info">다음</a>
          </div>   
       </div>
</section> 
    <!-- Shop Section End -->
</body>
</html>