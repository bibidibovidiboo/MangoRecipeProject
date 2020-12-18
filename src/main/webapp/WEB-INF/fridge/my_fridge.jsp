<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



 <!-- 나의 냉장고 Start -->
                    <div class="blog__sidebar__item">
	                            <h5>My Refrigerator List</h5>
	                            
	                     <div class="product__details__option">
	                            <a href="#" class="primary-btn" style="float:right;border-radius: 40px 40px 40px 40px">레시피 추천받기</a>
	                     </div>
	                     <div style="height:40px"></div>
	                           
						<!-- 표 Begin -->
	                    <div>
	                    	<c:if test="${sessionScope.id==null }">
		                    	<div class="text-center">
		                    		<center>로그인 후 사용 가능합니다.</center>
								</div>
							</c:if>
							
							<!-- 로그인 되어 있을 때 -->
							<c:if test="${sessionScope.id !=null }">
							<table class="table">
								<tr>
									<th width=40%>식재료명</th>
									<th width=20% class="text-center">냉장고 삭제</th>
									<th width=20% class="text-center">관심재료 등록</th>
									
									
								</tr>
								<tbody>
									<c:forEach var="vo" items="${list }" varStatus="ss">
										<tr>
											<td><span>${vo.title }</span></td>
											<td>
												<div class="delBtnTags">
													<a href="#" class="btn btn-lg btn-warning" style="font-size: 10pt">DEL</a>
												</div>
											</td>
											<td>
												<div class="favBtnTags">
													<a href="#" class="btn btn-lg btn-warning" style="font-size: 10pt">♥</a>
												</div>
											</td>
											
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</c:if>
							
						</div>
	                    <!-- 나의 냉장고 End -->
                    </div>



</body>
</html>