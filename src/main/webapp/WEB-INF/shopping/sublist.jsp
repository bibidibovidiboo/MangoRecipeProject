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
	   <div class="row">
            <c:forEach var="vo" items="${list }">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg"> 
                        	<a href="../shopping/detail.do?no=${vo.no }&category3=${vo.category3}"><img src="${vo.image }"></a>
                            <div class="product__label">
                                <span>${vo.no }.${vo.category2 }</span>
                            </div>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="../shopping/detail.do?no=${vo.no }&category3=${vo.category3}">${vo.title }</a></h6>
                            <div class="product__item__price">${vo.lprice }원</div>
                            <div class="cart_add">
                                <a href="#">최저가 구매하기</a>
                            </div>
                        </div>
                    </div>
                </div>
       </c:forEach>
</div>

             <div class="text-center">
            <a href="sublist.do?page=${curpage>1?curpage-1:curpage }&category2=${category2}" class="btn btn-sm btn-success">이전</a>
              ${curpage } page / ${totalpage } pages
            <a href="sublist.do?page=${curpage<totalpage?curpage+1:curpage }&category2=${category2}" class="btn btn-sm btn-info">다음</a>
          </div>   
	
</body>
</html>