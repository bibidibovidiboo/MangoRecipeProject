<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
	margin-bottom: 40px;
}

</style>
</head>
<body>
	<section class="shop spad">
	<div class="container">
		<div class="shop__option">
		
				<!-- ----------------------- 카테고리 중간------------------------------------------------------------------------------ -->
				<div class="row">
                    <div class="col-lg-7 col-md-7">
                        <div class="shop__option__search">
                            <form action="#">
                                <select>
                                    <option value="">Categories</option>
                                    <option value="">Red Velvet</option>
                                    <option value="">Cup Cake</option>
                                    <option value="">Biscuit</option>
                                </select>
                                <input type="text" placeholder="Search">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-5 col-md-5">
                        <div class="shop__option__right">
                            <select>
                                <option value="">Default sorting</option>
                                <option value="">A to Z</option>
                                <option value="">1 - 8</option>
                                <option value="">Name</option>
                            </select>
                            <a href="#"><i class="fa fa-list"></i></a>
                            <a href="#"><i class="fa fa-reorder"></i></a>
                        </div>
                    </div>
                </div>
		
				<!-- ---------------------------------- 식당 출력 --------------------------------------------------------------------------- -->
			<div class="container">
				<div class="row1">
					<c:forEach var="vo" items="${list }">
						<div class="col-lg-3 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="${vo.res_poster1 }">
									<div class="product__label">
										<a href="resDetail_before.do?no=${vo.no}"><span>${vo.res_title }</span></a>
									</div>
								</div>
								<div class="product__item__text">
									<h6>${vo.res_add }</h6>
									<h6>${vo.res_menu }</h6>
									<%-- <div class="product__item__price">${vo.res_menu }</div> --%>

								</div>

							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="row1">
					<h3>최근 본 식당</h3>
					<c:forEach var="vo" items="${cList }" varStatus="s">
						<c:if test="${s.index<6 }">
							<div class="col-md-2">
								<div class="thumbnail">
									<a href="resDetail_before.do?no=${vo.no}"> <img
										src="${vo.res_poster1 }" alt="Lights" style="width: 100%"
										class="img-rounded">
										<div class="caption">
											<p style="font-size: 8pt">${vo.res_title }</p>
										</div>
									</a>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			
		</div>
	</div>
	</section>
</body>
</html>
