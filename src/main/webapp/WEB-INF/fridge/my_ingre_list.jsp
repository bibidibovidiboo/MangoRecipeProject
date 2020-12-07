<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
				<c:forEach var="rvo" items="${rList }" varStatus="ss">
			    	<form method="post" action="../fridge/ingre_out.do">
		    		<input type="hidden" value="${rvo.title }" name="ingre_name"> 
			    	<tr>
			    			<td class="text-center" width=5%>${ss.count }</td>
			    			<td class="text-center" width=70%>${rvo.title }</td>
			    			<td class="text-center" width=25%>
			    				<input type="submit" value="삭제" class="btn btn-warning">
			    			</td>
			    	</tr>
			    	</form>
			    </c:forEach>
</body>
</html>