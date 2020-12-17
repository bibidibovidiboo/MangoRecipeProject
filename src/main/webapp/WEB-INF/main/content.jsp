<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:useBean id="toDay" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#restaurant {
   margin-top: 40px;
}
#recipe {
   margin-top: 40px;
}
.row {
   margin-top: 10px;
}
#wicon {
   width: 70px;
   height: 70px;
   margin-left: 20px;
}

</style>
</head>
<body>

   <!-- Hero Section Begin -->
   <section class="hero">
   <div class="hero__slider owl-carousel">
      <div class="hero__item set-bg" data-setbg="../img/hero/main_img.JPG">
         <div class="container">
            <div class="row d-flex justify-content-center">
               <div class="col-lg-8">
                  <div class="hero__text">
                     <h2>소중한 한끼를 위한</h2>
                     <h2>모든 정보를 드려요</h2>
                     <a href="#" class="primary-btn">망고의 레시피</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="hero__item set-bg" data-setbg="../img/hero/main_img2.JPG">
         <div class="container">
            <div class="row d-flex justify-content-center">
               <div class="col-lg-8">
                  <div class="hero__text">
                     <h2>행복한 한끼를 위한</h2>
                     <h2>모든 정보를 드려요</h2>
                     <a href="#" class="primary-btn">망고의 레시피</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   </section>

   <!-- 날씨레시피 -->
   <div class="breadcrumb-option">
      <div class="container">
         <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6" style="margin-bottom: 30px;">
               <h2>
                  오늘의 날씨
                  <c:choose>
                     <c:when test="${wd eq '맑음'}">
                        <img id=wicon alt="" src="../img/icon/sun.png">
                     </c:when>
                     <c:when test="${wd eq '비'}">
                        <img id=wicon alt="" src="../img/icon/rainy.png">
                     </c:when>
                     <c:when test="${wd eq '눈'}">
                        <img id=wicon alt="" src="../img/icon/snowy.png">
                     </c:when>
                     <c:when test="${wd eq '눈비'}">
                        <img id=wicon alt="" src="../img/icon/snowy.png">
                     </c:when>
                     <c:when test="${wd eq '구름많음'}">
                        <img id=wicon alt="" src="../img/icon/suncloudy.png">
                     </c:when>
                     <c:when test="${wd eq '흐림'}">
                        <img id=wicon alt="" src="../img/icon/cloudy.png">
                     </c:when>
                     <c:otherwise>
                        <img id=wicon alt="" src="../iimg/icon/cloudy.png">
                     </c:otherwise>
                  </c:choose>

                  <!-- 현재년도 -->
                  <c:set var="now" value="<%=new java.util.Date()%>" />
                  <c:set var="sysYear">
                     <fmt:formatDate value="${now}" pattern="yyyy.MM.dd" />
                  </c:set>


                  <!-- 화면에 뿌릴때 -->
                  <c:out value="${sysYear}" />
                  <hr>
               </h2>
               <h2>날씨에 어울리는 요리 추천</h2>
            </div>
         </div>
      </div>
   </div>
   <div class="container">
      <div class="row" style="margin-bottom: 80px;">
         <c:forEach var="vo" items="${wddList }">
            <div class="col-lg-6" style="margin-bottom: 30px;">
               <div class="weatherList"
                  style="height: 150px; background-color: #FDF3EA;">
                  <img src="${vo.img }"
                     style="width: 150px; height: 150px; margin-right: 20px;"> <a
                     href="../recommand/weather_detail.do?rno=${vo.rno }"
                     style="color: black; font-weight: border;">
                     ${fn:length(vo.title)>23?fn:substring(vo.title,0,23)+="...":vo.title  }</a>
               </div>
            </div>
         </c:forEach>
      </div>
   </div>


   <!-- 레시피 -->
   <hr>
   <div class="container" id="recipe">
      <h3>레시피</h3>
      <div class="row">
         <c:forEach var="vo" items="${rdList }">
            <div class="col-lg-3 col-md-6 col-sm-6">
               <div class="product__item">
                  <div class="product__item__pic set-bg" data-setbg="${vo.img }">
                     <div class="product__label">
                        <span>${vo.chef }</span>
                     </div>
                  </div>
                  <div class="product__item__text">
                     <h6>
                        <a href="../recipe/detail_before.do?rno=${vo.rno }">${vo.title }</a>
                     </h6>
                  </div>
               </div>
            </div>

      </c:forEach>
      </div>
   </div>
   
  
   <!-- 레스토랑 -->
   <hr>
   <div class="container" id="restaurant">
      <h3>레스토랑</h3>
      <div class="row">
         <c:forEach var="vo" items="${rList }">
            <div class="col-lg-3 col-md-6 col-sm-6">
               <div class="product__item">
                  <div class="product__item__pic set-bg" data-setbg="${vo.poster }">
                     <div class="product__label">
                        <a href="../restaurant/resDetail_before.do?no=${vo.no}"><span>${vo.title }</span></a>
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
</body>
</html>