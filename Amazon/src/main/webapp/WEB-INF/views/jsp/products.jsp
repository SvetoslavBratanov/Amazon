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
<body style="background-color:powderblue;">

	<nav class="col-md-12">
	<form action="/productsByPrice" method="get">
		<nav class="col-md-4"> </nav>
		<input placeholder="Price from" type="text" name="from" /> <input
			placeholder="Price to" type="text" name="to" />
		<button type="submit" value="Send" class="btn-success">Search</button>
	</form>
	</n"src/main/webapp/WEB-INF/views/jsp/products.jsp"av>

	<c:if test="${not empty errorMessage}">
		<h1>
			<c:out value="${errorMessage}" />
		</h1>

	</c:if>


	<c:if test="${not empty products}">

		<nav class="col-md-12"> <c:forEach var="product" items="${products}">
			<nav class="col-md-6"> <img
				src="<c:url value="${product.poster}"/>" height="150" width="150">
			<br>
			<form action="/product" method="get">
				<input type="hidden" name="productId" value="${product.productID}" />
				<button type="submit" value="Send" class="btn-success">Show</button>
			</form>
			<h1>
				<c:out value="${product.productName}" />
			</h1>

			<h1>
				<c:out value="Price : ${product.price}" />
			</h1>
			<br>
			<p>
			</nav>
		</c:forEach> </nav>
	</c:if>
</body>
</html>