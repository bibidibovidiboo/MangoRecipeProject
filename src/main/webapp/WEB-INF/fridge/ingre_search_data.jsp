<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
				<c:forEach var="vo" items="${list }" varStatus="s">
		    		<form method="post" action="../fridge/ingre_in.do">
		    		<input type="hidden" value="${vo.ingre_name }" name="ingre_name"> 
			    	<tr>
			    			<td class="text-center" width=5%>${s.count }</td>
			    			<td class="text-center" width=70%>${vo.category2 }</td>
			    			<td class="text-center" width=70%>${vo.ingre_name }</td>
			    			<td class="text-center" width=25%>
			    				<input type="submit" value="추가" class="btn btn-primary">
			    			</td>
			    	</tr>
			    	</form>
			    </c:forEach>
</body>
</html>