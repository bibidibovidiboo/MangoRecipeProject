<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="Cake Template">
    <meta name="keywords" content="Cake, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MR</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="../css/barfiller.css" type="text/css">
    <link rel="stylesheet" href="../css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <style>
    #myModal{
    	z-index:500000;
    }
    .table td, .table th {
    padding: .75rem;
    vertical-align: top;
    border-top: 1px solid white;
	}
    </style>
</head>

<body>

<!-- header 영역 -->
<tiles:insertAttribute name="header"/>

<!-- Content 영역 -->
<tiles:insertAttribute name="content"/>

<!-- footer 영역 -->
<tiles:insertAttribute name="footer"/>


<!-- Js Plugins -->
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.nice-select.min.js"></script>
<script src="../js/jquery.barfiller.js"></script>
<script src="../js/jquery.magnific-popup.min.js"></script>
<script src="../js/jquery.slicknav.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/jquery.nicescroll.min.js"></script>
<script src="../js/main.js"></script>

    <script type="text/javascript">
    $(function(){
    	$('#logBtn').click(function(){
    		let id=$('#id').val();
    		if(id.trim()=="")
    		{
    			$('#id').focus();
    			return;
    		}
    		let pwd=$('#pwd').val();
    		if(pwd.trim()=="")
    		{
    			$('#pwd').focus();
    			return;
    		}
    		
    		$.ajax({
    			type:'POST',
    			url:'../main/login.do',
    			data:{"id":id,"pwd":pwd},
    			success:function(res)
    			{
    				let no=res.trim();
    				
    				if(no==1)
    				{
    					$('#result').text("ID가 존재하지 않습니다");
    					$('#id').val("");
    					$('#pwd').val("");
    					$('#id').focus();
    				}
    				else if(no==2)
    				{
    					$('#result').text("비밀번호가 틀립니다");
    					$('#pwd').val("");
    					$('#pwd').focus();
    				}
    				else
    				{
    					alert("로그인 되었습니다");
    					$('#myModal').modal("hide");
    					//location.href="../main/main.do";
    					//parent.location.reload();
    					window.top.location.reload(true);
    					$('#id').val("");
    					$('#pwd').val("");
    					$('#result').text("");

    				}
    					
    			}
    		});
    	});
    });
    </script>

<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4><b>Login</b></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body" style="padding-bottom: 0px">
			
				<table class="table">
					<tr>
						<td width=35% class="text-right"><b>ID</b></td>
						<td width=65%><input type=text id="id" class="input-sm" size=15></td>
					</tr>
					
					
					<tr>
						<td width=35% class="text-right"><b>PW</b></td>
						<td width=65%><input type=password id="pwd" class="input-sm" size=15></td>
					</tr>
					<tr>
						<td class="text-center" colspan="2" height="0.1"><span style="color: red" id="result"></span></td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<a href="${kakaoUrl }"><img src="../img/kakao_login.png" alt=""></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=button class="btn btn-primary" value="Login" id="logBtn">
				<button type="button" class="btn" data-dismiss="modal" style="background-color: gray;color:white" >Close</button>
				
				
			</div>
		</div>

	</div>
</div>

</body>

</html>