<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


 <!-- Blog Hero Begin -->
    <div class="blog-hero set-bg" data-setbg="${vo.img }">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-7">
                    <div class="blog__hero__text">
                        <div class="label">Recipes</div>
                        <h2 id=noto>${vo.title }</h2>
                        <ul>
                            <li>By <span>${vo.chef}</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Blog Hero End -->


<!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__content">
                        <div class="blog__details__text">
                            <p>${vo.summ }</p>
                        </div>
                        
                        
                        <div class="blog__details__recipe">
                            <div class="blog__details__recipe__item">
                                <h6><img src="../img/blog/details/user.png" alt=""> SERVES</h6>
                                <span>${vo.people }</span>
                            </div>
                            <div class="blog__details__recipe__item">
                                <h6><img src="../img/blog/details/clock.png" alt=""> LEVEL</h6>
                                <span>${vo.lvl }</span>
                            </div>
                            <div class="blog__details__recipe__item">
                                <h6><img src="../img/blog/details/clock.png" alt=""> COOK TIME</h6>
                                <span>${vo.cooktime }</span>
                            </div>
                        </div>
                        <div class="blog__details__direction">
                            <h6>Directions</h6>
                            <ul>
                            	<c:forEach var="cvo" items="${cList}" varStatus="c">
                            		<%-- <c:if test="${c.count==cvo.ord }"> --%>
                                		<li><span style="font-weight: bold;">${c.count }</span>${cvo.cook }</li>
                                	<%-- </c:if> --%>
                                </c:forEach>
                                
                            </ul>
                        </div>
                        <div class="blog__details__recipe__details">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="blog__details__ingredients">
                                        <h6>Ingredients</h6>
                                        <ul>
                                        	<c:forEach var="ivo" items="${iList}" varStatus="i">
                                            	<li><span>${i.count }</span> &nbsp;${ivo.ingre }</li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="blog__details__ingredients__pic">
                                        <img src="img/blog/details/blog-details.jpg" alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <!-- <div class="blog__details__print">
                            <a href="#" class="primary-btn"><i class="fa fa-print"></i> Print recipe</a>
                        </div>
                        <div class="blog__details__text">
                            <p>Molded ports in cast burners seem like they would be a good idea, but there is
                                considerable difficulty in making them uniform. Thus, it is quicker and less expensive
                            to drill.</p>
                            <p>Fire Magic grill burner has drilled orifices Notice (from the photo on our site) the lack
                                of extensive burring, allowing for a smooth flow of gas. Cast stainless leaves few, if
                                any, burrs when drilled. This burner has a lifetime warranty, including against rust and
                            burn-through.</p>
                        </div>
                        <div class="blog__details__tags">
                            <span>Tag</span>
                            <a href="#">Food</a>
                            <a href="#">Material</a>
                            <a href="#">Cakes</a>
                            <a href="#">Baking</a>
                        </div>
                        <div class="blog__details__btns">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="blog__details__btns__item">
                                        <a href="#"><span class="arrow_carrot-left"></span> Previous posts</a>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="blog__details__btns__item blog__details__btns__item--next">
                                        <a href="#">Next posts <span class="arrow_carrot-right"></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="blog__details__author">
                            <div class="blog__details__author__pic">
                                <img src="img/blog/details/blog-author.jpg" alt="">
                            </div>
                            <div class="blog__details__author__text">
                                <h6>Mitchell Holland</h6>
                                <div class="blog__details__author__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-youtube-play"></i></a>
                                </div>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                                incididunt ut labore et dolore magna aliqua.</p>
                            </div>
                        </div>
                        <div class="blog__details__comment">
                            <h5>03 Comment</h5>
                            <a href="#" class="primary-btn">Leave a comment</a>
                            <div class="blog__details__comment__item">
                                <div class="blog__details__comment__item__pic">
                                    <img src="img/blog/details/comment-1.jpg" alt="">
                                </div>
                                <div class="blog__details__comment__item__text">
                                    <h6>Dylan Stewart</h6>
                                    <span>26 Feb 2020</span>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                                    incididunt ut labore et dolore magna aliqua vel facilisis.</p>
                                    <div class="blog__details__comment__btns">
                                        <a href="#">Reply</a>
                                        <a href="#">Like</a>
                                    </div>
                                </div>
                            </div>
                            <div class="blog__details__comment__item blog__details__comment__item--reply">
                                <div class="blog__details__comment__item__pic">
                                    <img src="img/blog/details/comment-2.jpg" alt="">
                                </div>
                                <div class="blog__details__comment__item__text">
                                    <h6>Derrick Patrick</h6>
                                    <span>26 Feb 2020</span>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                                    incididunt ut labore et dolore magna aliqua vel facilisis.</p>
                                    <div class="blog__details__comment__btns">
                                        <a href="#">Reply</a>
                                        <a href="#">Like</a>
                                    </div>
                                </div>
                            </div>
                            <div class="blog__details__comment__item">
                                <div class="blog__details__comment__item__pic">
                                    <img src="img/blog/details/comment-3.jpg" alt="">
                                </div>
                                <div class="blog__details__comment__item__text">
                                    <h6>Michael Luna</h6>
                                    <span>26 Feb 2020</span>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                                    incididunt ut labore et dolore magna aliqua vel facilisis.</p>
                                    <div class="blog__details__comment__btns">
                                        <a href="#">Reply</a>
                                        <a href="#">Like</a>
                                    </div>
                                </div>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->



</body>
</html>