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

		 <c:forEach var="vo" items="${fList }">
             <div class="col-md-4">
               <div class="product-item" style="width: 350px; height:370px;  text-align: center;">
                  <a href="../restaurant/resDetail.do?no=${vo.no }"><img src="${vo.poster }" style="width: 300px; height: 300px; margin-bottom: 10px; "></a>   
	                 <h5>
	                  <a href="../restaurant/resDetail.do?no=${vo.no }" style="color: black; font-weight: bolder;">${vo.title }</a>
	                 </h5>
               </div>
             </div>
         </c:forEach>

<%-- 
        <div class="container">
            <div class="row">
            <c:forEach var="vo" items="${fList }">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="product__item">
                        <a href="#"><img src="${vo.poster }" style="width: 350px; height: 350px;"></a>
                      
                        <div class="product__item__text">
                            <h6><a href="../restaurant/resDetail.do?no=${vo.no }">${vo.title }</a></h6>
                        </div>
                    </div>
                </div>
              </c:forEach>
            </div>
        </div> --%>
    

</body>
</html>