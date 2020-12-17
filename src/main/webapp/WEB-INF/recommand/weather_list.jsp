<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR&display=swap" rel="stylesheet">
<style type="text/css">
.row{
    font-family: 'Noto Sans KR', sans-serif;
    }
#wicon {
	width: 60px;
	height: 60px;
	margin-left: 50px;
	margin-bottom: 10px;
}
.weatherList{
	width:390px; 
	height: 150px; 
	background-color: #FDF3EA; 
	float: left;
	padding: 30px;
	color: gray;
}
h2{
	font-family: 'Noto Sans KR', sans-serif;
	font-weight: border;
	color: black;
	margin-left: 30px;
}
</style>
</head>
<body>
  <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6" style="margin-bottom: 30px;"> 
                  	<h2>오늘의 요리
	                  <c:choose>
				         <c:when test = "${wd eq '맑음'}">
				            <img id=wicon alt="" src="../img/icon/sun.png">
				         </c:when>
				         <c:when test = "${wd eq '비'}">
				            <img id=wicon alt="" src="../img/icon/rainy.png">
				         </c:when>
				         <c:when test = "${wd eq '눈'}">
				            <img id=wicon alt="" src="../img/icon/snowy.png">
				         </c:when>
				         <c:when test = "${wd eq '눈비'}">
				            <img id=wicon alt="" src="../img/icon/snowy.png">
				         </c:when>
				         <c:when test = "${wd eq '구름많음'}">
				            <img id=wicon  alt="" src="../img/icon/suncloudy.png">
				         </c:when>
				         <c:when test = "${wd eq '흐림'}">
				            <img id=wicon  alt="" src="../img/icon/cloudy.png">
				         </c:when>
				         <c:otherwise>
				            <img id=wicon alt="" src="../iimg/icon/cloudy.png">
				         </c:otherwise>
				      </c:choose>
				    </h2>
                </div>
            </div>
        </div>
    </div>
  <!-- Breadcrumb End -->
  
 <%--  <table>
      <tbody>
      	<c:forEach var="vo" items="${list }">
          <tr>
              <td class="product__cart__item">
                  <div class="product__cart__item__pic">
                      <img src="${vo.img }" style="width: 100px; height: 100px;">
                  </div>
                  <div class="product__item__text" style="text-align: left;">
                      <h6><a href="weather_detail.do?rno=${vo.rno }">${vo.title }</a></h6>
                  </div>
              </td>
          </tr>
          </c:forEach>
      </tbody>
  </table> --%>
  
  <!-- Wishlist Section Begin -->
        <div class="container">
            <div class="row" style="margin-bottom: 80px;">
                    <c:forEach var="vo" items="${list }">
	    	            <div class="col-lg-6" style="margin-bottom: 30px;">
	    	            	<div style="float: left;">
		                      <img src="${vo.img }" style="width: 150px; height: 150px;">
		                    </div>
		                    <div class="weatherList">
		                      <a href="weather_detail.do?rno=${vo.rno }" style="color: black;"><font style="font-weight: border; font-size: 14pt;">${vo.title }</font></a><br><br>
		                      <img src="../img/icon/cooktime.png" style="width:7%">&nbsp;${vo.cooktime }&nbsp;&nbsp;&nbsp;&nbsp;
		                      <img src="../img/icon/level.png" style="width:7%">&nbsp;${vo.lvl }
		                    </div>
		                </div>
                    </c:forEach>
            </div>
        </div>
    <!-- Wishlist Section End -->
</body>
</html>