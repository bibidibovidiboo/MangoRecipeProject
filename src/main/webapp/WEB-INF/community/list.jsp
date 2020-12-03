<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* .title {
	font-size: 31px;
    margin: 36px auto 24px;
}
.c-box {
	padding: 40px 0 65px;
}
.new-btn {
	color: #ffffff;
    background-color: #f08632;
    border-color: #f08632;
	margin-top: 15px;
}
.table-row {
	background-color: #f3f3f3;
}
a {
	color: #222;
}
a:hover {
	color: #f08632;
} */
.title {
	font-weight: 100;
	font-size: 30px;
}
.title_box {
	padding: 22px 0px 0px 0px;
}
.spad {
    padding-top: 66px;
}
</style>  
</head>
<body>
  <%--  <div class="container">
     <div class="row c-box">
       <h1 class="title">커뮤니티 게시판</h1>
       <table class="table">
         <tr>
           <td>
             <a href="insert.do" class="btn btn-warning new-btn">새글</a>
           </td>
         </tr>
       </table>
       <table class="table">
         <tr class="table-row">
           <th class="text-center" width=10%>번호</th>
           <th class="text-center" width=45%>제목</th>
           <th class="text-center" width=15%>이름</th>
           <th class="text-center" width=20%>작성일</th>
           <th class="text-center" width=10%>조회수</th>
         </tr>
       
         <c:forEach var="vo" items="${list }">
           <tr>
               <td class="text-center" width=10%>${vo.no }</td>
	           <td class="text-left" width=45%>
	             <a href="detail.do?no=${vo.no }">${vo.subject }</a>
	           </td>
	           <td class="text-center" width=15%>${vo.name }</td>
	           <td class="text-center" width=20%>
	             <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
	           </td>
	           <td class="text-center" width=10%>${vo.hit }</td>
           </tr>
         </c:forEach>
       </table>
       <table class="table">
         <td class="text-center">
          <a href="#" class="btn btn-sm btn-default">이전</a>
          ${curpage } page / ${totalpage } pages
          <a href="#" class="btn btn-sm btn-default">다음</a>
         </td>
       </table>
     </div>
   </div> --%>
   
   <!-- 여기부터  -->

    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="class__item__text title_box">
                        <h2 class="title">커뮤니티 게시판</h2>
                    </div>
                </div>
                <!-- <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="./index.html">Home</a>
                        <span>Class</span>
                    </div>
                </div> -->
            </div>
        </div>
    </div>


    
    <!-- Class Section Begin -->
    <section class="class-page spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="class__item">
                                <div class="class__item__pic set-bg" data-setbg="../img/class/class-1.jpg">
                                    <div class="label">$35.00</div>
                                </div>
                                <div class="class__item__text">
                                    <h5><a href="#">ADVANCED BAKING COURSE</a></h5>
                                    <span>Wed 08 Apr 2020; 6.30pm - 9.30pm</span>
                                    <p>Professional course: cook’s certificate in food & wine (six weeks full-time)</p>
                                    <a href="#" class="read_more">Read more</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="class__item">
                                <div class="class__item__pic set-bg" data-setbg="../img/class/class-2.jpg">
                                    <div class="label">$35.00</div>
                                </div>
                                <div class="class__item__text">
                                    <h5><a href="#">TEEN COOKING CAMP</a></h5>
                                    <span>Wed 08 Apr 2020; 6.30pm - 9.30pm</span>
                                    <p>Professional course: cook’s certificate in food & wine (six weeks full-time)</p>
                                    <a href="#" class="read_more">Read more</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="class__item">
                                <div class="class__item__pic set-bg" data-setbg="../img/class/class-3.jpg">
                                    <div class="label">$35.00</div>
                                </div>
                                <div class="class__item__text">
                                    <h5><a href="#">THE ULTIMATE BAKING COURSE</a></h5>
                                    <span>Wed 08 Apr 2020; 6.30pm - 9.30pm</span>
                                    <p>Professional course: cook’s certificate in food & wine (six weeks full-time)</p>
                                    <a href="#" class="read_more">Read more</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="class__item">
                                <div class="class__item__pic set-bg" data-setbg="../img/class/class-4.jpg">
                                    <div class="label">$35.00</div>
                                </div>
                                <div class="class__item__text">
                                    <h5><a href="#">KIDS BAKING COURSE</a></h5>
                                    <span>Wed 08 Apr 2020; 6.30pm - 9.30pm</span>
                                    <p>Professional course: cook’s certificate in food & wine (six weeks full-time)</p>
                                    <a href="#" class="read_more">Read more</a>
                                </div>
                            </div>
                        </div>
                        
                    <div class="shop__pagination">
                        <a href="#">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#"><span class="arrow_carrot-right"></span></a>
                    </div>
                </div>
                <!-- <div class="col-lg-4">
                    <div class="class__sidebar">
                        <h5>Made from your own hands</h5>
                        <form action="#">
                            <input type="text" placeholder="Name">
                            <input type="text" placeholder="Phone">
                            <select>
                                <option value="">Studying Class</option>
                                <option value="">Writting Class</option>
                                <option value="">Reading Class</option>
                            </select>
                            <input type="text" placeholder="Type your requirements">
                            <button type="submit" class="site-btn">registration</button>
                        </form>
                    </div>
                </div> -->
            </div>
        </div>
    </section>
    <!-- Class Section End -->
</body>
</html>
