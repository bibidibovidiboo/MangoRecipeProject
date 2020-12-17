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
.con {
	background-image: url("https://blogfiles.pstatic.net/MjAyMDEyMThfMjg0/MDAxNjA4MjIxNzcwODA2.-67LVGLtyXnRdVCF_LxkZvNXePIg0qragsAWRb2fDI0g.OpOnKNb0bipaQaPF33ZQrD6QwwDGWCETAU7ok9uFGLYg.JPEG.hartring/bg_1.jpg");
	background-repeat: no-repeat;
    background-size: contain;
    width: 100%;
    height: 185%;
}
ul {
	margin-bottom : 0px;
}
li a:hover {
	text-decoration: none;
}
p {
	font-family: 'Noto Sans KR', sans-serif;
	font-weight: 300;
    color: #111;
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
  margin-top: 68px;
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
<div class="latest-products con" id="noto">  
      <div style="height:84px"></div>
      <div class="container" id="root">
      </div>
      <script src="../mart/bundle.js"></script>
      <div class="pagination p1 text-center">
      		<ul>
		        <a href="#"><li><</li></a>
		        <a class="is-active" href="#"><li>1</li></a>
		        <a href="#"><li>2</li></a>
		        <a href="#"><li>3</li></a>
		        <a href="#"><li>4</li></a>
		        <a href="#"><li>5</li></a>
		        <a href="#"><li>></li></a>
      		</ul>
    </div>
</div>
</body>
</html>