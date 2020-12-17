<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row1{
   margin: 0px auto;
   width:900px;
}
</style>
</head>
<body>
  <div style="height:30px"></div>
  <div class="container">
   <div class="row">
     <table class="table">
       <tr>
        <td>
          <c:forEach var="vo" items="${list }">
            <table class="table">
             <tr>
              <td width=30% class="text-center" rowspan="3">
               <a href="detail.do?no=${vo.no }"><img src="${vo.poster }" width=300 height=200></a>
              </td>
              <td width=70%><font size="12px">${vo.title }
                 <span style="color:orange">${vo.score }</span></font></td>
             </tr>
             <tr>
                <td width=70%>${vo.addr }</td>
             </tr>
             <tr>
                <td width=70%>${vo.tel }</td>
             </tr>
            </table>
          </c:forEach>
        </td>
       </tr>
       <tr>
         <td class="text-right">
          <a href="list.do" class="btn btn-sm btn-danger">목록</a>
         </td>
       </tr>
     </table>
   </div>
  </div>
</body>
</html>