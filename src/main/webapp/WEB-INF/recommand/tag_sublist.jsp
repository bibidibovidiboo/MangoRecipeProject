<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:forEach var="s" items="${ss }">
  	<span class="btn btn-xs" style="margin-bottom: 5px; border: solid 2px rgba(226, 108, 12, 0.7); ">${s }</span>&nbsp;
  </c:forEach>
  
  
<%--  <div class="container">
            <div class="row" style="margin-bottom: 80px;">
                    <c:forEach var="vo" items="${list }">
	    	            <div class="col-lg-6" style="margin-bottom: 30px;">
		                    <div class="weatherList" style=" height: 150px; background-color: #FDF3EA;">
		                      <img src="${vo.img }" style="width: 150px; height: 150px; margin-right: 20px;">
		                      <a href="weather_detail.do?rno=${vo.rno }" style="color: black; font-weight: border;">${vo.title }</a>
		                    </div>
		                </div>
                    </c:forEach>
            </div>
        </div> --%>
</body>
</html>