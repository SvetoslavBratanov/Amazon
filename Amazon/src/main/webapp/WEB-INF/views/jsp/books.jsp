<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
</head>
<body>
	

  	<c:if test="${not empty books}">
  		<ul>
  			<c:forEach var="book" items="${books}">
  			<img src="<c:url value="${book.poster}"/>" height="420" width="420">
			<br>
			<h1>
			<c:out value="${book.productName}" />
			</h1>
			<br>
			<p>
  			</c:forEach>
  		</ul>	

  	</c:if>
</body>
</html>