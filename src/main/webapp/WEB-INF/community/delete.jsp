<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.delete-box {
	padding: 112px 0 92px;
}
.cBtn {
	background: #111;
    color: #fff;
    border-radius: 0;
    font-weight: 500;
    padding: 8px 20px;
    margin-right: 1px;
}
h4{
	margin-bottom: 20px;
    font-size: 18px;
    color: #111;
    font-weight: 300;
}
.form-control {
	margin-bottom: 21px;
}
form {
	margin: 0 auto;
}
</style>
</head>
<body>
   <div class="container delete-box" id="noto">
    <div class="row">
     
      <form action="delete_ok.do" method="post">
      	<h4>글을 삭제하시겠습니까?</h4>
      	<div>
        	<input type=password name=pwd size=15 class="form-control" placeholder="비밀번호를 입력하세요">
            <input type=hidden name=no value="${no }">
        </div>
        <div class="text-center">
           <button type=submit value="삭제" class="cBtn">삭제</button>
           <button type=button value="취소" class="cBtn" onclick="javascript:history.back()">취소</button>
		</div>
      </form>
    </div>
   </div>
</body>
</html>