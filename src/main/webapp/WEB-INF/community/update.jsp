<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.update-box {
	padding: 50px 0 34px 220px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row update-box">
     <form method=post action="update_ok.do">
     <table class="table">
       <tr>
        <th class="text-right danger" width=15%>이름</th>
        <td width=85%>
          <input type=text name=name size=15 value="${vo.name }">
          <input type=hidden name=no value="${vo.no }">
        </td>
       </tr>
       
       <tr>
        <th class="text-right danger" width=15%>제목</th>
        <td width=85%>
          <input type=text name=subject size=50 value="${vo.subject }">
        </td>
       </tr>
       
       <tr>
        <th class="text-right danger" width=15%>내용</th>
        <td width=85%>
          <textarea rows="8" cols="55" name=content>${vo.content }</textarea>
        </td>
       </tr>
       <tr>
        <th class="text-right danger" width=15%>비밀번호</th>
        <td width=85%>
          <input type="password" name=pwd size=10>
        </td>
       </tr>
       
       <tr>
        <td colspan="2" class="text-center">
          <input type=submit value="수정">
          <input type=button value="취소" onclick="javascript:history.back()">
        </td>
       </tr>
     </table>
     </form>
    </div>
  </div>
</body>
</html>