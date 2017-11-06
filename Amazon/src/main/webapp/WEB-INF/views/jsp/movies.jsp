<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
<link href="<c:url value="/resources/static/css/products.css"/>"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/static/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<form action="movies" method="get">

		<input placeholder="Price from" type="text" name="from" /> <input
			placeholder="Price to" type="text" name="to" />
		<button type="submit" value="Send" class="btn-success">Send</button>
	</form>

	<c:if test="${not empty errorMessage}">
		<h1>
			<c:out value="${errorMessage}" />
		</h1>

	</c:if>
	<c:if test="${not empty movies}">
		<ul>
			<c:forEach var="movie" items="${movies}">

				<img src="<c:url value="${movie.poster}"/>" height="420" width="420">
				<br>
				<h1>
					<c:out value="${movie.productName}" />
				</h1>

				<h1>
					<c:out value="${movie.price}" />
				</h1>
				<br>
				<p>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>