<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['선호도', '댓글'],
          ['좋아요',     <c:out value="${vo.good}"/>],
          ['괜찮다',      <c:out value="${vo.soso}"/>],
          ['별로',  <c:out value="${vo.bad}"/>]
        ]);

        var options = {
          title: '댓글 분석',
          pieHole: 0.4,
        };
        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
      
      let u=0;
      $(function(){
    	  $('.up').click(function(){
    		 $('.updates').hide();
    		 let no=$(this).attr("value");
    		 if(u==0)
    		 {
    			 $('#u'+no).show();
    			 $(this).text("취소");
    			 u=1;
    		 }
    		 else
    		 {
    			 $('#u'+no).hide();
    			 $(this).text("수정");
    			 u=0;
    		 }
    	  });
      })
    </script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row3 {
	margin-bottom: 20px;
}
</style>
</head>
<body>

	<section class="product-details spad">
	<div class="container">
		<div class="row">

			<div class="col-lg-6">
				<div class="product__details__img">
					<div class="product__details__big__img">
						<img class="big_img" src="${vo.poster }" alt="">
					</div>
					<div class="product__details__thumb">
						<div class="pt__item active">
							<img data-imgbigurl="${vo.poster }" src="${vo.poster }" alt="">
						</div>
						<div class="pt__item">
							<img data-imgbigurl="${vo.poster2 }" src="${vo.poster2 }" alt="">
						</div>
						<div class="pt__item">
							<img data-imgbigurl="${vo.poster3 }" src="${vo.poster3 }" alt="">
						</div>
						<div class="pt__item">
							<img data-imgbigurl="${vo.poster4 }" src="${vo.poster4 }" alt="">
						</div>
						<div class="pt__item">
							<img data-imgbigurl="${vo.poster5 }" src="${vo.poster5 }" alt="">
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="product__details__text">
					<div class="product__label">${vo.type }</div>
					
					<h4>${vo.title }</h4>
					<h4>${vo.addr }</h4>
					<ul>
						<li>전화번호: <span>${vo.tel }</span></li>
						<li>가격대: <span>${vo.price }</span></li>
						<li>메뉴:</li>
						<li><span>
						<c:if test="${vo.menu!='no' }">
							<tr>
								<td width=80%><c:forTokens var="s" items="${vo.menu }"
										delims="^">
	                   ${s }<br>
									</c:forTokens></td>
							</tr>
						</c:if>
						</span></li>
					</ul>
				</div>
			</div>
			
			
			 <%-- <table class="table">
              <tr>
               <td>
                 <c:forEach var="rvo" items="${rList }">
                   <table class="table table-striped">
                    <tr>
                     <td class="text-left">◑${vo.name }(${vo.dbday })</td>
                     <td class="text-right">
                      <c:if test="${sessionScope.id==rvo.id }">
                       <span value="${vo.no }" class="btn btn-xs btn-success up">수정</span>
                       <a href="../food/reply_delete.do?no=${vo.no }&cno=${vo.no}" class="btn btn-xs btn-info">삭제</a>
                      </c:if>
                     </td>
                    </tr>
                    <tr>
                      <td colspan="2">
                       <pre style="white-space: pre-wrap;border:none;background-color: white">${vo.msg }</pre>
                      </td>
                    </tr>
                    <tr class="updates" id="u${vo.no }" style="display:none">
		               <td colspan="2">
		                 <form method="post" action="../food/reply_update.do">
			                 <input type="hidden" name="cno" value="${vo.no }">
			                 <input type="hidden" name="no" value="${vo.no }">
			                 <textarea rows="3" cols="60" name="msg" style="float: left">${vo.msg }</textarea>
			                 <input type=submit value="댓글수정" class="btn btn-sm btn-primary"
			                  style="float: left;height: 73px">
		                  </form>
		               </td>
		              </tr>
                   </table>
                 </c:forEach>
               </td>
              </tr>
            </table> --%>
			
			
			<div class="col-md-5">
				<table class="table">
					<div id="donutchart" style="width: 100%; height: 450px;"></div>
				</table>
			</div>
			<hr>
			<div class="col-md-5">
				<table class="table">
					<tr>
						<td class="text-center">
							<div id="map" style="width: 100%; height: 350px;"></div> <script
								type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=61c031b09975f55def59c9e3ad810e68&libraries=services"></script>
							<script>
                var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        	    mapOption = {
        	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        	        level: 3 // 지도의 확대 레벨
        	    };  
        	
        	// 지도를 생성합니다    
        	var map = new kakao.maps.Map(mapContainer, mapOption); 
        	
        	// 주소-좌표 변환 객체를 생성합니다
        	var geocoder = new kakao.maps.services.Geocoder();
        	
        	// 주소로 좌표를 검색합니다
        	geocoder.addressSearch('${vo.addr}', function(result, status) {
        	
        	    // 정상적으로 검색이 완료됐으면 
        	     if (status === kakao.maps.services.Status.OK) {
        	
        	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        	
        	        // 결과값으로 받은 위치를 마커로 표시합니다
        	        var marker = new kakao.maps.Marker({
        	            map: map,
        	            position: coords
        	        });
        	
        	        // 인포윈도우로 장소에 대한 설명을 표시합니다
        	        var infowindow = new kakao.maps.InfoWindow({
        	            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.title}</div>'
        	        });
        	        infowindow.open(map, marker);
        	
        	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        	        map.setCenter(coords);
        	    } 
        	});    
                </script>
						</td>
					</tr>
				</table>
				<hr>
			</div>
			<div class="col-lg-5 col-md-5">
				<div class="row3">
					<button type="submit" class="site-btn">
						<a href="javascript:history.back()">Back</a>
					</button>
					<button type="submit" class="site-btn">
						<a href="../restaurant/resList.do">List</a>
					</button>
				</div>
			</div>

		</div>
	</div>



	</section>
</body>
</html>
