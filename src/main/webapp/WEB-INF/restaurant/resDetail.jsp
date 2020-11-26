<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

</style>
</head>
<body>
    <section class="product-details spad">
        <div class="container">
            <div class="row">
            
                            <div class="col-lg-6">
                    <div class="product__details__img">
                        <div class="product__details__big__img">
                            <img class="big_img" src="${vo.res_poster1 }" alt="">
                        </div>
                        <div class="product__details__thumb">
                            <div class="pt__item active">
                                <img data-imgbigurl="${vo.res_poster1 }" src="${vo.res_poster1 }" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="${vo.res_poster2 }" src="${vo.res_poster2 }" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="${vo.res_poster3 }" src="${vo.res_poster3 }" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="${vo.res_poster4 }" src="${vo.res_poster4 }" alt="">
                            </div>
                            <div class="pt__item">
                                <img data-imgbigurl="${vo.res_poster5 }" src="${vo.res_poster5 }" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <div class="product__label">${vo.res_menu }</div>
                        <h4>${vo.res_title }</h4>
                        <h5>${vo.res_add }</h5>
                        <ul>
                            <li>전화번호: <span>${vo.res_tel }</span></li>
                            <li>가격대: <span>${vo.res_price }</span></li>
                        </ul>
                     
                    </div>
                </div>
            </div>
              </div>
            
         

  </section>
</body>
</html>
