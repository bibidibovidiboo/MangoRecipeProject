<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$('.upBtn').click(function(){
		$('.update').hide();
		let no=$(this).attr("data-no");
		if(i==0)
		{
			$(this).text("취소");
			$('#reply_up'+no).show();
			i=1;
		}
		else
		{
			$(this).text("수정");
			$('#reply_up'+no).hide();
			i=0;
		}
	});
});
</script>
<style type="text/css">
#noto {
	padding-bottom: 100px;
}
 .detail-box {
	margin-top: 63px;
    padding: 0 120px;
}
.reply-box {
	margin: 52px 0px 0px -170px;
}
.reply-table {
	margin-top: 10px;
}
.btn-write {
	border: 1px solid #d1d1d1;
    color: #616161;
    font-weight: 300;
    background-color: #f4f4f4;
}
.thead {
	border-top: 2px solid #858585;
}
.title {
	font-size: 27px;
	font-weight: 400;
	color: #343434;
}
td {
	font-weight: 300;
}
.thead td {
	font-weight: 400;
}
.btn-reply {
	margin-top: 15px;
}
.reply-table td, .reply-table th{
	border-top: none;
}
pre {
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 15px;
	white-space: pre-line;
	border:none;
	background-color: white; 
	font-weight: 300;
}
.btn-custom {
	font-size: 14px;
    color: #111111;
    text-transform: uppercase;
    font-weight: 400;
    margin-right: 24px;
    position: relative;
}
.btn-custom1:after {
	position: absolute;
    right: -16px;
    top: 3px;
    content: "|";
    color: #888888;
    font-weight: 500;
}
.tit {
	padding-left: 116px;
}
.dbday{
	font-size: 14px;
    font-weight: 300;
    margin-left: 15px;
    color: #8c8c8c;
}
.card-header {
	font-size: 19px;
}
.card my-4 {
	margin-left: 12px;
}
.blog__details__comment h5:before {
    top: 3px;
    height: 17px;
    width: 7px;
}
.reply-write{
	margin-left: 97px;
}
.site-btn {
    background: #1e1e1e;
    font-weight: 400;
    padding: 13px 28px;
}
.contact__form form textarea {
	width: 168%;
}
.reply-con {
	padding-left: 12px;
}
.table .site-btn {
    background: #1e1e1e;
    font-weight: 400;
    padding: 8px 16px;
    border-radius: 0;
}
.reply-write {
    padding: 12px 22px;
    margin-top: -6px;
}
</style>
</head>
<body>
   <div class="container" id="noto">
     <div class="row detail-box">
      <table class="table">
      	<!-- <h1 class="title">자유게시판</h1> -->
        <tr class="thead">
          <td colspan="3" class="text-left">${vo.subject }</td>
        </tr>
        <tr>
          <td colspan="3" class="text-left">${vo.name } / <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/> / 조회수 : ${vo.hit }</td>
        </tr>
              
        <tr>
          <td colspan="4" class="text-left" valign="top" height=200>
            ${vo.content }
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
            <a href="update.do?no=${vo.no }" class="btn-m site-btn">수정</a>
            <a href="delete.do?no=${vo.no }" class="btn-m site-btn">삭제</a>
            <a href="list.do" class="btn-m site-btn">목록</a>
          </td>
        </tr>
      </table>
     </div>
     
     
     <div class="row blog__details__comment reply-con">
    	<div class="tit"><h5>Comment</h5></div>

       	<div class="col-sm-6  reply-box">
        <table class="table reply-table">
         <tr>
           <td>
            <c:forEach var="rvo" items="${list }">
             <table class="table">
              <tr>
                <td class="text-left" style="font-weight:300;padding-top:15px">
                   ${rvo.name }  <span class="dbday">${rvo.dbday}</span>
                </td>
                <td class="text-right">
                  <c:if test="${sessionScope.id==rvo.id }">
                    <span class="btn btn-sm btn-custom btn-custom1 upBtn" data-no="${rvo.no }">수정</span>
                    <a href="reply_delete.do?no=${rvo.no }&cno=${vo.no}" class="btn btn-sm btn-custom">삭제</a>
                  </c:if>
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <pre>${rvo.msg }</pre>
                </td>
              </tr>
              <tr id="reply_up${rvo.no }" class="update" style="display:none">
		          <td colspan="2">
		            <form method=post action="reply_update.do">
		            <input type=hidden name=cno value=${vo.no }>
		            <input type=hidden name=no value=${rvo.no }>
		            <textarea rows="3" cols="45" style="float: left;font-weight:300;font-size:15px" name=msg class="form-control">${rvo.msg }</textarea>
		            <input type=submit value="댓글수정"
		              class="btn btn-m btn-write" style="float: left; margin-top: 10px;">
		            </form>
		          </td>
		         </tr>
             </table>
            </c:forEach>
           </td>
         </tr>
         
         
        <%--  <tr>
          <td>
         
          	<div class="card my-4">
          	 
	          <h4 class="card-header">COMMENT</h4>
	          <div class="card-body">
	            <form method=post action="reply_insert.do">
	            <input type=hidden name=cno value=${vo.no }>
	            <textarea rows="3" class="form-control" name=msg></textarea>
	             <button type="submit" class="btn btn-write btn-reply">댓글쓰기</button>
	            </form>
	            </div>
	        </div>
          </td>
         </tr> --%>
         
         <tr>
         
         
         </tr>
        </table>
       </div>

       <div class="col-sm-6 reply-write">
                    <div class="contact__form">
                         <form method=post action="reply_insert.do">
                         	<input type=hidden name=cno value=${vo.no }>
                            <div class="row">
                                <div class="col-lg-12">
                                    <textarea rows="3" class="form-control" name=msg></textarea>
                                    <button type="submit" class="site-btn">댓글쓰기</button>
                                </div>
                            </div>
                        </form>
                    </div>
      </div>
               
                

     </div>
   </div>
</body>
</html>