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
.title {
	font-size: 32px;
	margin: 32px auto;
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
</style>
</head>
<body>
   <div class="container">
     <div class="row c-box">
       <h1 class="title">커뮤니티 게시판</h1>
       <table class="table">
         <tr>
           <td>
             <a href="insert.do" class="btn btn-warning new-btn">새글</a>
           </td>
         </tr>
       </table>
       <table class="table table-striped">
         <tr class="warning">
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
   </div>
</body>
</html>
