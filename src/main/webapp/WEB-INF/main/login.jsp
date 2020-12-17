<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="../js/jquery-3.3.1.min.js"></script>
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
    					parent.location.reload();
    					$('#id').val("");
    					$('#pwd').val("");
    					$('#result').text("");

    				}
    					
    			}
    		});
    	});
    });
    </script>

<body>

		<div class="modal-content">
				<h4>Login</h4>
				
			<div class="modal-body">
				<table class="table">
					<tr>
						<td width=25% class="text-right">ID</td>
						<td width=75%><input type=text id="id" class="input-sm"
							size=15></td>
					</tr>
					<tr>
						<td width=25% class="text-right">PW</td>
						<td width=75%><input type=password id="pwd" class="input-sm"
							size=15></td>
					</tr>
					<tr>
						<td class="text-center" colspan="2"><span style="color: red"
							id="result"></span></td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<input type=button class="btn btn-success" value="로그인" id="logBtn">
				<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
</body>
</html>