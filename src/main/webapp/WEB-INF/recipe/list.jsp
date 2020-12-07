<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%-- <%@ taglib prefix="fn"uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- Shop Section Begin -->
    <section class="shop spad">
        <div class="container">
            <div class="shop__option">
            <div class="col-lg-12"><h3 class="text-center" >레시피 자랑하기</h3><br><br>
               <!--  <div class="row">
                
                    <div class="col-lg-7 col-md-7">
                        <div class="shop__option__search">
                            <form action="#">
                                <select>
                                
                                    <option value="">recipe</option>
                                    <option value="">chef</option>
                                    <option value="">헤헿</option>
                                    <option value="">야호</option>
                                </select>
                                <input type="text" placeholder="Search">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                    </div>
                     <div class="col-lg-5 col-md-5">
                        <div class="shop__option__right">
                            <select>
                                <option value="">Default sorting</option>
                                <option value="">A to Z</option>
                                <option value="">1 - 8</option>
                                <option value="">Name</option>
                            </select>
                            <a href="#"><i class="fa fa-list"></i></a>
                            <a href="#"><i class="fa fa-reorder"></i></a>
                        </div>
                    </div> 
                </div>
            </div> -->
            
            
            <div class="row">
            <c:forEach var="vo" items="${list }">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="${vo.img }">
                            <div class="product__label">
                                <span>${vo.chef }</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                         
                            <h6><a href="detail_before.do?rno=${vo.rno }">${vo.title }</a></h6>
                            <!-- <div class="product__item__price">$32.00</div> -->
                            <!-- <div class="cart_add">
                                <a href="#">Add to cart</a>
                            </div> -->
                        </div>
                    </div>
                </div>
                </c:forEach>
                <div>
           
      </div>
               </div>
		<div class="text-center">
            <a href="../recipe/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-success">이전</a>
              ${curpage } page / ${totalpage } pages
            <a href="../recipe/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-info">다음</a>
          </div>   
                </div>   
                    
        </div>
    </section>
     
    <!-- Shop Section End -->
    
    <hr>
               
               <h3>&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;최근 본 레시피</h3>
               
                <div class="row"><br>
                    <!-- <div class="col-lg-6 col-md-6 col-sm-6"> -->
                    
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <c:forEach var="vo" items="${cList }" varStatus="s">
                        <c:if test="${s.index<5 }">
                        	<div class="col-md-2">
                        		<div class="thumbnail">
                        			<a href="detail_before.do?rno=${vo.rno }">
                        				
                        				<img src="${vo.img }" alt="Light"  width=220 height=130>
                        				<div class="caption">
                        				
                        					  <p style="font-size:8pt">${vo.title }</p> 
                        				</div>
                        			</a>
                        		</div>
                        	</div>
                        </c:if>
                        </c:forEach>
                   <!--  </div> --> 
                </div>
           		<div class="aa">
           		<br><br><br><br>           		
           		</div>
    
</body>
</html>