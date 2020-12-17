<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.header {
	background-color: #fff;
}
.header__top {
    background: #faa741;
}
.header__top__inner {
    height: 0px;
    padding-top: 0px
}
.header__top__left {
	float: right;
}
.header__top__left ul li span {
	color: #fff;
}
.header__menu ul li a {
	color: #2d2d2d;
	font-weight: 400;
	font-size: 15px;
}
.header__top__left ul li a {
	color: #fff;
}
.mango_logo img {
	width: 160px;
    margin-top: 8px;
}
</style>
</head>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>


    
    
    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="header__top__inner">
                            <div class="header__top__left">
                                <ul>
                                    <li><a href="#">Login/out</a> <span class="arrow_carrot-down"></span>
                                     	<ul>
                                     		<c:choose>
                                     		<c:when test="${id==null }">
                                     			<li data-toggle="modal" data-target="#myModal">Login</li>
                                     			<li>회원가입</li>
                                     		</c:when>
                                     		<c:when test="${id!=null }">
                                     		<a href="../main/logout.do"><li>Logout</li></a>
                                     		<li>Logout</li>
                                            </c:when>
                                            </c:choose>
                                        </ul>
                                        
                                    </li>
                                    <c:if test="${sessionScope.id!=null }">
	                                 	&nbsp;<span style="font-size:9.5pt"> ${id }님, 안녕하세요!</span>
	                            	  </c:if>
                                </ul>
                            </div>
                            <!--  <div class="header__logo">
                                <a href="../main/main.do"><img src="../img/logo.png" alt=""></a>
                            </div>
                            <div class="header__top__right">
                                <div class="header__top__right__links">
                                    <a href="#" class="search-switch"><img src="../img/icon/search.png" alt=""></a>
                                    <a href="#"><img src="../img/icon/heart.png" alt=""></a>
                                </div>
                            </div> -->
                        </div>
                    </div>
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>
        </div>
        <div class="container">
            <div class="row">
            	<div class="col-lg-2 mango_logo">
            		<a href="../main/main.do"><img src="../img/logo.png" alt=""></a>
            	</div>
                <div class="col-lg-10">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <li><a href="../main/main.do">HOME</a></li>
                            <li><a href="../fridge/fridge_main.do">MY냉장고</a></li>
                            <li><a href="../recipe/list.do">레시피</a></li>
                            <li><a href="../restaurant/resList.do">맛집</a></li>
                            <li><a href="../recommand/weather_list.do">추천</a>
                            	<ul class="dropdown">
                                    <li><a href="../recommand/weather_list.do">오늘의 요리</a></li>
                                    <li><a href="../recommand/tag_list.do">태그</a></li>
                                </ul>
                            </li>
                            <li><a href="../community/list.do">커뮤니티</a></li>
                            <li><a href="../shopping/list.do">최저가</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
    
</body>
</html>