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
 .detail-box {
	margin-top: 63px;
    padding: 0 120px;
}
.reply-box {
	margin: 0 0 50px 100px;
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
	font-weight: 100;
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
            <a href="update.do?no=${vo.no }" class="btn btn-m btn-write">수정</a>
            <a href="delete.do?no=${vo.no }" class="btn btn-m btn-write">삭제</a>
            <a href="list.do" class="btn btn-m btn-write">목록</a>
          </td>
        </tr>
      </table>
     </div>
     
     
     <div class="row">

       <div class="col-sm-6  reply-box">
        <table class="table reply-table">
         <tr>
           <td>
            <c:forEach var="rvo" items="${list }">
             <table class="table">
              <tr>
                <td class="text-left" style="font-weight: 300">
                   ${rvo.name } / ${rvo.dbday}
                </td>
                <td class="text-right">
                  <c:if test="${sessionScope.id==rvo.id }">
                    <span class="btn btn-sm btn-write upBtn" data-no="${rvo.no }">수정</span>
                    <a href="reply_delete.do?no=${rvo.no }&cno=${vo.no}" class="btn btn-sm btn-write">삭제</a>
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
         
         <tr>
          <td>
          	<div class="card my-4">
	          <h5 class="card-header">Comment</h5>
	          <div class="card-body">
	            <form method=post action="reply_insert.do">
	            <input type=hidden name=cno value=${vo.no }>
	            <textarea rows="3" class="form-control" name=msg></textarea>
	             <button type="submit" class="btn btn-write btn-reply">댓글쓰기</button>
	            </form>
	            </div>
	        </div>
          </td>
         </tr>
        </table>
       </div>
       <div class="col-sm-6"></div>
       
        
     </div>
   </div>
</body>
</html>