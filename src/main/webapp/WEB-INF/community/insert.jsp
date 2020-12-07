<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.con {
	padding: 82px 0;
}
.title {
	font-size: 27px;
	font-weight: 400;
	color: #343434;
}
.w-box {
	margin: 0 auto;
	width: 800px;
}
th {
	font-weight: 300;
}
.btn-write {
	border: 1px solid #d1d1d1;
    color: #616161;
    font-weight: 300;
    background-color: #f4f4f4;
}
.btn {
	width: 68px;
}
.form-control {
	display: inline-block;
	width: 85%;
}
.form-end {
	width: 99%;
	height: 500px;
}
label {
	width: 10%;
	margin-right: 20px;
	margin-left: 10px
}
.mb-3 {
	border-bottom: 1px solid #e0e0e0;
    padding-bottom: 18px;
}
.btn-box {
	margin-top: 36px;
}
</style>
</head>
<body>
  <div id="noto" class="con">
    <div class="row">
     <form method=post action="insert_ok.do" class="w-box">
     	<!-- <h1 class="title">자유게시판 글쓰기</h1> -->
     	<div class="mb-3">
     		<h1 class="title">게시판 글쓰기</h1>
     	</div>
      	<div class="mb-3">
	  		<label for="subject">제목</label>
			<input type="text" class="form-control" name=subject>
      	</div>
		<div class="mb-3">
			<label for="name">작성자</label>
			<input type="text" class="form-control" name=name>
		</div>
		<div class="mb-3">
			<textarea class="form-control form-end" rows="5" name=content  placeholder="내용을 입력해 주세요" style="height: 300px"></textarea>
		</div>
		<div class="mb-3">
			<label for="pwd">비밀번호</label>
			<input type="password" class="form-control" name=pwd>
		</div>
		<div class="text-center btn-box">
			<button type=submit value="글쓰기" class="btn btn-write">등록</button>
        	<button type=button value="취소" class="btn btn-write" onclick="javascript:history.back()">취소</button>
		</div>
     </form>
    </div>
  </div>
</body>
</html>