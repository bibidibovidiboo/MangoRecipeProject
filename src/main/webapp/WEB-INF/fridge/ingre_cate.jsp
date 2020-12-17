<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<style>
.addBtnTags {
	touch-action: manipulation;
	font-size: 0.8em;
	font-family: 'Montserrat', sans-serif;
	font-weight: bold;
	color: orange;
	display: inline-block;
	border: 2px;
	border-radius: 999em;
	padding: 0.7em 2em 0.7em 1em;
	min-width: 12em;
	text-align: center;
	margin: 0.3em;
	position: relative;
}
.delBtnTags {
	touch-action: manipulation;
	font-size: 0.8em;
	font-family: 'Montserrat', sans-serif;
	font-weight: bold;
	color: orange;
	display: inline-block;
	border: 2px;
	border-radius: 999em;
	padding: 0.7em 2em 0.7em 1em;
	min-width: 12em;
	text-align: center;
	margin: 0.3em;
	position: relative;
}
.favBtnTags {
	touch-action: manipulation;
	font-size: 0.8em;
	font-family: 'Montserrat', sans-serif;
	font-weight: bold;
	color: orange;
	display: inline-block;
	border: 2px;
	border-radius: 999em;
	padding: 0.7em 2em 0.7em 1em;
	min-width: 12em;
	text-align: center;
	margin: 0.3em;
	position: relative;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	// 재료 클릭했을 때
	$('.ingreBtnTags').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	});
	$('.ingreBtnTags').click(function(){
		let ingre_name = $(this).text();
		//alert("["+ingre_name+"] : 냉장고에 등록되었습니다.")
		/* $.ajax({
			  type:'POST',
			  url:'../fridge/ingre_map_detail.do',
			  data:{"region1":region1},
			  success:function(res)
			  {
				  $('#ingreMapPrint').html(res);
			  }
		}); */
	});
});
</script>
</head>
<body>
	<!-- iList -->
	<table class="table">
		<tr>
			<th width=40%>식재료명</th>
			<th width=20% class="text-center">냉장고 추가</th>
			<th width=20% class="text-center">냉장고 삭제</th>
			<th width=20% class="text-center">관심재료 등록</th>

		</tr>
		<tbody>
			<c:forEach var="ivo" items="${iList }" varStatus="ss">

				<tr>
					<td><span>${ivo.ingre_name} </span></td>
					
					<c:if test="${sessionScope.id!=null }">
					<td>
						<div class="addBtnTags">
							<a href="../fridge/ingre_in.do?ingre_name=${ivo.ingre_name}" class="btn btn-lg btn-warning" style="font-size: 10pt">ADD</a>
						</div>
					</td>
					<td>
						<div class="delBtnTags">
							<a href="../fridge/ingre_out.do?ingre_name=${ivo.ingre_name}" class="btn btn-lg btn-warning" style="font-size: 10pt">DEL</a>
						</div>
					</td>
					<td>
						<div class="favBtnTags">
							<a href="../fridge/ingre_heart.do?ingre_name=${ivo.ingre_name}" class="btn btn-lg btn-warning" style="font-size: 10pt">♥</a>
						</div>
					</td>
					</c:if>
					
					<c:if test="${sessionScope.id==null }">
						<td colspan="3" style="color:gray"><center>로그인 후 이용 가능합니다</center><td>
						<!-- rowspan="${fn:length(iList) }" -->
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>