<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="shop spad">
        <div class="container">
            <div class="shop__option">
                <div class="row">
		  <div class="col-md-4">
		  	<h3 class="text-center">나만의 냉장고</h3>
		  	<hr>
		  		<img src="../img/full-fridge.png">
		  </div>
		  
		  <div class="col-md-4">
			<h3 class="text-center">나의 식재료</h3>
		  	<hr>
		  	<div class="shop__option__search">
		        <form action="../fridge/fridge_main.do">
		            <select>
		                <option value="">재료명</option>
		                <option value="">레시피명</option>
		                <option value="">카테고리</option>
		            </select>
		            <input type="text" name="ingre_name" placeholder="Search">
		            <button type="submit"><i class="fa fa-search"></i></button>
		        </form>
		    </div>
		    <div>
		    	<c:choose>
		    	<c:when test="${list!=null }">
		    	<table class="table">
			    	<tr class="warning">
			    		<th class="text-center" width=5%>NO</th>
			    		<th class="text-center" width=70%>식재료명</th>
			    		<th class="text-center" width=25%>삭제</th>
			    	</tr>
		    		<c:forEach var="vo" items="${list }" varStatus="s">
			    	<tr>
			    			<td class="text-center" width=5%>${s.count }</td>
			    			<td class="text-center" width=70%>${vo.ingre_name }</td>
			    			<td class="text-center" width=25%>
			    				<button type="button" class="btn btn-warning" onclick="location.href='../fridge/ingre_out.do'">
			    					삭제
			    				</button>
			    			</td>
			    	</tr>
			    	</c:forEach>
			    </table>
			    </c:when>
			    <c:when test="${list==null }">
			    	<center><h5>등록할 식재료를 검색하세요</h3></center>
			    </c:when>
			    </c:choose>
		    </div>	
		</div>
		
		
		  <div class="col-md-4">
		  	<h3 class="text-center">재료 검색</h3>
		  	<hr>
		  	<div class="shop__option__search">
		        <form action="../fridge/fridge_main.do">
		            <select>
		                <option value="">재료명</option>
		                <option value="">레시피명</option>
		                <option value="">카테고리</option>
		            </select>
		            <input type="text" name="ingre_name" placeholder="Search">
		            <button type="submit"><i class="fa fa-search"></i></button>
		        </form>
		    </div>
		    <div>
		    	<c:choose>
		    	<c:when test="${list!=null }">
		    	<table class="table">
			    	<tr class="warning">
			    		<th class="text-center" width=5%>NO</th>
			    		<th class="text-center" width=70%>식재료명</th>
			    		<th class="text-center" width=25%>추가</th>
			    	</tr>
		    		<c:forEach var="vo" items="${list }" varStatus="s">
			    	<tr>
			    			<td class="text-center" width=5%>${s.count }</td>
			    			<td class="text-center" width=70%>${vo.ingre_name }</td>
			    			<td class="text-center" width=25%>
			    				<button type="button" class="btn btn-primary" onclick="location.href='../fridge/ingre_in.do'">
			    					추가
			    				</button>
			    			</td>
			    	</tr>
			    	</c:forEach>
			    </table>
			    </c:when>
			    <c:when test="${list==null }">
			    	<center><h5>등록할 식재료를 검색하세요</h3></center>
			    </c:when>
			    </c:choose>
		    </div>
		</div>
	</div>
</div>
</div>
</section>
</body>
</html>