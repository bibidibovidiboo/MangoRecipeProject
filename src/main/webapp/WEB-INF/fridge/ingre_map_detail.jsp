<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<table class="table">
		<tr style="background-color: antiquewhite;">
			<th width="15%">특산물</th>
			<th width="15%">지역</th>
			<th width="20%">주출하시기</th>
			<th width="55%">특징</th>

		</tr>
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr>
					<c:if test="${list!=null }">
						<td><strong>${vo.title }</strong></td>
						<td>${vo.region2 }</td>
						<td>${vo.when }</td>
						<td><c:if test="${vo.content1!=null }">
								<li>${vo.content1 }</li>
							</c:if> <c:if test="${vo.content2!=null }">
								<li>${vo.content2 }</li>
							</c:if> <c:if test="${vo.content3!=null }">
								<li>${vo.content3 }</li>
							</c:if> <c:if test="${vo.content4!=null }">
								<li>${vo.content4 }</li>
							</c:if>
						</td>
					</c:if>
					<c:if test="${list==null }">
						<td colspan="4"><center>등록된 정보가 없습니다.</center></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>