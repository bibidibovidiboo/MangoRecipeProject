<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.recomm').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	});
	
	$('.recomm').click(function(){
		let no=$(this).attr("value");
		$.ajax({
			type:'POST',
			url:'../recommand/tag_sublist.do',
			data:{"no":no},
			success:function(res)
			{
				$('#print').html(res);
			}
		});
	});
})
</script>
<style type="text/css">
.taglist{
	margin: 0 auto;
	margin-top: 50px;
}
.sublist{
	margin: 0 auto;
	margin-top: 30px;
}
#tag{
	background-color: rgba(226, 108, 12, 0.5);
	border-radius: 15px;
	margin-right: 40px;
}
</style>
</head>
<body>
	<div class="container" style="height: 1100px;">
	  <div class="row">
	    <div class="taglist">
	      <span id="tag" class="primary-btn recomm" value="1">날씨/계절</span>
	      <span id="tag" class="primary-btn recomm" value="2">감성</span>
	      <span id="tag" class="primary-btn recomm" value="3">스타일</span>
	      <span id="tag" class="primary-btn recomm" value="4">상황</span>
	    </div>
	  </div>
	  <div class="row">
	    <div class="sublist" id="print">
	  	
	    </div>
	  </div>
	</div>
</body>
</html>