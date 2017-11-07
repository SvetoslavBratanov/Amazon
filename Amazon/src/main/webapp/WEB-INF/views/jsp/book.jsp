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
		
			<nav class="col-md-6"> <img
				src="<c:url value="/resources/static${book.poster}"/>" height="150" width="150">
			<br>
			
			<h1>
				<c:out value="${book.productName}" />
			</h1>

			<h1>
				<c:out value="Price: ${book.price}" />
			</h1>
			
			
			<h1>
				<c:out value="Author: ${book.authorName}" />
			</h1>
			
			<h1>
				<c:out value="Genre: ${book.genre}" />
			</h1>
</body>
</html>