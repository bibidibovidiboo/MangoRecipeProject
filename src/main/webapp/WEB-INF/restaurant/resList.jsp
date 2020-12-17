<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.box {
   margin-top: 40px;
}

</style>
</head>
<body>
   <section class="shop spad">
   <div class="container">
      <div class="shop__option">
            <!-- ----------------------- 카테고리 중간------------------------------------------------------------------------------ -->
            <div class="row">
                    <div class="col-lg-5 col-md-5">
                        <div class="shop__option__search">
                            <form action="#">
                                <select>
                                    <option value="">Categories</option>
                                    <option value="">소고기</option>
                                    <option value="">돼지고기</option>
                                    <option value="">닭고기</option>
                                    <option value="">과일류</option>
                                    <option value="">채소류</option>
                                </select>
                                <input type="text" placeholder="Search">
                                
                                <button type="submit"><i class="fa fa-search">
                                <form method=post action="../restaurant/resList.do">
                                </form>
                                </i></button>
                                
                              
                            
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-7">
                      
                    <div class="breadcrumb__links">
                        <a href="./index.html">전체보기</a>
                        <a href="./shop.html">소고기</a>
                        <a href="./shop.html">돼지고기</a>
                        <a href="./shop.html">닭고기</a>
                        <a href="./shop.html">과일류</a>
                        <a href="./shop.html">채소류</a>
                      
                    </div>
      
                    </div>
                </div>
      
            <!-- ---------------------------------- 식당 출력 --------------------------------------------------------------------------- -->
       <div class="container">
            <div class="box">
               <c:forEach var="vo" items="${list }">
                  <div class="col-lg-3 col-md-6 col-sm-6">
                     <div class="product__item">
                        <div class="product__item__pic set-bg"
                           data-setbg="${vo.poster }">
                           <div class="product__label">
                              <a href="resDetail_before.do?no=${vo.no}"><span>${vo.title }</span></a>
                           </div>
                        </div>
                        <div class="product__item__text">
                           <h5>${fn:length(vo.addr)>18?fn:substring(vo.addr,0,18)+="...":vo.addr  }</h5>
                           <h5>${vo.type }</h5>
                        </div>

                     </div>
                  </div>
               </c:forEach>
            </div>
         </div> 
          <div class="box2">
         <div class="text-center">
            <ul class="pagination">
               <c:if test="${curpage>BLOCK }">
                  <li><a href="../restaurant/resList?page=${startPage-1 }">&lt;</a></li>
               </c:if>
               <c:forEach var="i" begin="${startPage }" end="${endPage }">
                  <c:if test="${i==curpage }">
                     <li class="active"><a href="../restaurant/resList?page=${i }">${i }</a></li>
                  </c:if>
                  <c:if test="${i!=curpage }">
                     <li><a href="../restaurant/resList.do?page=${i }">${i }</a></li>
                  </c:if>
               </c:forEach>
               <c:if test="${endPage<totalpage }">
                  <li><a href="../restaurant/resList.do?page=${endPage+1 }">&gt;</a></li>
               </c:if>
            </ul>
         </div>
      </div> 

         <div class="row1">
               <h3>최근 본 식당</h3>
               <c:forEach var="vo" items="${cList }" varStatus="s">
                  <c:if test="${s.index<6 }">
                     <div class="col-md-2">
                        <div class="thumbnail">
                           <a href="resDetail_before.do?no=${vo.no}"> <img
                              src="${vo.poster }" alt="Lights" style="width: 100%"
                              class="img-rounded">
                              <div class="caption">
                                 <p style="font-size: 8pt">${vo.title }</p>
                              </div>
                           </a>
                        </div>
                     </div>
                  </c:if>
               </c:forEach>
            </div>
         
      </div>
   </div>
   </section>
</body>
</html>