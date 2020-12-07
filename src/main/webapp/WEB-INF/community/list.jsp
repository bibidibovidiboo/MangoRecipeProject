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
#noto {
	padding: 83px 33px 74px;
}
.title {
	font-size: 27px;
	margin-bottom: 23px;
	font-weight: 400;
	color: #343434;
}
a {
	color: #212529;
}
.table {
	border-bottom: 1px solid #e0e0e0;
	font-size: 15px;
}
.thead {
	border-top: 2px solid #858585;
}
.thead th{
	font-weight: 400;
}
.table td, .table th {
    padding: 0.6rem
}
tr {
	font-weight: 300;
}
.btn-write {
	border: 1px solid #d1d1d1;
    color: #616161;
    font-weight: 300;
}
.con-box {
	margin-bottom: 10px;
}
.table a:hover {
	text-decoration: underline;
	color: #222;
}
/* pagination */
a{
  text-decoration: none;
}
.pagination a{
  font-size: 14px;
}
.pagination{
  display: block;
  margin-top: 100px;
}
.pagination ul{
  margin: 0;
  padding: 0;
  list-style-type: none;
}
.pagination a{
  display: inline-block;
  padding: 10px 18px;
  color: #222;
}
.p1 a{
  width: 40px;
  height: 40px;
  line-height: 40px;
  padding: 0;
  text-align: center;
}
.p1 a.is-active{
  background-color: #f0f0f0;
  border-radius: 100%;
  color: #000;
}
</style>  
</head>
<body>
<div class="container" id="noto">
     <div class="row con-box">
       <h1 class="title">자유게시판</h1>
       <table class="table">
         <tr class="thead">
           <th class="text-center" width=10%>번호</th>
           <th class="text-center" width=45%>제목</th>
           <th class="text-center" width=15%>작성자</th>
           <th class="text-center" width=15%>작성일</th>
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
      		     		
     </div>
     <p class="pull-right"><a href="insert.do" class="btn btn-write">글쓰기</a></p>
     
    	<div class="pagination p1 text-center">
      		<ul>
		        <a href="#"><li><</li></a>
		        <a class="is-active" href="#"><li>1</li></a>
		        <a href="#"><li>2</li></a>
		        <a href="#"><li>3</li></a>
		        <a href="#"><li>></li></a>
      		</ul>
    	</div>
  	 <!--  
     <div class="text-center page">
         <a href="#" class="btn btn-sm">pre</a>
          ${curpage } page / ${totalpage } pages
         <a href="#" class="btn btn-sm">next</a>
     </div> 
     -->
  	  
   </div> 
</body>
</html>
