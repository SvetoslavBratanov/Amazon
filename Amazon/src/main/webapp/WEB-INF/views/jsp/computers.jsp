<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Computers</title>
</head>
<body>
	

  	<c:if test="${not empty computers}">
  		<ul>
  			<c:forEach var="computer" items="${computers}">
  				
		<img src="<c:url value="${computer.poster}" />">
			<br>
			<h1>
			<c:out value="${computer.name}" />
			</h1>
			<br>
			<p>
  			</c:forEach>
  		</ul>	

  	</c:if>
</body>
</html>