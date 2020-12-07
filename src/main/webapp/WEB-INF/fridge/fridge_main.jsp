<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<section class="shop spad">
        <div class="container">
            <div class="shop__option">
                <div class="row">
                
                
		  <!-- <div class="col-md-4">
		  	<h3 class="text-center">나만의 냉장고</h3>
		  	<hr>
		  		<img src="../img/full-fridge.png">
		  </div> -->
		  
		<!------------------------------------나의 냉장고--------------------------------------->
		  
		  <div class="col-md-6">
			<h3 class="text-center">나만의 냉장고</h3>
		  	<hr>
		    <div id="my-fridge-list">
		    
		    
		    
		   <c:choose>
		    <c:when test="${rList==null }">
		    	<center><h5>식재료를 등록하세요</h3></center>
			 </c:when>
			 <c:when test="${rList!=null }">
		    	<table class="table">
			    	<tr class="warning">
			    		<th class="text-center" width=5%>NO</th>
			    		<th class="text-center" width=70%>식재료명</th>
			    		<th class="text-center" width=25%>삭제</th>
			    	</tr>
			    	<c:forEach var="rvo" items="${rList }" varStatus="ss">
			    	<form method="post" action="../fridge/ingre_out.do">
		    		<input type="hidden" value="${rvo.title }" name="ingre_name"> 
			    	<tr>
			    			<td class="text-center" width=5%>${ss.count }</td>
			    			<td class="text-center" width=70%>${rvo.title }</td>
			    			<td class="text-center" width=25%>
			    				<input type="submit" value="삭제" class="btn btn-warning">
			    			</td>
			    	</tr>
			    	</form>
			    	</c:forEach>
			    </c:when>
			    </c:choose>
			    </table>
			    
			    
			    
			    
			    
		    </div>	
		</div>
		
		<!------------------------------------재료검색--------------------------------------->
		
		  <div class="col-md-6">
		  	<h3 class="text-center">재료 검색</h3>
		  	<hr>
		  	
		  	<div class="shop__option__search">
		        <form action="../fridge/fridge_main.do">
		            <select>
		                <option value="">재료명</option>
		                <option value="">카테고리</option>
		            </select>
		            <input type="text" name="ingre_name" placeholder="Search" id="ingre_keyword">
		            <button type="submit"><i class="fa fa-search"></i></button>
		        </form>
		    </div>
		    
		    <div id="ingre_search_data">
		    
		    	<c:choose>
		    	<c:when test="${list!=null }">
		    	<table class="table" id="ingre_search_table">
		    	  <tbody>
			    	<tr class="warning">
			    		<th class="text-center" width=5%>NO</th>
			    		<th class="text-center" width=70%>카테고리</th>
			    		<th class="text-center" width=70%>식재료명</th>
			    		<th class="text-center" width=25%>추가</th>
			    	</tr>
		    		<c:forEach var="vo" items="${list }" varStatus="s">
		    		<form method="post" action="../fridge/ingre_in.do">
		    		<input type="hidden" value="${vo.ingre_name }" name="ingre_name"> 
			    	<tr>
			    			<td class="text-center" width=5%>${s.count }</td>
			    			<td class="text-center" width=70%>${vo.category2 }</td>
			    			<td class="text-center" width=70%>${vo.ingre_name }</td>
			    			<td class="text-center" width=25%>
			    				<input type="submit" value="추가" class="btn btn-primary">
			    			</td>
			    	</tr>
			    	</form>
			    	</c:forEach>
			      </tbody>
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