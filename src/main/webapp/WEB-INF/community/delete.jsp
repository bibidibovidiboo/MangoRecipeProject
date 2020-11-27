<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.delete-box {
	margin: 44px auto 20px;
}
</style>
</head>
<body>
   <div class="container">
    <div class="row">
      <!-- <h1>삭제하기</h1> -->
      <form action="delete_ok.do" method="post" class="delete-box">
      <table class="table delete-box">
       <tr>
         <td>
          비밀번호:  <input type=password name=pwd size=15 class="input-sm">
            <input type=hidden name=no value="${no }">
         </td>
       </tr>
       <tr>
         <td class="text-center">
           <input type=submit value="삭제">
           <input type=button value="취소" onclick="javascript:history.back()">
         </td>
       </tr>
      </table>
      </form>
    </div>
   </div>
</body>
</html>